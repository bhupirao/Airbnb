package com.airbnb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Host {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hostId;
    private String name;
    private Boolean active;
    private String location;
    private String propertyType;
    private String about;
    private LocalDate hostingSince;

}
