package com.example.project_2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotionRepository extends JpaRepository<Motion, Long> {

    // List<Motion> findByMaker(Maker maker);

}
