
/**
 * Write a description of class Skill here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Skill
{

    private int rank;
    private int modScore;
    private String name;
    
    public Skill()
    {
        
        rank = 0;
        name = "";
        modScore = 0;
        
    }

    public Skill(String name, int rank, Stat modStat){
        
        this.name = name;
        this.rank = rank;
        this.modScore = modScore;
        
    }
    
    public void addRank(){
        
        rank++;
        
    }
    
    public void setRank(int rank){
        
        this.rank = rank;
        
    }
    
    public void addMod(int mod){
    
        modScore = mod;
        
    }
    
    public String getName(){
        
        return name;
        
    }
    
    public String toString(){
        
        int totalMod = 0;
        return name+": " + totalMod; 
        
    }
    
}
