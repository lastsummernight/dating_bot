package com.github.datingbot.keyboard;

import com.github.datingbot.auxiliary.State;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static com.github.datingbot.auxiliary.State.*;

public class KeyboardBuilder {

    public static ReplyKeyboardMarkup buildKeyboard(State key) {

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();

        switch (key) {
            case USER_GENDER:
                keyboardRow.add("Парень");
                keyboardRow.add("Девушка");
                keyboard.add(keyboardRow);
                break;

            case USER_STATE_MAIN_MENU:
                keyboardRow.add("Поиск");
                keyboardRow.add("Моя анкета");
                keyboardRow.add("Сообщения");
                keyboard.add(keyboardRow);
                break;

            case USER_STATE_FINDING:
                keyboardRow.add("♥");
                keyboardRow.add("Назад");
                keyboardRow.add("\uD83D\uDC94"); // разбитое сердечко
                keyboard.add(keyboardRow);
                break;

            case USER_PROFILE:
                keyboardRow.add("Изменить профиль");
                keyboardRow.add("Назад");
                keyboard.add(keyboardRow);
                break;

            case USER_MESSAGES:
                keyboardRow.add("Выбрать диалог");
                keyboardRow.add("Назад");
                keyboard.add(keyboardRow);
                break;

            case USER_PROFILE_CHANGE:
                keyboardRow.add("Имя");
                keyboardRow.add("Возраст");
                keyboardRow.add("Город");

                keyboard.add(keyboardRow);
                keyboardRow = new KeyboardRow();

                keyboardRow.add("Пол");
                keyboardRow.add("О себе");
                keyboardRow.add("Назад");
                keyboard.add(keyboardRow);
                break;

            case USER_MESSAGES_CHOOSE:
                keyboardRow.add("Назад");
                keyboard.add(keyboardRow);
                break;

            case EMPTY:
                keyboard.add(keyboardRow);
                break;
        }

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        if (key == USER_GENDER)
            replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }
}