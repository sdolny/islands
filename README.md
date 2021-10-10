# islands

Simple program for counting islands on the map given in txt file like:

```
000000000
010000000
111000100
110001110
000001100
001000000
110000000
000001100
```

0 represents water, 1 represents land. In this example there are 4 lands.

## Building

Java 11 is required for building

```shell
mvn clean install
```

## Run

```shell
java -jar target/islands-1.0-SNAPSHOT.jar <file with map>
```
