package com.chisimdi.Bank.Management.services;
import com.chisimdi.Bank.Management.models.*;
import com.chisimdi.Bank.Management.repsitories.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userService {
    private final userRepository userRepository;
    private final checkingsAccountRepository checkingsAccountRepository;
    private final savingsAccountRepository savingsAccountRepository;
    private final withdrawalHistoryRepository withdrawalHistoryRepository;
    private final depositHistoryRepository depositHistoryRepository;
    public userService(checkingsAccountRepository checkingsAccountRepository,
                       userRepository userRepository,
                       savingsAccountRepository savingsAccountRepository,
                       depositHistoryRepository depositHistoryRepository,
                       withdrawalHistoryRepository withdrawalHistoryRepository){
        this.checkingsAccountRepository=checkingsAccountRepository;
        this.savingsAccountRepository=savingsAccountRepository;
        this.userRepository=userRepository;
        this.depositHistoryRepository=depositHistoryRepository;
        this.withdrawalHistoryRepository=withdrawalHistoryRepository;
    }

    public String createUser(user user){
        userRepository.save(user);
        return "user created sucessflly";
    }
    public String deleteUser(int userId){
        user user =userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
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
    public String deleteSavingsAccount(int userId){
        savingsAccountRepository.deleteById(userId);
        return "account deleted";
    }
    public String deleteCheckingsAccount(int userId){
        checkingsAccountRepository.deleteById(userId);
        return "account deleted";
    }

    public String createNewSavingsAccount(savingsAccount savingsAccount,int userId){
        savingsAccount savingsAccount1=savingsAccountRepository.save(savingsAccount);
        user user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        savingsAccount1.setUsers(user);
        savingsAccountRepository.save(savingsAccount1);
        user.getSavingsAccounts().add(savingsAccount1);
        userRepository.save(user);
        return "account created successfully";
    }
    public String createNewCheckingsAccount(checkingsAccount checkingsAccount,int userId){
        checkingsAccount checkingsAccount1=checkingsAccountRepository.save(checkingsAccount);
        user user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        checkingsAccount1.setUsers(user);
        checkingsAccountRepository.save(checkingsAccount1);
        user.getCheckingsAccounts().add(checkingsAccount1);
        userRepository.save(user);
        return "account created successfully";
    }
    public List<checkingsAccount>viewAllCheckingsAccount(int userId){
        user user= userRepository.findById(userId).orElseThrow(()->
                new RuntimeException("user not found"));
        return user.getCheckingsAccounts();
    }
    public List<savingsAccount>viewAllSavingsAccount(int userId){
        user user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        return user.getSavingsAccounts();
    }
    public String withdrawFromSavingsAccount(int bankId, double amount){
        savingsAccount sv=savingsAccountRepository.findById(bankId).orElseThrow(()->new RuntimeException("Account not found"));
        if(amount>sv.getBalance()){
            return "Insufficient funds";
        }
        else{
            withdrawalHistory wh=new withdrawalHistory(amount);
            wh.setSavingsAccount(sv);
            withdrawalHistoryRepository.save(wh);
            sv.getWithdrawalHistories().add(wh);
            savingsAccountRepository.save(sv);
            return "withdraw successful";
        }
    }
    public String withdrawFromCheckingsAccount(int bankId, double amount){
        checkingsAccount ck=checkingsAccountRepository.findById(bankId).orElseThrow(()->new RuntimeException("Account not found"));
        if(amount>ck.getBalance()){
            return "Insufficient funds";
        }
        else{
withdrawalHistory wh=new withdrawalHistory(amount);
wh.setCheckingsAccount(ck);
withdrawalHistoryRepository.save(wh);
ck.getWithdrawalHistories().add(wh);
            ck.setBalance(ck.getBalance()-amount);
            checkingsAccountRepository.save(ck);
            return "withdraw successful";
        }
    }
    public String depositetoSavingsAccount(int bankId, double amount){
        savingsAccount sv=savingsAccountRepository.findById(bankId).orElseThrow(()->new RuntimeException("Account not found"));
        sv.setBalance(sv.getBalance()+amount);
depositHistory dp=new depositHistory(amount);
dp.setSavingsAccount(sv);
depositHistoryRepository.save(dp);
sv.getDepositHistories().add(dp);

        savingsAccountRepository.save(sv);
        return "deposit successful";
    }
    public String depositetoCheckingsAccount(int bankId, double amount){
        checkingsAccount ck=checkingsAccountRepository.findById(bankId).orElseThrow(()->new RuntimeException("Account not found"));
        ck.setBalance(ck.getBalance()+amount);
depositHistory dp=new depositHistory(amount);
dp.setCheckingsAccount(ck);
depositHistoryRepository.save(dp);
ck.getDepositHistoryList().add(dp);
        checkingsAccountRepository.save(ck);
        return "deposit successful";
    }
public List<depositHistory>viewDepositHistoryCheckingsAccount(int bankId){
        checkingsAccount dp= checkingsAccountRepository.findById(bankId).orElseThrow();
        return dp.getDepositHistoryList();

}
public List<depositHistory>viewDepositHistorySavingsAccount(int bankId){
    savingsAccount dp= savingsAccountRepository.findById(bankId).orElseThrow();
    return dp.getDepositHistories();
}
public List<withdrawalHistory>viewWithdrawalHistoryCheckingAccount(int bankId){
    checkingsAccount dp= checkingsAccountRepository.findById(bankId).orElseThrow();
    return dp.getWithdrawalHistories();
}

    public List<withdrawalHistory>viewWithdrawalHistorySavingsAccount(int bankId){
        savingsAccount dp= savingsAccountRepository.findById(bankId).orElseThrow();
        return dp.getWithdrawalHistories();
    }
}
