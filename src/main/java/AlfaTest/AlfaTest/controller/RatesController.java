package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.RatesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/rates")
public class RatesController {
    private final RatesService ratesService;

    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping("/get")
    public Set<String> getCharCodes() {
        return ratesService.getCharCodes();
    }
}
