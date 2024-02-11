package com.wk.demozh.dbapi.config;

import com.wk.demozh.api.config.PropertiesApiDemozh;
import com.wk.demozh.dbapi.steps.CompareDbApiDemozhSteps;
import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseTest {

    private Connection connectionDemozh;
    public CompareDbApiDemozhSteps compareDbApiDemozhSteps;

    private void connectRestAssured() {
        RestAssured.baseURI = PropertiesApiDemozh.getInstance().getBaseUrlApi();  // https://192.168.85.85:8082/admin/customer/group/26
        RestAssured.port = PropertiesApiDemozh.getInstance().getPortApi();
        RestAssured.useRelaxedHTTPSValidation();                                // подменяет сертификат
    }

    private Connection connectDbDemozh() {
        try {
            Class.forName("org.postgresql.Driver");
            connectionDemozh = DriverManager.getConnection
                    (PropertiesDbDemozh.getInstance().getUrlDbDemozh(), PropertiesDbDemozh.getInstance().getDbLoginDemozh(), PropertiesDbDemozh.getInstance().getDbPasswordDemozh());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectionDemozh;
    }

    @BeforeClass
    public void beginTestCompareDbApiDemozh() {
        connectRestAssured();
        connectionDemozh = connectDbDemozh();
        compareDbApiDemozhSteps = new CompareDbApiDemozhSteps(connectionDemozh);
    }

    @AfterClass
    public void endTestCompareDbApiDemozh() throws Exception {
        connectionDemozh.close();
    }

}
