package it.pino.zelchat.api.message.infraction;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Represents a rule infraction that is applied to a {@link it.pino.zelchat.api.message.ChatMessage}
 * @since 2.0.0
 */
public interface ChatInfraction {

    /**
     * Returns the flagged rules of the infraction.
     * <p>The `String` in the `Map` represents the word, and the `Integer` represents the points associated.</p>
     *
     * @since 2.0.0
     */
    @NotNull
    Map<String, Integer> getFlaggedRules();

    /**
     * Returns the points of the infraction.
     * <p>These points will be given to the player</p>
     * @since 2.0.0
     */
    int getPoints();

    /**
     * Adds points to the infraction.
     * @param points the points to add
     * @since 2.0.0
     */
    void addPoints(final int points);

    /**
     * Sets the points of the infraction.
     * @param points the points to set
     * @since 2.0.0
     */
    void setPoints(final int points);
}
