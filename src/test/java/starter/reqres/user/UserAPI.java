package starter.reqres.user;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UserAPI {

    private static String SERVER_URI = "https://reqres.in/";
    private static String GET_USER_ENDPOINT = "api/users/{id}";
    private static String POST_USER_ENDPOINT = "api/users/";

    public static final String EMAIL = "'data'.'email'";
    public static final String FIRST_NAME = "'data'.'first_name'";

    @Step("Fetch user by id {0}")
    public void fetchUserById(String id) {
        SerenityRest.given()
                .baseUri(SERVER_URI)
                .basePath(GET_USER_ENDPOINT)
                .pathParam("id",id)
                .get();
    }

    @Step("Save a new user with name {0} and job {1}")
    public void postUserWithNameAndJob(String name, String job) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("name",name);
        map.put("job",job);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .baseUri(SERVER_URI)
                .basePath(POST_USER_ENDPOINT)
                .body(map)
                .log()
                .all()
                .post();

    }
    @Step("Delete user by id {0}")
    public void deleteUserById(String idUser) {
        SerenityRest.given()
                .when()
                .baseUri(SERVER_URI)
                .basePath(GET_USER_ENDPOINT)
                .pathParam("id",idUser)
                .delete();
    }
}
