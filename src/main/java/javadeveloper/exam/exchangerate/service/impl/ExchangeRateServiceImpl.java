package javadeveloper.exam.exchangerate.service.impl;

import javadeveloper.exam.exchangerate.dao.ExchangeRateRepository;
import javadeveloper.exam.exchangerate.model.LatestCurrency;
import javadeveloper.exam.exchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Autowired
    ExchangeRateRepository xchRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "https://api.exchangeratesapi.io/";
    List curriencies = Arrays.asList("USD","CAD","PHP");


    @Override
    public void getExchangeRate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        /*
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "latest?base=USD",
                HttpMethod.GET,
                requestEntity,
                String.class);
        System.out.println("Request Body " + responseEntity);
        */

        LatestCurrency latestCurrency = restTemplate.getForObject(baseUrl + "latest?base=USD",LatestCurrency.class);

        curriencies.stream().forEach(currency->{
            String currencyValue = String.valueOf(latestCurrency.getRates().get(currency.toString()));
            xchRepository.saveExcangeRate(currency.toString(),currencyValue);
        });
        System.out.println(">>>>> Getting Exchange Rate <<<<<<<<");
    }


}
