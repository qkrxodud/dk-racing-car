package com.study.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

@DisplayName("\uD83D\uDE80String 클래스에 대한 학습 테스트 - 1단계")
class CarTest {
	String regex = ",";

	@Nested
	@Test
	@DisplayName("요구사항 1-1")
	public void case_1() {
		String testStr = "1,2";
		String[] strings = testStr.split(regex);

		// 값 일치
		assertThat(strings).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-2")
	public void case_2() {
		String testStr = "1";
		String[] strings = testStr.split(regex);

		// containsExactly 순서와 값이 정확히 일치
		assertThat(strings).containsExactly("1");
	}
}