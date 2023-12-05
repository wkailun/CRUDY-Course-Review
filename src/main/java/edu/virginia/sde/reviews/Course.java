package edu.virginia.sde.reviews;

import javax.persistence.*;
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @Column(name = "Course_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Mnemonic", length = 4)
    private String Mnemonic;

    @Column(name = "CourseTitle", length = 50)
    private String courseTitle;

    @Column(name = "Catalog_Number", length = 4)
    private Integer catalogNumber;

    public Course() {

    }
    public Course(String mnemonic, int catNum, String courseTitleAttempt) {
        this.Mnemonic = mnemonic;
        this.catalogNumber = catNum;
        this.courseTitle = courseTitleAttempt;
    }
    public void setDepartment(String department) {
        this.Mnemonic = Mnemonic;
    }
    public void setCatalogNumber(int catalog_number) {
        this.catalogNumber = catalogNumber;
    }
    public int getID() {
        return id;
    }
    public void setCourseTitle(String courseTitleAttempt) {
        this.courseTitle = courseTitleAttempt;
    }
    public String getMnemonic() {
        return Mnemonic;
    }
    public void setMnemonic(String mnemonic) {
        this.Mnemonic = mnemonic;
    }
    public int getCatalogNumber() {
        return this.catalogNumber;
    }
    public String getCourseTitle() {
        return this.courseTitle;
    }
}