package com.wk.demozh.springdbapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data              // ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor // ломбок аннотация: конструктор без аргуметов
@AllArgsConstructor
@Entity
@Table(name = "customer_group")
public class CustomerGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private boolean deletable;
    /*@Column(name = "manager_id")
    private String managerId;*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "ldap_username")
    private Manager manager;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customers> customers = new ArrayList<>();

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        //this.customer = customer; // с этим ошибка - org.springframework.orm.jpa.JpaSystemException: A collection with cascade="all-delete-orphan" was no longer referenced by the owning entity instance
        this.customers.clear();
        this.customers.addAll(customers);
    }


}
