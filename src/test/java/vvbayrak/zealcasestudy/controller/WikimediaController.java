package vvbayrak.zealcasestudy.controller;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class WikimediaController {
    private static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri("https://api.wikimedia.org/core/v1/wikipedia/en")
            .setContentType(ContentType.JSON)
            .build();
    public Response searchPage(String query) {
        return given()
                .spec(SPEC)
                .param("q", query)
                .get("/search/page")
                .then()
                .extract()
                .response();
    }

    public Response getPageHistory(String title) {
        return given()
                .spec(SPEC)
                .get("/page/" + title + "/history")
                .then()
                .extract()
                .response();
    }
}
