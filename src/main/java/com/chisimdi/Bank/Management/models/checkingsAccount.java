package com.chisimdi.Bank.Management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
public class checkingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user users;

@OneToMany(mappedBy = "checkingsAccount")
List<depositHistory> depositHistoryList;

@OneToMany(mappedBy="checkingsAccount")
List<withdrawalHistory>withdrawalHistories;


    private String accountNumber;
    private double balance;

    private LocalDate dateOfCreation= LocalDate.now();
public checkingsAccount(user users, String accountNumber, double balance){
    this.users= users;
    this.accountNumber=accountNumber;
    this.balance=balance;
}
public checkingsAccount(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



    public user getUsers() {
        return this.users;
    }

    public void setUsers(user users) {
        this.users = users;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public LocalDate getDateOfCreation(){
    return  this.dateOfCreation;
    }

    public List<depositHistory> getDepositHistoryList() {
        return depositHistoryList;
    }

    public List<withdrawalHistory> getWithdrawalHistories() {
        return withdrawalHistories;
    }

    public void setDepositHistoryList(List<depositHistory> depositHistoryList) {
        this.depositHistoryList = depositHistoryList;
    }

    public void setWithdrawalHistories(List<withdrawalHistory> withdrawalHistories) {
        this.withdrawalHistories = withdrawalHistories;
    }

}
