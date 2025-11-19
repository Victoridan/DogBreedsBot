package models;

public enum DogSize {
    SMALL,
    MEDIUM,
    LARGE;

    public int getSize() {
        switch (this) {
            case SMALL:
                return 1;
            case MEDIUM:
                return 2;
            case LARGE:
                return 3;
            default:
                return 0;
        }
    }

    public final String getRussianName() {
        switch (this) {
            case SMALL:
                return "Маленькая";
            case MEDIUM:
                return "Средняя";
            case LARGE:
                return "Большая";
            default:
                return "Неизвестно";
        }
    }

    public static DogSize fromSize(int size) {
        switch (size) {
            case 1:
                return SMALL;
            case 2:
                return MEDIUM;
            case 3:
                return LARGE;
            default:
                throw new IllegalArgumentException("Неизвестный размер собачки " + size);
        }
    }
}