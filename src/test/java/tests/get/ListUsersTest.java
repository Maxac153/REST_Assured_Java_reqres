package tests.get;

import api.get.list_users.response.ListUsers;
import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class ListUsersTest {
    @DisplayName("Проверка поиска пользователей")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/get/list_users/data_list_users.csv", numLinesToSkip = 1)
    public void successListUsersTest(String nameTest, String statusCode, String numberPage, String expectedResult) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        ListUsers users = given()
                .when()
                .get("api/users?page=" + numberPage)
                .then()
                .log().all()
                .extract().body().as(ListUsers.class);

        Assertions.assertEquals(users.getData().size(), Integer.parseInt(expectedResult));
    }
}
