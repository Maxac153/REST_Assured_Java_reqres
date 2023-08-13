package tests.post;

import api.post.register.request.Register;
import api.post.register.response.SuccessRegister;
import api.post.register.response.UnsuccessRegister;
import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class RegisterTest {
    @DisplayName("Проверка регистрации позитивные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/post/register/positive_data_register.csv", numLinesToSkip = 1)
    public void successUserRegTest(String NameTest, String statusCode, String email, String password, String expectedResultId, String expectedResultToken) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        Register peopleSecond = new Register(email, password);

        SuccessRegister successUserReg = given()
                .body(peopleSecond)
                .when()
                .post(ConstantParameters.getUrlRegister())
                .then()
                .log().body()
                .extract().as(SuccessRegister.class);

        Assertions.assertEquals(successUserReg.getId(), Integer.parseInt(expectedResultId));
        Assertions.assertEquals(successUserReg.getToken(), expectedResultToken);
    }

    @DisplayName("Проверка регистрации негативные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/post/register/negative_data_register.csv", numLinesToSkip = 1)
    public void unsuccessUserRegTest(String NameTest, String statusCode, String email, String password, String expectedResult) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        Register peopleSecond = new Register(email, password);

        UnsuccessRegister unSuccessUserReg = given()
                .body(peopleSecond)
                .when()
                .post("api/register")
                .then()
                .log().body()
                .extract().as(UnsuccessRegister.class);

        Assertions.assertEquals(expectedResult, unSuccessUserReg.getError());
    }
}
