package com.kblyumkin.lecture5.examples.enumexamples;

public class CardTypeTest {
    public static void main(String[] args) {
        /*CardType cardType = CardType.Visa.VISA;
        CardType anotherCardType = CardType.Visa.VISA;

        System.out.println(cardType.equals(anotherCardType));
        System.out.println(cardType.validate("4123123412341231"));*/


        TrueCardType cardType = TrueCardType.MASTER_CARD;
        TrueCardType anotherCardType = TrueCardType.MASTER_CARD;
        System.out.println(cardType.equals(anotherCardType));
        System.out.println(cardType.validate("5123123412341231"));
    }
}
