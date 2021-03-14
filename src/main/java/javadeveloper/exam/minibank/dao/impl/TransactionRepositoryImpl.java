package javadeveloper.exam.minibank.dao.impl;

import javadeveloper.exam.minibank.dao.TransactionRepository;
import javadeveloper.exam.minibank.model.Transaction;
import javadeveloper.exam.minibank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private static final String GET_BALANCE = "SELECT * FROM USERS WHERE ACCOUNTNO=?";
    private static final String UPDATE_BALANCE = "UPDATE USERS SET BALANCE = ? WHERE ACCOUNTNO = ?";
    private static final String INSERT_TRANSACTION = "INSERT INTO TRANSACTIONS(TRANSACTION_DATE,ACCOUNTNO,TRANSACTION," +
            "TRANSACTION_AMOUNT) VALUES(?,?,?,?) ";
    private static final String GET_TRANSACTIONS = "SELECT * FROM TRANSACTIONS WHERE ACCOUNTNO = ? ORDER BY TRANSACTION_DATE" +
            " DESC ";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal withraw(User user, BigDecimal amount) {
        System.out.println(">>>>>>>Updating Balance<<<<<<<<<<");
        jdbcTemplate.update(UPDATE_BALANCE,new Object[]{amount,user.getAccountNo()});
        return amount;
    }

    @Override
    public void insertTransaction(User user,BigDecimal amount,String transaction){
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(INSERT_TRANSACTION);
            ps.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
            ps.setInt(2,user.getAccountNo());
            ps.setString(3,transaction);
            ps.setBigDecimal(4,amount);
            return ps;
        });
    }

    @Override
    public BigDecimal deposit(User user, BigDecimal amount) {
        System.out.println(">>>>>>>Updating Balance<<<<<<<<<<");
        jdbcTemplate.update(UPDATE_BALANCE,new Object[]{amount,user.getAccountNo()});
        return amount;
    }

    @Override
    public List<Transaction> getAllTransaction(User user) {
        return jdbcTemplate.query(GET_TRANSACTIONS,new Object[]{user.getAccountNo()},transactionRowMapper);
    }

    @Override
    public BigDecimal getBalance(User user) {
       User userFromDb =  jdbcTemplate.queryForObject(GET_BALANCE,new Object[]{user.getAccountNo()},userRowMapper);
        return userFromDb.getBalance();
    }

    private RowMapper<User> userRowMapper = ((rs, rowNum)->{
        return new User(
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("password"),
                rs.getBigDecimal("balance"),
                rs.getInt("accountno")

        );
    });

    private RowMapper<Transaction> transactionRowMapper = ((rs, rowNum)->{
        return new Transaction(
                rs.getDate("transaction_date"),
                rs.getInt("accountno"),
                rs.getString("transaction"),
                rs.getBigDecimal("transaction_amount"),
                rs.getInt("transactionno")
        );
    });
}
