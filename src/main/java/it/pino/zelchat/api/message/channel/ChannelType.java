package it.pino.zelchat.api.message.channel;

/**
 * Represents the type of a {@link ChatChannel}
 * @since 2.0.0
 */
public enum ChannelType {

    /**
     * The channel is visible to everyone
     */
    EVERYONE,

    /**
     * The channel is visible only to staff members
     */
    STAFF,

    /**
     * The channel is visible only to the {@link ChatChannel} viewers
     */
    CUSTOM,

    /**
     * The channel is related to a private message
     */
    PRIVATE;
}
