package models;

public enum ActivityLevel {
    VERY_LOW,
    LOW,
    MEDIUM,
    HIGH,
    VERY_HIGH;

    public int getLevel() {
        switch (this) {
            case VERY_LOW: return 1;
            case LOW: return 2;
            case MEDIUM: return 3;
            case HIGH: return 4;
            case VERY_HIGH: return 5;
            default: return 0;
        }
    }
    public String getRussianName() {
        switch (this) {
            case VERY_LOW: return "Очень низкая";
            case LOW: return "Низкая";
            case MEDIUM: return "Средняя";
            case HIGH: return "Высокая";
            case VERY_HIGH: return "Очень высокая";
            default: return "Неизвестно";
        }
    }

    public static ActivityLevel fromLevel(int level) {
        switch (level) {
            case 1: return VERY_LOW;
            case 2: return LOW;
            case 3: return MEDIUM;
            case 4: return HIGH;
            case 5: return VERY_HIGH;
            default: throw new IllegalArgumentException("Неизвестный уровень активности: " + level);
        }
    }
}