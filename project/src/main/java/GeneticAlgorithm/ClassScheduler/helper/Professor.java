package GeneticAlgorithm.ClassScheduler.helper;

/**
 *
 * @author ankit
 */
public class Professor {

    private final int profId;
    private final String profName;

    public Professor(int profId, String profName){
        this.profId = profId;
        this.profName = profName;
    }

    public int getProfessorId(){
        return this.profId;
    }

    public String getProfessorName(){
        return this.profName;
    }
}

