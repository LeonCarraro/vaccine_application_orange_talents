package com.leoncarraro.vaccination_control.repository;

import com.leoncarraro.vaccination_control.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    boolean existsByName(String name);

}
