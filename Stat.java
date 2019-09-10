
/**
 * An object to hold a single basic stat for a character
 *
 * @author (Joe Manship)
 * @version (5/21/19)
 */
public class Stat
{

    private int score;
    private String name;
    private int scoreMod;

    public Stat()
    {
    
        score = 0;
        name = "";
        
    }
    
    public Stat(int score){
        
        this.score = score;
        
        scoreMod = getMod(score);
        
    }
    
    public Stat(int score, String name){
        
        this.name = name;
        this.score = score;
        
        scoreMod = getMod(score);
        
    }
    
    public int getScore(){
        
        return score;
        
    }
    
    public void setName(String name){
        
        this.name = name;
    
    }
    //once set in the constructor, the score will never be directly set
    //only modified
    public int modScore(int modifier){
                    
        return getScore()+modifier;
        
    }
    
    //each score has a modifier attached for use with skills and other
    //things, such as saving throws and attack bonus
    public int getMod(){
        
        int scoreMod=-5;//the penalty for an intelligence of 0
        
        for(int i =1; i<=getScore(); i++){//the chart for intelligence starts at 1
            
            if(i%2==0){ //the modifier changes on even numbers, this adds to the loop
                
                scoreMod++;
                
            }
            
        }
        
        return scoreMod;
        
    }
    
    public int getMod(int score){
    
        int scoreMod=-5;//the penalty for an intelligence of 0
        
        for(int i =1; i<=score; i++){//the chart for intelligence starts at 1
            
            if(i%2==0){ //the modifier changes on even numbers, this adds to the loop
                
                scoreMod++;
                
            }
            
        }
        
        return scoreMod;
        
    }
    
    //prints out a score with the modifier from the statroller in a standard format
    public String toString(){
        
        return (score + " (" + scoreMod + ")");
        
    }
    
    public static String getName(int num){
        
        //System.out.println(this.name);
        
        String statName;
        
        switch(num){
            
            case 1:
         
                return "Str: ";
            
            case 2:
            
                return "Dex: ";
            
            case 3:
            
                return "Int: ";
            
            case 4:
            
                return "Wis: ";

            case 5:
            
                return "Con: ";
            
            default:
            
                return "Cha: ";
            
            
        }
    
    }
    
}
