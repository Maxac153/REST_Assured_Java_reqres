package tests.delete;

import environment.ConstantParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class DeleteUserTest {
    @Test
    @DisplayName("Проверка удаления пользователя")
    public void deleteUserTest() {
        Specifications.installSpecification(ConstantParameters.getBaseURL(), 204);
        given().when().delete("api/users?page=2");
    }
}
