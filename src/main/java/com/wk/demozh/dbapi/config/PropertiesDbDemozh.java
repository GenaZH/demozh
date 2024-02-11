package com.wk.demozh.dbapi.config;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("application.properties")     // для иницализации класса будет использоваться файл dbdemozh.poerties
public class PropertiesDbDemozh {

    private static volatile PropertiesDbDemozh instanse;

    private PropertiesDbDemozh() {
        PropertyLoader.populate(this); // инициализация полей класса значениями из файла
    }

    public static PropertiesDbDemozh getInstance() {
        if (instanse == null)
            synchronized (PropertiesDbDemozh.class) {
                if (instanse == null)
                    instanse = new PropertiesDbDemozh();
            }
        return instanse;
    }

    @Property("spring.datasource.url")
    private String urlDB;

    @Property("spring.datasource.username")
    private String dbLogin;

    @Property("spring.datasource.password")
    private String dbPassword;


    public String getUrlDbDemozh() {
        return urlDB;
    }

    public String getDbLoginDemozh() {
        return dbLogin;
    }

    public String getDbPasswordDemozh() {
        return dbPassword;
    }


}
