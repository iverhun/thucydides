package net.thucydides.core.screenshots;

import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class WhenUsingRecordedScreenshots {

    @Test
    public void a_screenshot_was_taken_if_the_screenshot_file_is_not_null() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(new File("screen.png"), new File("screen.html"));
        assertThat(screenshotAndHtmlSource.wasTaken(), is(true));
    }

    @Test
    public void a_screenshot_was_not_taken_if_the_screenshot_file_is_null() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(null, null);
        assertThat(screenshotAndHtmlSource.wasTaken(), is(false));
    }

    @Test
    public void a_screenshot_is_equal_to_itself() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/amazon.png"), new File("screen.html"));
        assertThat(screenshotAndHtmlSource, is(screenshotAndHtmlSource));
    }

    @Test
    public void a_screenshot_is_not_equal_to_an_object_of_a_different_type() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/amazon.png"), new File("screen.html"));
        assertThat(screenshotAndHtmlSource.equals(screenshotFileFrom("/screenshots/amazon.png")), is(false));
    }

    @Test
    public void screenshots_with_the_same_image_are_considered_identical() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/amazon.png"), new File("screen.html"));
        ScreenshotAndHtmlSource identicalScreenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/amazon.png"), new File("screen.html"));
        
        assertThat(screenshotAndHtmlSource, is(identicalScreenshotAndHtmlSource));
        assertThat(screenshotAndHtmlSource.hashCode(), is(identicalScreenshotAndHtmlSource.hashCode()));
    }

    @Test
    public void screenshots_with_different_images_are_considered_unidentical() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/google_page_1.png"), new File("screen.html"));
        ScreenshotAndHtmlSource differentScreenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/google_page_2.png"), new File("screen.html"));

        assertThat(screenshotAndHtmlSource, is(not(differentScreenshotAndHtmlSource)));
        assertThat(screenshotAndHtmlSource.hashCode(), is(not(differentScreenshotAndHtmlSource.hashCode())));
    }

    @Test
    public void a_screenshot_with_an_image_is_not_equal_to_a_null_screenshot() {
        ScreenshotAndHtmlSource screenshotAndHtmlSource = new ScreenshotAndHtmlSource(screenshotFileFrom("/screenshots/google_page_1.png"), new File("screen.html"));
        ScreenshotAndHtmlSource nullScreenshotAndHtmlSource = new ScreenshotAndHtmlSource(null, null);

        assertThat(screenshotAndHtmlSource, is(not(nullScreenshotAndHtmlSource)));
        assertThat(nullScreenshotAndHtmlSource, is(not(screenshotAndHtmlSource)));
    }

    private File screenshotFileFrom(final String screenshot) {
        URL sourcePath = getClass().getResource(screenshot);
        return new File(sourcePath.getPath());
    }

}
