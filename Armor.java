import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class Armor here.
 *
 * @author (Joe Manship)
 * @version (8/20/18)
 */
public class Armor//stretch goal, unlikely to be implemented
{
    int numPlus;
    String armorNum, armorName, propNum, propName;
    
    Dice d = new Dice();
    ArrayList<String> props = new ArrayList<String>();
        //props is for displaying the final result
            
    private static int[] plusVal = new int[6];
        //plusVal[0] is enhancement, 1-5 are used for properties to avoid confusion
        //plusVal[1] is # of +1 properties
        //plusVal[2] is # of +2 properties
        //plusVal[3] is # of +3 properties and so on
        
    public Armor()throws FileNotFoundException{
     
        this.numPlus = 5;
        armorNum = "999";
        armorName = "armor";
                
    }
       
    public void makeArmor(int numPlus) throws FileNotFoundException{
        
        //this.numPlus = numPlus;
        
        File armorFile = new File ("DataFiles/armor.txt");
        Scanner armor = new Scanner(armorFile);
        
        String armorType;
        String fileLine = "";
        
        int roll100 = d.d100();
        
        for(int count = 0; count<roll100; count ++){
            
            fileLine = armor.nextLine();
            
        }
        
        this.armorName = fileLine.substring(5);
        this.armorNum = fileLine.substring(0,4);
       
        armor.close();
        
        plusToProps(numPlus); 
        
    }
    
    
    private void getProp(int enhancement) throws FileNotFoundException{
        System.out.println("getProp");
        String fileLine = "";
        String fileName = "ArmorProps.txt";       
        
        File propFile = new File(fileName);
       
        Scanner prop = new Scanner(propFile);    
        
        String[] propsArray = new String[500];
        
        int roll100;
        
        //test code as ShieldProps.txt is incomplete
                
        //if(armorNum.charAt(0) == 0){
         
        //    fileName = "ShieldProps.txt";            
            
        //}else{
            
        //    fileName = "ArmorProps.txt";
            
        //}
              
        for(int count = 0; count<500; count ++){
            
            propsArray[count] = prop.nextLine();
            
        }
        
        prop.close();
        
        do{
            
            roll100 = d.d100()+((enhancement-1)*100);
            
            propName = propsArray[roll100].substring(4);
            propNum = propsArray[roll100].substring(1,4);            
            
            System.out.println("propName" + propName);
        }while(compatible(propName, propNum));
      
        if(propName.charAt(0) == '+'){
            
            plusVal[propName.charAt(1)]+=1;
            plusVal[propName.charAt(2)]+=1;
            
        }
        
    }
    
    private boolean compatible(String propName, String propNum){
        //System.out.println("compatibility check");
        
        for(int i = 0; i<this.propNum.length(); i++){
            
            if(propNum.charAt(i) == 9 || propNum.charAt(i) == armorNum.charAt(i+1)){
                
                props.add(propName);
                
                return true;
                
            }else{
                
                return false;
                
            }
                
        } 
        
        return true;
        
    }
     
    public void print(){
        
        System.out.print("+" + plusVal[0] + " " +armorName);
        //System.out.println(props.size());
        if(props.size()>0){
            
            System.out.print(" of ");
            //System.out.println(props.size());
            
            for(int i = 0; i<props.size(); i++){
            
                System.out.print(props.get(i) + " ");
            
            }
            
        }
        
        System.out.println();
        
    }

    public void plusToProps(int numPlus) throws FileNotFoundException{
        //converts the total value into properties and an enhancement value
        //stores globally
        //System.out.println("plustoprops");
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
        
        int totalProps = 0;
        
        //do{
            
            for(int count = 1; count<6; count++){
            
                totalProps += plusVal[count];
            
            }
            //System.out.println(totalProps);
            for(int i = 1;i<6; i++){
        
                while(plusVal[i]>0){
                    
                    getProp(i);
                    
                    plusVal[i]--;
            
                }
            
            }
            
        //}while(totalProps != 0);
        //System.out.println("left the props loop");
    }  
    
}
