package GeneticAlgorithm.ClassScheduler.helper;

/**
 *
 * @author ankit
 */
public class Course {
    private final int courseId;
    private final String courseCode;
    private final String course;
    private final int profIds[];

    public Course(int courseId, String courseCode, String course, int[] profIds) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.course = course;
        this.profIds = profIds;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return course;
    }


    public int getRandomProfId(){
        int profId = profIds[(int) (profIds.length * Math.random())];
        return profId;
    }
}

