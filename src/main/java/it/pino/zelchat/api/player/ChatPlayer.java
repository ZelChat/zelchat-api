package it.pino.zelchat.api.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a ChatPlayer handled from ZelChat
 * @since 2.0.0
 */
public interface ChatPlayer {

    /**
     * Get the player's id in the database
     *
     * @return the player's id
     * @since 2.0.0
     */
    int getPlayerId();

    /**
     * Get the nickname of the player
     *
     * @return the player's name
     * @since 2.0.0
     */
    @NotNull
    String getUsername();

    /**
     * Get the uniqueId of the player
     *
     * @return the player's unique id
     * @since 2.0.0
     */
    @NotNull
    UUID getUniqueId();

    /**
     * Get the player object related to the sender of this ChatPlayer
     *
     * @return the {@link Player} object
     * @since 2.0.0
     */
    Optional<Player> getBukkitPlayer();

    /**
     * Get the last message sent by the player
     *
     * @return the last message sent
     * @since 2.0.0
     */
    Optional<String> getLastMessage();

    /**
     * Get the points of the player
     *
     * @return the player's points
     * @since 2.0.0
     */
    int getPoints();

    /**
     * Get the state of the player's messages
     *
     * @return the state of the player's messages
     * @since 2.0.0
     */
    boolean hasMessagesClosed();

    /**
     * Get the cooldown of the player expressed in seconds (eg: 1.2 | 2.3 | 1.0)
     * @return the cooldown in seconds
     * @since 2.0.0
     */
    double cooldownSeconds();

    /**
     * Get if the player is in cooldown
     * @return if the player can send messages in chat
     * @since 2.0.0
     */
    boolean isInCooldown();

    /**
     * Remove the cooldown from the player
     * @since 2.0.0
     */
    void removeCooldown();

    /**
     * Add a cooldown to the player
     * @param millis the time in milliseconds
     * @since 2.0.0
     */
    void addCooldown(final long millis);

    /**
     * Get the ignored players by the player
     *
     * @return a view only {@link Collection}
     * @see java.util.Collections#unmodifiableCollection(Collection)
     * @since 2.0.0
     */
    @NotNull
    @UnmodifiableView
    Set<UUID> getIgnoredPlayers();

    /**
     * Get the last player's uniqueId that sent a private message to this player
     *
     * @return the last player's uniqueId that sent a private message
     * @since 2.0.0
     */
    @Nullable
    UUID getReplierUniqueId();

    /**
     * Get the last private message sent by this player
     *
     * @return the last private message
     * @since 2.0.0
     */
    Optional<String> getLastPrivateMessage();

    /**
     * Get the player object related to the last player that sent a private message to this player
     *
     * @return the {@link Player} object
     * @since 2.0.0
     */
    Optional<Player> getReplier();

    /**
     * Set the last player's uniqueId
     * @param uniqueId the uniqueId of the target player
     * @since 2.0.0
     */
    void setReplier(final @Nullable UUID uniqueId);


}
