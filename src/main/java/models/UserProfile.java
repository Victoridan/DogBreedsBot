package models;

public class UserProfile {
    private int activityPreference; // 1-активный, 2-домосед
    private boolean hasAllergy; // есть ли аллергия
    private boolean hasChildren; // есть ли дети
    private String livingSpace; // "apartment" или "house"
    private String dogRole; // "friend" или "guard"
    private String dogSize; // "small", "medium", "large"
    private boolean willingToTrain; // готов дрессировать
    private boolean needGoodWithAnimals; // должно ладить с животными
    private int groomingFrequency; // 1-редко, 2-иногда, 3-часто

    // Конструктор по умолчанию
    public UserProfile() {
        // Инициализируем значения по умолчанию
        reset();
    }

    // Метод для сброса всех ответов
    public void reset() {
        this.activityPreference = 0;
        this.hasAllergy = false;
        this.hasChildren = false;
        this.livingSpace = "";
        this.dogRole = "";
        this.dogSize = "";
        this.willingToTrain = false;
        this.needGoodWithAnimals = false;
        this.groomingFrequency = 0;
    }

    // Проверяем, заполнен ли профиль полностью
    public boolean isComplete() {
        return activityPreference != 0 &&
                livingSpace != null && !livingSpace.isEmpty() &&
                dogRole != null && !dogRole.isEmpty() &&
                dogSize != null && !dogSize.isEmpty() &&
                groomingFrequency != 0;
    }

    // Геттеры и сеттеры для всех полей
    public int getActivityPreference() { return activityPreference; }
    public void setActivityPreference(int activityPreference) {
        this.activityPreference = activityPreference;
    }

    public boolean hasAllergy() { return hasAllergy; }
    public void setHasAllergy(boolean hasAllergy) {
        this.hasAllergy = hasAllergy;
    }

    public boolean hasChildren() { return hasChildren; }
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getLivingSpace() { return livingSpace; }
    public void setLivingSpace(String livingSpace) {
        this.livingSpace = livingSpace;
    }

    public String getDogRole() { return dogRole; }
    public void setDogRole(String dogRole) {
        this.dogRole = dogRole;
    }

    public String getDogSize() { return dogSize; }
    public void setDogSize(String dogSize) {
        this.dogSize = dogSize;
    }

    public boolean isWillingToTrain() { return willingToTrain; }
    public void setWillingToTrain(boolean willingToTrain) {
        this.willingToTrain = willingToTrain;
    }

    public boolean needGoodWithAnimals() { return needGoodWithAnimals; }
    public void setNeedGoodWithAnimals(boolean needGoodWithAnimals) {
        this.needGoodWithAnimals = needGoodWithAnimals;
    }

    public int getGroomingFrequency() { return groomingFrequency; }
    public void setGroomingFrequency(int groomingFrequency) {
        this.groomingFrequency = groomingFrequency;
    }
}