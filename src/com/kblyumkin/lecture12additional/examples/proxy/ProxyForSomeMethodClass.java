package com.kblyumkin.lecture12additional.examples.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForSomeMethodClass {
    private static final Object lock = new Object();

    public static SomeMethodsInterface newInstance(final SomeMethodsClass smc) {
        return (SomeMethodsInterface) Proxy.newProxyInstance(
                SomeMethodsClass.class.getClassLoader(),
                SomeMethodsClass.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Entering synchronized section");
                        try {
                            synchronized (lock) {
                                return method.invoke(smc, args);
                            }
                        } finally {
                            System.out.println("Leaving synchronized section");
                        }
                    }
                });
    }
}
