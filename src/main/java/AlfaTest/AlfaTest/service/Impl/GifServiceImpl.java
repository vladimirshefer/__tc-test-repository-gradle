package AlfaTest.AlfaTest.service.Impl;

import AlfaTest.AlfaTest.client.GifClient;
import AlfaTest.AlfaTest.service.GifService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GifServiceImpl implements GifService {
    private GifClient gifClient;
    @Value("${giphy.api.key}")
    private String apiKey;

    public GifServiceImpl(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @Override
    public ResponseEntity<String> getGif(String tag) {
        ResponseEntity<Map> json = gifClient.getRandomGifByTag(apiKey, tag);
        String gifUrl = getGifUrlByJson(json);
        return gifUrl.isEmpty()
                ? new ResponseEntity<>("error", HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(gifUrl, HttpStatus.OK);
    }

    private String getGifUrlByJson(ResponseEntity<Map> json) {
        Map body = json.getBody();
        Map data = (Map) body.get("data");
        return (String) data.get("embed_url");
    }
}
