package com.example.project_2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Maker extends AbstractPersistable<Long> {
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "maker")
    List<Motion> motions = new ArrayList<>();
}
