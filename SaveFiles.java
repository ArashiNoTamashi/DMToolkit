import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;
/**
 * Write a description of class MainMenu here.
 *
 * @author Joe Manship
 * @version 2/19/19
 */
public class SaveFiles
{
    
    private String path, name;
    private boolean append = false;
    
    public SaveFiles( String filePath){
        
        path = filePath;
        
    }

    public SaveFiles( String filePath , boolean append_value ){

        path = filePath;
        append= append_value;

    }
    
    public void save( String textLine) throws IOException {

        FileWriter write = new FileWriter(path , append);
        PrintWriter print_line = new PrintWriter( write );
        
        print_line.printf("%s"+"%n",textLine);
        
        print_line.close();
        
    }
    
    public static void savePrompt(Scanner input, String path) throws FileNotFoundException, IOException{
        
        String yesNo;
        
        File tempFile = new File(path+"temp.txt");

        System.out.println();
        
        do{
            
            System.out.print("Save? ");       
            
            yesNo = input.next();
                                
        }while(!yesNo.equalsIgnoreCase("yes")&&!yesNo.equalsIgnoreCase("y")&&!"no".equalsIgnoreCase(yesNo)&&!"n".equalsIgnoreCase(yesNo));
        
        if(yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y")){
            
            System.out.println("Enter new filename");
            
            boolean fileFlag = false;
            String fileName = input.next();

            File movedFile = new File(path+fileName+".txt");
            
            do{
                                
                while(fileName.equalsIgnoreCase("temp")){
                    
                    System.out.println("Invalid File Name!");
                    System.out.println("Enter new filename");
                
                    fileName = input.next();
                    
                }
                
                if (movedFile.exists()){
                    
                    System.out.println("Overwrite? ");
                    String confirm = input.next();
                
                    if(confirm.equalsIgnoreCase("yes")||confirm.equalsIgnoreCase("y")){
                    
                        movedFile.delete();
                    
                    }
                
                }
            
            }while(movedFile.exists());
            
            tempFile.renameTo(movedFile);
            tempFile.delete();
            
        }else{
            
            tempFile.delete();            
            
        }
        
    }
    
}
