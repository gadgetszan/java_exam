package javadeveloper.exam.minibank.model;


import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Date transaction_date;
    private Integer accountNo;
    private String transaction;
    private BigDecimal transactionAmount;
    private Integer transactionNo;

    public Transaction(Date transaction_date, Integer accountNo, String transaction, BigDecimal transactionAmount) {
        this.transaction_date = transaction_date;
        this.accountNo = accountNo;
        this.transaction = transaction;
        this.transactionAmount = transactionAmount;
    }

    public Transaction(Date transaction_date, Integer accountNo, String transaction, BigDecimal transactionAmount,Integer transactionNo) {
        this.transaction_date = transaction_date;
        this.accountNo = accountNo;
        this.transaction = transaction;
        this.transactionAmount = transactionAmount;
        this.transactionNo = transactionNo;
    }


    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(Integer transactionNo) {
        this.transactionNo = transactionNo;
    }


}
