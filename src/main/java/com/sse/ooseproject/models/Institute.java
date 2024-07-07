package com.sse.ooseproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Institute extends OrganizationalUnit {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @OneToMany(mappedBy = "institute")
    private List<Chair> chairs;
    private String providesStudySubject;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
