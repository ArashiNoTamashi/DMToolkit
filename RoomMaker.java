import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class RoomMaker here.
 *
 * @author Joe Manship
 * @version 1/23/19
 */
public class RoomMaker
{

    
    
    public static void MakeRoom()throws FileNotFoundException, IOException{
    
        Scanner input = new Scanner(System.in);
        
        int numRooms, cr;
        //String roomEnd = "";
        
        System.out.print("\f");
        
        do{
            
            System.out.print("How many rooms? ");
            numRooms = input.nextInt();
        
        }while (input == null);
                
        do{
        
            System.out.print("CR? ");
            cr = input.nextInt();
        
        }while(input == null);
            
        for(int i = 0; i<numRooms; i++){
            
            String roomString="";
            String roomEnd ="";
            
            if(i<10){
                
                roomEnd = "**************";
                
            }else{
                
                roomEnd = "*************";
                
            }
            
            roomString = "***Room " + (i+1) + roomEnd;
            saveToFile(roomString);
            
            buildDungeon(cr);

            System.out.println(roomString);
        
        }
        
        SaveFiles.savePrompt(input, "SavedDungeons/"); 
        String yesNo = "";
        
        do{
            
            System.out.print("Again? Y/N ");
            
            yesNo = input.next();
                             
        }while(!yesNo.equalsIgnoreCase("yes")&&!yesNo.equalsIgnoreCase("y")&&!"no".equalsIgnoreCase(yesNo)&&!"n".equalsIgnoreCase(yesNo));
        
        if("no".equalsIgnoreCase(yesNo)||"n".equalsIgnoreCase(yesNo)){
                
            return;
                
        }else{
            
            MakeRoom();
            
        }
            
        System.out.println();

        input.close();  
            
    }
        
    public static void buildDungeon(int CR)throws FileNotFoundException, IOException{
        
        Room newRoom = new Room(CR);
        
        newRoom.buildRoom();
        newRoom.print();
        
    }
    
    public static void saveToFile(String input) throws FileNotFoundException, IOException{
        
        SaveFiles newDun = new SaveFiles("SavedDungeons/temp.txt",true);
        
        newDun.save(input);
        
    }
}
