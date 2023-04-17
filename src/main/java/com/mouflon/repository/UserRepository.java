package com.mouflon.repository;

import com.mouflon.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String username);

    @Query("select case when count(u)>0 then true else false end from UserEntity u where u.email like :email")
    boolean existsByEmail(@Param(value = "email") String email);
}
