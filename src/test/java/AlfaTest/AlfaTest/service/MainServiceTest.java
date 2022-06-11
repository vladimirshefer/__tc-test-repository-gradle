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
        Map<String, Double> currentMap = new HashMap<>();
        currentMap.put("C1", 2.0);
        currentMap.put("C2", 1.0);
        currentMap.put("C3", 3.0);
        currentRates.setRates(currentMap);
        currentRates.setBase("BASE");
        currentRates.setTimestamp(0);

        prevRates = new Rates();
        Map<String, Double> prevMap = new HashMap<>();
        currentMap.put("P1", 2.0);
        currentMap.put("P2", 1.0);
        currentMap.put("P3", 3.0);
        currentMap.put("P4", 3.0);
        prevRates.setRates(prevMap);
        prevRates.setBase("BASE");
        prevRates.setTimestamp(24);
    }

    @Test
    public void whenReturnGif() {
        ResponseEntity<Map> result = mainService.getGifByCharCode("RUB");
        Assert.assertTrue(result.getBody().size()  > 0 );
    }
}
