package ua.zvgod.cursach.cursach.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "qa_form")
public class QAForm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name should not be empty")
    private String name;

    @Column(name="phone")
    @NotBlank(message = "Phone should not be empty")
    private String phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Guest getGuest() {
        return guest;
    }

    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
