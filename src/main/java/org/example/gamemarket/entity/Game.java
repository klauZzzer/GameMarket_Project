package org.example.gamemarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.gamemarket.entity.enums.GenreName;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "games")
public class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "overall_rating")
    private Double overallRating;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sales")
    private Integer sales;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    @JoinTable(name = "game_genre",
    joinColumns = @JoinColumn(name = "game_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @JsonIgnore
    @OneToMany(mappedBy = "game",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(name, game.name) && Objects.equals(overallRating, game.overallRating) && Objects.equals(price, game.price) && Objects.equals(sales, game.sales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, overallRating, price, sales);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + overallRating +
                ", price=" + price +
                ", sales=" + sales +
                '}';
    }
}
