package tests.put;

import api.put.update.request.Update;
import api.put.update.response.SuccessUpdate;
import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class UpdateTest {
    @DisplayName("Проверка регистрации позитивные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/put/update/positive_data_update.csv", numLinesToSkip = 1)
    public void successUserUpdateTest(String nameTest, String statusCode, String name, String job) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        Update peopleSecond = new Update(name, job);

        SuccessUpdate successUserReg = given()
                .body(peopleSecond)
                .when()
                .put(ConstantParameters.getUrlUpdatePut())
                .then()
                .log().body()
                .extract().as(SuccessUpdate.class);

        Assertions.assertEquals(successUserReg.getName(), name);
        Assertions.assertEquals(successUserReg.getJob(), job);
    }
}
