package it.pino.zelchat.api.formatter.module.priority;

import it.pino.zelchat.api.formatter.module.internal.ChatModule;

/**
 * Represents the priority of a {@link ChatModule}
 * <p>⚠️ Priority will decide order of execution</p>
 * @since 2.0.0
 */
public enum ModulePriority {

    /**
     * This means that the {@link ChatModule} will be executed as the first one
     */
    LOWEST,
    /**
     * After LOWEST
     */
    LOW,
    /**
     * After LOW
     */
    NORMAL,
    /**
     * After NORMAL
     */
    HIGH,
    /**
     * This means that the {@link ChatModule} will be executed as the last one
     */
    HIGHEST,
}
