package it.pino.zelchat.api.message.channel;

import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents a ChatChannel used by {@link it.pino.zelchat.api.message.ChatMessage}
 *
 * @since 2.0.0
 */
public interface ChatChannel {

    /**
     * Get the viewers of this ChatChannel
     * @see Audience
     * @return the viewers
     * @since 2.0.0
     */
    @NotNull Collection<Audience> getViewers();

    /**
     * Get the type of this ChatChannel
     *
     * @return the {@link ChannelType}
     * @see ChannelType
     * @since 2.0.0
     */
    @NotNull ChannelType getType();

    /**
     * Set the viewers of this ChatChannel
     * @param viewers the viewers
     * @since 2.0.0
     */
    void setViewers(@NotNull final Collection<Audience> viewers);

}
