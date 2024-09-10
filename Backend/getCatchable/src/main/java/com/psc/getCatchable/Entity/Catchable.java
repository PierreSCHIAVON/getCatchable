package com.psc.getCatchable.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name="catchable")
public class Catchable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Catchable", nullable = false)
    private Long idCatchable;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "icon")
    private String icon;
    @Column(name = "sell_price")
    private Integer sellPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "shadow_size", nullable = false)
    private CatchableShadowSize shadowSize;
    @Enumerated(EnumType.STRING)
    @Column(name = "shadow_movement", nullable = false)
    private CatchableShadowMovement shadowMovement;
    @Column(name = "time")
    private String time;
    @Column(name = "months")
    private String months;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CatchableType type;

}
