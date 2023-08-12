package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    private static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .build();
    }

    private static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    private static ResponseSpecification responseSpecOK201() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }

    private static ResponseSpecification responseSpecError400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    private static ResponseSpecification responseSpecError404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    private static ResponseSpecification responseSpec(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public static void installSpecification(String URL, Integer statusCode) {
        switch (statusCode) {
            case 200:
                RestAssured.responseSpecification = Specifications.responseSpecOK200();
                break;
            case 201:
                RestAssured.responseSpecification = Specifications.responseSpecOK201();
                break;
            case 204:
                RestAssured.responseSpecification = Specifications.responseSpec(statusCode);
                break;
            case 400:
                RestAssured.responseSpecification = Specifications.responseSpecError400();
                break;
            case 404:
                RestAssured.responseSpecification = Specifications.responseSpecError404();
                break;
        }
        RestAssured.requestSpecification = Specifications.requestSpec(URL);
    }
}
