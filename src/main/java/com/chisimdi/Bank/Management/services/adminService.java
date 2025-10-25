package com.chisimdi.Bank.Management.services;
import com.chisimdi.Bank.Management.models.*;
import com.chisimdi.Bank.Management.repsitories.*;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
@Service

public class adminService {
    private final userRepository userRepository;
    private final checkingsAccountRepository checkingsAccountRepository;
    private final savingsAccountRepository savingsAccountRepository;
    private final withdrawalHistoryRepository withdrawalHistoryRepository;
private final depositHistoryRepository depositHistoryRepository;
    public adminService(userRepository userRepository,
                        checkingsAccountRepository checkingsAccountRepository,
                        savingsAccountRepository savingsAccountRepository,
                        depositHistoryRepository depositHistoryRepository,
                        withdrawalHistoryRepository withdrawalHistoryRepository){
        this.userRepository=userRepository;
        this.checkingsAccountRepository=checkingsAccountRepository;
        this.savingsAccountRepository=savingsAccountRepository;
        this.depositHistoryRepository=depositHistoryRepository;
        this.withdrawalHistoryRepository=withdrawalHistoryRepository;
    }

    public List<user>viewAllUsers(){
        return userRepository.findAll();
    }
    public user findUserById(int userId){
        return userRepository.findById(userId).
                orElseThrow(()->new RuntimeException("user not found"));
    }
    public List<checkingsAccount>findAllCheckingsAccount(){
        return checkingsAccountRepository.findAll();
    }
    public checkingsAccount findCheckingsAccountById(int userId){
        return checkingsAccountRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }
    public List<savingsAccount>findAllSavingsAccount(){
        return savingsAccountRepository.findAll();
    }
    public savingsAccount findSavingAccountbyId(int userId){
        return savingsAccountRepository.findById(userId).
                orElseThrow(()->new RuntimeException("Account not found"));
    }
    public String deleteUser(int userId){
        user user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        List<checkingsAccount>checkingsAccounts=user.getCheckingsAccounts();
        List<savingsAccount>savingsAccounts=user.getSavingsAccounts();
        for(int x=0;x<checkingsAccounts.size();x++){
            checkingsAccountRepository.delete(checkingsAccounts.get(x));
        }
        for(int x=0;x<savingsAccounts.size();x++){
            savingsAccountRepository.delete(savingsAccounts.get(x));
        }
        userRepository.deleteById(userId);

        return "user deleted";
    }
    public List<depositHistory>viewAllDeposits(){
        return depositHistoryRepository.findAll();
    }
    public List<withdrawalHistory>viewAllWithdraws(){
        return withdrawalHistoryRepository.findAll();
    }
    public String calculateInterest (int userId){
        savingsAccount s= savingsAccountRepository.findById(userId).orElseThrow();
       LocalDate c= s.getDateOfCreation();
       LocalDate d= LocalDate.now();
       double duration= ChronoUnit.DAYS.between(c,d);
       double interest=(s.getBalance()*duration*0.05)/100;
       s.setBalance(s.getBalance()+interest);
       savingsAccountRepository.save(s);
       return "interest added";
    }



}