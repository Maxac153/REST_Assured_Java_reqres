package tests.patch;

import environment.ConstantParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specifications.Specifications;
import api.patch.update.response.SuccessUpdate;
import static io.restassured.RestAssured.given;

public class Update {
    @DisplayName("Проверка регистрации позитивные сценарии")
    @ParameterizedTest(name = "Test {index}: {0}")
    @CsvFileSource(resources = "/test_data_csv/patch/update/positive_data_update.csv", numLinesToSkip = 1)
    public void successUserUpdateTest(String nameTest, String statusCode, String name, String job) {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), Integer.parseInt(statusCode));
        api.put.update.request.Update peopleSecond = new api.put.update.request.Update(name, job);

        SuccessUpdate successUserReg = given()
                .body(peopleSecond)
                .when()
                .patch("api/users/2")
                .then()
                .log().body()
                .extract().as(SuccessUpdate.class);

        Assertions.assertEquals(successUserReg.getName(), name);
        Assertions.assertEquals(successUserReg.getJob(), job);
    }
}
