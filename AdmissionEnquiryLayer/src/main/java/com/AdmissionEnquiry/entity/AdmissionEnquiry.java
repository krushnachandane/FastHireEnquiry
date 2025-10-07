package com.AdmissionEnquiry.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "interestedCourse")
@EqualsAndHashCode(exclude = "interestedCourse")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eid")
public class AdmissionEnquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    private String name;
    private String email;
    private Long mobileNO;
    private String interestedCourse;
}