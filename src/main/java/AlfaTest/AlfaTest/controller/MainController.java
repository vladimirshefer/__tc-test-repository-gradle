package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.MainServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("/gif")
public class MainController {
    private final MainServiceImpl mainService;

    public MainController(MainServiceImpl ratesService) {
        this.mainService = ratesService;
    }

    @GetMapping("/{charCode}")
    public ResponseEntity<Map> getGif(@PathVariable("charCode") String charCode) {
        return mainService.getGifByCharCode(charCode);
    }
}

