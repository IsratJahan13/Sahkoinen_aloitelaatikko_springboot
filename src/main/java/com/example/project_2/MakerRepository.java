package com.example.project_2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MakerRepository extends JpaRepository<Maker, Long> {
    Maker findByEmail(String email);
}
