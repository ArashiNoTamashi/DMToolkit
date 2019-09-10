import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class MainMenu here.
 *
 * @author Joe Manship & Adam Jiminez
 * @version 5/21/18
 */
public class MainMenu
{

    public static void main(String[] args)throws FileNotFoundException, IOException{

        mainMenu();

    }

    public static void mainMenu()throws FileNotFoundException, IOException{
        
        Scanner input = new Scanner(System.in);
        
        int selection;
        
        do{
            
            do{
                System.out.print("\f");
                
                System.out.println("Welcome to the DM Toolkit!");
                System.out.println("What's your pleasure?");
                System.out.println("    1) Dice Roller");
                System.out.println("    2) Stat Roller");
                System.out.println("    3) Hoard Generator");
                System.out.println("    4) Skill Point Calculator");
                System.out.println("    5) XP Calculator");
                System.out.println("    6) Room Creator");
                System.out.println("    7) Quit");
                System.out.println();
                
                selection = input.nextInt();

                switch(selection){
                
                    case 1:

                        DiceRoller.RollDice();
                    
                        break;
                    
                    case 2:

                        StatRoller.statRolls();

                        break;
                    
                    case 3:

                        HoardMaker.makeHoard();
                          
                        break;
                    
                    case 4:

                        SkillPoints.skillCalc();

                        break;
                    
                    case 5:

                        XPCalc.CalcXP();
                        
                        break;
                    
                    case 6:
                        
                        RoomMaker.MakeRoom();
                        
                        break;
                        
                    case 7:
                    
                        return;
                    
                    default:

                        mainMenu(); 

                    }
        
                }while(selection<1||selection>6);
                    
        }while(selection!=6);

        input.close();
        
    }

}