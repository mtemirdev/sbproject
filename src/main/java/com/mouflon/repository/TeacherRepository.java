package com.mouflon.repository;

import com.mouflon.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByEmail(String username);

    @Query("select case when count(t)>0 then true else false end from Teacher t where t.email like :email")
    boolean existsByEmail(@Param(value = "email") String email);
}
