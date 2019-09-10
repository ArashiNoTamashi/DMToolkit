import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * The primary class to control the generic aspects of the various
 * character classes. Using this methods allows for simple and 
 * efficient addition of further classes to the list of supported 
 * classes.
 *
 * @author (Joe Manship)
 * @version (5/21/19)
 */

public class CharClass
{

    Dice d = new Dice();
    ArrayList <Skill> skillList = new ArrayList <Skill>();
    ArrayList <Skill> classSkillList = new ArrayList <Skill>();
    ArrayList <Skill> nonClassSkillList = new ArrayList <Skill>();
    
    Stat str,dex,con,intel,wis,cha;
        
    int level;
    int skillPoints;
    int hitDice;
    int BAB;
    int fort,will,ref;
    
    Stat[] rawScores = StatRoller.Stats(1);

    public CharClass()
    {
        
    
        
    }
    
    //Saving throw calculation
    
    public int getSave(char saveTier,int level, int statMod){
     
        int total = 0;
        
        if(saveTier=='g'){//"good" saving throws
            
            for(int i = 1; i<= level; i++){
                
                if(i%2 ==0){
                    
                    total++;
                    
                }
            
            }
            return total+2 + statMod;
            
        }else{
            
            return (int)level/3 + statMod;
            
        }
     
    }
 
    //Base attack bonus calculation by tier and level
    
    public void setBAB(char babTier, int level){
        
        int total = 0;
        
        if(babTier=='g'){
            
            total = level;
            
        }else if (babTier=='f'){
            
            for(int i = 0; i<= level; i++){
                
                if(level<5){
                
                    total = level-1;
                    
                }else if(level<9){
                    
                    total = level-2;
                    
                }else if(level<13){
                    
                    total = level-3;
                    
                }else if(level<17){
                    
                    total = level-4;
                    
                }else{
                    
                    total = level-5;
                    
                }
                
            }
            
        }else{
                        
            for(int i = 1; i<= level; i++){
                
                if(i%2 ==0){
                    
                    total++;
                    
                }
            
            }
            
            total+=1;
            
        }
        
        this.BAB = total;
        
    }
    
    //Calculation of HP
    
    private int getHP(int hitDice, int level, Stat con){
        
        System.out.println("level = " + level);
        return hitDice + d.multiDice(level-1,hitDice)+con.getMod()*level;
        
    }
    
    private String getAttacks(int bonus){
        
        int numAtt = 0;
        
        String attackString = " "+bonus;
        
        for(int i = 0; i<bonus; i++){
            
            if(bonus > 5){
                
                attackString += "/"+(bonus-5);
                bonus-=5;
                
            }
            
        }
        
        return attackString;
        
    }
    //TEST CODE FOR toSTRING METHOD
    public String toString(){
     
        String characterString;
        characterString = ("Str: " + str + " Dex: " + dex + " Con: " + con + " Int: " + intel + " Wis: " + wis + " Cha: " + cha + 
                           "\n" + "HP: " + getHP(hitDice,level,con) + 
                           "\n" + "BAB: "+ BAB + " Full Att:" + getAttacks(BAB) + " Grapple: " + (BAB + str.getMod())+
                           "\n" + "Fort Save: " + fort + "\n" + "Will Save: " + will + "\n" + "Reflex Save: " + ref) + 
                           "\n" + "Skill points: " + SkillPoints.autoCalc(level,skillPoints,intel.getMod(),false);
            
        return characterString;
        
    }
    
    public boolean checkEven(int num){
        
        return num%2 == 0;
        
    }
    
    private boolean arrayContains(Skill[] arr, Skill s){
     
        boolean contains = false;
        
        for(int i = 1; i<arr.length; i++){
            
            if(arr[i].getName().equalsIgnoreCase(s.getName())){
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public void splitSkills(Skill[] classSkills){
        
        skillList.add(new Skill("Appraise",0,intel));
        skillList.add(new Skill("Balance",0,dex));
        skillList.add(new Skill("Bluff",0,cha));
        skillList.add(new Skill("Climb",0,str));
        
        for(int count = 0; count<skillList.size(); count++){           
            
            if(arrayContains(classSkills,skillList.get(count))){
                
                classSkillList.add(classSkills[count]);
                
            }else{
                
                nonClassSkillList.add(skillList.get(count));
                
            }
        
        }
        
        // for(int i = 0; i<classSkills.length; i++){
            
            // classSkillList.add(classSkills[i]);          
            // System.out.println(classSkillList.indexOf(classSkills[i]));
            
            // Skill skillToRemove = (Skill)classSkills[i];
            // System.out.println(skillToRemove);
            
            // skillList.remove(skillToRemove);
            
        // }
      
        System.out.println("class skills:");
        for(int j = 0; j<classSkillList.size(); j++){
            
            System.out.println(classSkillList.get(j));
        
        }
        
        System.out.println("cross-class skills:");
        for(int k = 0; k<nonClassSkillList.size(); k++){
            
            System.out.println(nonClassSkillList.get(k));
            
        }
        
    }
    
    public void addRanks(int num){
        
        
        
    }
}
