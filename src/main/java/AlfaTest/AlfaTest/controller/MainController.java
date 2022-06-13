package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.MainServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/gifs")
public class MainController {
    private final MainServiceImpl mainService;

    public MainController(MainServiceImpl ratesService) {
        this.mainService = ratesService;
    }

    @GetMapping()
    public String getGif(@RequestParam("symbol") String charCode) {
        return "redirect:"+mainService.getGifByCharCode(charCode).getBody();
    }
}

