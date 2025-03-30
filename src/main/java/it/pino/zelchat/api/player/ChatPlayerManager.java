package it.pino.zelchat.api.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Async;
import org.jetbrains.annotations.NonBlocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

public interface ChatPlayerManager {


    /**
     * Returns an UnmodifiableMap of all online {@link ChatPlayer}
     *
     * @return a view only {@link java.util.Map}
     * @throws UnsupportedOperationException if you try to alter the map
     * @see java.util.Collections#unmodifiableMap(Map)
     * @since 2.0.0
     */
    @NotNull
    @UnmodifiableView
    Map<UUID, ChatPlayer> getOnlinePlayers();

    /**
     * Set the infraction points of the player
     *
     * @param player the player
     * @param points the points to set
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> setPoints(final @NotNull ChatPlayer player, final int points);

    /**
     * Set if the player has closed the messages
     *
     * @param player the player
     * @param value  value to set
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> setMessagesClosed(final @NotNull ChatPlayer player, final boolean value);

    /**
     * Add a target to the ignored list of the player
     *
     * @param player         the player
     * @param targetUniqueId the target to add
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> hidePlayer(final @NotNull ChatPlayer player, final @NotNull UUID targetUniqueId);

    /**
     * Remove a target from the ignored list of the player
     *
     * @param player         the player
     * @param targetUniqueId the target to remove
     * @return a {@link CompletionStage} that will complete true or false depending on the success of the operation
     */
    @NotNull
    @NonBlocking
    CompletionStage<Boolean> showPlayer(final @NotNull ChatPlayer player, final @NotNull UUID targetUniqueId);

    /**
     * Sends a message to the chat as the specified Player.
     * <p>Message will be formatted using player's chat format</p>
     * <p>Execution will be done inside a VirtualThread</p>
     * @param player the player to send the message as
     * @param text the message to send
     * @since 2.0.0
     */
    @NonBlocking
    @Async.Execute
    void makePlayerChat(final @NotNull Player player, final @NotNull String text);

    /**
     * Sends a message to the target as the specified Player.
     * <p>Message will be formatted using private messages format</p>
     * <p>Execution will be done inside a VirtualThread</p>
     * @param player the player to send the message as
     * @param target the target to send the message to
     * @param message the message to send
     * @since 2.0.0
     */
    @NonBlocking
    @Async.Execute
    void makePlayerPrivateMessage(final @NotNull Player player, final @NotNull Player target, final @NotNull String message);

}
