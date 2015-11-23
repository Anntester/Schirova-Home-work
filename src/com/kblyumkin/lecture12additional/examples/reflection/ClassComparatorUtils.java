package com.kblyumkin.lecture12additional.examples.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ClassComparatorUtils {
    private ClassComparatorUtils() {}

    public static boolean isAllFieldsAreNull(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object currentValue = field.get(obj);
                if (currentValue != null && field.getType().isPrimitive()) {
                    if (boolean.class.equals(field.getType())) {
                        if (field.getBoolean(obj)) {
                            return false;
                        }
                    } else if (field.getInt(obj) != 0) {
                        return false;
                    }
                } else if (currentValue != null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error comparing fields", e);
            }
        }
        return true;
    }

    public static boolean isAllFieldsAreEquals(Object first, Object second) {
        Field[] fields = first.getClass().getDeclaredFields();
        for (Field firstField : fields) {
            try {
                firstField.setAccessible(true);
                Field secondField;
                try {
                    secondField = second.getClass().getDeclaredField(firstField.getName());
                } catch (NoSuchFieldException e) {
                    return false;
                }
                secondField.setAccessible(true);
                Object currentFirstValue = firstField.get(first);
                Object currentSecondValue = secondField.get(second);

                if (!firstField.getType().equals(secondField.getType()) ||
                        (currentFirstValue == null ^ currentSecondValue == null)) {
                    return false;
                }

                if (currentFirstValue != null && firstField.getType().isPrimitive()) {
                    if (boolean.class.equals(firstField.getType())) {
                        if (firstField.getBoolean(first) != secondField.getBoolean(second)) {
                            return false;
                        }
                    } else if ("long".equals(firstField.getType().getName())) {
                        if (firstField.getLong(first) != firstField.getLong(second)) {
                            return false;
                        }
                    } else if (firstField.getInt(first) != firstField.getInt(second)) {
                        return false;
                    }
                } else if (currentFirstValue != null && firstField.getType().isArray()) {
                    int firstArrayLength = Array.getLength(currentFirstValue);
                    int secondArrayLength = Array.getLength(currentSecondValue);
                    if (firstArrayLength != secondArrayLength) {
                        return false;
                    }
                    for (int index = 0; index < firstArrayLength; index++) {
                        if (Array.get(currentFirstValue, index).getClass().isPrimitive() &&
                                Array.get(currentFirstValue, index) != Array.get(currentSecondValue, index)) {
                            return false;
                        } else {
                            if (Array.get(currentFirstValue, index) == null ^ Array.get(currentSecondValue, index) == null) {
                                return false;
                            }
                            if (Array.get(currentFirstValue, index) != null &&
                                    !isAllFieldsAreEquals(Array.get(currentFirstValue, index),
                                            Array.get(currentSecondValue, index))) {
                                return false;
                            }
                        }
                    }

                } else if (currentFirstValue != null && firstField.getType().equals(String.class)) {
                    if (!currentFirstValue.equals(currentSecondValue)) {
                        return false;
                    }
                } else if (currentFirstValue != null && !isAllFieldsAreEquals(currentFirstValue, currentSecondValue)) {
                    return false;
                }
            } catch (IllegalAccessException e) {
            }
        }
        return true;
    }
}
