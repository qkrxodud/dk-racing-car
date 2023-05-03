package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    /**
     * contains: 중복여부, 순서에 관계 없이 값만 일치
     * containsOnly: 순서, 중복을 무시하는 대신 원소값과 갯수가 정확히 일치
     * containsExactly: 순서를 포함해서 정확히 일치
     */
    @Test
    @DisplayName("요구사항 1")
    void Requirements01() {
        String array1 = "1,2";
        String array2 = "1";

        String[] answer1 = array1.split(",");
        String[] answer2 = array2.split(",");

        assertThat(answer1).containsExactly("1", "2");
        assertThat(answer2).contains("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void Requirements02() {
        String str = "(1,2)";

        String answer = str.substring(str.indexOf("(")+1, str.lastIndexOf(")"));

        assertThat("1,2").contains(answer);
    }

    @Test
    @DisplayName("요구사항 3")
    void Requirements03() {
        String str = "abc";

        // 3-1
        assertThat(str.charAt(1)).isEqualTo('b');

        // Test case1
        assertThatThrownBy(() -> {str.charAt(9);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .isInstanceOf(IndexOutOfBoundsException.class);

        // Test case2
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> { str.charAt(9);})
                .withMessageContaining("out");

        // Test case3
        Throwable thrown = catchThrowable(() -> { throw new StringIndexOutOfBoundsException("out!"); });
        assertThat(thrown)
                .isInstanceOf(Exception.class)
                .hasMessageContaining("out");
    }
}
