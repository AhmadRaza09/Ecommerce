package com.ecommerce.Ecommerce.services;

import com.ecommerce.Ecommerce.Dtos.AdminDto;
import com.ecommerce.Ecommerce.models.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
