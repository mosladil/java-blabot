package cz.osladil.blabot.api;

/**
 *
 * @author mosladil
 */
public enum BlabotMethod {

    PARAGRAPH("paragraph"), LIST("list");

    private final String method;

    private BlabotMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

}