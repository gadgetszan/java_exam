package javadeveloper.exam.exchangerate.model;

import java.util.Map;

public class LatestCurrency {
    private String date;
    private Map<String,Object> rates;
    private String base;

    public LatestCurrency(){
        super();
    }
    public LatestCurrency(String date, Map<String, Object> rates, String base) {
        this.date = date;
        this.rates = rates;
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Object> getRates() {
        return rates;
    }

    public void setRates(Map<String, Object> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
