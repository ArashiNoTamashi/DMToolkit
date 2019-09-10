import java.util.Scanner;
import java.util.Arrays;
/**
 * Rolls a set of 6 stats, and returns an array of Stat objects.
 * User chooses method. In method 2, the Stats are rolled and 
 * assigned to ability scores
 *
 * @Joe Manship
 * @updated 4/18/19
 */
public class StatRoller
{
    
    public static void statRolls(){
        
        System.out.print("\f");
        
        Scanner rolls = new Scanner(System.in);
        
        System.out.println("Use 4d6, drop lowest or just 3d6? ");
        System.out.println("   1) 4d6, drop lowest");
        System.out.println("   2) Straight 3d6");
        
        int method; 
        
        do{
            
            method = rolls.nextInt();
        
        }while(method>2||method<1);
        
        System.out.print("\f");
        
        for(int i = 0; i<3; i++){
            
            Stat[] arr = Stats(method);
            
            for(int j = 0; j<arr.length; j++){
                
                if(method == 1){//method by which player can assign the 
                                //numbers as desired                                
                    System.out.println(arr[j]);
                
                }else{//method by which player "takes what he/she gets"
                    
                    System.out.println(arr[j].getName(j+1)+arr[j]);
                    
                }
                
            }
                
            System.out.println();
        
        }
            
        System.out.print("Another set? Y/N ");
        
        String yesNo;
        
        do{
            
            yesNo =  rolls.nextLine();
            
            if("y".equalsIgnoreCase(yesNo)||"yes".equalsIgnoreCase(yesNo)){
            
                statRolls();
        
            }else if("n".equalsIgnoreCase(yesNo)||"no".equalsIgnoreCase(yesNo)){
            
                return;
            
            }
            
        }while((!"y".equalsIgnoreCase(yesNo)&&!"yes".equalsIgnoreCase(yesNo)&&!"n".equalsIgnoreCase(yesNo)&&!"no".equalsIgnoreCase(yesNo)));
        
    }

    public static Stat[] Stats(int method){
    
        Dice d = new Dice();
        
        Stat[] rolledStats = new Stat[6];
        
        for(int i = 0; i<6; i++){
            
            int[] array = new int[4];
            int fourScore = 0;
            int score = 0;               
            
            Stat newStat;
            
            if(method == 1){
        
                for(int j = 0; j<array.length; j++){
                
                    array[j] = d.d6();
                
                    fourScore += array[j]; //keeps a cumulative count,
                    //the array will subtract the smallest from this
                
                }
                
                Arrays.sort(array); //drops the lowest result, equivalent
                                    //to disregarding the lowest die result
                newStat = new Stat (fourScore - array[0]);
                        
            }else{
            
                for(int j = 0; j<3; j++){
                
                    score+=d.d6();
                
                }
                
                newStat = new Stat(score,Stat.getName(i+1));
                
            }
            
            rolledStats[i] = newStat;
            
        }
        
        return rolledStats;
            
    }
    
}