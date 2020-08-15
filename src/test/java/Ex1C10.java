import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class Ex1C10 {


    @Test
    public void createUserAndCheckID() {
        JsonPath jsonPathCreate = given().baseUri("http://34.89.187.127/api/v1/users/signup")
                .contentType("application/json")
                .body("{\n" +
                        "    \"username\": \"CrosyPostmanIJ100001\",\n" +
                        "    \"name\": \"CrosyPostmanIJ10001\",\n" +
                        "    \"email\": \"CrosyPostmanIJ100004@acadtest.ro\",\n" +
                        "    \"password\": \"Test123\",\n" +
                        "    \"password_confirmation\": \"Test123\"\n" +
                        "}")
                .post()
                .jsonPath();

        HashMap<String, String> result = jsonPathCreate.get("user");
        String idCreate = String.valueOf(result.get("id"));
        System.out.println("ID-ul la create este: " + idCreate);

        JsonPath jsonPathView = given()
                .baseUri("http://34.89.187.127/api/v1/users/view")
                .auth().basic("CrosyPostmanIJ100004@acadtest.ro","Test123")
                .get()
                .jsonPath();

        Integer idView = jsonPathView.get("id");
        System.out.println("ID-ul la view este: " + idView);

        assertTrue(idCreate.equals(String.valueOf(idView)));
    }

}
