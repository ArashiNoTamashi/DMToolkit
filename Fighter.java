import java.util.Arrays;
import java.util.ArrayList;
/**
 * Fighter Class extending the CharClass class to allow a "fighter" character
 *
 * @author (Joe Manship)
 * @version (5/21/19)
 */
public class Fighter extends CharClass
{
    int level,totHP;
            
    public Fighter(int level)
    {
        
        super.hitDice = 10;
        super.level = level;
        super.skillPoints = 2;
        
        this.level = level;
        
        int[] skillList = {};
            /*climb 
             * craft (unique, dealt with later)
             * handle animal
             * intimidate
             * jump
             * ride
             * swim 
             */
               
        int[] scores = new int[6];
        for(int i = 0; i<6; i++){
            
            scores[i] = rawScores[i].getScore();
        
        }
        
        buildFighter(scores);
        //splitSkills(skillList);
        //addSkills(skillPoints);
        
    }
    
    public void buildFighter(int[] scores){
        
        Arrays.sort(scores);//sorted lowest to highest
        //prioritized: str = 5, con = 4, dex = 3, wis = 2, int = 1, cha = 0
        
        //prioritizing
        str = new Stat(scores[5]);
        dex = new Stat(scores[3]);
        con = new Stat(scores[4]);
        intel = new Stat(scores[1]);
        wis = new Stat(scores[2]);
        cha = new Stat(scores[0]);

        setBAB('g',level);
        
        if((int)(level/4)>0){
            
            int statBoost = (int)(level/4);
            
            for(int i = 0; i< statBoost; i++){
                
                if(!checkEven(scores[5])){
                    
                    scores[5]++;
                    
                }else if(!checkEven(scores[4])){
                    
                    scores[4]++;
                    
                }else if(!checkEven(scores[3])){
                    
                    scores[3]++;
                    
                }else{
                    
                    scores[5]++;
                    
                }
            
            }
            
        }
    
        fort = getSave('g',level,con.getMod());
        will = getSave('b',level,wis.getMod());
        ref = getSave('b',level,dex.getMod());
        
    }
    
}
