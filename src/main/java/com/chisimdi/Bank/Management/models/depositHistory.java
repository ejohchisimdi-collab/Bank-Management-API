package com.chisimdi.Bank.Management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class depositHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int DepositId;

    @JsonIgnore
    @ManyToOne
            @JoinColumn(name = "checkings_account_id")
    checkingsAccount checkingsAccount;

    @JsonIgnore
    @ManyToOne
            @JoinColumn(name = "savings_account_id")
    savingsAccount savingsAccount;

    double amount;
    LocalDate DateOfDeposit= LocalDate.now();
    public depositHistory(double amount){
        this.amount=amount;
    }
    public depositHistory(){}

    public int getDepositId() {
        return DepositId;
    }

    public void setDepositId(int depositId) {
        DepositId = depositId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfDeposit() {
        return DateOfDeposit;
    }

    public void setDateOfDeposit(LocalDate dateOfDeposit) {
        DateOfDeposit = dateOfDeposit;
    }

    public checkingsAccount getCheckingsAccount() {
        return checkingsAccount;
    }

    public savingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setCheckingsAccount(checkingsAccount checkingsAccount) {
        this.checkingsAccount = checkingsAccount;
    }

    public void setSavingsAccount(savingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

}
