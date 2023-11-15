package ua.clamor1s.Accountant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.clamor1s.Accountant.entity.enums.Period;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_type")
public class ProductType {
    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    private String name;

    @Column(name = "depreciation_limit")
    private Double depreciationLimit;

    @Column(name = "depreciation_sell_rate")
    private Double depreciationSellRate;

    @Column(name = "depreciation")
    private Double depreciation;

    @Column(name = "depreciation_period")
    @Enumerated(EnumType.STRING)
    private Period depreciationPeriod;

    @Column(name = "benefit_rate")
    private Double benefitRate;

    @Column(name = "benefit_period")
    @Enumerated(EnumType.STRING)
    private Period benefitPeriod;
}
