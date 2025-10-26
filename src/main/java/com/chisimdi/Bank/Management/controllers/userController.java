package com.chisimdi.Bank.Management.controllers;
import com.chisimdi.Bank.Management.services.*;
import com.chisimdi.Bank.Management.models.*;
import org.springframework.web.bind.annotation.*;
import com.chisimdi.Bank.Management.dto.*;

import java.util.List;

@RestController
public class userController {

    private final userService userService;

    public userController(userService userService){
        this.userService=userService;
    }

    @PostMapping("/user/user")
    public String createUser(@RequestBody user user){
        return userService.createUser(user);
    }
    @DeleteMapping("/user/user/{userID}")
    public String deleteUser(@PathVariable("userID")int userID){
        return userService.deleteUser(userID);
    }
    @PostMapping("/user/savings-account/{userId}")
    public String createSavingsAccount(@PathVariable("userId")int userID, @RequestBody savingsAccount savingsAccount){
        return userService.createNewSavingsAccount(savingsAccount, userID);
    }
    @GetMapping("/user/savings-account/{bankId}")
    public List<savingsAccount>viewAllSavingsAccount(@PathVariable("bankId")int bankId){
        return userService.viewAllSavingsAccount(bankId);
    }
    @DeleteMapping("/user/savings-account/{bankId}")
    public String deleteSavingsAccount(@PathVariable("bankId")int bankId){
        return userService.deleteSavingsAccount(bankId);
    }
    @PostMapping("/user/checking-account/{userID}")
    public String createCheckingAccount(@PathVariable("userId")int userId, @RequestBody checkingsAccount checkingsAccount){
        return userService.createNewCheckingsAccount(checkingsAccount, userId);
    }
    @GetMapping("/user/checking-account/{bankId}")
    public List<checkingsAccount>checkingsAccounts(@PathVariable("bankId")int bankId){
        return userService.viewAllCheckingsAccount(bankId);
    }
    @DeleteMapping("/user/checking-account/{bankId}")
    public String deleteCheckingsAccount(@PathVariable("bankId")int bankId){
        return userService.deleteCheckingsAccount(bankId);
    }

    @PostMapping("/user/checking-account/deposit/{bankId}")
    public String makedepositForC(@PathVariable("bankId")int bankId,@RequestBody userDTo dto){
        return userService.depositetoCheckingsAccount(bankId, dto.getAmount());
    }
    @GetMapping ("/user/checking-account/deposit/{bankId}")
    public List<depositHistory> getdepositForC(@PathVariable("bankId")int bankId){
        return userService.viewDepositHistoryCheckingsAccount(bankId);
    }

    @PostMapping("/user/checking-account/withdrawal/{bankId}")
    public String makewithdrawForC(@PathVariable("bankId")int bankId,@RequestBody userDTo dto){
        return userService.withdrawFromCheckingsAccount(bankId, dto.getAmount());
    }
    @GetMapping("/user/checking-account/withdrawal/{bankId}")
    public List<withdrawalHistory> getwithdrawForC(@PathVariable("bankId")int bankId){
        return userService.viewWithdrawalHistoryCheckingAccount(bankId);
    }

    @PostMapping("/user/savings-account/deposit/{bankId}")
    public String makedepositForS(@PathVariable("bankId")int bankId,@RequestBody userDTo dto){
        return userService.depositetoSavingsAccount(bankId, dto.getAmount());
    }
    @GetMapping ("/user/savings-account/deposit/{bankId}")
    public List<depositHistory> getdepositForS(@PathVariable("bankId")int bankId){
        return userService.viewDepositHistorySavingsAccount(bankId);
    }

    @PostMapping("/user/savings-account/withdrawal/{bankId}")
    public String makewithdrawFors(@PathVariable("bankId")int bankId,@RequestBody userDTo dto){
        return userService.withdrawFromSavingsAccount(bankId, dto.getAmount());
    }
    @GetMapping("/user/savings-account/withdrawal/{bankId}")
    public List<withdrawalHistory> getwithdrawForS(@PathVariable("bankId")int bankId){
        return userService.viewWithdrawalHistorySavingsAccount(bankId);
    }





}
