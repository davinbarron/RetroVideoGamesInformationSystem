package Application;

import Controller.GameSystemAPI;
import java.io.Serializable;

public class GameSystemAPIInstance implements Serializable {

    private static GameSystemAPI instance;

    private GameSystemAPIInstance() {
        // private constructor to prevent instantiation
    }

    public static GameSystemAPI getInstance() {
        if (instance == null) {
            instance = new GameSystemAPI();
        }
        return instance;
    }

    public static void setInstance(GameSystemAPI api) {
        instance = api;
    }
}
