package com.kblyumkin.lecture5.examples.enumexamples;

public enum TrueCardType {

    AMEX {
        @Override
        public boolean validate(String ccNo) {
            if (!isDigitsOnly(ccNo)) {
                return false;
            }
            return  (ccNo.length() == 16) && ccNo.startsWith("3");
        }
    }, VISA {
        @Override
        public boolean validate(String ccNo) {
            if (!isDigitsOnly(ccNo)) {
                return false;
            }
            return (ccNo.length() == 16 && ccNo.startsWith("4"));
        }
    }, MASTER_CARD {
        @Override
        public boolean validate(String ccNo) {
            if (!isDigitsOnly(ccNo)) {
                return false;
            }
            return ((ccNo.length() == 12 || ccNo.length() == 16) && ccNo.startsWith("5"));
        }
    };


    public abstract boolean validate(String ccNo);
    private static  boolean isDigitsOnly(String ccNo) {
        return ccNo.matches("\\d+");
    }
}
