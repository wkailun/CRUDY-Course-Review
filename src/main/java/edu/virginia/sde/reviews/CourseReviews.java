package edu.virginia.sde.reviews;

import javax.persistence.*;

@Entity
@Table(name = "Course Reviews")
public class CourseReviews {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Student_ID")
    Student student;
    @ManyToOne
    @JoinColumn(name = "Course_ID")
    Course courses;
    @Column(name = "message")
    private String message;

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


    public Long getId() {
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
}