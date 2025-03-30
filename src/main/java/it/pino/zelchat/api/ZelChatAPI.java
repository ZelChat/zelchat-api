package it.pino.zelchat.api;

import it.pino.zelchat.api.module.ModuleManager;
import it.pino.zelchat.api.player.ChatPlayerManager;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletionStage;

public interface ZelChatAPI {

    /**
     * Get the main API instance.
     *
     * @return the main API instance
     */
    static @NotNull ZelChatAPI get(){
        return ZelChatProvider.getApi();
    }

    /**
     * Get the module manager.
     *
     * @return the module manager
     */
    @NotNull
    ModuleManager getModuleManager();

    /**
     * Get the player service.
     *
     * @return the player service
     */
    @NotNull
    ChatPlayerManager getPlayerService();

    /**
     * Get the server chat mute status.
     *
     * @return if the server chat is muted
     */
    boolean isChatMuted();

    /**
     * Set the server chat mute status.
     *
     * @param value the new mute status
     */
    CompletionStage<Boolean> setChatMuted(final boolean value);


}
