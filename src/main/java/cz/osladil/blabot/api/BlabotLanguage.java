package cz.osladil.blabot.api;

/**
 *
 * @author mosladil
 */
public enum BlabotLanguage {

    CS("cs");

    private final String method;

    private BlabotLanguage(String method) {
        this.method = method;
    }

    public String getLanguage() {
        return method;
    }

}