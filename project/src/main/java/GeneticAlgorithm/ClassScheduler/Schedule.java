package GeneticAlgorithm.ClassScheduler;

import GeneticAlgorithm.ClassScheduler.helper.*;

import java.util.HashMap;

/**
 *
 * @author ankit
 */
public class Schedule {

    // initializing the new class schedule
    public Schedule() {
        this.classRooms = new HashMap<>();
        this.professors = new HashMap<>();
        this.courses = new HashMap<>();
        this.studGroups = new HashMap<>();
        this.timeslots = new HashMap<>();
    }

    public Schedule(Schedule schedule) {

        this.classRooms = schedule.getClassRooms();
        this.professors = schedule.getProfessors();
        this.courses = schedule.getCourses();
        this.studGroups = schedule.getStudGroups();
        this.timeslots = schedule.getTimeslots();

    }

    public HashMap<Integer, ClassRoom> getClassRooms() {
        return classRooms;
    }

    public HashMap<Integer, Professor> getProfessors() {
        return professors;
    }

    public HashMap<Integer, Course> getCourses() {
        return courses;
    }

    public HashMap<Integer, StudentGroup> getStudGroups() {
        return studGroups;
    }

    public HashMap<Integer, Timeslot> getTimeslots() {
        return timeslots;
    }

    public UniversityClass[] getClasses() {
        return classes;
    }

    // add a new class room
    public void addClassRoom(int classRoomId, String classRoomName, int classRoomCapacity) {
        this.classRooms.put(classRoomId, new ClassRoom(classRoomId, classRoomName, classRoomCapacity));
    }

    // add new professor
    public void addProfessor(int professorId, String professorName) {
        this.professors.put(professorId, new Professor(professorId, professorName));
    }

    // add new course
    public void addCourse(int courseId, String courseCode, String course, int professorIds[]) {
        this.courses.put(courseId, new Course(courseId, courseCode, course, professorIds));
    }

    // add new student group
    public void addStudentGroup(int studGroupId, int studGroupSize, int courseIds[]) {
        this.studGroups.put(studGroupId, new StudentGroup(studGroupId, studGroupSize, courseIds));
        this.numOfClasses = 0;
    }

    // add new timeslot
    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
    }

    // get all student groups
    public StudentGroup[] getStudentGroupsAsArray() {
        return (StudentGroup[]) this.studGroups.values().toArray(new StudentGroup[this.studGroups.size()]);
    }

    // create university classes using individual chromosome
    public void createUnivClasses(Individual individual) {
        // Init classes
        UniversityClass classes[] = new UniversityClass[this.getNumOfClasses()];

        // Get individual’s chromosome
        int chromosome[] = individual.getChromosome();
        int chromosomePos = 0;
        int classIndex = 0;

        for (StudentGroup group : this.getStudentGroupsAsArray()) {
            int courseIds[] = group.getCourseIds();
            for (int courseId : courseIds) {
                classes[classIndex] = new UniversityClass(classIndex, group.getStudGroupId(), courseId);

                // Add timeslot
                classes[classIndex].addTimeslot(chromosome[chromosomePos]);
                chromosomePos++;

                // Add room
                classes[classIndex].setClassRoomId(chromosome[chromosomePos]);
                chromosomePos++;

                // Add professor
                classes[classIndex].addProfessor(chromosome[chromosomePos]);
                chromosomePos++;

                classIndex++;
            }
        }

        this.classes = classes;
    }

    // get a class room from classRoom id
    public ClassRoom getClassRoom(int classRoomId) {
        if (!this.classRooms.containsKey(classRoomId)) {
            System.out.println("Rooms doesn’t contain key " + classRoomId);
        }
        return (ClassRoom) this.classRooms.get(classRoomId);
    }

    // get a random class room
    public ClassRoom getRandomClassRoom() {
        Object[] classRoomsArray = this.classRooms.values().toArray();
        ClassRoom classRoom = (ClassRoom) classRoomsArray[(int) (classRoomsArray.length * Math.random())];
        return classRoom;
    }

    // get professor from professor id
    public Professor getProfessor(int professorId) {
        return (Professor) this.professors.get(professorId);
    }

    // get course from course ids
    public Course getCourse(int courseId) {
        return (Course) this.courses.get(courseId);
    }

    // get course ids of a student groups
    public int[] getStudGroupCourses(int studGroupId) {
        StudentGroup studGroup = (StudentGroup) this.studGroups.get(studGroupId);
        return studGroup.getCourseIds();
    }

    // get student group from student group id
    public StudentGroup getStudGroup(int studGroupId) {
        return (StudentGroup) this.studGroups.get(studGroupId);
    }

    // get timeslot by timeslot ids
    public Timeslot getTimeslot(int timeslotId) {
        return (Timeslot) this.timeslots.get(timeslotId);
    }

    // getting a random timeslot for genetic algorithm
    public Timeslot getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    public void setClasses(UniversityClass[] classes) {
        this.classes = classes;
    }

    public void setNumOfClasses(int numOfClasses) {
        this.numOfClasses = numOfClasses;
    }

    // function to get number of classes that needs scheduling
    public int getNumOfClasses() {
        if (this.numOfClasses > 0) {
            return this.numOfClasses;
        }

        int numOfClasses = 0;
        StudentGroup groups[] = (StudentGroup[]) this.studGroups.values().toArray(new StudentGroup[this.studGroups.size()]);
        for (StudentGroup group : groups) {
            numOfClasses += group.getCourseIds().length;
        }
        this.numOfClasses = numOfClasses;

        return this.numOfClasses;
    }

    // calculate number of clashes while making the schedule
    public int calcClashes() {
        int clashes = 0;

        for (UniversityClass classA : this.classes) {
            // Check room capacity
            int roomCapacity = this.getClassRoom(classA.getClassRoomId()).getClassRoomCapacity();
            int studGroupSize = this.getStudGroup(classA.getStudGroupId()).getStudGroupSize();

            if (roomCapacity < studGroupSize) {
                clashes++;
            }

            // Check if class room is taken
            for (UniversityClass classB : this.classes) {
                if (classA.getClassRoomId() == classB.getClassRoomId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }
        }

        return clashes;

    }




    private final HashMap<Integer, ClassRoom> classRooms;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Course> courses;
    private final HashMap<Integer, StudentGroup> studGroups;
    private final HashMap<Integer, Timeslot> timeslots;
    private UniversityClass classes[];

    private int numOfClasses = 0;
}
