package com.example.project_2;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedEntityGraph(name = "Motion.maker", attributeNodes = { @NamedAttributeNode("maker") })

public class Motion extends AbstractPersistable<Long> {
    private String description;
    private String date;

    @ManyToOne
    private Maker maker;
}
