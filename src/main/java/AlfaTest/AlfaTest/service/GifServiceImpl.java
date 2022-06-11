package AlfaTest.AlfaTest.service;

import AlfaTest.AlfaTest.client.GifClient;
import org.springframework.beans.factory.annotation.Value;
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
    public ResponseEntity<Map> getGif(String tag) {
        ResponseEntity<Map> result = gifClient.getRandomGifByTag(apiKey, tag);
        result.getBody().put("tag", tag);
        return gifClient.getRandomGifByTag(this.apiKey, tag);
    }
}
