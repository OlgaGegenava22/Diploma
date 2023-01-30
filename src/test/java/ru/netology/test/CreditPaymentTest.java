package ru.netology.test;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.HomePage;

import static com.codeborne.selenide.Selenide.open;


public class CreditPaymentTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED c именем и фамилией владельца на латинице")
    void successfulPaymentWithApprovedCard1() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber1();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED c фамилией владельца с дефисом")
    void successfulPaymentWithApprovedCard2() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber2();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED c двойным именем владельца")
    void successfulPaymentWithApprovedCard3() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber3();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED c фамилией владельца с апострофом")
    void successfulPaymentWithApprovedCard4() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber4();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED c текущим месяцем окончания срока действия карты")
    void successfulPaymentWithApprovedCard5() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber5();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус DECLINED")
    void unsuccessfulPaymentWithDeclinedCard() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithDeclinedCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.unsuccessfulPaymentNotification();
    }

    @Test
    @DisplayName("Ввод невалидного номера карты. Ввод номера карты менее 16 цифр")
    void enterInvalidShortCardNumber() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithShortCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cardNumberErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидного номера карты. Ввод номера карты более 16 цифр")
    void enterInvalidLongCardNumber() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithLongCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Ввод невалидного номера карты. Ввод буквы")
    void enterLetterInCardNumber() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithLetterInCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cardNumberErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидного номера карты. Ввод символа")
    void enterSymbolInCardNumber() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithSymbolInCardNumber();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cardNumberErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод прошлого года")
    void enterPastYear() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithPastYear();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.yearErrorCaption("Истёк срок действия карты");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод прошедшего месяца текущего года")
    void enterPastMonthOfCurrentYear() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithPastMonthOfCurrentYear();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.monthErrorCaption("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод месяца одной цифрой")
    void enterOneNumberMonth() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithOneNumberMonth();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.monthErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод месяца тремя цифрами")
    void enterThreeNumbersMonth() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithThreeNumbersMonth();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод года тремя цифрами")
    void enterThreeNumbersYear() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithThreeNumbersYear();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод буквы в поле Месяц")
    void enterLetterInMonth() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithLetterInMonth();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.monthErrorCaption("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод символа в поле Месяц")
    void enterSymbolInMonth() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithSymbolInMonth();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.monthErrorCaption("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод буквы в поле Год")
    void enterLetterInYear() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithLetterInYear();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.yearErrorCaption("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Ввод невалидной даты. Ввод символа в поле Год")
    void enterSymbolInYear() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithSymbolInYear();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.yearErrorCaption("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Ввод невалидных данных владельца. Ввод на кириллице")
    void enterNameOnCyrillic() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithNameInCyrillic();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.ownerErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидных данных владельца. Ввод цифр")
    void enterNumbersInName() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithNumbersInName();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.ownerErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидных данных владельца. Ввод спецсимволов, кроме дефиса и апострофа")
    void enterWrongSymbolsInName() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithWrongSymbolsInName();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.ownerErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидного CVC/CVV. Ввод двух цифр")
    void enterTwoNumbersInCVC() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInValidDataWithTwoNumbersInCVC();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cvvErrorCaption("Неверный формат");
    }

    @Test
    @DisplayName("Ввод невалидного CVC/CVV. Ввод четырех цифр")
    void enterFourNumbersInCVC() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInValidDataWithFourNumbersInCVC();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.successfulPaymentNotification();
    }

    @Test
    @DisplayName("Ввод невалидного CVC/CVV. Ввод букв")
    void enterLettersInCVC() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInValidDataWithLetterInCVC();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cvvErrorCaption("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Ввод невалидного CVC/CVV. Ввод символов")
    void enterSymbolsInCVC() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInValidDataWithSymbolInCVC();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cvvErrorCaption("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Пустые поля")
    void doNotEnterAnything() {
        var homePage = new HomePage();
        var creditPaymentPage = homePage.creditPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getInvalidDataWithEmptyStrings();
        creditPaymentPage.fillCardInfo(cardInfo);
        creditPaymentPage.cardNumberErrorCaption("Поле обязательно для заполнения");
        creditPaymentPage.monthErrorCaption("Поле обязательно для заполнения");
        creditPaymentPage.yearErrorCaption("Поле обязательно для заполнения");
        creditPaymentPage.ownerErrorCaption("Поле обязательно для заполнения");
        creditPaymentPage.cvvErrorCaption("Поле обязательно для заполнения");
    }
}
