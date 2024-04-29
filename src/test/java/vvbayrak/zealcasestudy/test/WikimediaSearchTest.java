package vvbayrak.zealcasestudy.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import vvbayrak.zealcasestudy.controller.WikimediaController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WikimediaSearchTest {
	private final WikimediaController apiController = new WikimediaController();

	@Test
	public void getSearchPage_validQuery_then200() {
		// When
		Response response = apiController.searchPage("furry rabbits");

		// Then
		String pageTitle = response.jsonPath().getString("pages.title");

		assertThat(pageTitle).contains("Sesame Street");
	}

	@Test
	public void getPageHistory_existentPage_then200() {
		// When
		Response response = apiController.getPageHistory("Sesame_Street");

		// Then
		String lastTimestamp =
				response.jsonPath().getString("revisions[0].timestamp");
		LocalDate lastRevisionDate =
				LocalDate.parse(lastTimestamp.substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate checkDate =
				LocalDate.parse("2023-08-17", DateTimeFormatter.ISO_LOCAL_DATE);

		assertTrue(
				lastRevisionDate.isAfter(checkDate),
				"The last timestamp " + lastRevisionDate + " is earlier than " + checkDate);
	}
}