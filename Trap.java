import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;

/**
 * Write a description of class Trap here.
 *
 * @author (Joe Manship)
 * @version (1/23/19)
 */
public class Trap
{
    
    public String trapString = "";
    Dice d = new Dice();
    public final int CR;
    private String[] trapData = new String[3]; 
        //[0] = cr
        //[1] = search
        //[2] = disable
    
    public Trap(int CR){
    
        this.CR = CR;
        
    }
    
    private int lineCount(File trapFile) throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader(trapFile));
        
        int lines = 0;
        
        while(reader.readLine() != null){
            
            lines++;
            
        }
        
        reader.close();
        
        return lines;
        
    }
    
    
    public void buildTrap()throws FileNotFoundException, IOException{
     
        String trapName = "";
        String fileAddOn;
        
        if(CR<4){
            
            fileAddOn = "traps13";
            
        }else if(CR<7){
            
            fileAddOn = "traps46";
            
        }else{
            
            fileAddOn = "traps710";
            
        }
        
        File trapFile = new File("DataFiles/RoomFiles/" + fileAddOn + ".txt");
        
        Scanner trapScanner = new Scanner(trapFile);
        
        int totLines = lineCount(trapFile);
        int chosenTrap = d.multiDice(1,totLines,false);
        
        for(int i = 1; i<=chosenTrap; i+=2){
            
            trapName = trapScanner.nextLine();
            
            for(int j = 0; j<2; j++){
                
                trapData[j] = trapScanner.next();
                
            }
            
            trapData[2] = trapScanner.nextLine();
        
        }
        
        //System.out.println(trapName);
        //this.trapString = trapName + "/n" + "CR " + trapData[0] + " Search DC " + trapData[1] + " Disable DC " + trapData[2];
        System.out.println(trapName);
        System.out.print("CR: " + trapData[0]);
        System.out.print(" Search DC: " + trapData[1]);
        System.out.println(" Disable DC: " + trapData[2]);
        
    }
    
}
