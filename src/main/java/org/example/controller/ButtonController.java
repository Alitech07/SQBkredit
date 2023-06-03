package org.example.controller;

import org.example.entity.ExchangeRateApi;
import org.example.utils.InlineKeybordUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import sun.security.jgss.wrapper.GSSCredElement;

import java.util.List;

public class ButtonController {
    ExchangeRateApi rateApi = new ExchangeRateApi();
    SendMessage sendMessage = new SendMessage();
        public SendMessage exchangeRateCommand(Long chatId){

            String sendText = "----Bugungi valyuta kursi----\n"
                    +"Valyuta nomi: "+rateApi.getCcyNm_UZ()
                    +"\nValyuta qiymati USD:"+rateApi.getNominal()
                    +"\nValyuta sumdagi qiymati UZS: "+rateApi.getRate();
            sendMessage.setChatId(chatId);
            sendMessage.setText(sendText);
            return sendMessage;
        }
        public SendMessage getCreditCommand(Long chaId){
            String sendText = "Bizdagi kreditlar haqida malumot."
                    +"\n3 - oy  5%"
                    +"\n5 - oy  8%"
                    +"\n6 - oy  10%"
                    +"\n9 - oy  12%"
                    +"\n12 - oy  15%"
                    +"\nHohish va imkoniyatingizga qarab tanlang!";
            InlineKeyboardButton button = InlineKeybordUtil.button("Olish", "getCredit");
            List<InlineKeyboardButton> row = InlineKeybordUtil.row(button);
            List<List<InlineKeyboardButton>> buttonsRow = InlineKeybordUtil.buttonsRow(row);
            InlineKeyboardMarkup buttons = InlineKeybordUtil.buttonColletion(buttonsRow);

            sendMessage.setChatId(chaId);
            sendMessage.setText(sendText);
            sendMessage.setReplyMarkup(buttons);
            return sendMessage;
        }
}
