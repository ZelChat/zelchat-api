package it.pino.zelchat.api.player.infraction.message;

/**
 * Represents a rule infraction that is applied to a {@link it.pino.zelchat.api.message.ChatMessage}
 * @since 2.0.0
 */
public interface ChatInfraction {

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
