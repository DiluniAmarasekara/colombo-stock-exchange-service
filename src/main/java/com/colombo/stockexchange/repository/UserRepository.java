package com.colombo.stockexchange.repository;

import com.colombo.stockexchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Diluni
 * on 1/4/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
