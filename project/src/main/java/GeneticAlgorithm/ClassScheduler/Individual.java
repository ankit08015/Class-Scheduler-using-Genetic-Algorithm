package GeneticAlgorithm.ClassScheduler;
import GeneticAlgorithm.ClassScheduler.helper.Course;
import GeneticAlgorithm.ClassScheduler.helper.StudentGroup;

import java.util.Arrays;
public class Individual {

    private int[] chromosome;
    private double fitness = -1;
    private Genotype[] genes;

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public Genotype[] getGenes() {
        return genes;
    }

    public void setGenes(Genotype[] genes) {
        this.genes = genes;
    }

    public Individual(int[] chromosome) {
        // Create individualchromosome
        this.chromosome = chromosome;
    }

    public Individual(int chromosomeLength) {
        // Create random individual
        int[] individual;
        individual = new int[chromosomeLength];
        for (int gene = 0; gene < chromosomeLength; gene++) {
            individual[gene] = gene;
        }

        this.chromosome = individual;
    }

    //
    public Individual(Schedule schedule) {
        int numClasses = schedule.getNumOfClasses();

        // 1 gene for room, 1 for time, 1 for professor
        int chromosomeLength = numClasses * 3;
        // Create random individual
        int newChromosome[] = new int[chromosomeLength];
        int chromosomeIndex = 0;
        // Loop through groups
        for (StudentGroup group : schedule.getStudentGroupsAsArray()) {
            // Loop through modules
            for (int courseId : group.getCourseIds()) {
                // Add random time
                int timeslotId = schedule.getRandomTimeslot().getTimeslotId();
                newChromosome[chromosomeIndex] = timeslotId;
                chromosomeIndex++;

                // Add random room
                int classRoomId = schedule.getRandomClassRoom().getClassRoomId();
                newChromosome[chromosomeIndex] = classRoomId;
                chromosomeIndex++;

                // Add random professor
                Course course = schedule.getCourse(courseId);
                newChromosome[chromosomeIndex] = course.getRandomProfId();
                chromosomeIndex++;
            }
        }

        this.chromosome = newChromosome;
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }

    public int getGene(int offset) {
        return this.chromosome[offset];
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene] + ",";
        }
        return output;
    }

    public boolean containsGene(int gene) {
        for (int i = 0; i < this.chromosome.length; i++) {
            if (this.chromosome[i] == gene) {
                return true;
            }
        }
        return false;
    }


    /**
     * Generates hash code based on individual’s
     * chromosome
     *
     * @return Hash value
     */
    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(this.chromosome);
        return hash;
    }

    /**
     * Equates based on individual’s chromosome
     *
     * @param obj
     * @return Equality boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Individual individual = (Individual) obj;
        return Arrays.equals(this.chromosome, individual.chromosome);
    }

}

