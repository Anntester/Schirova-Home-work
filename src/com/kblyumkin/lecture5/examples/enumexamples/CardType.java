package com.kblyumkin.lecture5.examples.enumexamples;


public abstract class CardType {

    private String cardType;

    protected CardType() {}

    public abstract boolean validate(String ccNo);

    protected boolean isDigitsOnly(String ccNo) {
        return ccNo.matches("\\d+");
    }

    public static class MasterCard extends CardType {
        public static final CardType MASTER_CARD = new CardType.MasterCard();

        private MasterCard() {}

        @Override
        public boolean validate(String ccNo) {
            if (!isDigitsOnly(ccNo)) {
                return false;
            }
            return  ((ccNo.length() == 12 || ccNo.length() == 16) && ccNo.startsWith("5"));
        }
    }

    public static class Visa extends CardType {
        public static final CardType VISA = new CardType.Visa();

        private Visa() {}

        @Override
        public boolean validate(String ccNo) {
            if (!isDigitsOnly(ccNo)) {
                return false;
            }
            return (ccNo.length() == 16 && ccNo.startsWith("4"));
        }
    }

    public static class Amex extends CardType {
        public static final CardType AMEX = new CardType.Amex();

        private Amex() {}

        @Override
        public boolean validate(String ccNo) {
            if (!isDigitsOnly(ccNo)) {
                return false;
            }
            return (ccNo.length() == 16 && ccNo.startsWith("3"));
        }
    }

}
