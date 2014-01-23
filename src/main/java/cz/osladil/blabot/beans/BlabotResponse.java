package cz.osladil.blabot.beans;

/**
 *
 * @author mosladil
 */
public class BlabotResponse {
    BlabotResponseBody blabot;
    
    public void setBlabot(BlabotResponseBody blabot) {
        this.blabot = blabot;
    }
    
    public BlabotRequest getRequest() {
        return blabot.request;
    }
    
    public BlabotResponseAuthor getIndex() {
        return blabot.index;
    }
    
    public BlabotResponseResult getResult() {
        return new BlabotResponseResult(blabot.result);
    }
}
