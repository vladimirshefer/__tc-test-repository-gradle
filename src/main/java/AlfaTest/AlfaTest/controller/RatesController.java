package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.RatesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RatesController {
    private final RatesService ratesService;

    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @Operation(summary = "Get all symbols")
    @ApiResponse(responseCode = "200", description = "all codes found")
    @GetMapping("/symbols")
    public Set<String> getSymbols() {
        return ratesService.getSymbols();
    }
}
