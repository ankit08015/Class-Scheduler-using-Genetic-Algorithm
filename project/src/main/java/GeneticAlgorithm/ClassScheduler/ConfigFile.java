package GeneticAlgorithm.ClassScheduler;


/**
 *
 * @author ankit
 */
public class ConfigFile {

    public static Schedule initializeSchedule() {
        // Create timetable
        Schedule schedule = new Schedule();

        // Set up rooms
        schedule.addClassRoom(101, "Shillman", 35);
        schedule.addClassRoom(201, "East Village", 50);
        schedule.addClassRoom(401, "Ell Hall", 40);
        schedule.addClassRoom(503, "Snell Engineering", 45);

        // Set up timeslots
        schedule.addTimeslot(1, "Monday 9:00 - 11:00");
        schedule.addTimeslot(2, "Monday 11:00 - 13:00");
        schedule.addTimeslot(3, "Monday 13:00 - 15:00");
        schedule.addTimeslot(4, "Tuesday 9:00 - 11:00");
        schedule.addTimeslot(5, "Tuesday 11:00 - 13:00");
        schedule.addTimeslot(6, "Tuesday 13:00 - 15:00");
        schedule.addTimeslot(7, "Wednesday 9:00 - 11:00");
        schedule.addTimeslot(8, "Wednesday 11:00 - 13:00");
        schedule.addTimeslot(9, "Wednesday 13:00 - 15:00");
        schedule.addTimeslot(10, "Thursday 9:00 - 11:00");
        schedule.addTimeslot(11, "Thursday 11:00 - 13:00");
        schedule.addTimeslot(12, "Thursday 13:00 - 15:00");
        schedule.addTimeslot(13, "Friday 9:00 - 11:00");
        schedule.addTimeslot(14, "Friday 11:00 - 13:00");
        schedule.addTimeslot(15, "Friday 13:00 - 15:00");

        // Set up professors
        schedule.addProfessor(1, "Dr N Sharma");
        schedule.addProfessor(2, "Mrs G Kalra");
        schedule.addProfessor(3, "Dr R Thomsan");
        schedule.addProfessor(4, "Mr R Ponting");

        // Set up modules and define the professors that teach them
        schedule.addCourse(1, "CSE05", "Computer Science", new int[]{1, 2});
        schedule.addCourse(2, "ALG04", "Algorithms", new int[]{1, 3});
        schedule.addCourse(3, "OS101", "Operating System", new int[]{1, 2});
        schedule.addCourse(4, "EET08", "Engineering Ethics", new int[]{3, 4});
        schedule.addCourse(5, "TED07", "Thermodynamics", new int[]{4});
        schedule.addCourse(6, "BDA03", "Big Data", new int[]{1, 4});

        // Set up student groups and the modules they take.
        schedule.addStudentGroup(1, 30, new int[]{1, 3, 4});
        schedule.addStudentGroup(2, 50, new int[]{2, 3, 5, 6});
        schedule.addStudentGroup(3, 38, new int[]{3, 4, 5});
        schedule.addStudentGroup(4, 45, new int[]{1, 4});
        schedule.addStudentGroup(5, 40, new int[]{2, 3, 5});
        schedule.addStudentGroup(6, 42, new int[]{1, 4, 5});
        schedule.addStudentGroup(7, 36, new int[]{1, 3});
        schedule.addStudentGroup(8, 38, new int[]{2, 6});
        schedule.addStudentGroup(9, 44, new int[]{1, 6});
        schedule.addStudentGroup(10, 45, new int[]{3, 4});
        return schedule;
    }



}

