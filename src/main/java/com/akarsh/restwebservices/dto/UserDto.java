package com.akarsh.restwebservices.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private Date birthDate;

}
