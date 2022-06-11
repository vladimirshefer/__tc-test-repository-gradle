package AlfaTest.AlfaTest.service;

import AlfaTest.AlfaTest.client.FeignRatesClient;
import AlfaTest.AlfaTest.model.Rates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RatesServiceImpl implements RatesService {

    private Rates currentRates;
    @Value("${openexchangerates.app.key}")
    private String apiKey;
    private final FeignRatesClient feignRatesClient;

    public RatesServiceImpl(FeignRatesClient feignRatesClient) {
        this.feignRatesClient = feignRatesClient;
    }

    @Override
    public Set<String> getCharCodes() {
        Rates currentRates = feignRatesClient.getСurrentRates(apiKey);
        Set<String> codes = currentRates.getRates().keySet();
        return codes;
    }

    @Override
    public double getForCharCode(String charCode) {
        Rates currentRates = feignRatesClient.getСurrentRates(apiKey);
        return currentRates.getRates().get(charCode);
    }

    @Override
    public double getForCharCodeAndDate(String charCode, String date) {
        Rates prevRates = feignRatesClient.getPrevRates(apiKey, date);
        return prevRates.getRates().get(charCode);
    }
}
