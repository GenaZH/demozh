package com.wk.demozh.springdbapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data              // ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor // ломбок аннотация: конструктор без аргуметов
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Manager implements Serializable {

    @Id
    @Column(name = "ldap_username")
    private String id;


}
