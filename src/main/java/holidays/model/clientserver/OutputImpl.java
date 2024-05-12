package holidays.model.clientserver;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OutputImpl implements Output {

    /**
     * send data to the online output API;
     * @param message the data to be send to the new pastebin
     * @return the generated url
     */
    @Override
    public String createPaste(String message){
        try {
            URL url = new URL("https://pastebin.com/api/api_post.php");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String data = "api_dev_key=5pkQkSS67HF33a2G67XEMPkt1DELPtpN&api_paste_code="+message+"&api_option=paste";

            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);
            BufferedReader br;
            if (http.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    return strCurrentLine;
                }
            }
            http.disconnect();
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
