import java.io.*;
import java.util.Scanner;
/**
 * Calculates XP and treasure based upon # and cr of enemies
 *
 * @author Joe Manship
 * @version 2/18/19
 */
public class XPCalc
{
        
    public static void CalcXP()throws FileNotFoundException, IOException{
        
        Scanner xpfile = new Scanner(new File("DataFiles/XPChart.txt"));
        
        int[][] xpChart = new int[20][21];
        
        for(int i = 0; i<(xpChart.length); i++){

            for(int k = 0; k<21; k++){

                xpChart[i][k]=xpfile.nextInt();

            }

        }
        
        xpfile.close();
        
        Scanner input = new Scanner(System.in);
        
        String yesNo, crString;      
        int cr, lowestLevel, highestLevel;
        int crDivisor = 1;
        
        do{
            
            System.out.print("\f");
        
            System.out.println("XP Calculator");
        
            do{
                
                System.out.println("Enter CR of critter(1-20) ");
                System.out.println("NOTE: if the CR is fractional, omit the numerator (i.e. /3 for 1/3)");
                System.out.print("CR: ");
                crString = input.next();
                
                if(crString.charAt(0) == '/'){
                    
                    crDivisor = Integer.parseInt(String.valueOf(crString.substring(1)));
                    cr = 1;                
                    
                }else{
                    
                    cr = Integer.parseInt(String.valueOf(crString));
                    
                }                
            
            }while(cr<1||cr>20);
                
            System.out.print(" How many? ");
            int numCritter = input.nextInt();
            
            do{
                
                System.out.print("Lowest party member's level(1-20): ");
                lowestLevel = input.nextInt(); 
            
            }while(lowestLevel<1||lowestLevel>20);
            
            do{
                
                System.out.print("Highest level(1-20): ");
                highestLevel = input.nextInt();
        
            }while((highestLevel<1||highestLevel>20)&&highestLevel>=lowestLevel);
            
            System.out.print("Number of party members: ");
            int numParty = input.nextInt();
            
            if(lowestLevel>highestLevel){
                
                highestLevel += lowestLevel;
                lowestLevel = highestLevel - lowestLevel;
                highestLevel -= lowestLevel;
                
            }
            
            for(int i=lowestLevel-1;i<highestLevel;i++){
            
                if(xpChart[i][cr]==99999){
                
                    System.out.println("Too high! No XP gained");
                
                }else{
                
                    System.out.println("  Level "+(i+1)+": " + ((numCritter*xpChart[i][cr])/crDivisor)/numParty);        
        
                }
            
            }
            
            System.out.println();
            
            do{
            
                System.out.print("Create Hoard? Y/N ");
            
                yesNo = input.next();
                                
            }while(!yesNo.equalsIgnoreCase("yes")&&!yesNo.equalsIgnoreCase("y")&&!"no".equalsIgnoreCase(yesNo)&&!"n".equalsIgnoreCase(yesNo));
        
            System.out.println();
         
            if(yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y")){
                
                HoardMaker.treasureLoop(numCritter,cr);
                
            }
            
            System.out.println();
            
            yesNo=input.nextLine();
            
            System.out.print("Again? Y/N ");           
            
                        
        }while(yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y"));
    
        input.close();
        
        return;
        
    }
    
}
    
