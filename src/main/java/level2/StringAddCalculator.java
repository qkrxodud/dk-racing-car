package level2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String CUSTOM_REGEX = "//(.)\n(.*)";
    private final static String REGEX = ",|:";
    private final static int NUM_ONE = 1;
    private final static int NUM_TWO = 2;

    public int splitAndSum(String text) {
        // null, empty check
        if(text == null || text.isEmpty())
            return 0;

        return sumArray(text);
    }

    /**
     * TODO <a href="https://dublin-java.tistory.com/47">...</a>
     */
    private int sumArray(String text) {
        return Arrays
            .stream(split(text))
            .mapToInt(i -> {
                return Integer.parseInt(validation(i));
            })
            .sum();
    }

    private String[] split(String text) {
        String[] tokens;
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if(matcher.find()) {
            tokens = matcher.group(NUM_TWO).split(matcher.group(NUM_ONE));
        } else {
            tokens = text.split(REGEX);
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
