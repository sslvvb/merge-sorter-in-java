# merge-sorter-in-java
## Программа сортировки слиянием нескольких файлов.

### Requierements:

#### Java vesion:

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



##### Ввод значений:
- Параметры с флагами ожидаются до имени выходного и входных файлов.
- Порядок ввода флагов неважен.
- Нельзя вводить несколько флагов одного параметра/режима (сначала инт, затем строка).
- Имена входных файлов указываются только после выходного.
- Именя файлов не начинаются с символа '-'.


##### Особенности реализации:
По заданию считается, что файлы предварительно отсортированы.
(но строки с пробелами считаются ошибочными)
Строки с пробелами или не являющиеся числами будут пропущены.
Если нарушен порядок сортировки, ошибочное значение будет пропущено.
// в вывод ошибки пишу файл, ошибочную строку и ее порядковый номер, чтобы было удобно найти невалидные данные если нужно.
Нижеследующие значения, удавлетворяющие заданному условию, будут обработаны.

После этого будет происходить слияние уже точно отсортированных файлов. ??? не сделала сортировку больших файлов


##### Сортировка:

В случае неправильно отсортированных файлов программа работает медленнее за счет лишних операций по сортировке.
Зато не происходит потеря данных неверно отсортированных данных.

Будут потеряны только данные неправильного формата.


# To do:
- собрать exe для windows и будет ли работать ?