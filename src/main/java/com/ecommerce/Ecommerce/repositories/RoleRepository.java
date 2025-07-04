package com.ecommerce.Ecommerce.repositories;

import com.ecommerce.Ecommerce.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("""
            SELECT r FROM Role r where r.name = :name
            """)
    Role findByName(@Param("name") String name);
}
