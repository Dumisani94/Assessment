package com.xib.assessment.dtos;

import lombok.*;

@NoArgsConstructor
@Setter
@Builder
@ToString
@AllArgsConstructor
public class TeamDto {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        if (this.name != null)
            return name;
        return "";
    }
}