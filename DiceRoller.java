import java.util.Scanner;
/**
 * A minimalistic dice roller
 * @author Joe Manship
 * @version 4/18/19
 */
public class DiceRoller
{
   
    public static void RollDice(){
        
        Dice d = new Dice();
        
        int total = 0;
        
        Scanner s = new Scanner(System.in);
        
        String yesNo;
        
        do{
        
            System.out.print("\f");
        
            System.out.println("Dice Roller: ");
            System.out.print("   Number of Sides: ");
            int numSides = s.nextInt();
            System.out.print("   Number of Dice: ");
            int numDice = s.nextInt();
            System.out.print("   Modifier: ");
            int mod = s.nextInt();
            int min = 1;
            
            System.out.println();
            if(mod<0){
                
                System.out.println("Minimum (n for no minimum): ");
                String minString = s.next();
                
                if(minString.charAt(0)!='n'){
               
                    min = Integer.parseInt(minString);
               
                }
            
            }
            int roll = d.multiDice(numDice,numSides,true,mod,min);
            int natRoll = roll - mod;
            
            System.out.println();
            
            System.out.println("Total: "+roll);
            System.out.println("Again?");
            
            yesNo =s.next(); 
        }while(yesNo.charAt(0)=='y'||yesNo.charAt(0)=='Y');
        
    }
    
}