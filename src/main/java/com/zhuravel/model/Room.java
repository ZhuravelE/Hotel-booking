package com.zhuravel.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rooms")
public class Room implements BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RoomCategory category;

    @Column(name = "standard_price")
    private Integer standardPrice;

    /*@OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JoinColumn(name = "room_id")
    private Set<RoomOption> options = new HashSet<>();*/
}
