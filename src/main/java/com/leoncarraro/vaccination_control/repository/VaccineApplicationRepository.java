package com.leoncarraro.vaccination_control.repository;

import com.leoncarraro.vaccination_control.model.User;
import com.leoncarraro.vaccination_control.model.VaccineApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineApplicationRepository extends JpaRepository<VaccineApplication, Long> {

    boolean existsByUser(User user);

}
