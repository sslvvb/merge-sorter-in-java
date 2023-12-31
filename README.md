## Программа сортировки слиянием нескольких файлов.

### Dependencies:

- Java version: Java 8
- Build system: Maven
- JUnit, Mockito for unit testing
- Jacoco for coverage

### About:

Программа сортировки слиянием нескольких файлов. Входные файлы содержат данные одного из двух видов: целые числа или строки. Данные записаны в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные символы, строки с пробелами считаются ошибочными. Также считается, что файлы предварительно отсортированы. Результатом работы программы должен являться новый файл с объединенным содержимым входных файлов, отсортированным по возрастанию или убыванию путем сортировки слиянием.

##### Особенности реализации:
- Параметры с флагами ожидаются до имени выходного и входных файлов.
- Порядок ввода флагов неважен.
- Нельзя вводить несколько флагов одного параметра/режима (сначала инт, затем строка).
- Имена входных файлов указываются только после выходного.

Строки с пробелами или не являющиеся числами будут пропущены.
Если нарушен порядок сортировки, ошибочное значение будет пропущено.
Нижеследующие значения, удавлетворяющие условию, будут обработаны.

Параметры командной строки для корректной работы:

* режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
* тип данных (-s или -i), обязательный;
* имя выходного файла, обязательное; (все пути относительно директории запуска)
* остальные параметры – имена входных файлов, не менее одного.

### Usage:

1) В корне директории для сборки проекта:

`mvn package`

2) Для запуска из корня директории:

`java -jar target/shiftTestProject-1.0-SNAPSHOT.jar -a -i out.txt in1.txt in2.txt in3.txt`

3) Для запуска тестов:

`mvn test`

4) Покрытие:

`mvn clean test jacoco:report`
