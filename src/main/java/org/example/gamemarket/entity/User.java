package org.example.gamemarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart shoppingCart;

    @OneToMany(mappedBy = "user",
            fetch = FetchType.EAGER)
    private Set<Order> orders;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_favorite_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> favoriteGames;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Review> reviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nickname, user.nickname) && Objects.equals(balance, user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, balance);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
