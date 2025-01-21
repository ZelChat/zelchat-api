package it.pino.zelchat.api;


import it.pino.zelchat.api.formatter.FormatterService;
import it.pino.zelchat.api.player.infraction.ChatInfractionService;
import it.pino.zelchat.api.player.ChatPlayerService;
import org.jetbrains.annotations.NotNull;

/**
 * The main API interface for ZelChat.
 */
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
     * Get the formatter service.
     *
     * @return the formatter service
     */
    @NotNull FormatterService getFormatterService();


    /**
     * Get the player service.
     *
     * @return the player service
     */
    @NotNull ChatPlayerService getPlayerService();

    /**
     * Get the infractions service.
     *
     * @return the infractions service
     */
    @NotNull ChatInfractionService getInfractionService();

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
    void setChatMuted(boolean value);

}
