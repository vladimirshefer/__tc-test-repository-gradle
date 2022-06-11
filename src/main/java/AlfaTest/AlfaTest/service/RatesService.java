package AlfaTest.AlfaTest.service;

import java.util.List;
import java.util.Set;

public interface RatesService {

    Set<String> getCharCodes();

    double getForCharCode(String charCode);

    double getForCharCodeAndDate(String charCode,String date);
}
