package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public boolean login(
            String email,
            String password) {

        Admin admin =
                adminRepo.findByEmail(email);

        if(admin == null) {
            return false;
        }

        return admin.getPassword()
                .equals(password);
    }
}
