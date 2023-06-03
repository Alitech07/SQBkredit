package org.example.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotController extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        boolean exist = true;

        if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            Message cbqMessage = callbackQuery.getMessage();
            Long chatId = cbqMessage.getChatId();

            if (data.equals("exchRate")){
                ButtonController buttonController = new ButtonController();
                sendMessage = buttonController.exchangeRateCommand(chatId);
            } else if (data.equals("credit")) {
                ButtonController buttonController = new ButtonController();
                sendMessage = buttonController.getCreditCommand(chatId);
            }
            else if (data.equals("getCredit")){
                sendMessage.setChatId(chatId);
                sendMessage.setText("Olmoqchi bolgan summani kiriting! ");
            }
        }else {
            GeneralController generalController = new GeneralController();
            sendMessage = generalController.handle(message);
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "@testSQBKredit_bot";
    }

    @Override
    public String getBotToken() {
        return "6267348781:AAFHs8xlQVZNX8ZW5sf4lNcKqjg980alU28";
    }
}
