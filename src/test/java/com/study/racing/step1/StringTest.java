package com.study.racing.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("요구사항 1-1")
    public void test1_1() {
        String str = "1,2";
        String[] expected = {"1", "2"};

        String[] answer = str.split(",");

        assertThat(answer).contains("1").containsExactly(expected);
    }

    @Test
    @DisplayName("요구사항 1-2")
    public void test1_2() {
        String str = "1";
        String[] expected = {"1"};
        String[] answer = str.split(",");

        assertThat(answer).contains("1").containsExactly(expected);
    }

    @Test
    @DisplayName("요구사항 2")
    public void test2() {
        String str = "(1,2)";
        int startIndex = str.indexOf("(");
        int endIndex = str.indexOf(")");
        String fixStr = str.substring(startIndex + 1, endIndex);

        assertThat(fixStr).isEqualTo("1,2");

    }

    @Test
    @DisplayName("요구사항 3-1")
    public void test3_1() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3-2")
    public void test3_2() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(3);
        }).withMessageContaining("String index out of range");

    }

}
