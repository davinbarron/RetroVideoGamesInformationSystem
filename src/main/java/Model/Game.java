package Model;

import java.io.Serializable;

/**
 * This class represents a game.
 */
public class Game implements Serializable {
    private String title;
    private String publisher;
    private String description;
    private String developer;
    private String gameMachine;
    private int releaseYear;
    private String coverImageUrl;

    /**
     * Constructs a new game with the specified details.
     *
     * @param title the title of the game
     * @param publisher the publisher of the game
     * @param description the description of the game
     * @param developer the original developer of the game
     * @param gameMachine the original game machine the game was developed for
     * @param releaseYear the year of first release of the game
     * @param coverImageUrl the URL of the original cover art/image of the game
     */
    public Game(String title, String publisher, String description, String developer, String gameMachine, int releaseYear, String coverImageUrl) {
        setTitle(title);
        setPublisher(publisher);
        setDescription(description);
        setDeveloper(developer);
        setGameMachine(gameMachine);
        setReleaseYear(releaseYear);
        setCoverImageUrl(coverImageUrl);
    }

    // getters and setters with validation
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher != null && !publisher.isEmpty()) {
            this.publisher = publisher;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        if (developer != null && !developer.isEmpty()) {
            this.developer = developer;
        }
    }

    public String getGameMachine() {
        return gameMachine;
    }

    public void setGameMachine(String gameMachine) {
        if (gameMachine != null && !gameMachine.isEmpty()) {
            this.gameMachine = gameMachine;
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear > 0) {
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
        return title;  // return only the title
    }
}
