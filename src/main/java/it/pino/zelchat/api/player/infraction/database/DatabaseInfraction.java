package it.pino.zelchat.api.player.infraction.database;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Timestamp;

/**
 * Represents an infraction that is stored in a database.
 */
public interface DatabaseInfraction {

    /**
     * Returns the id of the infraction in the database.
     * <p>This id is unique for each infraction</p>
     * @since 2.0.0
     */
    int getId();

    /**
     * Returns the id of the player that received the infraction.
     * <p>This id is unique for each player</p>
     * @since 2.0.0
     */
    int getPlayerId();

    /**
     * Returns the points of the infraction.
     * <p>These points will be given to the player</p>
     * @since 2.0.0
     */
    int getPoints();


    /**
     * Returns the message of the infraction.
     * <p>This message is the reason why the infraction was given</p>
     * @since 2.0.0
     */
    @Nullable
    String getMessage();

    /**
     * Returns the time of the infraction.
     * <p>This time is the time when the infraction was given</p>
     * @since 2.0.0
     */
    @NotNull
    Timestamp getTime();

    /**
     * Returns the server of the infraction.
     * <p>This server is the server where the infraction was given</p>
     * @since 2.0.0
     */
    @Nullable
    String getServer();
}
