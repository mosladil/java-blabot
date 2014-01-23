package cz.osladil.blabot.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mosladil
 */
public class BlabotResponseResult {
    private final ArrayList<String> messages;
    
    public BlabotResponseResult(ArrayList<String> messages) {
        this.messages = messages;
    }
    
    public List<String> getMessages() {
        List<String> list = this.messages;
        return list;
    }
}
