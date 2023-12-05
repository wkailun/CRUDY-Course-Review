package edu.virginia.sde.reviews;

import javax.persistence.*;

@Entity
@Table(name = "CourseReviews")
public class CourseReviews {
    @Id
    @Column(name = "CourseReivew_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Student_ID")
    Student student;
    @ManyToOne
    @JoinColumn(name = "Course_ID")
    Course courses;
    @Column(name = "message")
    private String message;

    // Going to need to change this to double for average rating
    @Column(name = "rating")
    private Integer rating;

    public CourseReviews() {

    }
    public CourseReviews(Student students, Course courses, String message, int rating) {
        this.student = students;
        this.courses = courses;
        this.message = message;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }
    public Course getCourses() { return courses; }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setCourses(Course courses) {
        this.courses = courses;
    }
}
