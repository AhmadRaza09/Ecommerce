package com.ecommerce.Ecommerce.services.impl;


import com.ecommerce.Ecommerce.Dtos.AdminDto;
import com.ecommerce.Ecommerce.converters.AdminMapper;
import com.ecommerce.Ecommerce.models.Admin;
import com.ecommerce.Ecommerce.repositories.AdminRepository;
import com.ecommerce.Ecommerce.repositories.RoleRepository;
import com.ecommerce.Ecommerce.services.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Arrays;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    private final RoleRepository roleRepository;

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminRepository adminRepository, RoleRepository roleRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }


    @Override
    @Transactional
    public Admin save(AdminDto adminDto) {
        Admin admin = adminMapper.toAdmin(adminDto);
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}
