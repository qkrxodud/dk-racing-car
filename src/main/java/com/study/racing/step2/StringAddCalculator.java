package com.study.racing.step2;

import java.util.Arrays;
import org.springframework.util.StringUtils;

public class StringAddCalculator {

    public static Integer isEmpty(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        } else {
            return null;
        }
    }

    public static Integer isNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer splitAndSum(String[] numbers) {

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
    }

}
