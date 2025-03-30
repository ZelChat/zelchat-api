package it.pino.zelchat.api.module;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface ModuleManager {

    /**
     * Registers a new module to the formatter service.
     * @param plugin the plugin registering the module
     * @param module the module to register
     * @since 2.0.0
     * @see ChatModule
     */
    void register(final @NotNull Plugin plugin, final @NotNull ChatModule module);

    /**
     * Unregisters a module from the formatter service.
     * @param plugin the plugin registering the module
     * @param module the module to unregister
     * @since 2.0.0
     * @see ChatModule
     */
    void unregister(final @NotNull Plugin plugin, final @NotNull ChatModule module);
}
