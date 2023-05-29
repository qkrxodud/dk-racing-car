package level2;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.util.NumberUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void ExpectedExceptionTest() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("For input string");
        Integer.parseInt("dddd");
    }
}

class StringAddCalculator {
    public static int splitAndSum(String text) {
        // null, empty check
        if(text == null || text.isEmpty())
            return 0;

        // single num or split
        if(text.length() == 1)
            return Integer.parseInt(validation(text));
        else
            return Arrays.stream(split(text)).mapToInt( i -> {
                return Integer.parseInt(validation(i));
            }).sum();
    }

    private static String[] split(String text) {
        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            tokens = m.group(2).split(m.group(1));
        } else {
            tokens = text.split(",|:");
        }
        return tokens;
    }

    private static String validation(String text) {
        try {
            if(Integer.signum(Integer.parseInt(text)) < 0)
                throw new RuntimeException("음수");

            return text;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 아님");
        }
    }
}
