import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class ApiCalls {
    private String emailCreated = generateEmail();

    public void createNewUser (String uri, String loginPassword) {
        given()
                .baseUri(uri)
                .basePath("users/signup")
                .contentType("application/json")
                .body("{\n" +
                        "    \"username\": \"MarianP\",\n" +
                        "    \"name\": \"PMarian\",\n" +
                        "    \"email\": \""+emailCreated+"\",\n" +
                        "    \"password\": \""+ loginPassword + "\",\n" +
                        "    \"password_confirmation\": \"" + loginPassword + "\"\n" +
                        "}")
                .post()
                .then()
                .statusCode(200);
        System.out.println("The following user: " + emailCreated + ", has been created!");
    }

    public void createAuthor(String psw) {
        ValidatableResponse response = given().baseUri("http://34.89.187.127/api/v1/authors/MarianP")
                .auth().basic(getEmailCreated(), psw)
                .contentType("application/json")
                .body("{\n" +
                        "    \"firstName\": \"George\",\n" +
                        "    \"lastName\": \"COSBUC\",\n" +
                        "    \"id\": 101\n" +
                        "}")
                .post()
                .then()
                .statusCode(200);
                System.out.println(response);

    }

    public void createBook(String pssw)  {
        ValidatableResponse response = given().baseUri("http://34.89.187.127/api/v1/books/MarianP")
                .auth().basic(getEmailCreated(),pssw)
                .contentType("application/json")
                .body("{\"name\": \"MarianPBookIJ\",\"total\": \"101\",\"available\": \"91\",\"authors\": \"506\",\"id\": 200}")
                .post()
                .then()
                .statusCode(201);
            System.out.println(response);
    }


    private String generateEmail() {
        return new Random().nextInt(99999) + "@acadtest.com";
    }
    public String getEmailCreated(){
        return emailCreated;
    }
}
