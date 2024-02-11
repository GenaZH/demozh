package com.wk.demozh.api.config;

import io.restassured.RestAssured;

public class BaseTest {

    public void connectRestAssured() {
        RestAssured.baseURI = PropertiesApiDemozh.getInstance().getBaseUrlApi();  // https://192.168.85.85:8082/admin/customer/group/26
        RestAssured.port = PropertiesApiDemozh.getInstance().getPortApi();
        RestAssured.useRelaxedHTTPSValidation();                                // подменяет сертификат
    }

}
