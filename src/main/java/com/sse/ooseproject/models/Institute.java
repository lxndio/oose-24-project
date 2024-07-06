package com.sse.ooseproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Institute extends OrganizationalUnit {
    @OneToMany(mappedBy = "institute")
    private List<Chair> chairs;
    private String providesStudySubject;
}
