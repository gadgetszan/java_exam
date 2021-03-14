package javadeveloper.exam.minibank.controller;

import javadeveloper.exam.minibank.model.Transaction;
import javadeveloper.exam.minibank.model.User;
import javadeveloper.exam.minibank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody Map<String,Object> transactionMap){
        String accountNo = (String) transactionMap.get("accountno");
        String amount = (String) transactionMap.get("amount");
        System.out.println(">>>>>You are in deposit<<<<<<<<<: " + accountNo + " " + amount);
        User user = new User();
        user.setAccountNo(Integer.parseInt(accountNo));
        BigDecimal newBalance = transactionService.deposit(user,new BigDecimal(amount));
        return new ResponseEntity<>(String.valueOf(newBalance), HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody Map<String,Object> transactionMap){
        String accountNo = (String) transactionMap.get("accountno");
        String amount = (String) transactionMap.get("amount");
        User user = new User();
        user.setAccountNo(Integer.parseInt(accountNo));
        BigDecimal balance = transactionService.withraw(user, new BigDecimal(amount));
        return new ResponseEntity<>("you balance is: " + String.valueOf(balance),HttpStatus.OK);
    }

    @PostMapping("/history")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@RequestBody Map<String,Object> transactionMap){
        String accountNo = (String) transactionMap.get("accountno");
        User user = new User();
        user.setAccountNo(Integer.parseInt(accountNo));
        List<Transaction> transactions = transactionService.getAllTransaction(user);
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    };


}
