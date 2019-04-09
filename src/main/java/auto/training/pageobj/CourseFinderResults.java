package auto.training.pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CourseFinderResults extends BasePage {

    public CourseFinderResults(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "views-row")
    private List<WebElement> courses;

    @FindBy(xpath = "//div[text()='Date']/..")
    private List<WebElement> datesOfCourses;

    @FindBy(xpath = "//div[text()='Location']/..")
    private List<WebElement> locationsOfCourses;

    public int getNumberOfCourses() {
        return courses.size();
    }

    public List<String> getDatesOfCourses() {
        return datesOfCourses.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getLocationsOfCourses() {
        return locationsOfCourses.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
