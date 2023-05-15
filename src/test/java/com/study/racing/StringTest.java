package com.study.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("\uD83D\uDE80String 클래스에 대한 학습 테스트 - 1단계")
class StringTest {
	String regex = ",";

	@Test
	@DisplayName("요구사항 1-1")
	public void case_1_1() {
		String testStr = "1,2";
		String[] strings = testStr.split(regex);

		// 값 일치
		assertThat(strings).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-2")
	public void case_1_2() {
		String testStr = "1";
		String[] strings = testStr.split(regex);

		// containsExactly 순서와 값이 정확히 일치
		assertThat(strings).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2")
	public void case_2() {
		String testStr = "(1,2)";
		// 앞과 뒤 괄호 제거
		testStr = testStr.substring(1, testStr.length()-1);

		// 값 일치
		assertThat(testStr).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항 3")
	public void case_3() {
		String testStr = "abc";
		int idx = testStr.length();

		assertThatThrownBy(() -> System.out.println(testStr.charAt(idx)))
				.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}