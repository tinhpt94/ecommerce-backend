package com.tinhpt.ecommerce.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    public static String convertToCode(String name) {
        try {
            String temp = Normalizer.normalize(name, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
