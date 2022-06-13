package AlfaTest.AlfaTest.service;

import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<String> getGif(String tag);
}
