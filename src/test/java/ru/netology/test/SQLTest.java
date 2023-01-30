package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class SQLTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @AfterAll
    public static void setDown() {
        SQLHelper.cleanTables();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED")
    void successfulPaymentWithApprovedCard() {
        var homePage = new HomePage();
        var cardPaymentPage = homePage.cardPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber1();
        cardPaymentPage.fillCardInfo(cardInfo);
        Assertions.assertEquals("APPROVED", SQLHelper.getCardPaymentStatus());
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус DECLINED")
    void unsuccessfulPaymentWithDeclinedCard() {
        var homePage = new HomePage();
        var cardPaymentPage = homePage.cardPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithDeclinedCardNumber();
        cardPaymentPage.fillCardInfo(cardInfo);
        Assertions.assertEquals("DECLINED", SQLHelper.getCardPaymentStatus());
    }

    @Test
    @DisplayName("Покупка тура по карте, которой нет в базе")
    void unsuccessfulPaymentWithRandomCard() {
        var homePage = new HomePage();
        var cardPaymentPage = homePage.cardPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getDataWithRandomCardNumber();
        cardPaymentPage.fillCardInfo(cardInfo);
        Assertions.assertNull(SQLHelper.getCardPaymentStatus());
    }

    @Test
    @DisplayName("Тур в кредит по карте, для которой задан статус APPROVED")
    void successfulPaymentWithApprovedCardByCredit() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber1();
        creditPaymentPage.fillCardInfo(cardInfo);
        Assertions.assertEquals("APPROVED", SQLHelper.getCreditPaymentStatus());
    }

    @Test
    @DisplayName("Тур в кредит по карте, для которой задан статус DECLINED")
    void unsuccessfulPaymentWithDeclinedCardByCredit() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithDeclinedCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        Assertions.assertEquals("DECLINED", SQLHelper.getCreditPaymentStatus());
    }

    @Test
    @DisplayName("Тур в кредит по карте, которой нет в базе")
    void unsuccessfulPaymentWithRandomCardByCredit() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getDataWithRandomCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        Assertions.assertNull(SQLHelper.getCreditPaymentStatus());
    }
}
