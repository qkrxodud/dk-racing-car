package com.study.racing.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringSumTest {

    /**
     * 기본구분자 : ",", ":" => 합을 반환
     * 커스텀 구분자 : "//", "\n" 사이에 위치하는 문자
     * 숫자 이외의값, 음수 전달 시 Exception 발생
     */


    @Test
    @DisplayName("요구사항 1")
    public void test1() {
        String text = null;

        Integer result = StringAddCalculator.isEmpty(text);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("요구사항 2")
    public void test2() {
        String text = "1";

        Integer result = StringAddCalculator.isNumber(text);
        assertThat(result).isNotNull().isEqualTo(1);

    }

    @Test
    @DisplayName("요구사항 3")
    public void test3() {
        String text = "1,2";
        String[] numbers = text.split(",");

        Integer result = StringAddCalculator.splitAndSum(numbers);
        assertThat(result).isNotNull().isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 4")
    public void test4() {
        String text = "1,2:3";
        String[] tokens= text.split(",|:");

        Integer result = StringAddCalculator.splitAndSum(tokens);
        assertThat(result).isNotNull().isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 5")
    public void test5() {
        String text = "“//;\n1;2;3";
        int result = 0;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            result = StringAddCalculator.splitAndSum(tokens);
        }

        assertThat(result).isNotNull().isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 6")
    public void test6() {
        String text = "-1,2,3";

        String[] tokens= text.split(",|:");

        boolean hasNegative = Arrays.stream(tokens).mapToInt(Integer::parseInt).anyMatch(num -> num < 0);

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                if (hasNegative) {
                    throw new RuntimeException("Have Negative");
                }
            });

    }


}
