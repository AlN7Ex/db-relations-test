package com.example.testrelationsdb.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

    @Column(unique = true, nullable = false)
    private String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Passport passport = (Passport) o;
        return id != null && Objects.equals(id, passport.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
