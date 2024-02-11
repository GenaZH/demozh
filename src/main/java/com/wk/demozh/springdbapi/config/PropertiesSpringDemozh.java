package com.wk.demozh.springdbapi.config;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("system.properties")     // для иницализации класса будет использоваться файл apidemozh.poerties
public class PropertiesSpringDemozh {

    private static volatile PropertiesSpringDemozh instanse;

    private PropertiesSpringDemozh() {
        PropertyLoader.populate(this); // инициализация полей класса значениями из файла
    }

    public static PropertiesSpringDemozh getInstance() {
        if (instanse == null)
            synchronized (PropertiesSpringDemozh.class) {
                if (instanse == null)
                    instanse = new PropertiesSpringDemozh();
            }
        return instanse;
    }


    @Property("base.url.api")
    private String baseUrlApi;

    @Property("port.api")
    private int portApi;

    @Property("id.customer.group")
    private Long idCustomerGroup;


    public String getBaseUrlApi() {
        return baseUrlApi;
    }

    public int getPortApi() {
        return portApi;
    }

    public Long getIdCustomerGroup() {
        return idCustomerGroup;
    }


}
