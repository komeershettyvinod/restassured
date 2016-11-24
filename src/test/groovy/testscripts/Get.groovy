package testscripts

import Utils.RestHelper
import au.com.bytecode.opencsv.CSVReader

/**
 * Created by vinodk on 04-09-2016.
 */

import com.jayway.restassured.builder.RequestSpecBuilder
import com.jayway.restassured.http.ContentType
import com.jayway.restassured.path.json.JsonPath
import com.jayway.restassured.specification.RequestSpecification
import org.testng.Reporter
import org.testng.annotations.BeforeClass
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import com.jayway.restassured.response.Response

import static com.jayway.restassured.RestAssured.baseURI
import static com.jayway.restassured.RestAssured.given

import com.jayway.restassured.RestAssured

class Get extends RestHelper{

    String jsonAsString,finalCookie,rootDir,relativePath,filePath;
    Response response;
    public  RequestSpecBuilder builder;
    int m;
    public  RequestSpecification requestSpec;
    CSVReader reader;

    @BeforeClass
    public setup() {

        rootDir = new File(".").getCanonicalPath()
        relativePath="/src/test/resources/TestFiles/".replace("/",File.separator)
        filePath=rootDir+relativePath
//        reader = new CSVReader(new FileReader(System.getProperty("csvFilePath").replace("/",File.separator)));


        response=given().header("Content-Type", "application/x-www-form-urlencoded").formParam("j_username", "secret").formParam("j_password", "secret").request().post();
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

    @Test(enabled = true)
    public void testApp(){

        print baseURI
        print"dddss"
        + baseURI

        Reporter.log("At Test")
        setBasePath("/api/concepts?projectId=56403")
        Response res= given().spec(requestSpec).when().get(RestAssured.basePath)
                .then().contentType(ContentType.JSON).extract().response()
        JsonPath jp=getJsonPath(res)
        println jp
//        Assert.assertTrue(jp.concepts.conceptImages[0],"apshot")
    }

    @Test(enabled = true)
    public void get2() {
        println jp
        setBasePath("/api/concepts?projectId=56403")
         given().spec(requestSpec).get(RestAssured.basePath)
                .then().contentType(ContentType.JSON).extract().response()
    }

//    @Test(dataProvider = "fileTypes")
//    public void  fileTypes(String filename,String path,String da){
////       setBasePath("/documentstore/v1/file/upload")
//        Response res= given().contentType("multipart/form-data").with().multiPart(filename, new File("D://sampleFile.txt")).when().post(RestAssured.baseURI).then().extract().response()
//        JsonPath js= getJsonPath(res)
////        println res.statusCode()
//        println(filename+"   and my path  is "+"" +path+"dd"+da)
////        println  "json file" + js
//    }


//    @DataProvider(name = "fileTypes")
//    public String[][] createMD5TestData() {
//
////        reader.
////        String[][] salutation=new String[3][3];
////        salutation[0][0]="fileName1"
////        salutation[0][1]="FilePath1"
////        salutation[0][2]="Fileda1"
////
////        salutation[1][0]="fileName2"
////        salutation[1][1]="filePath2"
////        salutation[1][2]="Fileda2"
////
////        salutation[2][0]="FileName3"
////        salutation[2][1]="FilePath3"
////        salutation[2][2]="Fileda3"
//
//
////        return salutation
//        }




//    @Test
//    public void m2(){.
//        print "sds"
//        expect().body("concepts.s[1].project",equalTo("/platformservices/api/concepts/109833/project"))
//                .given()
//                .header("Cookie",finalCookie)
//                .get("http://dweb5s4.dev.affinnova.com/platformservices/api/concepts?projectId=56403")
//    }

//    @Test
//    public void m3(){
//        expect().body("concepts.links[1].project",equalTo("/platformservices/api/concepts/109833/project"))
//                .given()
//                .header("Cookie",finalCookie)
//                .get("http://dweb5s4.dev.affinnova.com/platformservices/api/concepts?projectId=56403")
////                .asString()
//    }

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



