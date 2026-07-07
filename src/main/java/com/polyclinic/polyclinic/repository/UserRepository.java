package com.polyclinic.polyclinic.repository;


import com.polyclinic.polyclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    Optional<User> findByBirthDate(LocalDate birthDate);

    @Query("SELECT u FROM User u WHERE " +
            "LOWER(u.firstName) = LOWER(:firstName) AND " +
            "LOWER(u.secondName) = LOWER(:secondName) AND " +
            "(:patronymic IS NULL OR LOWER(u.patronymic) = LOWER(:patronymic))")
    List<User> findByFullName(@Param("firstName") String firstName,
                          @Param("secondName") String secondName,
                          @Param("patronymic") String patronymic);


}
