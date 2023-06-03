package org.example.utils;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InlineKeybordUtil {
    public static InlineKeyboardButton button(String text,String callbackData){
        return new InlineKeyboardButton().setText(text).setCallbackData(callbackData);
    }

    public static List<InlineKeyboardButton> row(InlineKeyboardButton... buttons){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.addAll(Arrays.asList(buttons));
        return row;
    }

    public static List<List<InlineKeyboardButton>> buttonsRow(List<InlineKeyboardButton>... buttonList){
        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
        rowCollection.addAll(Arrays.asList(buttonList));
        return rowCollection;
    }

    public static InlineKeyboardMarkup buttonColletion(List<List<InlineKeyboardButton>> rowCollection){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowCollection);
        return inlineKeyboardMarkup;
    }

}
