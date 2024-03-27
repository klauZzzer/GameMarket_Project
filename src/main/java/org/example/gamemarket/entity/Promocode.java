package org.example.gamemarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.gamemarket.entity.enums.PromoType;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "promo_codes")
public class Promocode {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type")
    private PromoType type;

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "promoCode")
    @JoinColumn(name = "order_id")
    private Set<Order> orders;
}
