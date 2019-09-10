import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Room here.
 *
 * @author Joe Manship
 * @version 1/22/19
 */
public class Room
{
    Dice d = new Dice();
    ArrayList<String> contents = new ArrayList<String>();
    
    private final int CR;
    
    public Room(){   
        
        CR = 0;
        
    }
 
    public Room(int CR){
        
        this.CR = CR;
        
    }
    
    public void buildRoom()throws FileNotFoundException, IOException{
                
        int result = d.d100();
        
        if(result < 51){
            
            contents.add("Monster");
            
        }
        
        if(result > 18 && result < 45){
            
            features();
                        
        }else if(result == 45){
            
            treasure();
            
        }else if(result == 46){
            
            trap();
            
        }else if(result == 47){
            
            features();
            treasure();
            
        }else if(result == 48){
            
            features();
            trap();
            
        }else if(result == 49){
            
            trap();
            treasure();
            
        }else if(result == 50){
        
            features();
            trap();
            treasure();
            
        }else if(result < 77){
            
            features();
            
        }else if(result == 77){
            
            features();
    
        }else if(result == 78){
            
            features();
            trap();
            
        }else if(result == 79){
            
            features();
            trap();
            treasure();
            
        }else if(result == 80){
            
            treasure();
            
        }else if(result == 81){
            
            trap();
            treasure();
            
        }else if(result == 82){
            
            trap();
            
        }else{
            
            contents.add("Nothing");
            
        }
        
    }
    
    private void features()throws FileNotFoundException, IOException{
        
        int result = d.d100();
        
        if(result<41){
            
            featureMaker("MinRoom",d.d4());
            
        }else if(result<81){
            
            featureMaker("MajRoom",d.d4());
            
        }else{
            
            featureMaker("MinRoom",d.d4());
            featureMaker("MajRoom",d.d4());
            
        }
        
    }
    
    private void featureMaker (String fileAddOn, int numFeatures)throws FileNotFoundException, IOException{
        
        String fileName = "DataFiles/RoomFiles/" + fileAddOn + ".txt";
        String featName = "";
        
        File roomFile = new File(fileName);
        Scanner fileScanner = new Scanner(roomFile);
        
        for(int i = 0; i<numFeatures; i++){
                               
            for(int j = 1; j<=d.d100(); j++){
                    
                featName = fileScanner.nextLine();
                    
            }
            
            contents.add(featName);
                
        }
    
    }
    
    private void trap() throws FileNotFoundException, IOException{
    
        Trap newTrap = new Trap(CR);
        
        newTrap.buildTrap();
    
    }
    
    private void treasure()throws FileNotFoundException, IOException{
        
        HoardMaker.getCoins(CR);
        HoardMaker.getGoods(CR);
        HoardMaker.getTreasure(CR);
        
    }
    
    public void print()throws FileNotFoundException, IOException{
     
        for(int i = 0; i<contents.size(); i++){
            
            System.out.println(contents.get(i));
            RoomMaker.saveToFile(contents.get(i));
            
        }
        
    }
    
}
