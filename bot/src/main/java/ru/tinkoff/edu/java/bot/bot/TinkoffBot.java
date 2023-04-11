package ru.tinkoff.edu.java.bot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.bot.BaseAbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tinkoff.edu.java.bot.dto.User;
import ru.tinkoff.edu.java.bot.service.ResponseService;

import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

@Component
public class TinkoffBot extends AbilityBot {
    private User user;
    private ResponseService responseService;
    public Reply sayYuckOnImage() {
        // getChatId is a public utility function in rg.telegram.abilitybots.api.util.AbilityUtils
        BiConsumer<BaseAbilityBot,Update> action = (bot,upd) -> silent.send("Invalid command", getChatId(upd));
        return Reply.of(action, hasText());
    }

    public Predicate<Update> hasText(){
        return update -> !(update.getMessage().getText().toLowerCase().contains("/start")
        ||update.getMessage().getText().toLowerCase().contains("/help")
                ||update.getMessage().getText().toLowerCase().contains("/track")
                ||update.getMessage().getText().toLowerCase().contains("/untrack")
                ||update.getMessage().getText().toLowerCase().contains("/list"))
                &&update.getMessage().getText().toLowerCase().contains("/");
    }
    public Ability startCommand() {
        return Ability
                .builder()
                .name("start")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx ->{
                    user = new User(ctx.chatId().intValue(),null,"newer",new int[5]);
                    user.links=new ArrayList<>();
                    silent.send(responseService.startResponse(user,ctx.chatId()), ctx.chatId());
                })
                .build();
    }
    public Ability helpCommand() {
        return Ability
                .builder()
                .name("help")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("God will help you😇" +
                        "Joke\ncommand track + link - will set your link, untrack - unset, list - get your all links", ctx.chatId()))
                .build();
    }
    public Ability trackCommand() {
        return Ability
                .builder()
                .name("track")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {silent.send(responseService.trackResponse(user,ctx.secondArg()), ctx.chatId());

                })
                .build();
    }
    public Ability untrackCommand() {
        return Ability
                .builder()
                .name("untrack")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {silent.send("Ohhh... no... The command 'untrack' was used!", ctx.chatId());
                    //todo сделать реализацию
                })
                .build();
    }
    public Ability listCommand() {
        return Ability
                .builder()
                .name("list")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                        silent.send(responseService.listResponse(user,ctx.chatId()), ctx.chatId());


                })
                .build();
    }


    @Override
    public long creatorId() {
        return 0;
    }

    public TinkoffBot(@Value("${bot.token}") String botToken,
                         @Value("${bot.name}") String botName, ResponseService responseService)
    {
        super(botToken, botName);
        this.responseService = responseService;
    }
}
