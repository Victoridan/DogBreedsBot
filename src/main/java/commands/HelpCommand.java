package commands;

/**
 * Команда help - показывает список доступных команд
 */
public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\n=== Доступные команды ===");
        System.out.println("help - показать список команд");
        System.out.println("start - начать тест по подбору породы собаки");
        System.out.println("stop - сбросить текущий тест");
        System.out.println("result - показать подходящие породы собак");
        System.out.println("exit - выйти из программы");
        System.out.println("\n=== Команды во время теста ===");
        System.out.println("stop - прервать тест");
        System.out.println("help - показать справку по командам теста");
        System.out.println("========================\n");
    }
}