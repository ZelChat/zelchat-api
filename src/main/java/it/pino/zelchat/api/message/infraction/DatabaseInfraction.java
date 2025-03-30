package it.pino.zelchat.api.message.infraction;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Timestamp;

/**
 * Represents an infraction linked to {@link it.pino.zelchat.api.player.ChatPlayer} that is stored in the database
 * @since 2.0.0
 */
public interface DatabaseInfraction {

    /**
     * Get the id of the infraction
     * @return the id of the infraction
     */
    int getInfractionId();

    /**
     * Get the message of the infraction
     * @return the message of the infraction
     */
    @Nullable
    String getMessage();

    /**
     * Get the points of the infraction
     * @return the points of the infraction
     */
    int getPoints();

    /**
     * Get the time of the infraction
     * @return the time of the infraction
     */
    @NotNull
    Timestamp getTime();

    /**
     * Get the server of the infraction
     * @return the server of the infraction
     */
    @NotNull
    String getServer();

}
