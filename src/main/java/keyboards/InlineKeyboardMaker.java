package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;// класс для создания inline-кнопок
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;//для 1 кнопки
import java.util.ArrayList;
import java.util.List;
import models.DogBreed;

public class InlineKeyboardMaker {
    // Создает inline-кнопки
    public static InlineKeyboardMarkup getStartTestKeyboard() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();//разметка для них
// Создаем список рядов кнопок
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton startButton = new InlineKeyboardButton();
        startButton.setText("🐕 Начать тест");
        startButton.setCallbackData("start_test");
        row.add(startButton);

        keyboard.add(row);//обавляем ряд в клавиатуру
        markup.setKeyboard(keyboard);// Устанавливаем клавиатуру
        return markup;
    }

    public static InlineKeyboardMarkup getResultsKeyboard() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton resultsButton = new InlineKeyboardButton();
        resultsButton.setText("📊 Посмотреть результаты");
        resultsButton.setCallbackData("show_results");
        row.add(resultsButton);

        keyboard.add(row);
        markup.setKeyboard(keyboard);
        return markup;
    }

    public static InlineKeyboardMarkup getHelpKeyboard() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton startButton = new InlineKeyboardButton();
        startButton.setText("🚀 Старт");
        startButton.setCallbackData("command_start");
        row1.add(startButton);

        InlineKeyboardButton helpButton = new InlineKeyboardButton();
        helpButton.setText("❓ Помощь");
        helpButton.setCallbackData("command_help");
        row1.add(helpButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton resultsButton = new InlineKeyboardButton();
        resultsButton.setText("📈 Результаты");
        resultsButton.setCallbackData("command_results");
        row2.add(resultsButton);

        InlineKeyboardButton stopButton = new InlineKeyboardButton();
        stopButton.setText("🛑 Стоп");
        stopButton.setCallbackData("command_stop");
        row2.add(stopButton);

        keyboard.add(row1);
        keyboard.add(row2);
        markup.setKeyboard(keyboard);
        return markup;
    }

    public static InlineKeyboardMarkup breedsBoard(List<DogBreed> breeds){
        InlineKeyboardMarkup markup= new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for (DogBreed breed:breeds){
            List<InlineKeyboardButton> row = new ArrayList<>();
            InlineKeyboardButton breedButton= new InlineKeyboardButton();
            breedButton.setText(breed.getName());
            breedButton.setCallbackData("breed_"+ breed.getName());
            row.add(breedButton);
            keyboard.add(row);}
        markup.setKeyboard(keyboard);
        return markup;}
}