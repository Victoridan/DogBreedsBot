package services;

import models.UserProfile;
import java.util.Scanner;

/**
 * Сервис для управления вопросами теста
 */
public class QuestionService {
    private UserProfile userProfile;
    private Scanner scanner;
    private boolean questionnaireActive;

    public QuestionService(UserProfile userProfile, Scanner scanner) {
        this.userProfile = userProfile;
        this.scanner = scanner;
        this.questionnaireActive = false;
    }

    /**
     * Запускает опросник с вопросами
     */
    public void startQuestionnaire() {
        questionnaireActive = true;
        System.out.println("\nОтветьте на несколько вопросов, чтобы мы могли подобрать для вас идеальную породу!");
        System.out.println("В любой момент вы можете ввести 'stop' для выхода из теста\n");

        askAllQuestions();

        if (questionnaireActive) {
            System.out.println("\n=== Тест завершен! ===");
            System.out.println("Введите 'result' чтобы увидеть подходящие породы.\n");
        }
    }

    private void askAllQuestions() {
        if (!askActivityPreference()) return;
        if (!askAllergy()) return;
        if (!askChildren()) return;
        if (!askLivingSpace()) return;
        if (!askDogRole()) return;
        if (!askDogSize()) return;
        if (!askTrainingWillingness()) return;
        if (!askAnimalCompatibility()) return;
        if (!askGroomingFrequency()) return;
    }

    private boolean askActivityPreference() {
        System.out.println("1. Что вам ближе?");
        System.out.println("1 - Вы активный человек и любите много гулять");
        System.out.println("2 - Вы предпочитаете домашнее времяпровождение");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setActivityPreference(answer);
        });
    }

    private boolean askAllergy() {
        System.out.println("\n2. У вас есть аллергия на шерсть?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setHasAllergy(answer == 1);
        });
    }

    private boolean askChildren() {
        System.out.println("\n3. Есть ли у вас дети?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setHasChildren(answer == 1);
        });
    }

    private boolean askLivingSpace() {
        System.out.println("\n4. Вы живёте в?");
        System.out.println("1 - Квартира");
        System.out.println("2 - Дом с участком");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setLivingSpace(answer == 1 ? "apartment" : "house");
        });
    }

    private boolean askDogRole() {
        System.out.println("\n5. Вам ближе:");
        System.out.println("1 - Друг");
        System.out.println("2 - Охранник");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setDogRole(answer == 1 ? "friend" : "guard");
        });
    }

    private boolean askDogSize() {
        System.out.println("\n6. Какую собаку вы бы хотели?");
        System.out.println("1 - Маленькая");
        System.out.println("2 - Средняя");
        System.out.println("3 - Большая");

        return askQuestionWithOptions(1, 3, (answer) -> {
            switch (answer) {
                case 1: userProfile.setDogSize("small"); break;
                case 2: userProfile.setDogSize("medium"); break;
                case 3: userProfile.setDogSize("large"); break;
            }
        });
    }

    private boolean askTrainingWillingness() {
        System.out.println("\n7. Готовы ли вы уделять время дрессировке?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setWillingToTrain(answer == 1);
        });
    }

    private boolean askAnimalCompatibility() {
        System.out.println("\n8. Ваша собака должна ладить с другими животными?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");

        return askQuestionWithOptions(1, 2, (answer) -> {
            userProfile.setNeedGoodWithAnimals(answer == 1);
        });
    }

    private boolean askGroomingFrequency() {
        System.out.println("\n9. Насколько часто вы готовы ухаживать за шерстью вашего питомца?");
        System.out.println("1 - Редко (1-2 раза в месяц)");
        System.out.println("2 - Иногда (1 раз в неделю)");
        System.out.println("3 - Часто (ежедневно или через день)");

        return askQuestionWithOptions(1, 3, (answer) -> {
            userProfile.setGroomingFrequency(answer);
        });
    }

    /**
     * Универсальный метод для задавания вопросов с проверкой на команды
     */
    private boolean askQuestionWithOptions(int min, int max, AnswerProcessor processor) {
        while (true) {
            System.out.print("Ваш выбор (" + min + "-" + max + ", или 'stop' для выхода): ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Проверяем, не хочет ли пользователь выйти
            if (input.equals("stop") || input.equals("exit")) {
                System.out.println("\n=== Тест прерван ===");
                questionnaireActive = false;
                return false;
            }

            // Проверяем, не хочет ли пользователь посмотреть команды
            if (input.equals("help")) {
                showHelpDuringTest();
                continue;
            }

            try {
                int answer = Integer.parseInt(input);
                if (answer >= min && answer <= max) {
                    processor.process(answer);
                    return true;
                } else {
                    System.out.println("Пожалуйста, введите число от " + min + " до " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число или 'stop' для выхода");
            }
        }
    }

    /**
     * Показывает справку по командам во время теста
     */
    private void showHelpDuringTest() {
        System.out.println("\n=== Команды во время теста ===");
        System.out.println("help - показать эту справку");
        System.out.println("stop - прервать тест и вернуться в главное меню");
        System.out.println("число от 1 до 3 - выбрать вариант ответа");
        System.out.println("==============================\n");
    }

    public boolean isQuestionnaireActive() {
        return questionnaireActive;
    }

    /**
     * Функциональный интерфейс для обработки ответов
     */
    @FunctionalInterface
    private interface AnswerProcessor {
        void process(int answer);
    }
}