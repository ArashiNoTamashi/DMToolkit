import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
/**
 * Write a description of class HoardMaker here.
 *
 * @author (Joe Manship)
 * @version (3/21/19)
 */
public class HoardMaker
{
    
    
    
    public static void makeHoard() throws FileNotFoundException, IOException{
        Dice d = new Dice();
        Scanner crEntry = new Scanner(System.in);
        
        String yesNo = "";
        
        int cr;
        
        do{   
            
            System.out.print("\f");
            
            do{
            
                System.out.print("Enter critter CR(1-20): ");
                            
                cr = crEntry.nextInt(); 
            
                System.out.println();
                
            }while (cr<1||cr>20); 
            
            System.out.print("How many? ");
            int numCritters = crEntry.nextInt();
           
            treasureLoop(numCritters,cr);

            System.out.println();
            
            do{
            
                System.out.print("Again? Y/N ");
            
                yesNo = crEntry.next();
                                
            }while(!yesNo.equalsIgnoreCase("yes")&&!yesNo.equalsIgnoreCase("y")&&!"no".equalsIgnoreCase(yesNo)&&!"n".equalsIgnoreCase(yesNo));
        
            if("no".equalsIgnoreCase(yesNo)||"n".equalsIgnoreCase(yesNo)){
                
                crEntry.close();
                
                return;
                
            }
            
            }while(yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y"));
    
        crEntry.close();
        
        return;
        
    }

    public static void getCoins(int cr)throws FileNotFoundException, IOException{
        
        Dice d = new Dice();
        Scanner coinsFile = new Scanner(new File("DataFiles/money.txt"));
        
        String treasure;
        
        int index=(cr-1)*10;
        int roll,selection;
        int [][] coinTable = new int[201][4];

        for(int i = 0; i<(coinTable.length); i++){

            for(int k = 0; k<4; k++){

                coinTable[i][k]=coinsFile.nextInt();

            }

        }
        
        coinsFile.close();
        
        roll = d.d100();

        selection = index + getOffset(roll,cr);
        
        int numDice = coinTable[selection][0];
        int numSides = coinTable[selection][1];
        int multiplier = coinTable[selection][2];
        int denomination = coinTable[selection][3];

        treasure = (d.multiDice(numDice,numSides, false)*multiplier + getDenom(denomination) + " found");

        System.out.println(treasure);
        saveToFile(treasure);
        
    }

    public static void getGoods(int cr)throws FileNotFoundException, IOException{
        
        Dice d = new Dice();
        Scanner goodsFile = new Scanner(new File("DataFiles/GoodsFile.txt"));
        
        String[] goodsTable = new String[201];
        String goodsString = "";
        
        int index=(cr-1)*10;
        int roll = d.d100();
        int selection = index + getOffset(roll,cr);
        int goodsCount = 0;        
        
        for(int i = 0;i<goodsTable.length;i++){
            
            goodsTable[i] = goodsFile.nextLine();
            
        }
        
        for(int i = 0;i<goodsTable[selection].length();i++){
            
            goodsString += goodsTable[selection].charAt(i);
            
        }
        
        while(goodsCount<goodsString.length()&&goodsString.charAt(goodsCount)!='-'&&goodsString.charAt(goodsCount)!='+'){
        
            char itemType=goodsString.charAt(goodsCount);
            
            printGoods(itemType);
            
            goodsCount++;
            
        }
        
        goodsFile.close();
        
    }
   
    public static void getTreasure(int cr)throws FileNotFoundException, IOException{
        
        Dice d = new Dice();
        Scanner treasureFile = new Scanner(new File("DataFiles/TreasureFile.txt"));
        
        int index=(cr-1)*10;
        int roll = d.d100();
        int selection = index + getOffset(roll,cr);
        int treasureCount = 0;
        
        String[] treasureTable = new String[201];
        String treasureString = "";
        
        for(int i = 0; i<treasureTable.length; i++){

            treasureTable[i]=treasureFile.nextLine();
            
        }
        
        for(int i = 0;i<treasureTable[selection].length();i++){
            
            treasureString += treasureTable[selection].charAt(i);
            
        }
                                
        while(treasureCount<treasureString.length()&&(treasureString.charAt(treasureCount)!='-')&&treasureString.charAt(treasureCount)!='+'){
        
            char itemType=treasureString.charAt(treasureCount);
            
            printTreasure(itemType);
            
            treasureCount++;
            
        }
        
        treasureFile.close();
        
    }
    
    public static void printTreasure(char itemType)throws FileNotFoundException, IOException{
        
        Dice d = new Dice();
        ArrayList<String> itemsTable = new ArrayList<String>();
        
        String fileName = "DataFiles/Equipment/" + itemType + "LevelItems.txt";
        String itemName = "";
        String treasure = "";
   
        Scanner itemFile = new Scanner(new File(fileName));

        while (itemFile.hasNext()){

            itemsTable.add(itemFile.nextLine());
                
        }
        
        if(itemType!='-'){//some lines dont contain items at low cr's
            
            //Test Code
            itemName = itemsTable.get(90);
            //itemName = itemsTable.get(d.d100()-1);
            
            Scanner nameScanner = new Scanner(itemName);
                                  
            if(itemName.charAt(0) == '+'){
                
                int numPlus = nameScanner.nextInt();
                System.out.println(numPlus);
                String weapArmor = nameScanner.next();
                
                //send it to the appropriate chart to do appropriate stuff
                /*if(weapArmor.charAt(0)=='w'){
                    /*----------TEST CODE--------------
                    Armor newArmor = new Armor();
                    
                    newArmor.makeArmor(numPlus);
                    newArmor.print();                
                    //TEST CODE------------------------
                    
                    //Weapon newWeap = new Weapon(numPlus);
                                        
                }else{
                /*
                    Armor newArmor = new Armor();
                    
                    newArmor.makeArmor(numPlus);
                    newArmor.print();
                    
                }*/
                
                nameScanner.close();
                
                //---TEMPORARY CODE UNTIL WEAPON/ARMOR BUGS FIXED----------------------
                
                treasure = itemName;
                
                //---TEMPORARY CODE----------------------------------------------------
                
            }else{
            
                treasure = itemName;
        
            }
        
        }else{
        
            treasure = "No items";
        
        }
        
            saveToFile(treasure);
            System.out.println(treasure);
        
    }
    
    public static void printGoods(char itemType)throws FileNotFoundException,IOException{
        
        Dice d = new Dice();
        ArrayList<String> itemsTable = new ArrayList<String>(); //arraylist instead of array, as the list size varies
        
        if(itemType == 0){
            
            itemType = '-';
            
        }
        
        String fileName = "DataFiles/GemsArt/Item" + itemType + ".txt";
        String treasure;
        
        Scanner itemFile = new Scanner(new File(fileName));
        
        int numDice = itemFile.nextInt();
        int numSides = itemFile.nextInt();
        int multiplier = itemFile.nextInt();
        
        while (itemFile.hasNext()){

                itemsTable.add(itemFile.nextLine());
                
        }
        
        if(itemType!='-'){
        
            treasure = (itemsTable.get(d.multiDice(1,itemsTable.size()-1,false))+ " (" + d.multiDice(numDice,numSides,false)*multiplier + "gp)");
  
        }else{
        
            treasure = ("No gems, jewelry or art");
              
        }
        
        saveToFile(treasure);
        System.out.println(treasure);
        
    }
    
    public static int getOffset(int roll, int cr){
        //the array contains all 201 possiblities, the cr sets which is "0" using the (cr-1)*10
        //the offset gives which of the possibilities within that range. Possible to do with a 3d array
        //but we decided against a 3d array, as multidimensional arrays are beyond the scope of the class
        
        int offset;
        
        if(roll<8){
        
            offset = 0;
        
        }else if(roll<11){
        
            offset = 1;
        
        }else if(roll<22){
        
            offset = 2;
        
        }else if(roll<45){
        
            offset = 3;
        
        }else if(roll<61){
        
            offset = 4;
        
        }else if(roll<79){
        
            offset = 5;
        
        }else if(roll<84){
        
            offset = 6;
        
        }else if(roll<92){
                    
            offset = 7;
            
        }else if(roll<96){//strangely, cr20 has 11 entries instead of 10
            
            if (cr==20){
                
                offset = 8;
            
            }else{
            
                offset = 7;
            
            }
            
        }else if(roll<100){
        
            if (cr==20){
                
                offset = 9;
            
            }else{
            
                offset = 8;
            
            }
        
        }else{
        
            if (cr==20){
                
                offset = 10;
            
            }else{
            
                offset = 9;
            
            }
            
        }        
        
        return offset;
    
    }

    public static String getDenom(int denomination){

        String denomString = "";

        if(denomination == 0){

            denomString = " coins"; //used only when 0 coins are found :(

        }else if(denomination == 1){

            denomString = " cp";

        }else if(denomination == 2){

            denomString = " sp";

        }else if(denomination == 3){

            denomString = " gp";

        }else{

            denomString = " pp";

        }

        return denomString;

    }
    
    public static void treasureLoop(int num, int cr)throws FileNotFoundException, IOException{
        
        for(int i = 0; i<num; i++){
            
            getCoins(cr);
            getGoods(cr);
            getTreasure(cr);
        
        }
        
        Scanner input = new Scanner(System.in);
        
        SaveFiles.savePrompt(input,"SavedTreasure/");
        
        input.close();
        
    }
    
    private static void saveToFile(String input) throws FileNotFoundException, IOException{
        
        SaveFiles newTreas = new SaveFiles("SavedTreasure/temp.txt",true);
        
        newTreas.save(input);
        
    }
        
}