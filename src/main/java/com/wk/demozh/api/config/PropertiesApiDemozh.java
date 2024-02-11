package com.wk.demozh.api.config;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("system.properties")     // для иницализации класса будет использоваться файл apidemozh.poerties
public class PropertiesApiDemozh {

    private static volatile PropertiesApiDemozh instanse;

    private PropertiesApiDemozh() {
        PropertyLoader.populate(this); // инициализация полей класса значениями из файла
    }

    public static PropertiesApiDemozh getInstance() {
        if (instanse == null)
            synchronized (PropertiesApiDemozh.class) {
                if (instanse == null)
                    instanse = new PropertiesApiDemozh();
            }
        return instanse;
    }


    @Property("base.url.api")
    private String baseUrlApi;

    @Property("port.api")
    private int portApi;

    @Property("customer.group.first")
    private String customerGroupFirst;

    @Property("customer.group.second")
    private String customerGroupSecond;

    @Property("id.customer.group")
    private int idCustomerGroup;

    @Property("id.manager.group")
    private String idManagerGroup;

    @Property("name.manager.group")
    private String nameManagerGroup;

    @Property("customer.group.similar.name")
    private String customerGroupSimilarName;

    public String getBaseUrlApi() {
        return baseUrlApi;
    }

    public int getPortApi() {
        return portApi;
    }

    public String getCustomerGroupFirst() {
        return customerGroupFirst;
    }

    public String getCustomerGroupSecond() {
        return customerGroupSecond;
    }

    public int getIdCustomerGroup() {
        return idCustomerGroup;
    }

    public String getIdManagerGroup() {
        return idManagerGroup;
    }

    public String getNameManagerGroup() {
        return nameManagerGroup;
    }

    public String getCustomerGroupSimilarName() {
        return customerGroupSimilarName;
    }

}
