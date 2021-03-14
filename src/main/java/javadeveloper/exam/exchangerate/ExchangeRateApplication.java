package javadeveloper.exam.exchangerate;

import javadeveloper.exam.exchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ExchangeRateApplication {
    @Autowired
    ExchangeRateService xchService;

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateApplication.class,args);
    }

    @Scheduled(cron = "${cron.expression}")
    public void heartbeat() {
        xchService.getExchangeRate();
    }
}
