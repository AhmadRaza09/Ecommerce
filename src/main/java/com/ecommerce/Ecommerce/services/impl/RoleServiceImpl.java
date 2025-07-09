package com.ecommerce.Ecommerce.services.impl;

import com.ecommerce.Ecommerce.models.Role;
import com.ecommerce.Ecommerce.repositories.RoleRepository;
import com.ecommerce.Ecommerce.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        log.debug("finding role by name: {}", name);
        return roleRepository.findByName(name);
    }
}
