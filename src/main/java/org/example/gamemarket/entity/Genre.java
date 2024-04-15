package org.example.gamemarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.gamemarket.entity.enums.GenreName;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "genres")
public class Genre {

    @Id
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private GenreName name;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "genres")
    private Set<Game> games;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id) && name == genre.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
