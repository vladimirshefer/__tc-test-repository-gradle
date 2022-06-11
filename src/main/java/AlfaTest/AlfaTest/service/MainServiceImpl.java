package AlfaTest.AlfaTest.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService {
    private final String RICH_GIF_TAG = "rich";
    private final String BROKE_GIF_TAG = "broke";
    final private RatesService ratesService;
    private final GifService gifService;

    public MainServiceImpl(RatesService ratesService, GifService gifService) {
        this.ratesService = ratesService;
        this.gifService = gifService;
    }

    public ResponseEntity<Map> getGifByCharCode(String charCode) {
        String tag = getTag(isCurrentRateMore(charCode));
        return gifService.getGif(tag);
    }

    private boolean isCurrentRateMore(String charCode) {
        double currentRate = ratesService.getForCharCode(charCode);
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().minusDays(1));
        double prevRate = ratesService.getForCharCodeAndDate(charCode, date);
        return (currentRate - prevRate) > 0;
    }

    private String getTag(boolean isCurrenRateMore) {
        return isCurrenRateMore
                ? RICH_GIF_TAG
                : BROKE_GIF_TAG;
    }
}


