package cz.osladil.blabot;

import cz.osladil.blabot.api.BlabotMethod;
import cz.osladil.blabot.api.BlabotDictionary;
import cz.osladil.blabot.api.BlabotApi;
import cz.osladil.blabot.api.BlabotApiException;
import java.util.List;

/**
 *
 * @author mosladil
 */
public class Blabot {

    private final BlabotDictionary dictionary;
    private final BlabotApi api;

    public Blabot(BlabotDictionary dictionary) {
        this.dictionary = dictionary;
        this.api = new BlabotApi(this.dictionary);
    }

    public String getMessage() throws BlabotApiException {
        return getMessages(1);
    }

    public String getMessages(int count) throws BlabotApiException {
        try {
            return api
                .setResultMethod(BlabotMethod.PARAGRAPH)
                .setScount(count)
                .getResult()
                .getMessages()
                .get(0);
        } catch (Exception ex) {
            throw new BlabotApiException(ex.getMessage());
        }
    }

    public List<String> getMessagesAsList(int count) throws BlabotApiException {
        try {
            return api
                .setResultMethod(BlabotMethod.LIST)
                .setScount(count)
                .getResult()
                .getMessages();
        } catch (Exception ex) {
            throw new BlabotApiException(ex.getMessage());
        }
    }
}
