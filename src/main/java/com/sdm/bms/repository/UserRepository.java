package com.sdm.bms.repository;

import com.sdm.bms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.deletedAt IS NULL")
    List<UserEntity> findAllActiveUsers();


}
