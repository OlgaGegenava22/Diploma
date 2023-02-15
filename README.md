# Процедура запуска автотестов
# Предварительные требования
1.	Получить доступ к удаленному серверу

2.	На удаленном сервере должны быть установлены и доступны:

•	GIT

•	Docker

•	Bash

3.	На компьютере пользователя должна быть установлена:

•	Git Bash

•	Intellij IDEA

# Подготовка и запуск

1.	Залогиниться на удаленный сервер

2.	Клонировать проект на удаленный сервер командой:

https://github.com/OlgaGegenava22/Diploma.git

3.	Перейти в созданный каталог командой:
 cd Qa-Diplom 
 
4.	Создать и запустить необходимые Docker Container'ы командой:

docker-compose up -d

5.	Клонировать проект на свой компьютер: открыть терминал (командная строка) и ввести команду:

    git clone https://github.com/OlgaGegenava22/Diploma.git
    
6.	Открыть с клонированный проект в Intellij IDEA

# Для работы с базой данных MySQL
**Проект пред настроен под работу с базой данных MySQL развернутой по ip-адресу 185.119.57.176.**

**Как изменить ip-адрес описано в разделе "Для работы с базой данных PostgreSQL", для MySQL - делается аналогично.**

1.	Запустить SUT во вкладке Terminal Intellij IDEA командой:

java -jar artifacts/aqa-shop.jar
*Дождаться появления строки:
ru.netology.shop.ShopApplication         : Started ShopApplication in 16.682 seconds (JVM running for 19.968)

2.	Для запуска авто-тестов в Terminal Intellij IDEA открыть новую сессию и ввести команду:

./gradlew clean test allureReport -Dheadless=true
(В моем терминале запускается вот такой командой: gradlew clean test allureReport -Dheadless=true) где:

* **allureReport - подготовка данных для отчета Allure;**
* **-Dheadless=true - запускает авто-тесты в headless-режиме (без открытия браузера).**

3. Для просмотра отчета Allure в терминале ввести команду:

./gradlew allureServe
(В моем терминале запускается вот такой командой: gradlew allureServe)

# Для работы с базой данных PostgreSQL

В находящемся в проекте файле build.gradle в разделе test закомментировать строку ниже "//Для работы с базой данных mySQL" и раскомментировать строку ниже "//Для работы с базой данных postgreSQL", выглядеть будет так:

   //Для работы с базой данных mySQL (со строки ниже необходимо снять комментарий):
//systemProperty 'datasource', System.getProperty('datasource', 'jdbc:mysql://185.119.57.164:3306/base_mysql')
//Для работы с базой данных postgreSQL (со строки ниже необходимо снять комментарий):
systemProperty 'datasource', System.getProperty('datasource', 'jdbc:postgresql://185.119.57.164:5432/base_postgresql')
где:

185.119.57.164 - ip-адрес удаленной машины с развернутой PostgreSQL, в случае необходимости заменить на ip-адрес своей удаленной машины с развернутой PostgreSQL.

2. Применить изменения (Ctrl+Shift+O);

3.	Далее во вкладке Terminal Intellij IDEA запустить SUT командой:

    java -jar artifacts/aqa-shop.jar
    
**Дождаться появления строки: ru.netology.shop.ShopApplication  : Started ShopApplication in 17.116 seconds (JVM running for 19.968)**

4.	Для запуска авто-тестов в Terminal Intellij IDEA открыть новую сессию и ввести команду:

./gradlew clean test allureReport -Dheadless=true
(В моем терминале запускается вот такой командой: gradlew clean test allureReport -Dheadless=true) где:

* allureReport - подготовка данных для отчета Allure;

* -Dheadless=true - запускает авто-тесты в headless-режиме (без открытия браузера).

5. Для просмотра отчета Allure в терминале ввести команду:

./gradlew allureServe
(В моем терминале запускается вот такой командой: gradlew allureServe)

# Закрыть отчёт:

    CTRL + C -> y -> Enter
    
# Перейти в первый терминал и остановить приложение:

    CTRL + C
    
# Остановить контейнеры:

    docker-compose down
