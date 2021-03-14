package javadeveloper.exam.exchangerate.dao.impl;

import javadeveloper.exam.exchangerate.dao.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;


@Repository
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {

    private static final String SQL_INSERT_EXCHANGE_RATE ="INSERT INTO EXCHANGERATE(DATE,CURRENCY,VALUE)  " +
            "VALUES(?,?,?)";

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void saveExcangeRate(String currency,String value) {
        jdbcTemplate.update(connection ->{
           PreparedStatement ps = connection.prepareStatement(SQL_INSERT_EXCHANGE_RATE);
           ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
           ps.setString(2,currency);
           String currencyValue = String.valueOf(value);
           ps.setString(3, currencyValue);
           return ps;
        });
        System.out.println(">>>>>>Saving Data to DB<<<<<<<<<");
    }
}
