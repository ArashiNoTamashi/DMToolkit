
/**
 * Write a description of class Plusses here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/*
public class Plusses
{

    private int numPlus;
    private static int[] numProps = {0,0,0};
        //numProps is for displaying the final result
        //numProps[0] is enhancement
        //numProps[1] is value of prop#1
        //numProps[2] is value of prop#2
    private static int[] plusVal = new int[6];
        //plusVal[0] is unused, only 1-5 are used to avoid confusion
        //plusVal[1] is # of +1 properties
        //plusVal[2] is # of +2 properties
        //plusVal[3] is # of +3 properties and so on
    
    
    public Plusses(int numPlus)
    {
        
        this.numPlus = numPlus;
       
    }
        
    public static void plusToProps(int numPlus){
    
        int rollNum = DiceRoller.d100();
        
        switch(numPlus){
            
            case 1:
            
                numProps[0] = 1;
                
            case 2:
                    
                if(rollNum<63){
                        
                    numProps[0]=2;
                        
                }else{
                        
                    numProps[0] = 1;
                    numProps[1] = 1;
                    
                    plusVal[1] = 1;
                        
                }
                    
                break;
                
            case 3:
            
                if(rollNum<45){
                    
                    numProps[0]=3;
                    
                }else if(rollNum<80){
                    
                    numProps[0]=2;
                    numProps[1]=1;
                    
                    plusVal[1] = 1;
                    
                }else if(rollNum<92){
                    
                    numProps[0]=1;
                    numProps[1]=2;
                    
                    plusVal[2] = 1;
                    
                }else{
                    
                    numProps[0] = 1;
                    numProps[1] = 1;
                    numProps[2] = 1;
                    
                    plusVal[1] = 2;
                
                }
                
                break;
            
            case 4:
                        
                if(rollNum<45){
                    
                    numProps[0] = 4;
                    
                }else if(rollNum<80){
                    
                    numProps[0] = 3;
                    numProps[1] = 1;
                    
                    plusVal[1] = 1;
                    
                }else if(rollNum<92){
                    
                    numProps[0] = 2;
                    numProps[1] = 1;
                    
                    plusVal[2] = 1;
                    
                }else{
                    
                    numProps[0] = 1;
                    numProps[1] = 1;
                    
                    plusVal[3] = 1;
                    
                }
                
                break;
            
            case 5:
            
                if(rollNum<41){
                    
                    numProps[0] = 5;
                    
                }else if(rollNum<76){
                    
                    numProps[0] = 4;
                    numProps[1] = 1;
                    
                    plusVal[1] = 1;
                    
                }else if(rollNum<89){
                    
                    numProps[0] = 3;
                    numProps[1] = 2;
                    
                    plusVal[2] = 1;
                    
                }else if(rollNum<96){
                    
                    numProps[0] = 2;
                    numProps[1] = 3;
                    
                    plusVal[3] = 1;
                    
                }else{
                    
                    numProps[0] = 1;
                    numProps[1] = 4;
                    
                    plusVal[4] = 1;
                    
                }
                
                break;
                    
            case 6:
            
                if(rollNum<44){
                    
                    numProps[0] = 5;
                    numProps[1] = 1;
                    
                    plusVal[1] = 1;
                    
                }else if(rollNum<78){
                    
                    numProps[0] = 4;
                    numProps[1] = 2;
                    
                    plusVal[2] = 1;
                    
                }else if(rollNum<90){
                    
                    numProps[0] = 3;
                    numProps[1] = 3;
                    
                    plusVal[3] = 1;
                    
                }else if(rollNum<96){
                    
                    numProps[0] = 2;
                    numProps[1] = 4;
                    
                    plusVal[4] = 1;
                    
                }else{
                    
                    numProps[0] = 1;
                    numProps[1] = 5;
                    
                    plusVal[5] = 1;
                    
                }
                
                break;
                    
            case 7:
            
            case 8:
            
            case 9:
            
            case 10:
            
        }
                
    }
    //a couple of getters that will likely change a bit
    public int[] getName (int numPlus){
        
        plusToProps(numPlus);
        
        return numProps;
        
    }
    
    public int[] getProps(int numPlus){
        
        return plusVal;
        
    }
    
}
*/