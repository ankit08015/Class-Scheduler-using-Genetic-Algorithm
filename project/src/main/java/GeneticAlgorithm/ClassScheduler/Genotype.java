package GeneticAlgorithm.ClassScheduler;

public class Genotype implements Comparable<Genotype> {

    private String[] rep;
    private Phenotype phenotype;


    public Genotype(int courseId, int timeslotId, int professorId) {
        this.phenotype = new Phenotype(courseId, timeslotId, professorId);
    }

    public Genotype(int genotypeLength, int courseId, int timeslotId, int professorId) {
        this.rep = new String[genotypeLength];
        this.phenotype = new Phenotype(courseId, timeslotId, professorId);
    }

    public Phenotype getPhenotype() {
        return phenotype;
    }

    public void setPhenotype(Phenotype phenotype) {
        this.phenotype = phenotype;
    }

    public String[] getRep() {
        return rep;
    }

    public void setRep(String[] representation) {
        this.rep = representation;
    }

    @Override
    public int compareTo(Genotype genotype) {
        if(this.phenotype.getFitnessScore()==genotype.phenotype.getFitnessScore())return 0;
        else   if(this.phenotype.getFitnessScore()>genotype.phenotype.getFitnessScore())return 1;
        else return -1;
    }
}
