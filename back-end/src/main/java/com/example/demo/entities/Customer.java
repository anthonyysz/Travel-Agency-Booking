package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    //adding our columns using proper naming in accordance with the UML sheet and MySQL table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotBlank(message = "Address is necessary")
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @NotBlank(message = "First name is necessary")
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is necessary")
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @NotBlank(message = "Phone number is necessary")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotBlank(message = "Postal code is necessary")
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    //joining columns with foreign key
    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();
}
