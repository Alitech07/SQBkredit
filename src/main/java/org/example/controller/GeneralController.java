package org.example.controller;

import org.example.utils.InlineKeybordUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralController {
    public SendMessage handle(Message message){

        Long chatId = message.getChatId();
        String text = message.getText();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if (text.equals("/start")){

            String sendText = "Assalomu alaykum "+message.getChat().getFirstName()
                    +"\nBugungi Valyuta kurslarini bilishni va Bizning SQB bankdan kredit rasmiylashtirish uchun pasdagi tugmalardan biri tanlang";
            sendMessage.setText(sendText);
            //Buttonlar yaratish
            InlineKeyboardButton exchangeButton = InlineKeybordUtil.button("Valyuta kursi", "exchRate");
            InlineKeyboardButton creditButton = InlineKeybordUtil.button("Kerid olish", "credit");

            //Buttonlarni listga orash
            List<InlineKeyboardButton> row = InlineKeybordUtil.row(exchangeButton, creditButton);

            List<List<InlineKeyboardButton>> rowCollection = InlineKeybordUtil.buttonsRow(row);

            InlineKeyboardMarkup buttons = InlineKeybordUtil.buttonColletion(rowCollection);
            sendMessage.setReplyMarkup(buttons);

        } else if (text.equals("/help")) {
            String sendText = message.getChat().getFirstName()
                    +" Sizga qanday yordam kerak?";
            sendMessage.setText(sendText);
        }else if (text.equals("/settings")){

        }
        return sendMessage;
    }
}
