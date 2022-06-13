package AlfaTest.AlfaTest.client;

import AlfaTest.AlfaTest.model.Rates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ratesClient", url = "${openexchangerates.url.general}")
public interface FeignRatesClient extends RatesClient {
    @Override
    @GetMapping("/latest.json")
    Rates getCurrentRates(@RequestParam("app_id") String appId);

    @Override
    @GetMapping("/historical/{date}.json")
    Rates getPrevRates(
            @RequestParam("app_id") String appId,
            @PathVariable String date
    );
}
