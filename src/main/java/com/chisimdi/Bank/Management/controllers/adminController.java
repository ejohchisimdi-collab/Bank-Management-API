package com.chisimdi.Bank.Management.controllers;
import com.chisimdi.Bank.Management.dto.*;
import com.chisimdi.Bank.Management.models.*;
import com.chisimdi.Bank.Management.repsitories.*;
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
    @GetMapping("/admin/checking-account/{userId}")
    public checkingsAccount findbyid(@PathVariable("userId")int userId){
        return adminService.findCheckingsAccountById(userId);
    }
    @GetMapping("/admin/saving-account/")
    public List<savingsAccount>savingsAccounts(){
        return adminService.findAllSavingsAccount();
    }
    @GetMapping("/admin/saving-account/{userId}")
    public savingsAccount findbyId(@PathVariable("userId")int userId){
        return adminService.findSavingAccountbyId(userId);
    }
@GetMapping("/admin/deposit")
    public List<depositHistory>allDeposites(){
        return adminService.viewAllDeposits();
}
    @GetMapping("/admin/withdraws")
    public List<withdrawalHistory>allWithdraws(){
        return adminService.viewAllWithdraws();
}

@PostMapping("/admin/interest/{userId}")
    public String addIntereses(@PathVariable ("userId")int userId){
        return adminService.calculateInterest(userId);
}

}
