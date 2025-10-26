package com.chisimdi.Bank.Management.controllers;
import com.chisimdi.Bank.Management.models.*;
import com.chisimdi.Bank.Management.services.*;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class adminController {

    private final adminService adminService;

    public adminController(adminService adminService){
        this.adminService=adminService;
    }

    @GetMapping("/admin/users")
    public List<user>findall(){
        return adminService.viewAllUsers();
    }

    @GetMapping("/admin/users/{userId}")
    public user findById(@PathVariable("userId")int userId){
        return adminService.findUserById(userId);
    }
    @DeleteMapping("/admin/users/{userId}")
    public String deleteuser(@PathVariable("userId")int userId){
        return adminService.deleteUser(userId);
    }


    @GetMapping("/admin/checking-account")
    public List<checkingsAccount> findAllck(){
        return adminService.findAllCheckingsAccount();
    }
    @GetMapping("/admin/checking-account/{bankId}")
    public checkingsAccount findbyid(@PathVariable("bankId")int bankId){
        return adminService.findCheckingsAccountById(bankId);
    }
    @GetMapping("/admin/saving-account/")
    public List<savingsAccount>savingsAccounts(){
        return adminService.findAllSavingsAccount();
    }
    @GetMapping("/admin/saving-account/{bankId}")
    public savingsAccount findbyId(@PathVariable("bankId")int bankId){
        return adminService.findSavingAccountbyId(bankId);
    }
@GetMapping("/admin/deposit")
    public List<depositHistory>allDeposites(){
        return adminService.viewAllDeposits();
}
    @GetMapping("/admin/withdraws")
    public List<withdrawalHistory>allWithdraws(){
        return adminService.viewAllWithdraws();
}

@PostMapping("/admin/interest/{bankId}")
    public String addIntereses(@PathVariable ("bankId")int bankId){
        return adminService.calculateInterest(bankId);
}

}
