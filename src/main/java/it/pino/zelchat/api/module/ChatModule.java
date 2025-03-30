package it.pino.zelchat.api.module;

import it.pino.zelchat.api.module.annotation.ChatModuleSettings;
import it.pino.zelchat.api.message.ChatMessage;
import org.jetbrains.annotations.NotNull;

/** Represents a module that can handle chat messages
 * <p>The execution of external modules will be handled after ZelChat internal modules!</p>
 * <p>Requires {@link ChatModuleSettings} annotation to be present!</p>
 * @since 2.0.0
 */
public interface ChatModule {

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
     * Reload the module
     * <p>This method will be called when the module is reloaded</p>
     * @since 2.0.0
     */
    default void reload(){}

    /**
     * Handle a chat message
     * <p>This method will be called before sending a chat message</p>
     * @param chatMessage the chat message
     * @since 2.0.0
     */
     void handleChatMessage(final @NotNull ChatMessage chatMessage);
}
