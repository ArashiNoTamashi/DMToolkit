import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Weapon here.
 *
 * @author (Joe Manship)
 * @version (8/23/18)
 */
public class Weapon 
{
    
    private int numPlus; //"weap" refers to weapon, "prop" refers to property
    private String weapName, weapNum;//Type of weapon, such as "longsword" and weapon seed
    private String propName, propNum;
    
    Dice d = new Dice();
    ArrayList<String> props = new ArrayList<String>();
        //props is for displaying the final result
            
    private static int[] plusVal = new int[6];
        //plusVal[0] is enhancement, 1-5 are used for properties to avoid confusion
        //plusVal[1] is # of +1 properties
        //plusVal[2] is # of +2 properties
        //plusVal[3] is # of +3 properties and so on
        
    public Weapon(int numPlus)throws FileNotFoundException{
        
        this.numPlus = numPlus;
        
        makeWeapon();
        plusToProps(numPlus);
        getProp();
        
    }
    
    private void makeWeapon()throws FileNotFoundException{
    
        File weapFile = new File ("DataFiles/weapons.txt");
        Scanner weap = new Scanner(weapFile);
        
        String weapType;
        String fileLine = "";
        
        int roll100 = d.d100();
        
        for(int count = 0; count<roll100; count ++){
            
            fileLine = weap.nextLine();
            
        }
                
        this.weapName = fileLine.substring(10);
        this.weapNum = fileLine.substring(0,7);
       
        weap.close();
    
    }
    
    public void plusToProps(int numPlus){
        //converts the total value into properties and an enhancement value
        //stores globally
    
        int rollNum = d.d100();
        
        switch(numPlus){
            
            case 1:
            
                plusVal[0] = 1;
                
            case 2:
                    
                if(rollNum<63){
                        
                    plusVal[0] = 2;
                        
                }else{
                        
                    plusVal[0] = 1;
                        
                }
                    
                break;
                
            case 3:
            
                if(rollNum<45){
                    
                    plusVal[0] = 3;
                    
                }else if(rollNum<80){
                    
                    plusVal[0] = 2;
                    
                }else if(rollNum<92){
                    
                    plusVal[0] = 1;
                    
                }else{
                    
                    plusVal[0] = 1;
                
                }
                
                break;
            
            case 4:
                        
                if(rollNum<45){
                    
                    plusVal[0] = 4;
                    
                }else if(rollNum<80){
                    
                    plusVal[0] = 3;
                    
                }else if(rollNum<92){
                    
                    plusVal[0] = 2;
                    
                }else{
                    
                    plusVal[0] = 1;
                    
                }
                
                break;
            
            case 5:
            
                if(rollNum<41){
                    
                    plusVal[0] = 5;
                    
                }else if(rollNum<76){
                    
                    plusVal[0] = 4;
                    
                }else if(rollNum<89){
                    
                    plusVal[0] = 3;
                    
                }else if(rollNum<96){
                    
                    plusVal[0] = 2;
                    
                }else{
                    
                    plusVal[0] = 1;
                    
                }
                
                break;
                    
            case 6:
            
                if(rollNum<44){
                    
                    plusVal[0] = 5;
                    
                }else if(rollNum<78){
                    
                    plusVal[0] = 4;
                    
                }else if(rollNum<90){
                    
                    plusVal[0] = 3;
                    
                }else if(rollNum<96){
                    
                    plusVal[0] = 2;
                    
                }else{
                    
                    plusVal[0] = 1;
                    
                }
                
                break;
                    
            case 7:
                
                if(rollNum<48){
                    
                    plusVal[0] = 5;
                    
                }else if(rollNum<80){
                    
                    plusVal[0]=4;
                    
                }else if(rollNum<93){
                    
                    plusVal[0] = 3;
                    
                }else{
                    
                    plusVal[0] = 2;
                
                }
                    
                break;
                
            case 8:
            
                if(rollNum<53){
                    
                    plusVal[0] = 5;
                    
                }else if(rollNum<86){
                    
                    plusVal[0] = 4;
                    
                }else{
                    
                    plusVal[0] = 3;
                    
                }
                
                break;
            
            case 9:
                
                if(rollNum<53){
                    
                    plusVal[0] = 5;
                    plusVal[4] = 1;
                    
                }else if(rollNum<86){
                    
                    plusVal[0] = 4;
                    plusVal[3] = 1;
                    plusVal[2] = 1;
                    
                }else{
                    
                    plusVal[0] = 4;
                    plusVal[5] = 1;
                    
                }
            
                break;
                
            case 10:
            
                if(rollNum<51){
                    
                    plusVal[0] = 5;
                    plusVal[3] = 1;
                    plusVal[2] = 1;
                    
                }else if(rollNum<86){
                    
                    plusVal[0] = 5;
                    plusVal[5] = 1;
                    
                }else{
                    
                    plusVal[0] = 4;
                    plusVal[3] = 2;
                    
                }
                
                break;
                
        }
        
        if((numPlus != plusVal[0])&&(numPlus<9)){
         
            plusVal[numPlus-plusVal[0]] = 1;
            
        }
        
    }

    private boolean compCheck(){
    
        return true;
    
    }
    //a couple of getters that will likely change a bit
    
    private void getProp() throws FileNotFoundException{
        
        String fileName = "";
        
        File propFile = new File (fileName);
        Scanner prop = new Scanner(propFile);
        
        String weapType, fileLine;
        
        int count = 0;
        int roll100 = d.d100();
        
        do{
         
            fileLine = prop.nextLine();
            
            count++;
            
        }while(count<roll100);
                
        this.propName = fileLine.substring(10);
        this.propNum = fileLine.substring(0,7);    
        
        if(compCheck()){
            
            print();
            
            //prop[i] = prop  loop to have the properties entered 
            //into an array list
            
            
        }else{
            
            makeWeapon();
            
        }
    
    }
    
    private boolean isAmmo(char c){
        
        return c == 2;
        
    }
    
    private boolean isRanged(char c){
        
        return c == 1;
        
    }        
    
    private boolean isSpear(char c){
        
        return c == 1;
        
    }
        
    public void print(){
        
        System.out.println("+" + numPlus + " " + weapName);
        
    }
}

