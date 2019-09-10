import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Race here.
 *
 * @author (Joe Manship)
 * @version (5/22/19)
 */
public class Race
{
    String name;
    //abilities gained from race, such as seeing in the dark (Darkvision)
    ArrayList<String> abilities = new ArrayList<>(); 
    //feats, such as specialization with certain weapons or skills, racial
    ArrayList<String> raceFeats = new ArrayList<>();
    //bonus skills from race selected
    ArrayList<String> raceSkills = new ArrayList<>();
    
    //a balance mechanism in D&D 3.5, higher adjustments to offset 
    //powerful races
    int levelAdj;
    //the array to adjust scores based upon race
    int[] scoreMods;
    
    boolean human = false;
    
    public Race()throws FileNotFoundException{
    
        buildArrayLists();
        
    }
    
    private void buildArrayLists() throws FileNotFoundException{
        
        File raceFile = new File(name+".txt");
        Scanner fileScanner = new Scanner(raceFile);
        while(fileScanner.hasNextLine()){
            
            
            
        }
    }
    
    // public static boolean isHuman(){
        
        // return human;
        
    // }
    
    public int[] getScoreMods(){
        
        return scoreMods;
        
    }
    
    
}
