package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class SQLHelper {

    @SneakyThrows
    public static String getCardPaymentStatus() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM payment_entity ORDER BY id DESC LIMIT 1;";
        var dbUrl = System.getProperty("db.url");
        var dbUser = System.getProperty("db.username");
        var dbPass = System.getProperty("db.password");
        var conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        return runner.query(conn, status, new ScalarHandler<>());
    }
    @SneakyThrows
    public static String getCreditPaymentStatus() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM credit_request_entity ORDER BY id DESC LIMIT 1;";
        var dbUrl = System.getProperty("db.url");
        var dbUser = System.getProperty("db.username");
        var dbPass = System.getProperty("db.password");
        var conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        return runner.query(conn, status, new ScalarHandler<>());
    }
    @SneakyThrows
    public static void cleanTables() {
        var runner = new QueryRunner();
        var cleanCredit = "DELETE FROM credit_request_entity;";
        var cleanOrder = "DELETE FROM order_entity;";
        var cleanPayment = "DELETE FROM payment_entity;";
        var dbUrl = System.getProperty("db.url");
        var dbUser = System.getProperty("db.username");
        var dbPass = System.getProperty("db.password");
        var conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        runner.update(conn, cleanCredit);
        runner.update(conn, cleanOrder);
        runner.update(conn, cleanPayment);
    }
}


