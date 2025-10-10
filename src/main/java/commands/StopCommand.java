package commands;

import models.UserProfile;
import services.QuestionService;

/**
 * Команда stop - сбрасывает текущий тест
 */
public class StopCommand implements Command {
    private UserProfile userProfile;
    private QuestionService questionService;

    public StopCommand(UserProfile userProfile, QuestionService questionService) {
        this.userProfile = userProfile;
        this.questionService = questionService;
    }

    @Override
    public void execute() {
        userProfile.reset();
        System.out.println("\n=== Тест сброшен ===");
        System.out.println("Все ваши ответы удалены. Вы можете начать заново с команды 'start'\n");
    }
}