package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        checks.put("required", input -> input instanceof Integer);
    }

    public NumberSchema required() {
        requiredFlag = true;
        return this;
    }

    public NumberSchema positive() {
        checks.put("positive", number -> (int) number > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        // Make sure to have range look like "start <= input <= end"
        int normalizedStart = Math.min(start, end);
        int normalizedEnd = Math.max(start, end);
        Predicate<Object> checkRange = number -> (int) number >= normalizedStart && (int) number <= normalizedEnd;
        checks.put("range", checkRange);
        return this;
    }
}
