package AlfaTest.AlfaTest.client;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GifClient {
    ResponseEntity<Map> getRandomGifByTag(String apiKey, String tag);
}
