## Small client for debugging java-driver events

To run:
```
$ mvn package
$ java -jar target/java-driver-events-1.0-SNAPSHOT.jar --bundle <bundle> --username <username> --password <password>
```

Output:
```
INFO  [main] 2021-11-23 10:43:14,071 - DataStax Java driver 3.11.0 for Apache Cassandra
INFO  [main] 2021-11-23 10:43:14,079 - Detected Guava >= 19 in the classpath, using modern compatibility layer
INFO  [main] 2021-11-23 10:43:14,838 - Using native clock to generate timestamps.
INFO  [main] 2021-11-23 10:43:14,933 - Did not find Netty's native epoll transport in the classpath, defaulting to NIO.
INFO  [main] 2021-11-23 10:43:15,340 - Cannot connect with protocol version V5, trying with V4
INFO  [main] 2021-11-23 10:43:15,902 - Using data-center name 'us-east1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
INFO  [main] 2021-11-23 10:43:15,903 - New Cassandra host 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:784f9f5f-b115-4c30-b053-8714ae14c236 added
INFO  [main] 2021-11-23 10:43:15,904 - ADDED HOST 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:784f9f5f-b115-4c30-b053-8714ae14c236
INFO  [main] 2021-11-23 10:43:15,904 - New Cassandra host 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:39176429-d943-4692-a2e1-04b5bc989a1d added
INFO  [main] 2021-11-23 10:43:15,904 - ADDED HOST 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:39176429-d943-4692-a2e1-04b5bc989a1d
INFO  [main] 2021-11-23 10:43:15,904 - New Cassandra host 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:00b7dae8-fd69-475f-a2e5-78fae0088661 added
INFO  [main] 2021-11-23 10:43:15,904 - ADDED HOST 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:00b7dae8-fd69-475f-a2e5-78fae0088661
INFO  [main] 2021-11-23 10:43:16,287 - QUERIED HOST 1e1c9276-7146-4902-a7ce-ebf494a116ab-us-east1.db.astra-dev.datastax.com:29042:00b7dae8-fd69-475f-a2e5-78fae0088661
```
