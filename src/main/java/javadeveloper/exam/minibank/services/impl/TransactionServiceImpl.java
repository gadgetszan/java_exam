package javadeveloper.exam.minibank.services.impl;

import javadeveloper.exam.minibank.dao.TransactionRepository;
import javadeveloper.exam.minibank.model.Transaction;
import javadeveloper.exam.minibank.model.User;
import javadeveloper.exam.minibank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public BigDecimal withraw(User user, BigDecimal amount) {
        BigDecimal balance = checkBalance(user,amount);
        int checkBalance = balance.compareTo(amount);
        if(checkBalance != -1){
            BigDecimal newAmount = balance.subtract(amount);
            transactionRepository.insertTransaction(user,amount,"DEBIT");
            transactionRepository.withraw(user,newAmount);
            balance = newAmount;
        }else{
            System.out.println("insufficient balance");
        }
        return balance;
    }

    @Override
    public BigDecimal deposit(User user, BigDecimal amount) {
        BigDecimal balance = checkBalance(user,amount);
        BigDecimal newAmount = balance.add(amount);
        transactionRepository.insertTransaction(user,amount,"CREDIT");
        return transactionRepository.deposit(user,newAmount);
    }

    @Override
    public List<Transaction> getAllTransaction(User user) {
        return transactionRepository.getAllTransaction(user);
    }

    @Override
    public BigDecimal checkBalance(User user, BigDecimal amount) {
        System.out.println("Service - Checking Balance");
        return transactionRepository.getBalance(user);
    }
}
