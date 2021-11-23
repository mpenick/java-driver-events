package org.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Host.StateListener;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import java.io.File;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
@Command(name= "App")
public class App {
  static Logger logger = LoggerFactory.getLogger(App.class);

  @Option(name = {"-b", "--bundle"})
  private String bundle;

  @Option(name = {"-u", "--username"})
  private String username;

  @Option(name = {"-p", "--password"})
  private String password;

  @Option(name = {"-d", "--delay"})
  private Integer delay = 5;

  public void run() throws Throwable {
    if (bundle == null) {
      System.err.println("Bundle not set");
      System.exit(1);
    }
    if (username == null) {
      System.err.println("Username not set");
      System.exit(1);
    }
    if (password == null) {
      System.err.println("Password not set");
      System.exit(1);
    }
    try (Cluster cluster = Cluster.builder()
        .withCloudSecureConnectBundle(new File(bundle))
        .withAuthProvider(new PlainTextAuthProvider(username, password))
        .withInitialListeners(Collections.singleton(new StateListener() {
          @Override
          public void onAdd(Host host) {
            logger.info("ADDED HOST " + host.getEndPoint());
          }

          @Override
          public void onUp(Host host) {
            logger.info("REMOVED HOST " + host.getEndPoint());
          }

          @Override
          public void onDown(Host host) {
            logger.info("HOST DOWN " + host.getEndPoint());
          }

          @Override
          public void onRemove(Host host) {
            logger.info("HOST UP " + host.getEndPoint());
          }

          @Override
          public void onRegister(Cluster cluster) {
            // Nothing
          }

          @Override
          public void onUnregister(Cluster cluster) {
            // Nothing
          }
        }))
        .build()) {
      Session session = cluster.connect();
      while (true) {
        try {
          ResultSet rs = session.execute("SELECT * FROM system.local");
          logger.info("QUERIED HOST {}", rs.getExecutionInfo().getQueriedHost().getEndPoint());
        } catch (Exception e) {
          logger.error("Error executing query", e);
        }
        Thread.sleep(delay * 1000);
      }
    }
  }

  public static void main( String[] args ) throws Throwable {
    SingleCommand<App> parser = SingleCommand.singleCommand(App.class);
    App app = parser.parse(args);
    app.run();
  }
}
