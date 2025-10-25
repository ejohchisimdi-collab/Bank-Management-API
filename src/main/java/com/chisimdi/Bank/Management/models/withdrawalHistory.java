package com.chisimdi.Bank.Management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class withdrawalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int WithdrawalId;

    @ManyToOne
    @JsonIgnore
            @JoinColumn(name = "savings_account_id")
    savingsAccount savingsAccount;

    @ManyToOne
    @JsonIgnore
            @JoinColumn(name="checkings_account_id")
    checkingsAccount checkingsAccount;

    double amount;
    LocalDate date=LocalDate.now();

    public withdrawalHistory(double amount){
        this.amount=amount;
    }
    public withdrawalHistory(){}

    public int getWithdrawalId() {
        return WithdrawalId;
    }

    public void setWithdrawalId(int withdrawalId) {
        WithdrawalId = withdrawalId;
    }

    public savingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(savingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public void setCheckingsAccount(checkingsAccount checkingsAccount) {
        this.checkingsAccount = checkingsAccount;
    }

    public checkingsAccount getCheckingsAccount() {
        return checkingsAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
