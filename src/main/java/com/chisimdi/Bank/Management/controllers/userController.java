package com.chisimdi.Bank.Management.controllers;
import com.chisimdi.Bank.Management.services.*;
import com.chisimdi.Bank.Management.models.*;
import org.springframework.web.bind.annotation.*;
import com.chisimdi.Bank.Management.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
    @DeleteMapping("/user/user/{userId}")
    public String deleteUser(@PathVariable("userId")int userId){
        return userService.deleteUser(userId);
    }
    @PostMapping("/user/savings-account/{userId}")
    public String createSavingsAccount(@PathVariable("userId")int userId, @RequestBody savingsAccount savingsAccount){
        return userService.createNewSavingsAccount(savingsAccount,userId);
    }
    @GetMapping("/user/savings-account/{userId}")
    public List<savingsAccount>viewAllSavingsAccount(@PathVariable("userId")int userId){
        return userService.viewAllSavingsAccount(userId);
    }
    @DeleteMapping("/user/savings-account/{userId}")
    public String deleteSavingsAccount(@PathVariable("userId")int userId){
        return userService.deleteSavingsAccount(userId);
    }
    @PostMapping("/user/checking-account/{userId}")
    public String createCheckingAccount(@PathVariable("userId")int userId,@RequestBody checkingsAccount checkingsAccount){
        return userService.createNewCheckingsAccount(checkingsAccount,userId);
    }
    @GetMapping("/user/checking-account/{userId}")
    public List<checkingsAccount>checkingsAccounts(@PathVariable("userId")int userId){
        return userService.viewAllCheckingsAccount(userId);
    }
    @DeleteMapping("/user/checking-account/{userId}")
    public String deleteCheckingsAccount(@PathVariable("userId")int userId){
        return userService.deleteCheckingsAccount(userId);
    }

    @PostMapping("/user/checking-account/deposit/{userId}")
    public String makedepositForC(@PathVariable("userId")int userId,@RequestBody userDTo dto){
        return userService.depositetoCheckingsAccount(userId, dto.getAmount());
    }
    @GetMapping ("/user/checking-account/deposit/{userId}")
    public List<depositHistory> getdepositForC(@PathVariable("userId")int userId){
        return userService.viewDepositHistoryCheckingsAccount(userId);
    }

    @PostMapping("/user/checking-account/withdrawal/{userId}")
    public String makewithdrawForC(@PathVariable("userId")int userId,@RequestBody userDTo dto){
        return userService.withdrawFromCheckingsAccount(userId, dto.getAmount());
    }
    @GetMapping("/user/checking-account/withdrawal/{userId}")
    public List<withdrawalHistory> getwithdrawForC(@PathVariable("userId")int userId){
        return userService.viewWithdrawalHistoryCheckingAccount(userId);
    }

    @PostMapping("/user/savings-account/deposit/{userId}")
    public String makedepositForS(@PathVariable("userId")int userId,@RequestBody userDTo dto){
        return userService.depositetoSavingsAccount(userId, dto.getAmount());
    }
    @GetMapping ("/user/savings-account/deposit/{userId}")
    public List<depositHistory> getdepositForS(@PathVariable("userId")int userId){
        return userService.viewDepositHistorySavingsAccount(userId);
    }

    @PostMapping("/user/savings-account/withdrawal/{userId}")
    public String makewithdrawFors(@PathVariable("userId")int userId,@RequestBody userDTo dto){
        return userService.withdrawFromSavingsAccount(userId, dto.getAmount());
    }
    @GetMapping("/user/savings-account/withdrawal/{userId}")
    public List<withdrawalHistory> getwithdrawForS(@PathVariable("userId")int userId){
        return userService.viewWithdrawalHistorySavingsAccount(userId);
    }





}
