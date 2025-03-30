package it.pino.zelchat.api.module.priority;

import it.pino.zelchat.api.module.ChatModule;

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
