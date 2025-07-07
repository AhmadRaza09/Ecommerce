package com.ecommerce.Ecommerce.controllers;

import com.ecommerce.Ecommerce.Dtos.AdminDto;
import com.ecommerce.Ecommerce.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register-new")
    private ResponseEntity<?> addNewAdmin(@Valid @RequestBody AdminDto adminDto) {
        return ResponseEntity.ok().body(adminService.save(adminDto));
    }
}
