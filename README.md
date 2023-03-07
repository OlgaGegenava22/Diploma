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

• Node.js

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
    
6. Открыть с клонированный проект в Intellij IDEA

7. В терминале в папке gate-simulator запустить симулятор банковских сервисов: npm start

# Для работы с базой данных MySQL

**В новом окне терминала в корне проекта используется приложение под БД MySQL:**

1.	Запустить SUT во вкладке Terminal Intellij IDEA командой:

java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar


2. Для запуска авто-тестов в Terminal Intellij IDEA открыть новую сессию и ввести команду:

./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.username=app" "-Ddb.password=pass"


3. Для просмотра отчета Allure в терминале ввести команду:

./gradlew allureServe


# Для работы с базой данных PostgreSQL
1. Запустить приложение под БД PostgresSQL с помощью команды в терминале:

 2. Далее во вкладке Terminal Intellij IDEA запустить SUT командой:

   java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
    

4.	Для запуска авто-тестов в Terminal Intellij IDEA открыть новую сессию и ввести команду:

./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app" "-Ddb.username=app" "-Ddb.password=pass"


5. Для просмотра отчета Allure в терминале ввести команду:

./gradlew allureServe

# Закрыть отчёт:

    CTRL + C -> y -> Enter
    
# Перейти в первый терминал и остановить приложение:

    CTRL + C
    
# Остановить контейнеры:

    docker-compose down
