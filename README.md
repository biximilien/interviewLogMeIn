# LogMeIn Interview Assignment

This is the exercise I was assigned for my interview at LogMeIn.
The original assignment document is `assignment.pdf` and is included in the repo.

## Documentation

A few resources I have colligated while attempting this exercise. I have consulted other sources, examples and discussions that are not included as I forgot to bookmark them.

* The international standard ISO 8601 date and time interchange format [Wikipedia Article](https://en.wikipedia.org/wiki/ISO_8601).
* Transmission Control Protocol [Wikipedia Article](https://en.wikipedia.org/wiki/Transmission_Control_Protocol).
* User Datagram Protocol [Wikipedia Article](https://en.wikipedia.org/wiki/User_Datagram_Protocol).
* Java API 8 [ZonedDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html)
* Java API 8 [DateTimeFormatter](https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html)
* Java API 8 [ServerSocket](https://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html)
* Relevant discussion on StackOverflow about sockets [StackOverflow Question](https://stackoverflow.com/questions/10240694/java-socket-api-how-to-tell-if-a-connection-has-been-closed/10241044#10241044)
* [Java Logging Example](https://examples.javacodegeeks.com/core-java/util/logging/java-util-logging-example/)

## Automated Testing

I have not used automated testing in my solution, as it is rather simple. I felt unit tests would have been testing against core java API features, and as such did not feel too relevant. Furthermore, an integration test framework did not feel warranted for 3 use cases.

## Manual Testing

Simply start the server and wait for it to become ready, then use `netcat` to send requests to the TimeServer.

### Start the server

```sh
$ java com.logmein.interview.TimeServer 5051
```

### Test TCP Request

I simply used `netcat` to send bytes via TCP from the command-line.

```sh
$ nc 127.0.0.1 5051
datetime
2020-03-20T16:58:40.489589-04:00
```

### Test UDP Request

Again, I used `netcat` to send datagrams from the command-line.

```sh
$ nc -u 127.0.0.1 5051
date
2020-03-20-04:00
```