package org.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Specialty {
    @Id
    @GeneratedValue
    @Column(name = "id_specialty", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Gruppyi.class, mappedBy = "specialty", cascade = {CascadeType.ALL})
    private Collection<Gruppyi> gruppyis;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
