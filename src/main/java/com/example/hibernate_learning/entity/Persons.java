package com.example.hibernate_learning.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persons {
    @EmbeddedId
    private PersonsKey personsKey;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    @Column
    private String phone_number;



}
