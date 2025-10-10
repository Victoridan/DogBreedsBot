package services;

import models.DogBreed;
import models.UserProfile;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с базой данных пород собак и подбора подходящих пород
 */
public class BreedService {
    private List<DogBreed> dogBreeds;

    public BreedService() {
        initializeBreeds();
    }

    /**
     * Инициализирует базу данных пород собак
     */
    private void initializeBreeds() {
        dogBreeds = new ArrayList<>();

        // Маленькие породы
        dogBreeds.add(new DogBreed("Йоркширский терьер", "small", 3, true, true, true,
                "friend", 3, true, 3, "Маленькая декоративная порода, подходит для квартиры"));

        dogBreeds.add(new DogBreed("Чихуахуа", "small", 2, false, false, true,
                "friend", 2, false, 1, "Самая маленькая порода собак, требует бережного отношения"));

        dogBreeds.add(new DogBreed("Такса", "small", 3, false, true, true,
                "friend", 3, true, 2, "Охотничья порода, активная и умная"));

        dogBreeds.add(new DogBreed("Мопс", "small", 2, false, true, true,
                "friend", 2, true, 2, "Дружелюбная и спокойная порода, хорошо подходит для семьи"));

        dogBreeds.add(new DogBreed("Ши-тцу", "small", 2, true, true, true,
                "friend", 3, true, 4, "Длинношерстная декоративная порода, требует тщательного ухода"));

        // Средние породы
        dogBreeds.add(new DogBreed("Бульдог", "medium", 2, false, true, true,
                "friend", 3, true, 2, "Спокойная и дружелюбная порода, хороший компаньон"));

        dogBreeds.add(new DogBreed("Бигль", "medium", 4, false, true, false,
                "friend", 4, true, 2, "Активная охотничья порода, требует много движения"));

        dogBreeds.add(new DogBreed("Кокер-спаниель", "medium", 3, false, true, true,
                "friend", 3, true, 4, "Дружелюбная порода с красивой шерстью, требует ухода"));

        dogBreeds.add(new DogBreed("Бордер-колли", "medium", 5, false, true, false,
                "friend", 2, true, 3, "Самая умная порода, требует много физической и умственной нагрузки"));

        dogBreeds.add(new DogBreed("Шелти", "medium", 3, false, true, true,
                "guard", 2, true, 4, "Миниатюрная колли, хороший сторож и компаньон"));

        // Крупные породы
        dogBreeds.add(new DogBreed("Лабрадор-ретривер", "large", 4, false, true, false,
                "friend", 2, true, 3, "Популярная семейная порода, очень дружелюбная и умная"));

        dogBreeds.add(new DogBreed("Немецкая овчарка", "large", 4, false, true, false,
                "guard", 2, true, 3, "Универсальная служебная порода, умная и преданная"));

        dogBreeds.add(new DogBreed("Золотистый ретривер", "large", 4, false, true, false,
                "friend", 2, true, 3, "Очень дружелюбная и терпеливая порода, идеальна для семьи"));

        dogBreeds.add(new DogBreed("Ротвейлер", "large", 3, false, true, false,
                "guard", 3, false, 2, "Сильная и уверенная порода, требует опытного хозяина"));

        dogBreeds.add(new DogBreed("Сенбернар", "large", 2, false, true, false,
                "friend", 3, true, 3, "Очень крупная и спокойная порода, хороший семейный питомец"));

        dogBreeds.add(new DogBreed("Доберман", "large", 4, false, true, true,
                "guard", 3, false, 1, "Элегантная и умная порода, хороший сторож"));

        dogBreeds.add(new DogBreed("Пудель", "large", 3, true, true, true,
                "friend", 2, true, 4, "Очень умная гипоаллергенная порода, требует тщательного ухода"));
    }

    /**
     * Находит подходящие породы собак на основе профиля пользователя
     */
    public void findMatchingBreeds(UserProfile userProfile) {
        List<DogBreed> matchingBreeds = new ArrayList<>();

        for (DogBreed breed : dogBreeds) {
            if (isBreedSuitable(breed, userProfile)) {
                matchingBreeds.add(breed);
            }
        }

        displayResults(matchingBreeds, userProfile);
    }

    /**
     * Проверяет, подходит ли порода под требования пользователя
     */
    private boolean isBreedSuitable(DogBreed breed, UserProfile userProfile) {
        // Проверка размера
        if (!breed.getSize().equals(userProfile.getDogSize())) {
            return false;
        }

        // Проверка активности
        int userActivity = userProfile.getActivityPreference();
        if (userActivity == 1 && breed.getActivityLevel() < 3) {
            return false; // Активный человек - нужна активная собака
        }
        if (userActivity == 2 && breed.getActivityLevel() > 3) {
            return false; // Домосед - не очень активная собака
        }

        // Проверка аллергии
        if (userProfile.hasAllergy() && !breed.isHypoallergenic()) {
            return false;
        }

        // Проверка наличия детей
        if (userProfile.hasChildren() && !breed.isGoodWithKids()) {
            return false;
        }

        // Проверка жилого пространства
        if (userProfile.getLivingSpace().equals("apartment") && !breed.isSuitableForApartment()) {
            return false;
        }

        // Проверка роли собаки
        if (!breed.getRole().equals(userProfile.getDogRole())) {
            return false;
        }

        // Проверка готовности к дрессировке
        if (!userProfile.isWillingToTrain() && breed.getTrainingDifficulty() > 3) {
            return false;
        }

        // Проверка совместимости с животными
        if (userProfile.needGoodWithAnimals() && !breed.isGoodWithOtherAnimals()) {
            return false;
        }

        // Проверка ухода за шерстью
        int userGrooming = userProfile.getGroomingFrequency();
        if (userGrooming == 1 && breed.getGroomingNeeds() > 2) {
            return false; // Редкий уход - не подходят породы с высокими требованиями
        }
        if (userGrooming == 3 && breed.getGroomingNeeds() < 3) {
            return false; // Частый уход - не подходят породы с низкими требованиями
        }

        return true;
    }

    /**
     * Отображает результаты подбора
     */
    private void displayResults(List<DogBreed> matchingBreeds, UserProfile userProfile) {
        if (matchingBreeds.isEmpty()) {
            System.out.println("\nК сожалению, по вашим критериям не найдено подходящих пород.");
            System.out.println("Попробуйте изменить некоторые параметры поиска.\n");
            return;
        }

        System.out.println("\n=== Подходящие для вас породы собак ===");
        System.out.println("Найдено " + matchingBreeds.size() + " подходящих пород:\n");

        for (int i = 0; i < matchingBreeds.size(); i++) {
            DogBreed breed = matchingBreeds.get(i);
            System.out.println((i + 1) + ". " + breed.getName());
            System.out.println("   Размер: " + getSizeInRussian(breed.getSize()));
            System.out.println("   Активность: " + getActivityLevelInRussian(breed.getActivityLevel()));
            System.out.println("   Дрессировка: " + getTrainingDifficultyInRussian(breed.getTrainingDifficulty()));
            System.out.println("   Уход за шерстью: " + getGroomingNeedsInRussian(breed.getGroomingNeeds()));
            System.out.println("   Описание: " + breed.getDescription());
            System.out.println();
        }
    }

    // Вспомогательные методы для перевода на русский язык
    private String getSizeInRussian(String size) {
        switch (size) {
            case "small": return "Маленькая";
            case "medium": return "Средняя";
            case "large": return "Большая";
            default: return size;
        }
    }

    private String getActivityLevelInRussian(int level) {
        switch (level) {
            case 1: case 2: return "Низкая";
            case 3: return "Средняя";
            case 4: case 5: return "Высокая";
            default: return "Неизвестно";
        }
    }

    private String getTrainingDifficultyInRussian(int difficulty) {
        switch (difficulty) {
            case 1: case 2: return "Легко обучаема";
            case 3: return "Средняя сложность";
            case 4: case 5: return "Требует опыта";
            default: return "Неизвестно";
        }
    }

    private String getGroomingNeedsInRussian(int needs) {
        switch (needs) {
            case 1: case 2: return "Минимальный";
            case 3: return "Умеренный";
            case 4: case 5: return "Интенсивный";
            default: return "Неизвестно";
        }
    }
}