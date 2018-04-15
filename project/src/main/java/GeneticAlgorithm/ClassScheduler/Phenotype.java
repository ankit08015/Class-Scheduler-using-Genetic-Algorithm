package GeneticAlgorithm.ClassScheduler;

public class Phenotype {

    private int courseId;
    private int timeslotId;
    private int professorId;


    private double fitnessScore;

    public Phenotype(int courseId, int timeslotId, int professorId) {
        this.courseId = courseId;
        this.timeslotId = timeslotId;
        this.professorId = professorId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(double fitnessScore) {
        this.fitnessScore = fitnessScore;
    }
}

