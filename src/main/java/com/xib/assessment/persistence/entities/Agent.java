package com.xib.assessment.persistence.entities;

import com.xib.assessment.dtos.TeamDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@ToString
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Long getId() {
        return id;
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

    public Team getTeam() {
        return team;
    }
}
