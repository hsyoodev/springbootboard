package com.hsyoodev.springbootboard.repository;


import com.hsyoodev.springbootboard.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
