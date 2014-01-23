package cz.osladil.blabot.api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import cz.osladil.blabot.beans.BlabotResponse;
import cz.osladil.blabot.beans.BlabotResponseResult;

/**
 *
 * @author mosladil
 */
public class BlabotApi {

    private final String API_ENDPOINT = "http://api.blabot.net/?";
    private final String API_VERSION = "10b";
    private final String CHARSET = "UTF-8";

    private final int LIMIT_SCOUNT = 100;
    private int scount = 10;
    
    private BlabotMethod method = BlabotMethod.PARAGRAPH;

    private final BlabotFormat format = BlabotFormat.JSON;
    private final BlabotDictionary dictionary;
    private final BlabotLanguage language = BlabotLanguage.CS;
    
    public BlabotApi(BlabotDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public BlabotApi setScount(int c) throws BlabotApiException {
        if (c > LIMIT_SCOUNT) throw new BlabotApiException("Maximum count allowed " + LIMIT_SCOUNT);
        scount = c;
        return this;
    }
    
    public BlabotApi setResultMethod(BlabotMethod method) {
        this.method = method;
        return this;
    }
    
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public BlabotResponseResult getResult() throws IOException, URISyntaxException {
        BlabotResponse blabot;
        
        InputStream is = new URL(getApiEndpoint()).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName(CHARSET)));
            String jsonText = readAll(rd);
            blabot = new Gson().fromJson(jsonText, BlabotResponse.class);
        } finally {
            is.close();
        }
        return blabot.getResult();
    }
    
    private String getApiEndpoint() {
        List<NameValuePair> options = new ArrayList<NameValuePair>();
        options.add(new BasicNameValuePair("version", API_VERSION));
        options.add(new BasicNameValuePair("language", language.getLanguage()));
        options.add(new BasicNameValuePair("format", format.getFormat()));
        options.add(new BasicNameValuePair("dictionary", dictionary.getDictionary()));
        options.add(new BasicNameValuePair("method", method.getMethod()));
        options.add(new BasicNameValuePair("scount", Integer.toString(scount)));

        return API_ENDPOINT + URLEncodedUtils.format(options, CHARSET);
    }
}
