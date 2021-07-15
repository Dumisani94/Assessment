package com.xib.assessment.mapstract.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@ToString
public class ManagerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private List<TeamDto> teams;

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

    public List<TeamDto> getTeams() {
        return teams;
    }
}
