package AlfaTest.AlfaTest.client;

import AlfaTest.AlfaTest.model.Rates;

public interface RatesClient {
    Rates getCurrentRates(String appId);

    Rates getPrevRates(String appId, String date);
}
