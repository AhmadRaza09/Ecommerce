package com.ecommerce.Ecommerce.repositories;

import com.ecommerce.Ecommerce.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("""
                    SELECT a from Admin a where a.username = :username
            """)
    Admin findByUsername(@Param("username") String username);
}
