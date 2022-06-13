package AlfaTest.AlfaTest.service.Impl;

import AlfaTest.AlfaTest.client.FeignRatesClient;
import AlfaTest.AlfaTest.model.Rates;
import AlfaTest.AlfaTest.service.RatesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public Set<String> getSymbols() {
        Rates currentRates = feignRatesClient.getCurrentRates(apiKey);
        Set<String> codes = currentRates.getRates().keySet();
        return codes;
    }

    @Override
    public BigDecimal getBySymbol(String symbol) {
        Rates currentRates = feignRatesClient.getCurrentRates(apiKey);
        return currentRates.getRates().get(symbol);
    }

    @Override
    public BigDecimal getBySymbolAndDate(String symbol, String date) {
        Rates prevRates = feignRatesClient.getPrevRates(apiKey, date);
        return prevRates.getRates().get(symbol);
    }
}
