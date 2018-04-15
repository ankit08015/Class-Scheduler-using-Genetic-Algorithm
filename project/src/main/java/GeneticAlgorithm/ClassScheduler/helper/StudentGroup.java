package GeneticAlgorithm.ClassScheduler.helper;

/**
 *
 * @author ankit
 */
public class StudentGroup {

    private final int studGroupId;
    private final int studGroupSize;
    private final int courseIds[];

    public StudentGroup(int studGroupId, int studGroupSize, int[] courseIds) {
        this.studGroupId = studGroupId;
        this.studGroupSize = studGroupSize;
        this.courseIds = courseIds;
    }

    public int getStudGroupId() {
        return studGroupId;
    }

    public int getStudGroupSize() {
        return studGroupSize;
    }

    public int[] getCourseIds() {
        return courseIds;
    }





}

