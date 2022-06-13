package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.Impl.MainServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gifs")
public class MainController {
    private final MainServiceImpl mainService;

    public MainController(MainServiceImpl ratesService) {
        this.mainService = ratesService;
    }
    @Operation(summary = "Get gif by symbol")
    @ApiResponse(responseCode = "200", description = "Gif found")
    @GetMapping()
    public String getGif(@RequestParam(value = "symbol") String charCode) {
        return "redirect:"+mainService.getGifByCharCode(charCode).getBody();
    }
}

