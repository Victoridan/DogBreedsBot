package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;//класс для создания обычной клавиатуры (появляется вместо клавиатуры ввода)
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;//класс для создания ряда кнопок (одна строка в клавиатуре)
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;// класс для скрытия клавиатуры
import java.util.ArrayList;
import java.util.List;
// Создает главное меню с командами
public class ReplyKeyboardMaker {

    public static ReplyKeyboardMarkup getMainMenuKeyboard() {//создает обьект клавиатура
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true); // Показывать не всем в группе
        keyboardMarkup.setResizeKeyboard(true);// Автоматически подстраивать размер
        keyboardMarkup.setOneTimeKeyboard(false);//не скрывать после нажантия
//список рядов кнопок
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("/start");
        row1.add("/help");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("/result");
        row2.add("/stop");
//добавляем ряды в клаву
        keyboard.add(row1);
        keyboard.add(row2);
// Устанавливаем клавиатуру
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup getYesNoKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);// Скрыть после нажатия

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Да");
        row.add("Нет");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup getSizeKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Маленькая");
        row.add("Средняя");
        row.add("Большая");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup getRoleKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Друг");
        row.add("Охранник");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup getActivityKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Активный образ жизни");
        row1.add("Домашний образ жизни");
        keyboard.add(row1);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup getGroomingKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Редко");
        row1.add("Иногда");
        row1.add("Часто");
        keyboard.add(row1);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup getLivingSpaceKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Квартира");
        row1.add("Дом с участком");
        keyboard.add(row1);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }
    // Убрать клавиатуру (вернуть обычную клавиатуру)
    public static ReplyKeyboardRemove removeKeyboard() {
        return new ReplyKeyboardRemove(true);
    }
}