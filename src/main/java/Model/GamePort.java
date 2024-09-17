package Model;

import java.io.Serializable;

/**
 * This class represents a game port.
 */
public class GamePort implements Serializable {
    private Game originalGame;
    private GameMachine portedGameMachine;
    private String portDeveloper;
    private int releaseYear;
    private String coverImageUrl;

    /**
     * Constructs a new game port with the specified details.
     *
     * @param originalGame the original game being ported
     * @param portedGameMachine the new (ported to) games machine
     * @param portDeveloper the port developer (company or people names)
     * @param releaseYear the release year of the game port
     * @param coverImageUrl the cover art/image (as a URL) of the game port
     */
    public GamePort(Game originalGame, GameMachine portedGameMachine, String portDeveloper, int releaseYear, String coverImageUrl) {
        setOriginalGame(originalGame);
        setPortedGameMachine(portedGameMachine);
        setPortDeveloper(portDeveloper);
        setReleaseYear(releaseYear);
        setCoverImageUrl(coverImageUrl);
    }

    // getters and setters with validation
    public Game getOriginalGame() {
        return originalGame;
    }

    public void setOriginalGame(Game originalGame) {
        if (originalGame != null) {
            this.originalGame = originalGame;
        }
    }

    public GameMachine getPortedGameMachine() {
        return portedGameMachine;
    }

    public void setPortedGameMachine(GameMachine portedGameMachine) {
        if (portedGameMachine != null) {
            this.portedGameMachine = portedGameMachine;
        }
    }

    public String getPortDeveloper() {
        return portDeveloper;
    }

    public void setPortDeveloper(String portDeveloper) {
        if (portDeveloper != null && !portDeveloper.isEmpty()) {
            this.portDeveloper = portDeveloper;
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear >= originalGame.getReleaseYear()) {
            this.releaseYear = releaseYear;
        }
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        if (coverImageUrl != null && !coverImageUrl.isEmpty()) {
            this.coverImageUrl = coverImageUrl;
        }
    }

    @Override
    public String toString() {
        return "GamePort{" +
                "originalGame=" + originalGame +
                ", portedGameMachine=" + portedGameMachine +
                ", portDeveloper='" + portDeveloper + '\'' +
                ", releaseYear=" + releaseYear +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                '}';
    }

}
