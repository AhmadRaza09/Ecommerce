package com.ecommerce.Ecommerce.services;

import com.ecommerce.Ecommerce.models.Role;

public interface RoleService {
    Role findByName(String name);
}
