package com.kblyumkin.lecture11.examples;

public class StringVsStringBuilder {
    public static void main(String[] args) {
        String name = "John";
        String lastName = "Smith";
        System.out.println(name.startsWith("Jo"));
        System.out.println(name.endsWith("hn"));
        System.out.println(name.substring(1));
        System.out.println(name.substring(1, 3));
        String fullName = "John" + " " + "Smith";
        StringBuffer sb = new StringBuffer("John");
        sb.append(" ").append("Smith");
        System.out.println(sb.toString());
    }
}
