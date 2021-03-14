package javadeveloper.exam.exchangerate.dao;

import javadeveloper.exam.exchangerate.model.LatestCurrency;

public interface ExchangeRateRepository {
    void saveExcangeRate(String currency,String value);
}
