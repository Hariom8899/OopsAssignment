import java.util.*;

class Student {
    private String id;
    private String name;
    private String email;
    private int year;
    private String branch;

    public Student(String id, String name, String email, int year, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.year = year;
        this.branch = branch;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getBranch() { return branch; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id.equals(s.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}

class Course {
    private String courseId;
    private String courseName;
    private String instructorName;
    private int capacity;
    private int credits;

    private TreeSet<Student> enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getName));
    private Queue<Student> waitlist = new LinkedList<>();

    public Course(String courseId, String courseName, String instructorName, int capacity, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.credits = credits;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructorName() { return instructorName; }
    public int getCredits() { return credits; }
    public Set<Student> getEnrolledStudents() { return enrolledStudents; }
    public Queue<Student> getWaitlist() { return waitlist; }

    public boolean enroll(Student student) {
        if (enrolledStudents.contains(student) || waitlist.contains(student)) return false;
        if (enrolledStudents.size() < capacity) return enrolledStudents.add(student);
        return waitlist.offer(student);
    }

    public boolean drop(Student student) {
        if (enrolledStudents.remove(student)) {
            if (!waitlist.isEmpty()) enrolledStudents.add(waitlist.poll());
            return true;
        }
        return waitlist.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}

// === Registration System Class ===
class RegistrationSystem {
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    public void addCourse(Course course) {
        courses.putIfAbsent(course.getCourseId(), course);
    }

    public void addStudent(Student student) {
        students.putIfAbsent(student.getId(), student);
    }

    public boolean registerStudent(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student == null || course == null) return false;
        return course.enroll(student);
    }

    public boolean dropCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student == null || course == null) return false;
        return course.drop(student);
    }

    public List<Student> listStudentsByCourse(String courseId) {
        Course course = courses.get(courseId);
        if (course == null) return Collections.emptyList();
        return new ArrayList<>(course.getEnrolledStudents());
    }

    public List<Student> listStudentsByBranch(String branch) {
        List<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getBranch().equalsIgnoreCase(branch)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Course> listCoursesSortedByEnrollment() {
        List<Course> courseList = new ArrayList<>(courses.values());
        courseList.sort((a, b) -> b.getEnrolledStudents().size() - a.getEnrolledStudents().size());
        return courseList;
    }

    public List<Course> filterCoursesByCredits(int credits) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses.values()) {
            if (course.getCredits() == credits) {
                result.add(course);
            }
        }
        return result;
    }

    public List<Course> filterCoursesByInstructor(String instructor) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses.values()) {
            if (course.getInstructorName().equalsIgnoreCase(instructor)) {
                result.add(course);
            }
        }
        return result;
    }
}

// === Main Class ===
public class UniversitySystem {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        // Sample Students
        Student s1 = new Student("S01", "Alice", "alice@uni.edu", 2, "CSE");
        Student s2 = new Student("S02", "Bob", "bob@uni.edu", 1, "ECE");
        Student s3 = new Student("S03", "Charlie", "charlie@uni.edu", 2, "CSE");

        // Sample Courses
        Course c1 = new Course("C101", "Data Structures", "Dr. Smith", 2, 4);
        Course c2 = new Course("C102", "Operating Systems", "Dr. Ray", 1, 3);

        // Add to system
        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);
        system.addCourse(c1);
        system.addCourse(c2);

        // Registration
        system.registerStudent("S01", "C101"); // Alice enrolled
        system.registerStudent("S02", "C101"); // Bob enrolled
        system.registerStudent("S03", "C101"); // Charlie waitlisted

        // Print enrolled students for C101
        System.out.println("\nEnrolled students in C101:");
        for (Student s : system.listStudentsByCourse("C101")) {
            System.out.println(s);
        }

        // Drop Bob -> Charlie promoted
        system.dropCourse("S02", "C101");

        System.out.println("\nAfter Bob drops, new enrolled students in C101:");
        for (Student s : system.listStudentsByCourse("C101")) {
            System.out.println(s);
        }

        // Courses sorted by enrollment
        System.out.println("\nCourses sorted by number of enrolled students:");
        for (Course c : system.listCoursesSortedByEnrollment()) {
            System.out.println(c.getCourseName() + " - Enrolled: " + c.getEnrolledStudents().size());
        }
    }
}
