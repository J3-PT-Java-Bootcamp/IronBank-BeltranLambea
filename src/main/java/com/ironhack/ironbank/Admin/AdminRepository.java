package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}