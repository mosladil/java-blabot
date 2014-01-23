package cz.osladil.blabot.api;

/**
 *
 * @author mosladil
 */
public enum BlabotDictionary {

    CAPEK(1), MODERN(2), LAW(3);

    private final int dictionary;

    private BlabotDictionary(int dictionary) {
        this.dictionary = dictionary;
    }

    public String getDictionary() {
        return Integer.toString(dictionary);
    }
}