package Model;

import java.io.Serializable;

/**
 * This class represents a game machine.
 */
public class GameMachine implements Serializable {
    private String name;
    private String manufacturer;
    private String description;
    private String type;
    private String media;
    private int launchYear;
    private double price;
    private String imageUrl;

    /**
     * Constructs a new game machine with the specified details.
     *
     * @param name the name of the game machine
     * @param manufacturer the manufacturer of the game machine
     * @param description the description of the game machine
     * @param type the type of the game machine
     * @param media the media used by the game machine
     * @param launchYear the launch year of the game machine
     * @param price the initial RRP/price of the game machine
     * @param imageUrl the image URL of the game machine
     */
    public GameMachine(String name, String manufacturer, String description, String type, String media, int launchYear, double price, String imageUrl) {
        setName(name);
        setManufacturer(manufacturer);
        setDescription(description);
        setType(type);
        setMedia(media);
        setLaunchYear(launchYear);
        setPrice(price);
        setImageUrl(imageUrl);
    }

    // getters and setters with validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer != null && !manufacturer.isEmpty()) {
            this.manufacturer = manufacturer;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null && !type.isEmpty()) {
            this.type = type;
        }
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        if (media != null && !media.isEmpty()) {
            this.media = media;
        }
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        if (launchYear > 0) {
            this.launchYear = launchYear;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            this.imageUrl = imageUrl;
        }
    }

    @Override
    public String toString() {
        return name;  // return only some specific information
    }
}

