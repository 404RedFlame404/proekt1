package com.example.demo.models;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "appartment")

public class apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "room")
    private Integer room;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private owners owner;

    public owners getOwner() {
        return owner;
    }

    public void setOwner(owners owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
