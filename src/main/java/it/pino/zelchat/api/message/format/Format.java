package it.pino.zelchat.api.message.format;

import it.pino.zelchat.api.message.ChatMessage;
import it.pino.zelchat.api.message.format.type.FormatType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;

/**
 * Represents a Format used in a {@link ChatMessage}
 * @since 2.0.0
 */
public interface Format {

    /**
     * Get the name of this Format
     *
     * @return the name of this Format
     * @since 2.0.0
     */
    @NotNull
    String getName();

    /**
     * Get the type of this Format
     *
     * @return the type of this Format
     * @since 2.0.0
     */
    @NotNull
    FormatType getType();

    /**
     * Get the {@link Collection<FormatComponent>} of {@link FormatComponent} for this Format
     * @throws UnsupportedOperationException if you try to alter the collection
     * @see java.util.Collections#unmodifiableCollection(Collection)
     * @return the format components of this Format
     * @since 2.0.0
     */
    @NotNull
    @UnmodifiableView
    Collection<FormatComponent> getComponents();

    /**
     * Get the weight of this Format
     *
     * @return the weight of this Format
     * @since 2.0.0
     */
    @Nullable
    Integer getWeight();

    /**
     * Get the permission of this Format
     *
     * @return the permission of this Format
     * @since 2.0.0
     */
    @Nullable
    String getPermission();

}
