package com.chisimdi.Bank.Management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "users")

    List<savingsAccount>savingsAccounts;

    @OneToMany(mappedBy = "users")
    List<checkingsAccount>checkingsAccounts;

    String name;
    String contactInfo;

    public user(String name,String contactInfo,
                List<checkingsAccount>checkingsAccounts,
                List<savingsAccount>savingsAccount){
        this.name=name;
        this.contactInfo=contactInfo;
        this.checkingsAccounts=checkingsAccounts;
        this.savingsAccounts=savingsAccount;

    }
    public user(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<checkingsAccount> getCheckingsAccounts() {
        return checkingsAccounts;
    }

    public void setCheckingsAccounts(List<checkingsAccount> checkingsAccounts) {
        this.checkingsAccounts = checkingsAccounts;
    }

    public List<savingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts(List<savingsAccount> savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

}
