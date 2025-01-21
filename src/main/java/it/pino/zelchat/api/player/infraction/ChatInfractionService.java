package it.pino.zelchat.api.player.infraction;

import it.pino.zelchat.api.player.infraction.database.DatabaseInfraction;
import it.pino.zelchat.api.player.ChatPlayer;
import org.jetbrains.annotations.NonBlocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.concurrent.CompletionStage;

/**
 * Represents a service that manages chat infractions.
 */
public interface ChatInfractionService {

    /**
     * Get the last infraction of the player
     * @see DatabaseInfraction
     * @param player the associated player
     * @return a {@link CompletionStage} that will complete with {@link DatabaseInfraction} if the player has an infraction
     */
    @Nullable
    @NonBlocking
    CompletionStage<DatabaseInfraction> getLastInfraction(final @NotNull ChatPlayer player);

    /**
     * Get the last infractions of the player
     * @see DatabaseInfraction
     * @param player the associated player
     * @param limit the maximum amount of infractions to fetch
     * @return a {@link CompletionStage} that will complete with a {@link Collection} of {@link DatabaseInfraction} if the player has infractions
     */
    @Nullable
    @NonBlocking
    CompletionStage<Collection<DatabaseInfraction>> getInfractions(final @NotNull ChatPlayer player, final int limit);
}
