package com.kblyumkin.lecture5.examples.monkeybuisness;

public class MonkeyTest {
    public static void main(String[] args) {
        try (Monkey monkey = new Monkey();
             Monkey youngMonkey = new Monkey()){
            youngMonkey.wakeUp();
            monkey.wakeUp();
            monkey.doMonkeyBusiness();
            youngMonkey.doMonkeyBusiness();
            //monkey.doMonkeyBusiness();
        } catch (MonkeyWakeUpException | MonkeyBoomException e) {

        }
    }
}
