package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private DataHelper() {
    }

    private static Faker faker = new Faker();
    private static Faker ruFaker = new Faker(new Locale("ru"));

    @Data
    @AllArgsConstructor
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static String getApprovedCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return ("4444 4444 4444 4442");
    }

    public static String getShortCardNumber() {
        return ("4444 4444 4444 444");
    }

    public static String getLongCardNumber() {
        return ("4444 4444 4444 44411");
    }

    public static String getRandomCardNumber() {
        return faker.numerify("################");
    }

    public static String getLetterInsteadOfNumber() { //для номера карты, месяца, года, CVV
        return faker.letterify("???");
    }

    public static String getSymbolInsteadOfNumber() { //для номера карты, месяца, года, CVV
        return ("%");
    }

    public static String getPastMonth(int months) {
        return LocalDate.now().minusMonths(months).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getFutureYear(int years) {
        return LocalDate.now().plusYears(years).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getPastYear(int years) {
        return LocalDate.now().minusYears(years).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getThreeNumbersMonth() {
        return faker.numerify("05#");
    }

    public static String getThreeNumbersYear() {
        return faker.numerify("26#");
    }

    public static String getOneNumber() { //для месяца, года, CVV
        return faker.numerify("#");
    }

    public static String getTwoNumbers() { //для месяца, года, CVV
        return faker.numerify("##");
    }

    public static String getThreeNumbers() { //для месяца, года, CVV
        return faker.numerify("###");
    }

    public static String getFourNumbers() {
        return faker.numerify("####");
    }

    public static String getValidName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getValidDoubleName() {
        return faker.name().nameWithMiddle();
    }

    public static String getValidDoubleNameWithHyphen() {
        return faker.letterify("????? ???-???");
    }

    public static String getValidDoubleNameWithApostrophe() {
        return faker.letterify("????? ??`?????");
    }

    public static String getInvalidNameInCyrillic() {
        return ruFaker.name().firstName() + " " + ruFaker.name().lastName();
    }

    public static String getInvalidNameWithNumbers() {
        return faker.bothify("???###?");
    }

    public static String getInvalidNameWithWrongSymbols() {
        return faker.letterify("???+?? ?????");
    }

    public static String getEmptyString() {
        return ("");
    }

    public static CardInfo getValidDataWithApproveCardNumber1() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getValidDataWithApproveCardNumber2() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidDoubleNameWithHyphen(),
                getThreeNumbers()
        );
    }
    public static CardInfo getValidDataWithApproveCardNumber3() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidDoubleName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getValidDataWithApproveCardNumber4() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidDoubleNameWithApostrophe(),
                getThreeNumbers()
        );
    }

    public static CardInfo getValidDataWithApproveCardNumber5() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(0),
                getFutureYear(0),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getValidDataWithDeclinedCardNumber() {
        return new CardInfo(getDeclinedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithShortCardNumber() {
        return new CardInfo(getShortCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithLongCardNumber() {
        return new CardInfo(getLongCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithLetterInCardNumber() {
        return new CardInfo(getLetterInsteadOfNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithSymbolInCardNumber() {
        return new CardInfo(getSymbolInsteadOfNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithPastYear() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getPastYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithPastMonthOfCurrentYear() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(8),
                getFutureYear(0),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithOneNumberMonth() {
        return new CardInfo(getApprovedCardNumber(),
                getOneNumber(),
                getFutureYear(2),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithThreeNumbersMonth() {
        return new CardInfo(getApprovedCardNumber(),
                getThreeNumbersMonth(),
                getFutureYear(2),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithThreeNumbersYear() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getThreeNumbersYear(),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithLetterInMonth() {
        return new CardInfo(getApprovedCardNumber(),
                getLetterInsteadOfNumber(),
                getFutureYear(2),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithSymbolInMonth() {
        return new CardInfo(getApprovedCardNumber(),
                getSymbolInsteadOfNumber(),
                getFutureYear(2),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithLetterInYear() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getLetterInsteadOfNumber(),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithSymbolInYear() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getSymbolInsteadOfNumber(),
                getValidName(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithNameInCyrillic() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getInvalidNameInCyrillic(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithNumbersInName() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getInvalidNameWithNumbers(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInvalidDataWithWrongSymbolsInName() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getInvalidNameWithWrongSymbols(),
                getThreeNumbers()
        );
    }

    public static CardInfo getInValidDataWithTwoNumbersInCVC() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getTwoNumbers()
        );
    }

    public static CardInfo getInValidDataWithFourNumbersInCVC() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getFourNumbers()
        );
    }

    public static CardInfo getInValidDataWithLetterInCVC() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getLetterInsteadOfNumber()
        );
    }

    public static CardInfo getInValidDataWithSymbolInCVC() {
        return new CardInfo(getApprovedCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getSymbolInsteadOfNumber()
        );
    }

    public static CardInfo getInvalidDataWithEmptyStrings() {
        return new CardInfo(getEmptyString(),
                getEmptyString(),
                getEmptyString(),
                getEmptyString(),
                getEmptyString()
        );
    }

    public static CardInfo getDataWithRandomCardNumber() {
        return new CardInfo(getRandomCardNumber(),
                getPastMonth(2),
                getFutureYear(1),
                getValidName(),
                getThreeNumbers()
        );
    }
}














