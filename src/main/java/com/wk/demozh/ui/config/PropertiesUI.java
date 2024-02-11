package com.wk.demozh.ui.config;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("system.properties")     // для иницализации класса будет использоваться файл proxy.poerties
public class PropertiesUI {

    private static volatile PropertiesUI instanse;

    private PropertiesUI() {
        PropertyLoader.populate(this); // инициализация полей класса значениями из файла
    }

    public static PropertiesUI getInstance() {
        if (instanse == null)
            synchronized (PropertiesUI.class) {
                if (instanse == null)
                    instanse = new PropertiesUI();
            }
        return instanse;
    }

    @Property("path.chrome.driver")
    private String pathChromeDriver;

    @Property("url.autorization")
    private String urlAutorization;


    @Property("user.login")
    private String userLogin;

    @Property("user.password")
    private String userPassword;

    @Property("user.token")
    private String userToken;


    @Property("admin.login")
    private String adminLogin;

    @Property("admin.password")
    private String adminPassword;

    @Property("admin.token")
    private String adminToken;


    @Property("customer.name.new")
    private String customerNameNew;

    @Property("customer.country.new")
    private String customerCountryNew;

    @Property("customer.city.new")
    private String customerCityNew;

    @Property("customer.name.edit")
    private String customerNameEdit;

    @Property("customer.country.edit")
    private String customerCountryEdit;

    @Property("customer.city.edit")
    private String customerCityEdit;


    @Property("service.name.new")
    private String serviceNameNew;

    @Property("service.name.edit")
    private String serviceNameEdit;


    public String getPathChromeDriver() {
        return pathChromeDriver;
    }

    public String getUrlAutorization() {
        return urlAutorization;
    }


    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserToken() {
        return userToken;
    }


    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminToken() {
        return adminToken;
    }


    public String getCustomerNameNew() {
        return customerNameNew;
    }

    public String getCustomerCountryNew() {
        return customerCountryNew;
    }

    public String getCustomerCityNew() {
        return customerCityNew;
    }

    public String getCustomerNameEdit() {
        return customerNameEdit;
    }

    public String getCustomerCountryEdit() {
        return customerCountryEdit;
    }

    public String getCustomerCityEdit() {
        return customerCityEdit;
    }


    public String getServiceNameNew() {
        return serviceNameNew;
    }

    public String getServiceNameEdit() {
        return serviceNameEdit;
    }

}

