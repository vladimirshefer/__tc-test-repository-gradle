package AlfaTest.AlfaTest.service;

import AlfaTest.AlfaTest.model.Rates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainServiceTest {
    @Autowired
    MainServiceImpl mainService;

    @Autowired
    RatesServiceImpl ratesService;

    @Autowired
    GifServiceImpl gifService;

    private Rates currentRates;
    private Rates prevRates;

    @Before
    public void init() {
        currentRates = new Rates();
        Map<String, BigDecimal> currentMap = new HashMap<>();
        currentMap.put("C1", new BigDecimal("2.0"));
        currentMap.put("C2", new BigDecimal("1.0"));
        currentMap.put("C3", new BigDecimal("3.0"));
        currentRates.setRates(currentMap);
        currentRates.setBase("BASE");
        currentRates.setTimestamp(0);

        prevRates = new Rates();
        Map<String, BigDecimal> prevMap = new HashMap<>();
        currentMap.put("P1", new BigDecimal("2.0"));
        currentMap.put("P2", new BigDecimal("1.0"));
        currentMap.put("P3", new BigDecimal("3.0"));
        currentMap.put("P4", new BigDecimal("3.0"));
        prevRates.setRates(prevMap);
        prevRates.setBase("BASE");
        prevRates.setTimestamp(24);
    }

    @Test
    public void whenReturnGif() {
        ResponseEntity<String> result = mainService.getGifByCharCode("RUB");
        Assert.assertTrue(result.getBody().length() > 0);
    }
}
