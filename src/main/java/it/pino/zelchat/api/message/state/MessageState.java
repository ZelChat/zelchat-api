package it.pino.zelchat.api.message.state;

import it.pino.zelchat.api.message.ChatMessage;

/**
 * Represents the state of a {@link ChatMessage}
 * @since 2.0.0
 */
public enum MessageState {

    /**
     * The message is being processed
     */
    PROCESSING,

    /**
     * The message is ready to be sent
     */
    READY,

    /**
     * The message has been cancelled
     */
    CANCELLED,

    /**
     * The message has been modified from ChatFilter
     */
    FILTERED,

    /**
     * The message has been cancelled from ChatFilter
     */
    FILTERED_CANCELLED;
}
