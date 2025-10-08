package com.AdmissionEnquiry.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "admissionEnquiries")
@EqualsAndHashCode(exclude = "admissionEnquiries")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;

    @OneToMany(mappedBy = "interestedCourse", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<AdmissionEnquiry> admissionEnquiries = new ArrayList<>();
}
