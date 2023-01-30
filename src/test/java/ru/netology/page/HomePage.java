package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private SelenideElement purchaseByCard = $x("//span[text()=\"Купить\"]");
    private SelenideElement purchaseByCredit = $x("//span[text()=\"Купить в кредит\"]");

    public CardPaymentPage cardPayment() {
        purchaseByCard.click();
        return new CardPaymentPage();
    }

    public CreditPaymentPage creditPayment() {
        purchaseByCredit.click();
        return new CreditPaymentPage();
    }
}
