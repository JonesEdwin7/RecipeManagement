package com.Jones.Receipe_Management_System.service;

import com.Jones.Receipe_Management_System.model.PremiumRole;
import com.Jones.Receipe_Management_System.repository.IPremiumRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumRoleService {

    @Autowired
    IPremiumRoleRepo roleRepo;

    @Autowired
    HeadAdminService adminService;

    public String createRole(PremiumRole role , String email){
        if(adminService.isValidEmail(email)){
            roleRepo.save(role);
            return "Premium role created successfully....";
        }else
            return "You don't have the access to create premium roles..";
    }


}
