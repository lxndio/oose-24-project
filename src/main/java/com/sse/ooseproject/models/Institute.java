package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "institute")
public class Institute extends OrganizationalUnit {

    private String providesStudySubject;

    @OneToMany(mappedBy = "institute")
    private List<Chair> chairs;

    public String getProvidesStudySubject() {
        return providesStudySubject;
    }

    public void setProvidesStudySubject(String providesStudySubject) {
        this.providesStudySubject = providesStudySubject;
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }
}
