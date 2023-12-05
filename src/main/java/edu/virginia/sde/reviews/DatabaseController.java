package edu.virginia.sde.reviews;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class DatabaseController {

    // Login -- new user registration and confirming existence of user
    // Following resources were heavily used:
    // https://www.tutorialspoint.com/hibernate/hibernate_sessions.htm
    // https://www.javaguides.net/2019/02/hibernate-session-interface-methods-with-examples.html (contained examples)
    // https://www.baeldung.com/hibernate-session-object-states#:~:text=The%20Session%20interface%20is%20the,operations%2C%20and%20then%20close%20it.
    public static void registerNewLoginInformation(Student student) {
        // use hibernate to reduce database and table code lines
        // Configure hibernate and session
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        // Start session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Register new student login information
        session.save(student);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public static boolean checkUserExistence(String name, String password) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> registeredStudents = session.createQuery("FROM Student").list();

        // Going through all registered students
        for (var student : registeredStudents) {
            // Student exists AND
            // the username matches the password (and password is correct) = true
            if (student.getUsername().equals(name) && student.getPassword().equals(password)) {
                session.getTransaction().commit();
                session.close();
                sessionFactory.close();
                return true;
            }
        }

        // No match = close transaction and return false
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return false;
    }

    public static boolean checkUsernameExistence(String name) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> registeredStudents = session.createQuery("FROM Student").list();

        // Going through all registered students
        for (var student : registeredStudents) {
            // Student exists AND
            // the username matches the password (and password is correct) = true
            if (student.getUsername().equals(name)) {
                session.getTransaction().commit();
                session.close();
                sessionFactory.close();
                return true;
            }
        }

        // No match = close transaction and return false
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return false;
    }

    // Assuming student exists, populate table with reviews that the student has written
    public static List<CourseReviews> getAllReviewsByStudentName(String studentName) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<CourseReviews> courseReviewsListByStudentName = session.createQuery("from CourseReviews reviews where reviews.student.username1 = '" + studentName + "'").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return courseReviewsListByStudentName;
    }




    // Register student review
 /*   public static void registerStudentReview(CourseReviews review, String studentUsername) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Fetch the student from the database using the username
        Student student = getStudentByUsername(studentUsername);

        // Set the student and course for the review
        review.setStudent(student);

        // Save the review
        session.save(review);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    // Method to get a student by username
    private static Student getStudentByUsername(String username) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Query to get the student by username
        Student student = (Student) session.createQuery("from Student where username1 = :username")
                .setParameter("username", username)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return student;
    }*/

    // Course registration
    // Checking whether the attempted course registration exists or not
    // If not, add course to table
    public static boolean checkCourseExistence(Course courseRegisterAttempt) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Course> registeredCourses = session.createQuery("FROM Course").list();

        // Going through all registered courses
        for (var courses : registeredCourses) {
            // Student exists AND
            // the username matches the password (and password is correct) = true
            // Checks if mnemonic is the same (CS.equals(CS)), if catalog number is the same (3140 == 3140), and name of class
            if ((courses.getMnemonic().equals(courseRegisterAttempt.getMnemonic())) && (courses.getCatalogNumber() == courseRegisterAttempt.getCatalogNumber())
                    && (courses.getCourseTitle().equals(courseRegisterAttempt.getCourseTitle()))) {
                session.getTransaction().commit();
                session.close();
                sessionFactory.close();
                return true;
            }
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return false;
    }

    public static void registerNewCourse(Course courseRegister) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(courseRegister);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

/*    // Register student review
    public static void registerStudentReview(CourseReviews review) {
        String username = LoginScreenController.getUsername();
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(review);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/
    // Register student review
    public static void registerStudentReview(CourseReviews review) {
        String username = LoginScreenController.getUsername();
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(review);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    // Get all existing reviews for courses
    public static List<CourseReviews> getAllReviews() {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<CourseReviews> allCourseReviewsList = session.createQuery("FROM CourseReviews").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return allCourseReviewsList;
    }

    // Get all courses
    public static List<Course> getAllCourses() {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Course> allCourseList = session.createQuery("FROM Course").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return allCourseList;
    }

    // Need to create the following:
    // get courses just from course name (e.g. "Software"), mnemonic (e.g. "CS"), course number (3140)
    // Get course by name
    public static List<Course> getCourseByName(String courseName) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Course> nameCourseList = session.createQuery("FROM Course courseName WHERE courseName.courseTitle = '" + courseName + "'").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return nameCourseList;
    }

    // Get course by course mnemonic
    public static List<Course> getCourseByMnemonic(String courseMnemonic) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Course> mnemonicCourseList = session.createQuery("FROM Course courseName WHERE courseName.Mnemonic = '" + courseMnemonic + "'").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return mnemonicCourseList;
    }

    // Get course by course number
    public static List<Course> getCourseByCourseNumber(int courseNumberSearch) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Course> courseNumberList = session.createQuery("FROM Course courseName WHERE courseName.catalogNumber = '" + courseNumberSearch + "'").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return courseNumberList;
    }

    // Get course by course title and course mnemonic
    public static List<Course> getCourseByTitleAndMnemonic(String courseName, String courseMnemonic) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Course> nameAndMnemonicCourseList = session.createQuery(
                        "FROM Course courseName1 WHERE courseName1.courseTitle = :courseName AND courseName1.Mnemonic = :courseMnemonic", Course.class)
                .setParameter("courseName", courseName)
                .setParameter("courseMnemonic", courseMnemonic)
                .list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        if(nameAndMnemonicCourseList.size() > 0) {
            return nameAndMnemonicCourseList;
        }
        return null;
    }

    // Get course by course name and course number
    public static List<Course> getCourseByTitleAndCourseNumber(String courseName, int courseNumber) {
        try {

            Configuration hibernateConfiguration = new Configuration();
            hibernateConfiguration.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            try {

                List<Course> nameAndMnemonicCourseList = session.createQuery(
                                "FROM Course courseName1 WHERE courseName1.courseTitle = :courseName AND courseName1.catalogNumber = :courseNumber", Course.class)
                        .setParameter("courseName", courseName)
                        .setParameter("courseNumber", courseNumber)
                        .list();

                session.getTransaction().commit();
                session.close();
                sessionFactory.close();
                return nameAndMnemonicCourseList;

            } catch (Exception e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    // Get course by course mnemonic and course number
    public static Course getCourseByMnemonicAndCourseNumber(String courseMnemonic, int courseNumber) {
        try {
            Configuration hibernateConfiguration = new Configuration();
            hibernateConfiguration.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                List<Course> nameAndMnemonicCourseList = session.createQuery(
                                "FROM Course courseName1 WHERE courseName1.Mnemonic = :courseMnemonic AND courseName1.catalogNumber = :courseNumber", Course.class)
                        .setParameter("courseMnemonic", courseMnemonic)
                        .setParameter("courseNumber", courseNumber)
                        .list();

                session.getTransaction().commit();
                session.close();
                sessionFactory.close();
                if(nameAndMnemonicCourseList.size() > 0) return nameAndMnemonicCourseList.get(0);
                return null;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get the ratings from review
    public static CourseReviews getCourseReviewFromMnemonicAndNumber(Course coursePassed) {
        try {
            try {
                Configuration hibernateConfiguration = new Configuration();
                hibernateConfiguration.configure("hibernate.cfg.xml");
                SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

                try (Session session = sessionFactory.openSession()) {
                    session.beginTransaction();

                    // Use parameter binding to avoid SQL injection
                    // Have to add course mnemonic and catalog number
                    List<CourseReviews> reviews = session.createQuery("FROM CourseReviews r WHERE r.courses = :course")
                            .setParameter("course", coursePassed)
                            .list();

                    session.getTransaction().commit();
                    if (reviews.size() > 0) {
                        return reviews.get(0);
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double getAverageRatingForCourse(int courseReviewRating) {
        double courseReviewRatingAverage = 0.0;

        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<CourseReviews> matchingReviews = session.createQuery(
                        "FROM CourseReviews courseReview1 WHERE courseReview1.rating = :courseReviewRatingIndividual", CourseReviews.class)
                .setParameter("courseReviewRatingIndividual", courseReviewRating)
                .list();

        // Find sum of all the ratings
        double sumOfRatings = matchingReviews.stream()
                .mapToDouble(CourseReviews::getRating)
                .sum();

        // Calculate average
        if (!matchingReviews.isEmpty()) {
            courseReviewRatingAverage = sumOfRatings / matchingReviews.size();
        }

        // format decimal
        DecimalFormat df = new DecimalFormat("#.##");
        courseReviewRatingAverage = Double.parseDouble(df.format(courseReviewRatingAverage));

        return courseReviewRatingAverage;
    }

    public static int getCourseRatingInteger(CourseReviews courseReviewRating) {
        int courseReviewRatingAverage = 0;

        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<CourseReviews> matchingReviews = session.createQuery(
                        "FROM CourseReviews courseReview1 WHERE courseReview1.rating = :courseReviewRatingIndividual", CourseReviews.class)
                .setParameter("courseReviewRatingIndividual", courseReviewRating)
                .list();

        return 0;
    }

}
