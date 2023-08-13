package tests.get;


import api.get.single_user.response.SingleUser;
import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class SingleUserTest {
    @DisplayName("Проверка поиска одного пользователя")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/get/single_user/data_single_user.csv", numLinesToSkip = 1)
    public void checkAvatarContainsIdTest(String nameTest, String statusCode, String numberPage) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));

        SingleUser user = given()
                .when()
                .get(ConstantParameters.getUrlSingleUser() + numberPage)
                .then()
                .log().all()
                .extract().body().jsonPath().getObject("", SingleUser.class);

        switch (statusCode) {
            case "200":
                Assertions.assertEquals(user.getData().getId(), 2);
                Assertions.assertEquals(user.getData().getEmail(), "janet.weaver@reqres.in");
                Assertions.assertEquals(user.getData().getFirst_name(), "Janet");
                Assertions.assertEquals(user.getData().getLast_name(), "Weaver");
                Assertions.assertEquals(user.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");

                Assertions.assertEquals(user.getSupport().getUrl(), "https://reqres.in/#support-heading");
                Assertions.assertEquals(user.getSupport().getText(), "To keep ReqRes free, contributions towards server costs are appreciated!");
                break;
            case "404":
                Assertions.assertTrue(user.getData() == null);
                break;
        }
    }
}
