package it.pino.zelchat.api.formatter;

import it.pino.zelchat.api.formatter.module.external.ExternalModule;
import it.pino.zelchat.api.formatter.module.internal.ChatModule;
import net.kyori.adventure.audience.Audience;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;

/**
 * Represents the service that manages the chat formatter modules.
 * @since 2.0.0
 */
public interface FormatterService {

    /**
     * Returns an UnmodifiableCollection of all externally registered modules.
     * @throws UnsupportedOperationException if you try to alter the collection
     * @see java.util.Collections#unmodifiableCollection(Collection)
     * @return a view only {@link java.util.Collection}
     * @since 2.0.0
     */
    @UnmodifiableView
    Collection<ExternalModule> getExternalRegisteredModules();

    /**
     * Registers a new module to the formatter service.
     * @param plugin the plugin registering the module
     * @param module the module to register
     * @since 2.0.0
     * @see ChatModule
     */
    void registerExternalModule(final @NotNull JavaPlugin plugin, final @NotNull ExternalModule module);

    /**
     * Unregisters a module from the formatter service.
     * @param plugin the plugin registering the module
     * @param module the module to unregister
     * @since 2.0.0
     * @see ChatModule
     */
    void unregisterExternalModule(final @NotNull JavaPlugin plugin, final @NotNull ExternalModule module);

    /**
     * Sends a message to the chat as the specified Player.
     * <p>Message will be formatted using player's chat format</p>
     * @param player the player to send the message as
     * @param message the message to send
     * @since 2.0.0
     */
    @Blocking
    void makePlayerChat(final @NotNull Player player, final @NotNull String message);


    /**
     * Sends a message to the target as the specified Player.
     * <p>Message will be formatted using private messages format</p>
     * @param player the player to send the message as
     * @param target the target to send the message to
     * @param message the message to send
     * @since 2.0.0
     */
    @Blocking
    void makePlayerPrivateMessage(final @NotNull Player player, final @NotNull Player target, final @NotNull String message);

}
