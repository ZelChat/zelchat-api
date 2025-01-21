<div align="center">

# ZelChat API ([DOWNLOAD](https://bit.ly/45YpCUJ)) 

---
[![Discord](https://img.shields.io/discord/1116411447904317520?color=5865F2&label=Discord&logo=discord&logoColor=white)](https://discord.gg/X7yzyACy2x)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4a93cfec87404de485075646401ae92a)](https://app.codacy.com/gh/ZelChat/zelchat-api/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
![Repo](https://repo.pinodev.it/api/badge/latest/releases/it/pino/zelchat/api/?color=40c14a&name=Version&prefix=v)
[![Reposilite](https://img.shields.io/badge/Reposilite-Repo-blue)](https://repo.pinodev.it/#/)
[![Javadocs](https://img.shields.io/badge/Javadocs-DOCS-blue)](https://repo.pinodev.it/docs/zelchat/api/)

**It's time to get full control over your minecraft server chat!**

<img src="https://bstats.org/signatures/bukkit/zelchat.svg" width="500">

</div>

<div align="center">

## INTRODUCTION

---
</div>

### ADD TO YOUR PROJECT
` Replace LATEST with version above`

Maven
```xml
<repository>
    <id>pinodev-repo</id>
    <name>Pineta</name>
    <url>https://repo.pinodev.it/releases</url>
</repository>

```
```xml
<dependency>
    <groupId>it.pino.zelchat</groupId>
    <artifactId>api</artifactId>
    <version>LATEST</version>
</dependency>
```
Gradle
```sh
repositories {
maven {
    name = "pinodevRepo"
    url = uri("https://repo.pinodev.it/releases")
}
```
```sh
dependencies {
        implementation("it.pino.zelchat:api:LATEST")
}
```
<div align="center">

## EXAMPLES ([FULL CODE](https://github.com/ZelChat/example-addon))

---
</div>

**GETTING API AND REGISTERING MODULES**

```java
package it.pino.example.addon;

import it.pino.example.addon.command.MyChatCommand;
import it.pino.example.addon.module.MyChatModule;
import it.pino.zelchat.api.ZelChatAPI;
import it.pino.zelchat.api.formatter.module.external.ExternalModule;
import it.pino.zelchat.api.formatter.module.internal.ChatModule;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;

final class ExampleAddonBukkit {

    @NotNull
    private final ZelChatAPI zelchat; // This is the ZelChat API instance
    @NotNull
    private final JavaPlugin plugin;
    @NotNull
    private final Collection<ExternalModule> myModules; // This is the list of your modules

    public ExampleAddonBukkit(@NotNull final JavaPlugin plugin) {
        this.plugin = plugin;
        this.zelchat = ZelChatAPI.get(); // We get the ZelChat API instance
        this.myModules = new CopyOnWriteArrayList<>(List.of(
                new MyChatModule() // We add our module
        ));
    }

    void init(){
        plugin.getLogger().log(Level.INFO, "Loading my example addon...");
        // Registering modules properly!
        this.myModules.forEach(module -> {
            this.zelchat.getFormatterService().registerExternalModule(plugin, module);
            module.load();
        });
        Objects.requireNonNull(plugin.getCommand("example"), "You forgot to add it into plugin.yml")
                .setExecutor(new MyChatCommand(zelchat));
    }

    void stop(){
        plugin.getLogger().log(Level.INFO, "Stopping my example addon...");
        // Unregistering modules properly!
        this.myModules.forEach(module -> {
            module.unload();
            this.zelchat.getFormatterService().unregisterExternalModule(plugin, module);
        });

    }

    public void reload(){
        this.myModules.forEach(module -> {
            module.unload();
            module.load();
        });
    }

    @NotNull
    public ZelChatAPI getZelChat() {
        return zelchat;
    }

    @NotNull
    public Collection<ExternalModule> getMyModules() {
        return myModules;
    }
}
```
**CREATING YOUR FIRST MODULE**

```java
package it.pino.example.addon.module;

import it.pino.zelchat.api.formatter.module.external.ExternalModule;
import it.pino.zelchat.api.formatter.module.priority.ModulePriority;
import it.pino.zelchat.api.message.ChatMessage;
import it.pino.zelchat.api.message.MessageState;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public final class MyChatModule extends ExternalModule {


    @Override
    public ModulePriority getPriority() {
        return ModulePriority.NORMAL; // Just chose one!
    }

    @Override
    public void load(){
        // Do Something
    }

    @Override
    public ChatMessage handleChatMessage(final @NotNull ChatMessage chatMessage) {
        // Always check if the message is cancelled or filtered
        if(chatMessage.getState() == MessageState.CANCELLED || chatMessage.getState() == MessageState.FILTERED)
            return chatMessage;

        // Example of replacing something
        var message = chatMessage.getMessage();
        message = message.replaceText(builder -> builder.matchLiteral("%something%").replacement(Component.text("Something!")));
        chatMessage.setMessage(message);

        // Example of filtering the viewers
        Collection<Audience> newViewers = List.of(Bukkit.getPlayer("Pino"));
        chatMessage.getChannel().setViewers(newViewers);

        // Example of cancelling a message
        chatMessage.setState(MessageState.CANCELLED);

        // Example of adding points to infraction
        var infraction = chatMessage.getInfraction();
        if(infraction != null) {
            infraction.addPoints(10);
        }
        // When we are done we return the chatMessage!
        return chatMessage;
    }
}
```

**GETTING CHAT PLAYER**

```java
package it.pino.example.addon.command;

import it.pino.zelchat.api.ZelChatAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MyChatCommand implements CommandExecutor {

    @NotNull
    private final ZelChatAPI api;

    public MyChatCommand(final @NotNull ZelChatAPI api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player))
            return false;

        var identifier = player.getUniqueId();

        var chatPlayer = api.getPlayerService().getOnlinePlayers().get(identifier);
        if(chatPlayer == null){
            player.sendMessage(Component.text("Error while executing command...", NamedTextColor.RED));
            return false;
        }
        var points = chatPlayer.getPoints();

        var message = (points == 0) ? Component.text("You have been a good guy!", NamedTextColor.GREEN)
                : Component.text("You have been a bad boy", NamedTextColor.RED);

        player.sendMessage(message);

        return true;
    }
}
```