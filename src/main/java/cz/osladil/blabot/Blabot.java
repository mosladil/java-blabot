package cz.osladil.blabot;

import cz.osladil.blabot.api.BlabotMethod;
import cz.osladil.blabot.api.BlabotDictionary;
import cz.osladil.blabot.api.BlabotApi;
import cz.osladil.blabot.api.BlabotApiException;
import cz.osladil.blabot.beans.BlabotResponseResult;

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

    public BlabotResponseResult getMessages(int count) throws BlabotApiException {
        try {
            return api
                .setResultMethod(BlabotMethod.PARAGRAPH)
                .setScount(count)
                .getResult();
        } catch (Exception ex) {
            throw new BlabotApiException(ex.getMessage());
        }
    }
    
    public BlabotResponseResult getMessagesAsList(int count) throws BlabotApiException {
        try {
            return api
                .setResultMethod(BlabotMethod.LIST)
                .setScount(count)
                .getResult();
        } catch (Exception ex) {
            throw new BlabotApiException(ex.getMessage());
        }
    }
}
