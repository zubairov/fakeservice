Fake Service Locator Service Clients
===================

This package register fake Talend ESB Service Locator services, you just need
to specify the Zookeeper server location(s).

How to use it
===================

1. Build it with maven: mvn clean package
2. Use resulting executable JAR file like
> java -jar fakeservice-4.2.0-SNAPSHOT.jar
3. You can specify optional parameters with Zookeeper server locations
> java -jar fakeservice-4.2.0-SNAPSHOT.jar 127.0.0.1:2181
or
> java -jar fakeservice-4.2.0-SNAPSHOT.jar "127.0.0.1:2181, hasi:2181, foo:2181"