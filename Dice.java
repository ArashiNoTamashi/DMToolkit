
/**
 * Dice object for dice rolling
 *
 * @author (Joe Manship)
 * @version (4/8/19)
 */
public class Dice
{
    
    public Dice(){
    
        
    }
        
    public static int d2(){
        
        return (int)((Math.random()*2)+1);
        
    }
    
    public static int d3(){

        return (int)((Math.random()*3)+1);

    }

    public static int d4(){

        return (int)((Math.random()*4)+1);

    }

    public int d6(){

        return (int)((Math.random()*6)+1);

    }

    public static int d8(){

        return (int)((Math.random()*8)+1);

    }

    public static int d10(){

        return (int)((Math.random()*10)+1);

    }

    public static int d12(){

        return (int)((Math.random()*12)+1);

    }

    public static int d20(){

        return (int)((Math.random()*20)+1);

    }

    public static int d100(){

        return (int)((Math.random()*100)+1);

    }
    //basic multiple dice roller
    public static int multiDice(int numRolls, int numSides){

        int total=0;
        
        for(int i = 0;i<numRolls;i++){ 

            total+= (int)((Math.random()*numSides)+1);
            
        }
        
        return total;

    }
    //sometimes it is necessary to show the rolled dice
    public static int multiDice(int numRolls, int numSides, boolean show){

        int count = 0;
        int total = 0;
        int newNum = 0;
        int numcount= 0;
        do{

            newNum= (int)((Math.random()*numSides)+1);
            total+=newNum;
            count++;
            
            if(show){
                
                System.out.print(newNum + " ");
                
                numcount++;
                
                if(numcount%10 == 0){
                    
                    System.out.println();
                    
                }
                
            }
                
        }while(count<numRolls);

        return total;

    }
    //sometimes, when the dice are shown, there are modifiers.
    //in the case of negative modifiers, the minimum is usually 1 or 0.
    public static int multiDice(int numRolls, int numSides, 
        boolean show, int mod, int min){

        int count = 0;
        int total = 0;
        int newNum = 0;
        int numcount= 0;
        
        int[] numArray = new int[numRolls];
        
        do{

            newNum= (int)((Math.random()*numSides)+1)+mod;
            
            //numArray[count] = (int)((Math.random()*numSides)+1);
            
            if (newNum<min){
                
                newNum = min;
                
            }
            
            total+=newNum;
            count++;
            int baseNum = newNum - mod;
            
            //create new line after 10 numbers
            if(show){
                
                System.out.print(newNum +"("+baseNum+")" + " ");
                
                numcount++;
                
                if(numcount%10 == 0){
                    
                    System.out.println();
                    
                }
                
            }
                
        }while(count<numRolls);
        
        // for(int i = 0; i<numRolls; i++){
                  
            // System.out.println(numArray[i]);
        
        // }
        
        System.out.println();
        
        return total;

    }
    
    private static void bSort(int[] arr){
     
        
        
    }
}
