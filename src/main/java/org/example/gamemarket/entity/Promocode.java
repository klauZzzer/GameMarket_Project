package org.example.gamemarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.gamemarket.entity.enums.PromoType;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "promocodes")
public class Promocode {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PromoType type;

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "promocode",
            fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promocode promocode = (Promocode) o;
        return Objects.equals(id, promocode.id) && type == promocode.type && Objects.equals(code, promocode.code) && Objects.equals(discount, promocode.discount) && Objects.equals(quantity, promocode.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, code, discount, quantity);
    }

    @Override
    public String toString() {
        return "Promocode{" +
                "id=" + id +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", quantity=" + quantity +
                '}';
    }
}
