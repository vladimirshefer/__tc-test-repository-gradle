package AlfaTest.AlfaTest.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface MainService {
    ResponseEntity<String> getGifByCharCode(String charCode);
}
