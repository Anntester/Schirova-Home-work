package com.kblyumkin.lecture12additional.examples;

public class StringRevertExample {
    public static void main(String[] args) {
        String s = "Mama washed the window";
        System.out.println(revertString(s));
        System.out.println(anotherRevertString(s));
        anotherRevertString(null);
    }

    private static String anotherRevertString(String source) {
        return source == null || source.length() <= 1
                ? source
                : new StringBuilder(source).reverse().toString();
    }

    private static String revertString(String source) {
        if (source == null || source.length() <= 1) {
            return source;
        }
        char[] result = new char[source.length()];
        for (int index = 0; index < source.length(); index++) {
            result[index] = source.charAt(source.length() - index - 1);
        }
        return String.valueOf(result);
    }


}
