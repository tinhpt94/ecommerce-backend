package com.tinhpt.ecommerce.utils;

public class StringUtils {
    public static String convertToCode(String name) {
        return name.toLowerCase().replace(" ", "-");
    }
}
