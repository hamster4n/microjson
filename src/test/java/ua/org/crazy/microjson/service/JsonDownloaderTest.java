package ua.org.crazy.microjson.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import ua.org.crazy.microjson.services.JsonDownloader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonDownloaderTest {

    private static final String TEST_VALID_URL = "https://google.com";
    private static final String TEST_INVALID_URL = "invalid-url";

    private JsonDownloader jsonDownloader;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        jsonDownloader = new JsonDownloader();
    }

    @Test
    public void shouldReturnTrueForValidUrl() {

        boolean validUrl = jsonDownloader.isValidUrl(TEST_VALID_URL);

        assertThat(validUrl).isTrue();

    }

    @Test
    public void shouldReturnFalseForInvalidUrl() {

        boolean validUrl = jsonDownloader.isValidUrl(TEST_INVALID_URL);

        assertThat(validUrl).isFalse();

    }
}