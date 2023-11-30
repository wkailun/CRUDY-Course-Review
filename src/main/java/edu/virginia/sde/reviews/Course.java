package edu.virginia.sde.reviews;

import javax.persistence.*;
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @Column(name = "Course_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Department", length = 4)
    private String department;

    @Column(name = "Catalog_Number", length = 4)
    private Integer catalog_number;

    public Course() {

    }
    public Course(String department, int catNum){
        this.department = department;
        this.catalog_number = catNum;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setCatalogNumber(int catalog_number) {
        this.catalog_number = catalog_number;
    }
    public int getID() {
        return id;
    }
    public String getDepartment() {
        return department;
    }
    public int getCatalogNumber() {
        return this.catalog_number;
    }
}
