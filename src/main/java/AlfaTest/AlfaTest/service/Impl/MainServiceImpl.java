package AlfaTest.AlfaTest.service.Impl;

import AlfaTest.AlfaTest.service.GifService;
import AlfaTest.AlfaTest.service.MainService;
import AlfaTest.AlfaTest.service.RatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public ResponseEntity<String> getGifByCharCode(String charCode) {
        String tag = getTag(isCurrentRateMore(charCode));
        return gifService.getGif(tag);
    }

    private boolean isCurrentRateMore(String charCode) {
        BigDecimal currentRate = ratesService.getBySymbol(charCode);
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().minusDays(1));
        BigDecimal prevRate = ratesService.getBySymbolAndDate(charCode, date);
        return currentRate.compareTo(prevRate) > 0;
    }

    private String getTag(boolean isCurrenRateMore) {
        return isCurrenRateMore
                ? RICH_GIF_TAG
                : BROKE_GIF_TAG;
    }
}


