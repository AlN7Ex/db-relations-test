package com.example.testrelationsdb.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Phone> phone;

    @OneToOne(mappedBy = "person")
    private Passport passport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return person_id != null && Objects.equals(person_id, person.person_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
