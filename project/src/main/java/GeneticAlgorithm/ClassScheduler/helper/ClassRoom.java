package GeneticAlgorithm.ClassScheduler.helper;

/**
 *
 * @author ankit
 */
public class ClassRoom {

    private final int classRoomId;
    private final String classRoomNumber;
    private final int classRoomCapacity;

    public ClassRoom(int classRoomId, String classRoomNumber, int classRoomCapacity) {
        this.classRoomId = classRoomId;
        this.classRoomNumber = classRoomNumber;
        this.classRoomCapacity = classRoomCapacity;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public String getClassRoomNumber() {
        return classRoomNumber;
    }

    public int getClassRoomCapacity() {
        return classRoomCapacity;
    }



}

