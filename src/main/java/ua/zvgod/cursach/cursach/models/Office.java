package ua.zvgod.cursach.cursach.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone")
    private String phone;

    @Column(name="address")
    private String address;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getImg() {
        return img;
    }

    public Office() {
    }

    @Column(name="img")
    private String img;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
