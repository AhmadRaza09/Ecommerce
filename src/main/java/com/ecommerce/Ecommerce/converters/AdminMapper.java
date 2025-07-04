package com.ecommerce.Ecommerce.converters;

import com.ecommerce.Ecommerce.Dtos.AdminDto;
import com.ecommerce.Ecommerce.models.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDto toDto(Admin admin);

    Admin toAdmin(AdminDto adminDto);
}
