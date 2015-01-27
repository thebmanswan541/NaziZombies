package com.thecloud.Structure;

public enum GameState {

    IN_LOBBY(true), IN_GAME(false), RESETTING(false);

    private boolean canJoin;

    private static GameState currentState;

    GameState(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public boolean canJoin() {
        return canJoin;
    }

    public static void setGameState(GameState gamestate) {
        GameState.currentState = gamestate;
    }

    public static boolean isState(GameState gamestate) {
        return GameState.currentState == gamestate;
    }

    public static GameState getState() {
        return currentState;
    }
}
