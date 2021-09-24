package com.github.veteranandreich.robotter.bot;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Telegram bot
 */
@ParametersAreNonnullByDefault
public class RobOtter extends TelegramLongPollingBot {
    private static final String TOKEN = "";
    private static final String USERNAME = "RobOtter";

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getChatId());
    }

    public void sendTextMessage(String text, String chatId) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .build();

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendPicture(String url, String chatId, @Nullable String caption) {
        InputFile file = new InputFile().setMedia(url);
        SendPhoto photo = SendPhoto.builder()
                .photo(file)
                .chatId(chatId)
                .caption(caption)
                .build();

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send .gif
     */
    public void sendAnimation(String url, String chatId, @Nullable String caption) {
        InputFile file = new InputFile().setMedia(url);
        SendAnimation animation = SendAnimation.builder()
                .animation(file)
                .caption(caption)
                .chatId(chatId)
                .build();

        try {
            execute(animation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
