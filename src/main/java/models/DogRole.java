package models;

public enum DogRole {
    COMPANION,
    GUARD;

    public int getRole() {
        switch (this) {
            case COMPANION:
                return 1;
            case GUARD:
                return 2;
            default:
                return 0;
        }
    }

    public String getRussianName() {
        switch (this) {
            case COMPANION:
                return "Друг";
            case GUARD:
                return "Охранник";
            default:
                return "Неизвестно";
        }
    }

    public static DogRole fromRole(int role) {
        switch (role) {
            case 1:
                return COMPANION;
            case 2:
                return GUARD;
            default:
                throw new IllegalArgumentException("Неизвестная роль" + role);
        }
    }
}