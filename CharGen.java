import java.util.Scanner;
/**
 * Write a description of class CharGen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharGen
{
    Scanner input = new Scanner(System.in);

    public void characterGen(){
        
        Dice d = new Dice();
        
        int level,align;
                
        System.out.println("NPC Generator");
        System.out.print("  enter a level(1-20): ");
        
        do{
            
            level = input.nextInt();
            
        }while(level>20 || level<0);
        
        System.out.println();
        
        System.out.println(" enter an alignment: ");
        System.out.println("    1) Good");
        System.out.println("    2) Neutral");
        System.out.println("    3) Evil");
        System.out.println("    4) Random");
        
        // do{
            
            // align = input.nextInt();
            
        // }while(align>4 ||align<1);
        
        // if(align == 4){
            
            // align = d.d3(); //by picking a number 1-3 now, the same statement
                            // //is used.
            
        // }
        
        // if(align == 3){
            
            // //evil stuff
            
        // }else if(align == 2){
            
            // //neutral stuff
            
        // }else{
            
            // //good stuff
            
        // }
        
        Fighter newChar = new Fighter(level);        
        System.out.println(newChar);
        
    }
    
}
