package com.wk.demozh.api.json.customergroup;

import java.util.List;

public class CustomerGroups {

    private List<Customers> customers;
    private boolean deleted;
    private Manager manager;
    private int id;
    private String name;

    public CustomerGroups(List<Customers> customers) {
        this.customers = customers;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
