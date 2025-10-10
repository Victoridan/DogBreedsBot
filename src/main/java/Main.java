import commands.*;
import models.UserProfile;
import services.BreedService;
import services.QuestionService;
import java.util.Scanner;

/**
 * Главный класс приложения - консольный бот для подбора пород собак
 * Это точка входа в программу
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Добро пожаловать в бот для подбора пород собак! ===");
        System.out.println("Для начала работы введите 'help' чтобы увидеть список команд\n");

        // Инициализация компонентов
        Scanner scanner = new Scanner(System.in);
        UserProfile userProfile = new UserProfile();
        BreedService breedService = new BreedService();
        QuestionService questionService = new QuestionService(userProfile, scanner);

        // Создание команд
        Command helpCommand = new HelpCommand();
        Command startCommand = new StartCommand(questionService);
        Command stopCommand = new StopCommand(userProfile, questionService);
        Command resultCommand = new ResultCommand(breedService, userProfile);

        boolean running = true;

        // Главный цикл программы
        while (running) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "help":
                    helpCommand.execute();
                    break;

                case "start":
                    // Проверяем, не активен ли уже тест
                    if (questionService.isQuestionnaireActive()) {
                        System.out.println("\nТест уже активен! Завершите его или введите 'stop' для отмены.");
                    } else {
                        startCommand.execute();
                    }
                    break;

                case "stop":
                    stopCommand.execute();
                    break;

                case "result":
                    resultCommand.execute();
                    break;

                case "exit":
                    System.out.println("\nСпасибо за использование нашего бота! До свидания!");
                    running = false;
                    break;

                default:
                    // Если введена неизвестная команда, но тест активен - это нормально
                    if (!questionService.isQuestionnaireActive()) {
                        System.out.println("Неизвестная команда. Введите 'help' для списка команд.");
                    }
                    break;
            }
        }

        scanner.close();
    }
}