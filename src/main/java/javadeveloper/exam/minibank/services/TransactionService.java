package javadeveloper.exam.minibank.services;


import javadeveloper.exam.minibank.model.Transaction;
import javadeveloper.exam.minibank.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    BigDecimal withraw(User user, BigDecimal amount);
    BigDecimal deposit(User user,BigDecimal amount);
    List<Transaction> getAllTransaction(User user);
    BigDecimal checkBalance(User user,BigDecimal amount);
}
