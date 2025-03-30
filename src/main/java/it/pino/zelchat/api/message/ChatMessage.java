package it.pino.zelchat.api.message;

import it.pino.zelchat.api.message.channel.ChatChannel;
import it.pino.zelchat.api.message.format.Format;
import it.pino.zelchat.api.message.infraction.ChatInfraction;
import it.pino.zelchat.api.message.state.MessageState;
import it.pino.zelchat.api.player.ChatPlayer;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Represents a ChatMessage handled from ZelChat
 *
 * @since 2.0.0
 */
public interface ChatMessage {

    /**
     * Get the ChatPlayer related to the sender of this ChatMessage
     *
     * @return the {@link ChatPlayer}
     * @since 2.0.0
     */
    @NotNull ChatPlayer getChatPlayer();

    /**
     * Get the player object related to the sender of this ChatMessage
     *
     * @return the {@link Player} object
     * @since 2.0.0
     */
    @NotNull Player getBukkitPlayer();

    /**
     * Get the state of this ChatMessage
     *
     * @return the {@link MessageState}
     * @see MessageState
     * @since 2.0.0
     */
    @NotNull MessageState getState();

    /**
     * Get the format used in this ChatMessage
     *
     * @return the {@link Format}
     * @see Format
     * @since 2.0.0
     */
    @NotNull Format getFormat();

    /**
     * Get the raw message of this ChatMessage
     *
     * @return the raw message
     * @since 2.0.0
     */
    @NotNull String getRawMessage();

    /**
     * Get the final message that will be sent in chat
     *
     * @return the message
     * @see Component
     * @since 2.0.0
     */
    @NotNull Component getMessage();

    /**
     * Get the mentioned players of this ChatMessage
     *
     * @return the viewers
     * @see Collection
     * @since 2.0.0
     */
    @NotNull Collection<String> getMentions();

    /**
     * Get the ChatChannel used in this ChatMessage
     *
     * @return the channel
     * @see ChatChannel
     * @since 2.0.0
     */
    @NotNull ChatChannel getChannel();

    /**
     * Get if present the infraction triggered in this message
     *
     * @return the infraction
     * @see ChatInfraction
     * @since 2.0.0
     */
    @Nullable ChatInfraction getInfraction();

    /**
     * Set the state of this ChatMessage
     *
     * @param state the new state
     * @since 2.0.0
     */
    void setState(final @NotNull MessageState state);

    /**
     * Set the message that will be sent in chat
     * @param message the new format
     * @since 2.0.0
     */
    void setMessage(final @NotNull Component message);

    /**
     * Set the format that will be used
     * @param format the new format
     * @since 2.0.0
     */
    void setFormat(final @NotNull Format format);

    /**
     * Set the channel that will be used
     * @param channel the new channel
     */
    void setChannel(final @NotNull ChatChannel channel);

    /**
     * Set the flag that will be used
     * <p>You can pass null value</p>
     * @param flag the new flag
     * @since 2.0.0
     */
    void setInfraction(final @Nullable ChatInfraction flag);
}
