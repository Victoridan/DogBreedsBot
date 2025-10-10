package commands;

import services.BreedService;
import models.UserProfile;

/**
 * Команда result - показывает подходящие породы собак
 */
public class ResultCommand implements Command {
    private BreedService breedService;
    private UserProfile userProfile;

    public ResultCommand(BreedService breedService, UserProfile userProfile) {
        this.breedService = breedService;
        this.userProfile = userProfile;
    }

    @Override
    public void execute() {
        if (!userProfile.isComplete()) {
            System.out.println("\n=== Внимание ===");
            System.out.println("Вы еще не прошли тест полностью!");
            System.out.println("Введите команду 'start' чтобы начать тест или продолжить его.\n");
            return;
        }

        System.out.println("\n=== Подбираем для вас подходящие породы... ===");
        breedService.findMatchingBreeds(userProfile);
    }
}