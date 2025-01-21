package it.pino.zelchat.api.message.format;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a FormatComponent used in a {@link Format}
 * @since 2.0.0
 */
public interface FormatComponent {


    /**
     * Get the name of this FormatComponent
     *
     * @return the name of this FormatComponent
     * @since 2.0.0
     */
    @NotNull String getName();

    /**
     * Get the format of this FormatComponent
     *
     * @return the format of this FormatComponent
     * @since 2.0.0
     */
    @NotNull String getFormat();

    /**
     * Get the hover message of this FormatComponent
     *
     * @return the hover message of this FormatComponent
     * @since 2.0.0
     */
    @NotNull String getHoverMessage();

    /**
     * Get the action of this FormatComponent
     *
     * @return the action of this FormatComponent
     * @since 2.0.0
     */
    @NotNull String getAction();
}
