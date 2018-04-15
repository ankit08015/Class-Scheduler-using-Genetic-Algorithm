package GeneticAlgorithm.ClassScheduler;

import GeneticAlgorithm.ClassScheduler.helper.UniversityClass;
import org.apache.log4j.Logger;

/**
 *
 * @author ankit
 */
public class ScheduleGA {

      private static final Logger LOG = Logger.getLogger(ScheduleGA.class);


    public static void main(String[] args) {
        Schedule schedule = ConfigFile.initializeSchedule();

        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(150, 0.02, 0.85, 3, 6);

        Population population = ga.initPopulation(schedule);

        ga.evalPopulation(population, schedule);

        // Keep track of current generation
        int generation = 1;

        // Start evolution loop
        while (ga.isTerminationConditionMet(generation, 1000) == false && ga.isTerminationConditionMet(population) == false) {
            // Print fitness
            LOG.info("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, schedule);

            // Evaluate population
            ga.evalPopulation(population, schedule);

            // Increment the current generation
            generation++;
        }

        // Print fitness
        schedule.createUnivClasses(population.getFittest(0));
        LOG.info("");
        LOG.info("Schedule found after " + generation + " generations");
        LOG.info("Fitness of final Schedule: " + population.getFittest(0).getFitness());
        LOG.info("Conflict: " + schedule.calcClashes());

// Print classes
        System.out.println();
        UniversityClass classes[] = schedule.getClasses();
        int classIndex = 1;
        for (UniversityClass bestClass : classes) {
//            System.out.println("Class " + classIndex + ":");
//            System.out.print("Course: " + schedule.getCourse(bestClass.getCourseId()).getCourseName()+"\t");
//            System.out.print("Student Group: "  + schedule.getStudGroup(bestClass.getStudGroupId()).getStudGroupId()+"\t");
//            System.out.print("Class Room: "   + schedule.getClassRoom(bestClass.getClassRoomId()).getClassRoomNumber()+"\t");
//            System.out.print("Professor: " + schedule.getProfessor(bestClass.getProfessorId()).getProfessorName()+"\t");
//            System.out.println("Time: " + schedule.getTimeslot(bestClass.getTimeslotId()).getTimeslot()+"\t");
//            System.out.println("-----------------------------------------------------------");

            LOG.info("Class " + classIndex + ":");
            LOG.info("Course: " + schedule.getCourse(bestClass.getCourseId()).getCourseName()+"\t");
            LOG.info("Student Group: "  + schedule.getStudGroup(bestClass.getStudGroupId()).getStudGroupId()+"\t");
            LOG.info("Class Room: "   + schedule.getClassRoom(bestClass.getClassRoomId()).getClassRoomNumber()+"\t");
            LOG.info("Professor: " + schedule.getProfessor(bestClass.getProfessorId()).getProfessorName()+"\t");
            LOG.info("Time: " + schedule.getTimeslot(bestClass.getTimeslotId()).getTimeslot()+"\t");
            LOG.info("-----------------------------------------------------------");
            classIndex++;
        }
    }


}

