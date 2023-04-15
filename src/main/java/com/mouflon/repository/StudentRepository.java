package com.mouflon.repository;

import com.mouflon.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String username);

    @Query("select case when count(s)>0 then true else false end from Student s where s.email like :email")
    boolean existsByEmail(@Param(value = "email") String email);
}
