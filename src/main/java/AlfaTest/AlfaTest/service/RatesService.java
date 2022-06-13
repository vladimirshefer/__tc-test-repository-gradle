package AlfaTest.AlfaTest.service;

import java.math.BigDecimal;
import java.util.Set;

public interface RatesService {

    Set<String> getSymbols();

    BigDecimal getBySymbol(String symbol);

    BigDecimal getBySymbolAndDate(String symbol, String date);
}
