package cz.osladil.blabot.api;

/**
 *
 * @author mosladil
 */
public enum BlabotFormat {

    JSON("json"), PHP("php"), XML("xml");

    private final String format;

    private BlabotFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}