package it.pino.zelchat.api.formatter.module.internal;

import it.pino.zelchat.api.formatter.module.priority.ModulePriority;
import it.pino.zelchat.api.message.ChatMessage;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a chat module that can handle chat messages
 * <p>You can also specify a {@link ModulePriority}</p>
 * @since 2.0.0
 */
public interface ChatModule {

    /**
     * Get the priority of this module
     * <p>⚠️ Priority will decide order of execution</p>
     * @return the priority of this module
     * @see ModulePriority
     * @since 2.0.0
     */
    ModulePriority getPriority();

    /**
     * Load the module
     * <p>This method will be called when the module is registered</p>
     * @since 2.0.0
     */
    default void load(){}

    /**
     * Unload the module
     * <p>This method will be called when the module is unregistered</p>
     * @since 2.0.0
     */
    default void unload(){}

    /**
     * Handle a chat message
     * <p>This method will be called before sending a chat message</p>
     * @param chatMessage the chat message
     * @since 2.0.0
     */
    ChatMessage handleChatMessage(@NotNull ChatMessage chatMessage);

}
