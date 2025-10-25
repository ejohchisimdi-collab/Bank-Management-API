package com.chisimdi.Bank.Management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class savingsAccount {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
@JsonIgnore
        @ManyToOne
        @JoinColumn(name = "user_id")
        user users;

@OneToMany(mappedBy = "savingsAccount")
List<depositHistory>depositHistories;

@OneToMany(mappedBy="savingsAccount")
List<withdrawalHistory>withdrawalHistories;

        String accountNumber;
        double balance;

    private LocalDate dateOfCreation= LocalDate.now();

        public savingsAccount(user users, String accountNumber, double balance){
            this.users= users;
            this.accountNumber=accountNumber;
            this.balance=balance;
        }
        public savingsAccount(){}

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

    public void setWithdrawalHistories(List<withdrawalHistory> withdrawalHistories) {
        this.withdrawalHistories = withdrawalHistories;
    }

    public List<withdrawalHistory> getWithdrawalHistories() {
        return withdrawalHistories;
    }

    public List<depositHistory> getDepositHistories() {
        return depositHistories;
    }

    public void setDepositHistories(List<depositHistory> depositHistories) {
        this.depositHistories = depositHistories;
    }
}
