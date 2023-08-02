# merge-sorter-in-java
## Программа сортировки слиянием нескольких файлов.

### Requierements:

#### Java vesion:

Java version: Java 8
Build system: Maven

java version "1.8.0_381"
Java(TM) SE Runtime Environment (build 1.8.0_381-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.381-b09, mixed mode)

openjdk 20.0.2 2023-07-18
OpenJDK Runtime Environment (build 20.0.2+9-78)
OpenJDK 64-Bit Server VM (build 20.0.2+9-78, mixed mode, sharing)

#### Maven version:

Apache Maven 3.9.3 (21122926829f1ead511c958d89bd2f672198ae9f)
Maven home: /opt/homebrew/Cellar/maven/3.9.3/libexec
Java version: 20.0.1, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk/20.0.1/libexec/openjdk.jdk/Contents/Home
Default locale: ru_US, platform encoding: UTF-8
OS name: "mac os x", version: "13.4.1", arch: "aarch64", family: "mac"


Dependencies:
junit for unit testing


### Usage:

`mvn compile`

`mvn package`

`java -jar target/shiftTestProject-1.0-SNAPSHOT.jar asd er wer`

`mvn test` - запустить тесты

`mvn clean test jacoco:report` - для покрытия
