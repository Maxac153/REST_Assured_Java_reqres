package tests.post;

import api.post.create.request.Create;
import api.post.create.response.SuccessCreate;
import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class CreateTest {
    @DisplayName("Проверка создание пользователя позитивные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/post/create/positive_data_create.csv", numLinesToSkip = 1)
    public void successUserCreateTest(String NameTest, String statusCode, String name, String job) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        Create peopleSecond = new Create(name, job);

        SuccessCreate successUserCreate = given()
                .body(peopleSecond)
                .when()
                .post(ConstantParameters.getUrlCreate())
                .then()
                .log().body()
                .extract().as(SuccessCreate.class);

        Assertions.assertEquals(successUserCreate.getName(), name);
        Assertions.assertEquals(successUserCreate.getJob(), job);
        // Assertions.assertEquals(successUserReg.getId(), expectedResultId);
        // Assertions.assertEquals(successUserReg.getCreatedAt(), expectedResultAt);
    }
}
