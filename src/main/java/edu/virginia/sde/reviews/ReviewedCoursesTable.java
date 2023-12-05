package edu.virginia.sde.reviews;

import javafx.beans.property.*;

public class ReviewedCoursesTable {

    private IntegerProperty courseNumber, courseRating;

    private DoubleProperty averageRating;

    private StringProperty courseMnemonic, courseTitle;

    // Gets course number -- "3140" -- course number needs to be displayed
    // Required to be four digits
    public IntegerProperty courseNumberProperty() {
        if (courseNumber == null) {
            courseNumber = new SimpleIntegerProperty(this, "Course Number");
        }
        return courseNumber;
    }
    public void setCourseNumber(Integer value) {
        courseNumberProperty().set(value);
    }
    public Integer getCourseNumber() {
        return courseNumberProperty().get();
    }

    // Get average rating for class rounded to two decimals -- 2.54
    // Between 1 and 5, round to second decimal
    public DoubleProperty courseAverageRatingProperty() {
        if (averageRating == null) {
            averageRating = new SimpleDoubleProperty(this, "Average Course Rating");
        }
        return averageRating;
    }
    public void setAverageRating(Double value) {
        courseAverageRatingProperty().set(value);
    }
    public Double getAverageRating() {
        return courseAverageRatingProperty().get();
    }

    // Get rating for class
    // Between 1 and 5
    public IntegerProperty courseRatingProperty() {
        if (courseRating == null) {
            courseRating = new SimpleIntegerProperty(this, "Course Rating");
        }
        return courseRating;
    }
    public void setCourseRating(Integer value) {
        courseAverageRatingProperty().set(value);
    }
    public Integer getCourseRating() {
        Integer rating = courseRatingProperty().get();
        return rating != null ? rating : 0;
    }

    // Gets course mnemonics -- "CS"
    // Max of 4 characters
    public StringProperty courseMnemonicProperty() {
        if (courseMnemonic == null) {
            courseMnemonic = new SimpleStringProperty(this, "Course Mnemonic");
        }
        return courseMnemonic;
    }
    public void setCourseMnemonic(String value) {
        courseMnemonicProperty().set(value);
    }
    public String getCourseMnemonic() {
        return courseMnemonicProperty().get();
    }

    // Gets course title -- "Software Development Essentials"
    // Min of 1 character, max of 50
    public StringProperty courseTitleProperty() {
        if (courseTitle == null) {
            courseTitle = new SimpleStringProperty(this, "Course Title");
        }
        return courseTitle;
    }
    public void setCourseTitle(String value) {
        courseTitleProperty().set(value);
    }
    public String getCourseTitle() {
        return courseTitleProperty().get();
    }
}