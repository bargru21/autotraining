package auto.training.pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CourseFilter extends BasePage {

    public CourseFilter(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "edit_uid_chosen")
    private WebElement instructorsDropdown;

    @FindBy(id = "edit_type_chosen")
    private WebElement coursesDropdown;

    @FindBy(id = "edit-submit-courses")
    private WebElement applyFiltersButton;

    @FindBy(id = "edit-reset")
    private WebElement resetFiltersButton;

    public void applyFilters() {
        applyFiltersButton.click();
        wait.until(visibilityOf(resetFiltersButton));
    }

    public CourseFilter chooseInstructor(String instructorName) {
        instructorsDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + instructorName + "']")).click();
        return this;
    }

    public CourseFilter chooseCourse(String courseName) {
        coursesDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + courseName + "']")).click();
        return this;
    }
}
