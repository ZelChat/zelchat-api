package it.pino.zelchat.api;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class ZelChatProvider {

    private static ZelChatAPI api;

    private ZelChatProvider() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    static @NotNull ZelChatAPI getApi(){
        return Objects.requireNonNull(api, "API is not set! Please specify in plugin.yml ZelChat as dependency.");
    }

    public static void set(@NotNull ZelChatAPI api) {
        ZelChatProvider.api = api;
    }
}