# LogMeIn Interview Assignment
This is the exercise I was assigned for my interview at LogMeIn.

The original document is `assignment.pdf`.

## Documentation

A few resources I have colligated while attempting this exercise.

* The international standard ISO 8601 date and time interchange format [Wikipedia Article](https://en.wikipedia.org/wiki/ISO_8601).
* Transmission Control Protocol [Wikipedia Article](https://en.wikipedia.org/wiki/Transmission_Control_Protocol).
* User Datagram Protocol [Wikipedia Article](https://en.wikipedia.org/wiki/User_Datagram_Protocol).
* Java API 8 [ZonedDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html)
* Java API 8 [DateTimeFormatter](https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html)
* Relevant discussion on StackOverflow about sockets [StackOverflow Question](https://stackoverflow.com/questions/10240694/java-socket-api-how-to-tell-if-a-connection-has-been-closed/10241044#10241044)

## Test TCP Request

I used netcat to send bytes with my shell

```sh
$ nc 127.0.0.1 5051
datetime
2020-03-20T16:58:40.489589-04:00
```

## Test UDP Request

I used netcat to send bytes with my shell

```sh
$ nc -u 127.0.0.1 5051
date
2020-03-20-04:00
```