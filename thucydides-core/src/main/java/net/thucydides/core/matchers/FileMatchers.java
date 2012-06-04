package net.thucydides.core.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.io.File;


public class FileMatchers {

    @Factory
    public static Matcher<File> exists() {
        return new TypeSafeMatcher<File>() {
            private File checkedFile;

            @Override
            public boolean matchesSafely(File file) {
                checkedFile = file;
                return file.exists();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a file at " + checkedFile.getPath());
            }
        };
    }
}
