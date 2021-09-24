package com.github.veteranandreich.robotter.main;

import com.github.veteranandreich.robotter.bot.RobOtter;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Class for starting long-polling bot
 */
public class Runner {

    public static void main(String[] args) throws TelegramApiException {

        RobOtter robOtter = new RobOtter();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        telegramBotsApi.registerBot(robOtter);

    }
}
