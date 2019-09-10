import java.util.Scanner;
/**
 * Based upon user input (2/19/19), provides starting and per level skill points and displays caps on skill point allocation
 * 4/18/19 update allows for a quick-calculator for use by the character generator.
 * @author Joe Manship
 * @version Updated 4/18/19
 */
public class SkillPoints
{
    
    public static void skillCalc(){
        
        Scanner input = new Scanner(System.in);
        
        String yesNo;
        
        do{
        
            System.out.print("\f");
        
            int totalPoints=0;
            int level;
        
            do{
        
                System.out.print("Character level? ");
                level = input.nextInt();
                System.out.println();
        
            }while(level<1);
        
            int pointsPerLevel;
        
            do{
            
                System.out.print("Points per level of class(2, 4, 6 or 8 usually)? ");//classes differ in the number of granted skill points per level
                pointsPerLevel = input.nextInt();
                System.out.println();
        
            }while(level<1);
        
            int intel, intMod;
        
            do{
        
                System.out.print("Intelligence score(at least 3)? ");//each ability score has an associated modifier, intelligence is used for skills
                intel = input.nextInt();
                intMod = getMod(intel);
                System.out.println();
        
            }while(intel<3);
        
            System.out.print("Is the character human?");//humans get +1/level
            String isHuman = input.next();
            int humanMod=0;
        
            do{
        
                if("yes".equalsIgnoreCase(isHuman)||"y".equalsIgnoreCase(isHuman)){
                    
                    humanMod = 1;
            
                }
        
            }while(!"y".equalsIgnoreCase(isHuman)&&!"yes".equalsIgnoreCase(isHuman)&&!"n".equalsIgnoreCase(isHuman)&&!"no".equalsIgnoreCase(isHuman));
            //the first level is x4 for skill points, the rest are normal progression
            totalPoints = (pointsPerLevel + intMod+humanMod)*4 + (pointsPerLevel+intMod+humanMod)*(level-1);
   
            if(totalPoints<0){
            
                totalPoints = 0;
            
            }
        
            System.out.println("Total Skill Points: "+totalPoints);
            System.out.println();
            
            //maximum ranks are handy to know when assigning skills quickly, and the calculations were almost already done elsewhere
            System.out.println("Your maximum rank in class skills: "+ (level+3)); 
            System.out.println("Your maximum rank in cross-class skills: " + ((level+3)/2.0));//it is possible to have .5 ranks
            System.out.println();
            System.out.println("You get "+ (pointsPerLevel+intMod+humanMod) + " points per level");
            System.out.println();
            System.out.print("Again? Y/N ");
            
            yesNo=input.next();
            
        }while(yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y"));
    
        input.close();
        
    }
    
    private static int getMod(int score){
        //redone here to avoid using the data type's methods as a 
        //calculator. The method is not extensively used.
        
        int scoreMod=-5;//the penalty for a score of 0
        
        for(int i =1; i<=score; i++){//the chart for intelligence starts at 1
            
            if(i%2==0){ //the modifier changes on even numbers, this adds to the loop
                
                scoreMod++;
                
            }
            
        }
        
        return scoreMod;
        
    }
    
    public static int autoCalc(int level, int pointsPerLevel, int intMod, boolean isHuman)
    {
        int total = 0;
        int humanMod = 0;
        
        if(isHuman)//humans get an extra skill point per level
            humanMod = 1;

        return(pointsPerLevel + intMod+humanMod)*4 + (pointsPerLevel+intMod+humanMod)*(level-1);
        
    }
    
}