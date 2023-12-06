package edu.virginia.sde.reviews;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyReviewsTable {

    private IntegerProperty courseNumber, reviewRating;
    private StringProperty courseTitle, courseMnemonic;

    public IntegerProperty courseNumberProperty() {
        if (courseNumber == null) {
            courseNumber = new SimpleIntegerProperty(this, "Course Number");
        }
        return courseNumber;
    }
    public void setCourseNumber(Integer value) { courseNumberProperty().setValue(value);}
    public Integer getCourseNumber() { return courseNumberProperty().get();}


    public IntegerProperty courseRatingProperty() {
        if (reviewRating == null) {
            reviewRating = new SimpleIntegerProperty(this, "Course Rating");
        }
        return reviewRating;
    }
    public void setCourseRating(Integer value) {
        courseRatingProperty().set(value);
    }
    public Integer getCourseRating() {
        return courseRatingProperty().get();
    }


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
