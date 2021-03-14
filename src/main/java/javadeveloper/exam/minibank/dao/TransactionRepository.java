package javadeveloper.exam.minibank.dao;

import javadeveloper.exam.minibank.model.Transaction;
import javadeveloper.exam.minibank.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository {
    BigDecimal withraw(User user, BigDecimal amount);
    BigDecimal deposit(User user,BigDecimal amount);
    List<Transaction> getAllTransaction(User user);
    BigDecimal getBalance(User user);
    void insertTransaction(User user,BigDecimal amount,String transaction);
}
