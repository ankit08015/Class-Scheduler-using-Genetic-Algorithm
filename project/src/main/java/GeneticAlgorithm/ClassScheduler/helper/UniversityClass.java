package GeneticAlgorithm.ClassScheduler.helper;

/**
 *
 * @author ankit
 */
public class UniversityClass {
    private final int classId;
    private final int studGroupId;
    private final int courseId;
    private int profId;
    private int timeslotId;
    private int classRoomId;

    public UniversityClass(int classId, int studGroupId, int courseId) {
        this.classId = classId;
        this.courseId = courseId;
        this.studGroupId = studGroupId;
    }



    public void addProfessor(int professorId) {
        this.profId = professorId;
    }

    public void addTimeslot(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public int getClassId() {
        return this.classId;
    }

    public int getStudGroupId() {
        return this.studGroupId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public int getProfessorId() {
        return this.profId;
    }

    public int getTimeslotId() {
        return this.timeslotId;
    }

    public int getClassRoomId() {
        return this.classRoomId;
    }
}
