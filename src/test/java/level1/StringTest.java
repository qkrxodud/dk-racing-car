package level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("문자열 자르기")
    void split() {
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.\n")
    void removeBracket() {
        //given
        String input = "(1,2)";

        //when
        String substring = input.substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 문자 찾기, 입력값 범위 밖을 경우 String index out of range 발생")
    void findCharacter() {
        //given
        String msg = "abc";

        //when
        //then
        assertThatThrownBy(() -> {
            char c = msg.charAt(msg.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(msg.length()));
    }
}
