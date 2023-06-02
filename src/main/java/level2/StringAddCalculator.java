package level2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String text) {
        // null, empty check
        if(text == null || text.isEmpty())
            return 0;

        // single num or split
        if(text.length() == 1)
            return Integer.parseInt(validation(text));
        else
            return Arrays.stream(split(text)).mapToInt(i -> {
                return Integer.parseInt(validation(i));
            }).sum();
    }

    private String[] split(String text) {
        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            tokens = m.group(2).split(m.group(1));
        } else {
            tokens = text.split(",|:");
        }
        return tokens;
    }

    private String validation(String text) {
        try {
            if(Integer.signum(Integer.parseInt(text)) < 0)
                throw new RuntimeException("음수");

            return text;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 아님");
        }
    }
}
