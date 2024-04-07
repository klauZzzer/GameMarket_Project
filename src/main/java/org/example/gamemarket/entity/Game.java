package org.example.gamemarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.gamemarket.entity.enums.Genre;
import org.example.gamemarket.entity.enums.RatingStar;

import java.math.BigDecimal;
import java.util.Map;
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

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "game_genres",
            joinColumns = @JoinColumn(name = "game_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    @OneToMany(mappedBy = "game",
            fetch = FetchType.EAGER)
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
