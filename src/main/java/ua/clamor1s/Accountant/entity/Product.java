package ua.clamor1s.Accountant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.clamor1s.Accountant.entity.enums.State;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ProductType typeId;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "retail_price_buy")
    private Double retailPriceBuy;

    @Column(name = "retail_price_sell")
    private Double retailPriceSell;

    @Column(name = "purchase_buy_date")
    private LocalDate purchaseBuyDate;

    @Enumerated(EnumType.STRING)
    private State state;
}
