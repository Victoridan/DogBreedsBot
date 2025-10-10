package commands;

import services.QuestionService;

/**
 * Команда start - начинает опрос пользователя
 */
public class StartCommand implements Command {
    private final QuestionService questionService;

    public StartCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void execute() {
        questionService.startQuestionnaire();
    }
}