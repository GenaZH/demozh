package com.wk.demozh.robotframework;

//@RobotKeywords
public class GetIdByNameGroup {

    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    public static void main(String[] args){
        for (String str : args) {
            System.out.printf("Argument --> %s%n", str);
        }
        getJavaApiId();
    }

//    public void connectRestAssured() {
//        RestAssured.baseURI = PropertiesApiDemozh.getInstance().getBaseUrlApi();  // https://192.168.85.85
//        RestAssured.port = PropertiesApiDemozh.getInstance().getPortApi();        // 8082
//        RestAssured.useRelaxedHTTPSValidation();                                // подменяет сертификат
//    }

//    @RobotKeyword
//    @ArgumentNames({"nameSearch", "nameGroup"})
//    public int getJavaApiIdGroupNewNameGroupAutoTest(String nameSearch, String nameGroup) {
//        connectRestAssured();
//
//        Response response = given().
//                contentType(ContentType.JSON).
//                body("{\"filter\": {\"filter\": \"" + nameSearch + "\"}}").
//                when().
//                post("/admin/"+ nameGroup + "/group/search/simple").
//                then().
//                extract().response();
//        return response.jsonPath().getInt("id");
//    }

    //@RobotKeyword
    public static int getJavaApiId() {
//        connectRestAssured();
//
//        Response response = given().
//                contentType(ContentType.JSON).
//                body("{\"filter\": {\"filter\": \"" + nameSearch + "\"}}").
//                when().
//                post("/admin/"+ nameGroup + "/group/search/simple").
//                then().
//                extract().response();
//        return response.jsonPath().getInt("id");
        System.out.println("Hi welcome to GetIdByNameGroup");
        int i = 15;
        i = i + 10;
        System.out.println("Hi welcome to GetIdByNameGroup = " + i);
        return i;
    }


}
