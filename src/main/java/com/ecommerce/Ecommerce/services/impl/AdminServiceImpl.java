package com.ecommerce.Ecommerce.services.impl;


import com.ecommerce.Ecommerce.Dtos.AdminDto;
import com.ecommerce.Ecommerce.converters.AdminMapper;
import com.ecommerce.Ecommerce.models.Admin;
import com.ecommerce.Ecommerce.repositories.AdminRepository;
import com.ecommerce.Ecommerce.repositories.RoleRepository;
import com.ecommerce.Ecommerce.services.AdminService;
import com.ecommerce.Ecommerce.services.RoleService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    private final RoleService roleService;
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminServiceImpl(RoleService roleService, AdminRepository adminRepository, AdminMapper adminMapper) {
        this.roleService = roleService;
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }


    @Override
    @Transactional
    public Admin save(AdminDto adminDto) {
        log.debug("Request to save Admin : {}", adminDto);
        Admin admin = adminMapper.toAdmin(adminDto);
        admin.setRoles(Arrays.asList(roleService.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}
