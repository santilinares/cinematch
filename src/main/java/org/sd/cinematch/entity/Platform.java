package org.sd.cinematch.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity(name = "Platform")
@Table(
        name = "platform",
        uniqueConstraints = {
                @UniqueConstraint(name = "platform_name_unique", columnNames = "name")
        }
)
public class Platform {

    @Id
    @SequenceGenerator(
            name = "platform_sequence",
            sequenceName = "platform_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "platform_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    /* Una plataforma puede contener muchas peliculas */
   @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JsonIgnore
    private List<Film> films;

    public Platform() {
    }

    public Platform(String name, List<Film> films) {
        super();
        this.name = name;
        this.films = films;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Platform [id=" + id + ", name=" + name + ", films=" + films + "]";
    }
 
    
}
