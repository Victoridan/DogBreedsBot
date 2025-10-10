package models;

/**
 * Класс для представления породы собаки
 * Содержит все характеристики, которые учитываются при подборе
 */
public class DogBreed {
    private String name;
    private String size; // "small", "medium", "large"
    private int activityLevel; // 1-5 (1 - низкая, 5 - высокая)
    private boolean hypoallergenic; // гипоаллергенная ли порода
    private boolean goodWithKids; // хорошо ли ладит с детьми
    private boolean suitableForApartment; // подходит для квартиры
    private String role; // "companion", "guard"
    private int trainingDifficulty; // 1-5 (1 - легко обучаема, 5 - сложно)
    private boolean goodWithOtherAnimals; // ладит с другими животными
    private int groomingNeeds; // 1-5 (1 - минимальный уход, 5 - частый уход)
    private String description;

    public DogBreed(String name, String size, int activityLevel, boolean hypoallergenic,
                    boolean goodWithKids, boolean suitableForApartment, String role,
                    int trainingDifficulty, boolean goodWithOtherAnimals,
                    int groomingNeeds, String description) {
        this.name = name;
        this.size = size;
        this.activityLevel = activityLevel;
        this.hypoallergenic = hypoallergenic;
        this.goodWithKids = goodWithKids;
        this.suitableForApartment = suitableForApartment;
        this.role = role;
        this.trainingDifficulty = trainingDifficulty;
        this.goodWithOtherAnimals = goodWithOtherAnimals;
        this.groomingNeeds = groomingNeeds;
        this.description = description;
    }

    // Геттеры для всех полей
    public String getName() { return name; }
    public String getSize() { return size; }
    public int getActivityLevel() { return activityLevel; }
    public boolean isHypoallergenic() { return hypoallergenic; }
    public boolean isGoodWithKids() { return goodWithKids; }
    public boolean isSuitableForApartment() { return suitableForApartment; }
    public String getRole() { return role; }
    public int getTrainingDifficulty() { return trainingDifficulty; }
    public boolean isGoodWithOtherAnimals() { return goodWithOtherAnimals; }
    public int getGroomingNeeds() { return groomingNeeds; }
    public String getDescription() { return description; }
}