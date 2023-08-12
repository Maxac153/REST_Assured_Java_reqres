package tests.post;

import api.post.login.request.Login;
import api.post.login.response.SuccessLogin;
import api.post.login.response.UnsuccessLogin;
import api.post.register.response.UnsuccessRegister;
import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class LoginTest {
    @DisplayName("Проверка входа пользователя негативные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/post/login/positive_data_login.csv", numLinesToSkip = 1)
    public void successLoginTest(String nameTest, String statusCode, String email, String password, String expectedResult) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        Login peopleSecond = new Login(email, password);

        SuccessLogin successUserLogin = given()
                .body(peopleSecond)
                .when()
                .post("api/login")
                .then()
                .log().body()
                .extract().as(SuccessLogin.class);

        Assertions.assertEquals(successUserLogin.getToken(), expectedResult);
    }

    @DisplayName("Проверка входа пользователя негативные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/post/login/negative_data_login.csv", numLinesToSkip = 1)
    public void unsuccessLoginTest(String nameTest, String statusCode, String email, String password, String expectedResult) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        Login peopleSecond = new Login(email, password);

        UnsuccessLogin UnsuccessUserReg = given()
                .body(peopleSecond)
                .when()
                .post("api/login")
                .then()
                .log().body()
                .extract().as(UnsuccessLogin.class);

        Assertions.assertEquals(UnsuccessUserReg.getError(), expectedResult);
    }
}
