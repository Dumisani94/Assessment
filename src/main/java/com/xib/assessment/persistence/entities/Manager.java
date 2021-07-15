package com.xib.assessment.persistence.entities;

import com.xib.assessment.dtos.TeamDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@ToString
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private List<Team> teams;

    public Long getId() {
        if (this.id != null)
            return id;
        return 0L;
    }

    public String getFirstName() {
        if (this.firstName != null)
            return firstName;
        return "";
    }

    public String getLastName() {
        if (this.lastName != null)
            return lastName;
        return "";
    }

    public String getIdNumber() {
        if (this.idNumber != null)
            return idNumber;
        return "";
    }

    public List<Team> getTeams() {
            return teams;
    }
}
