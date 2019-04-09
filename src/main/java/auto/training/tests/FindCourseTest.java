package auto.training.tests;

import auto.training.base.BaseTest;
import auto.training.pageobj.CourseFilter;
import auto.training.pageobj.CourseFinderResults;
import org.assertj.core.api.Condition;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCourseTest extends BaseTest {

    private CourseFilter courseFilter = new CourseFilter(driver);
    private CourseFinderResults courseFinderResults = new CourseFinderResults(driver);

    @Test
    public void findCourse() {

        courseFilter
                .chooseInstructor("Andy Brandt")
                .chooseCourse("Professional Scrum Master II")
                .applyFilters();

        verifyNumberOfFoundCourses();

        verifyDatesOfFoundCourses();

        verifyLocationsOfFoundCourses();

    }

    private void verifyNumberOfFoundCourses() {

        assertThat(courseFinderResults.getNumberOfCourses())
                .as("Number of found courses is wrong!")
                .isEqualTo(3);
    }

    private void verifyDatesOfFoundCourses() {

        assertThat(courseFinderResults.getDatesOfCourses())
                .as("Date of found course is wrong!")
                .allSatisfy(element -> assertThat(element).contains("2019"));
    }

    private void verifyLocationsOfFoundCourses() {

        Condition<String> krkLocation = new Condition<>(element -> element.contains("Kraków"), "Kraków location");
        Condition<String> warsawLocation = new Condition<>(element -> element.contains("Warszawa"), "Warszawa location");

        assertThat(courseFinderResults.getLocationsOfCourses())
                .as("Location of found course is wrong!")
                .haveExactly(2, krkLocation)
                .haveExactly(1, warsawLocation);
    }
}
