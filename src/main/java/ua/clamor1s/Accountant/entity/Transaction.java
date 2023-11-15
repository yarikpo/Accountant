package ua.clamor1s.Accountant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.clamor1s.Accountant.entity.enums.TransferType;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @Column(name = "transfer_type")
    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private Double price;
}
