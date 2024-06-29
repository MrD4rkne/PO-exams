package Collectors;

public record Condition<T>(T firstPosValue, T value) {
    @Override
    public String toString() {
        return "Condition: 0-index:" + firstPosValue + " value:" + value;
    }
}
