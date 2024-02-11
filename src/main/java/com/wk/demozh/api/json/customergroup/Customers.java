package com.wk.demozh.api.json.customergroup;

import lombok.Data;  // Библиотека Lombok - генерирует конструктор, геттеры, сеттеры, методы equals, hashCode, toString. А также делает все поля private.

@Data
public class Customers {
    int id;
    String name;

}
