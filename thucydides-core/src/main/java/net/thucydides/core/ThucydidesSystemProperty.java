package net.thucydides.core;

/**
 * Properties that can be passed to a web driver test to customize its behaviour.
 * This class is mainly for internal use.
 * 
 * @author johnsmart
 *
 */
public enum ThucydidesSystemProperty {

    /**
     * The WebDriver driver - firefox or chrome.
     */
    DRIVER("webdriver.driver"),    
    
    /**
     * The default starting URL for the application, and base URL for relative paths.
     */
    BASE_URL("webdriver.base.url"),
    
    /**
     * Indicates a directory from which the resources for the HTML reports should be copied.
     * This directory currently needs to be provided in a JAR file.
     */
    REPORT_RESOURCE_PATH("thucydides.report.resources");
    
    private String propertyName;

    private ThucydidesSystemProperty(final String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

}