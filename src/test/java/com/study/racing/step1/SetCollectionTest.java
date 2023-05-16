package com.study.racing.step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Test
    @DisplayName("요구사항 1")
    public void test1() {
        System.out.println(numbers.size());
    }

    @Test
    @DisplayName("요구사항 2-1")
    public void test2_1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2-2")
    public void test2_2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5"})
    @DisplayName("요구사항 3")
    public void test3_1(int input) {

        assertThat(input >=4).isFalse();

        if(input < 4) {
            assertThat(numbers.contains(input)).isTrue();
        }
    }

}
