package TestMethods

import Utils.RestHelper

/**
 * Created by vinodk on 04-09-2016.
 */

import com.jayway.restassured.builder.RequestSpecBuilder
import com.jayway.restassured.http.ContentType
import com.jayway.restassured.path.json.JsonPath
import com.jayway.restassured.specification.RequestSpecification
import org.testng.Reporter
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import com.jayway.restassured.response.Response
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.RestAssured.*
import com.jayway.restassured.matcher.RestAssuredMatchers.*
import org.hamcrest.Matchers.*
import static com.jayway.restassured.RestAssured.baseURI
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.authentication.FormAuthConfig.springSecurity;
import static org.hamcrest.Matchers.equalTo;
class Get extends RestHelper{

    String jsonAsString,finalCookie;
    Response response;
    public  RequestSpecBuilder builder;
    int m;
    public  RequestSpecification requestSpec;

    @BeforeClass
    public setup() {
        response=given().header("Content-Type", "application/x-www-form-urlencoded").formParam("j_username", "Vinod.komeershetty.consultant@nielsen.com").formParam("j_password", "Affinnova").request().post();
        finalCookie=response.getHeader("Set-Cookie").split(";")[0]
        Reporter.log("Base Path----->"+RestAssured.basePath)
        setBasePath("")
        builder=new RequestSpecBuilder()
        builder.addHeader("Cookie",finalCookie)
        requestSpec= builder.build()
        Reporter.setEscapeHtml(true)
        Reporter.log("class level")
        Reporter.log("Base Path"+RestAssured.basePath)
        Reporter.log("Base URL-->"+RestAssured.baseURI)
    }

    @Test
    public void testApp(){

        Reporter.log("At Test")
        setBasePath("/api/concepts?projectId=56403")
        Response res= given().spec(requestSpec).when().get(RestAssured.basePath)
                .then().contentType(ContentType.JSON).extract().response()
        JsonPath jp=getJsonPath(res)
//        Assert.assertTrue(jp.concepts.conceptImages[0],"apshot")
    }

    @Test
    public void get2() {



        setBasePath("/api/concepts?projectId=56403")
         given().spec(requestSpec).get(RestAssured.basePath)
                .then().contentType(ContentType.JSON).extract().response()
    }
//
//    @Test
//    public void m2(){
//        print "sds"
//        expect().body("concepts.s[1].project",equalTo("/platformservices/api/concepts/109833/project"))
//                .given()
//                .header("Cookie",finalCookie)
//                .get("http://dweb5s4.dev.affinnova.com/platformservices/api/concepts?projectId=56403")
//    }
//
//    @Test
//    public void m3(){
//        expect().body("concepts.links[1].project",equalTo("/platformservices/api/concepts/109833/project"))
//                .given()
//                .header("Cookie",finalCookie)
//                .get("http://dweb5s4.dev.affinnova.com/platformservices/api/concepts?projectId=56403")
////                .asString()
//    }
//
//    @Test
//    public void  m4(){
//        Response res1= given().header("Cookie",finalCookie).when().get("http://dweb5s4.dev.affinnova.com/platformservices/api/concepts?projectId=56403")
//                .then().contentType(ContentType.JSON).extract().response()
//
////        body("store.book.findAll { it.price < 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));
////        res1.then().body("concepts.conceptImages[0].findAll{it.tiny}")
//    }
//
//    @Test(description = "Method is used json path ")
//    public  void   m5(){
//        Response res= given().header("Cookie",finalCookie).get("http://dweb5s4.dev.affinnova.com/platformservices/api/concepts?projectId=56403")
//                .then().contentType(ContentType.JSON).extract().response()
//        JsonPath jsonPath = new JsonPath(res.asString());
//        print "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
//        print jsonPath.get("concepts.conceptImages[0]")
//    }
//
//    @Test
//    public void m6q(){
//        setBasePath("/api/concepts?projectId=56403")
//        Response res= given().header("Cookie",finalCookie).get(RestAssured.basePath)
//                .then().contentType(ContentType.JSON).extract().response()
//        JsonPath jsonPath = new JsonPath(res.asString());
//    }
//
//    @Test
//    public void m6q1(){
//        print m
//        setBasePath("/api/concepts?projectId=56403")
//        Response res= given().spec(requestSpec).get(RestAssured.basePath)
//                .then().contentType(ContentType.JSON).extract().response()
//        JsonPath jp=getJsonPath(res)
//        println json.concepts.conceptImages[0]
//
//    }


}



