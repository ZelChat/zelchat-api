package it.pino.zelchat.api.player;


import org.jetbrains.annotations.NonBlocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

/**
 * Represents the service that manages the online players
 * @since 2.0.0
 */
public interface ChatPlayerService {

    /**
     * Returns an UnmodifiableMap of all online {@link ChatPlayer}
     * @throws UnsupportedOperationException if you try to alter the map
     * @see java.util.Collections#unmodifiableMap(Map)
     * @return a view only {@link java.util.Map}
     * @since 2.0.0
     */
    @NotNull
    @UnmodifiableView
    Map<UUID, ChatPlayer> getOnlinePlayers();

    /**
     * Fetch an offline player querying the database
     * <p>Use this method if you need to fetch a player that is not online</p>
     * <p>Fetching online players will complete exceptionally! Use {@link #getOnlinePlayers()} for that!</p>
     * @param uniqueId the uniqueId of the player
     * @since 2.0.0
     * @throws UnsupportedOperationException if you try to fetch an online player
     * @return a {@link CompletionStage} that will complete with {@link ChatPlayer} if the player is found
     */
    @NonBlocking
    CompletionStage<@Nullable ChatPlayer> queryPlayer(final @NotNull UUID uniqueId, final @NotNull String username);

    /**
     * Set the infraction points of the player
     * @param player the player
     * @param points the points to set
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> setPoints(final @NotNull ChatPlayer player, final int points);


    /**
     * Set if the player has closed the messages
     * @param player the player
     * @param value value to set
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> setMessagesClosed(final @NotNull ChatPlayer player, final boolean value);

    /**
     * Add a target to the ignored list of the player
     * @param player the player
     * @param targetUniqueId the target to add
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> addIgnoredPlayer(final @NotNull ChatPlayer player, final @NotNull UUID targetUniqueId);

    /**
     * Add more than one target to the ignored list of the player
     * <p>Use this method if you want to bulk update the ignored players</p>
     * @param player the player
     * @param targets the targets to add
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> addIgnoredPlayers(final @NotNull ChatPlayer player, final @NotNull Collection<UUID> targets);

    /**
     * Remove a target from the ignored list of the player
     * @param player the player
     * @param targetUniqueId the target to remove
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> removeIgnoredPlayer(final @NotNull ChatPlayer player, final @NotNull UUID targetUniqueId);

    /**
     * Remove more than one target from the ignored list of the player
     * <p>Use this method if you want to bulk update the ignored players</p>
     * @param player the player
     * @param targets the targets to remove
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> removeIgnoredPlayers(final @NotNull ChatPlayer player, final @NotNull Collection<UUID> targets);

}
