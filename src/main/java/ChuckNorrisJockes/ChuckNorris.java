package ChuckNorrisJockes;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ChuckNorris {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault(); // tworzenie użytkownika wysyłającego żądanie
        HttpGet httpGet = new HttpGet("https://api.chucknorris.io/jokes/random"); // żądanie get
        CloseableHttpResponse response1 = httpclient.execute(httpGet); // wysłanie żądania i odpowiedź
        InputStream content = response1.getEntity().getContent();



        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader(content));
        JsonObject rootObj = root.getAsJsonObject();
        String jocke = rootObj.get("value").getAsString();
        System.out.println(jocke);
    }
}