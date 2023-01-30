package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.*;

public class CardPaymentPage {

    private SelenideElement cardNumber = $("[placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement month = $("[placeholder=\"08\"]");
    private SelenideElement year = $("[placeholder=\"22\"]");
    private SelenideElement owner = $x("//*[text()='Владелец']/following-sibling::span/input");
    private SelenideElement cvv = $("[placeholder=\"999\"]");
    private SelenideElement continueButton = $x("//span[text()=\"Продолжить\"]");
    private SelenideElement cardNumberError = $x("//*[text()='Номер карты']/following-sibling::span[2]");
    private SelenideElement monthError = $x("//*[text()='Месяц']/following-sibling::span[2]");
    private SelenideElement yearError = $x("//*[text()='Год']/following-sibling::span[2]");
    private SelenideElement ownerError = $x("//*[text()='Владелец']/following-sibling::span[2]");
    private SelenideElement cvvError= $x("//*[text()='CVC/CVV']/following-sibling::span[2]");

    public void fillCardInfo(DataHelper.CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getCardNumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        owner.setValue(cardInfo.getOwner());
        cvv.setValue(cardInfo.getCvc());
        continueButton.click();
    }

    public void successfulPaymentNotification() {
        $(".notification_status_ok").shouldBe(visible, ofSeconds(40));
    }

    public void unsuccessfulPaymentNotification() {
        $(".notification_status_error").shouldBe(visible, ofSeconds(40));
    }

    public void cardNumberErrorCaption(String text) {
        cardNumberError.shouldBe(visible).shouldHave(Condition.text(text));
    }

    public void monthErrorCaption(String text) {
        monthError.shouldBe(visible).shouldHave(Condition.text(text));
    }

    public void yearErrorCaption(String text) {
        yearError.shouldBe(visible).shouldHave(Condition.text(text));
    }

    public void ownerErrorCaption(String text) {
        ownerError.shouldBe(visible).shouldHave(Condition.text(text));
    }

    public void cvvErrorCaption(String text) {
        cvvError.shouldBe(visible).shouldHave(Condition.text(text));
    }

}
