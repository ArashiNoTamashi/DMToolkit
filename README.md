# DMToolkit
Java-Based D&amp;D3.5 toolkit
------------------------------------------------------------------------

DM Toolkit v2.1.0.1
------------------------------------------------------------------------

PURPOSE OF PROJECT:




---HOW TO START THIS PROJECT--------------------------------------------

The project at this time requires BlueJ. Navigate to the main folder and double-click on the "package"
    file. Right-click on "Main Menu" and click on "void main(String[] args)". The program then can be
    navigated via number entry.

---AUTHORS--------------------------------------------------------------------------------------------

Joe Manship, Lead Developer 
Jason Walters, Lead QA

------------------------------------------------------------------------------------------------------

CUSTOMIZATION INSTRUCTIONS:

Data files can be found in the "DataFiles" directory and appropriate subdirectories, and altered using 
    notepad (or equivalent). The result MUST contain 100 lines for weapons, armor, money, goods and 
    "levelitems" files. Altering these files is inadvisable. 
Changing the "ItemA" - "ItemI" files can provide more types of jewelry and artwork, and is encouraged. 
    The existing lists were pulled from the Magic Item Compendium.
Traps can be added to in the trap files. Trap files are numbered my max and min CRs, so "trap710.txt" 
    contains traps between CR7 and CR10 Make sure the first line is trap name, followed by CR, Search
    and Disable DC's, in that order. Higher CR traps can be added, but won't be implemented correctly 
    without editing the code.
    
------------------------------------------------------------------------------------------------------

TECHNICAL NOTES:

The weapons, armor, money, goods and "level items" are using arrays. As a result, if anything is added 
    to the end, it will not be added to the array(as the arrays are sized specifically to the number of 
    lines in the file). If anything is deleted, the program will crash as it attempts to add an empty 
    line to the array. 
The jewelry and artwork in the ItemA-ItemI uses an array list, and will add new entries into the 
    arraylist for possible selection.
The RoomMaker uses d100 for features, so will only support 100 features. Any features beyond 100 
    cannot be selected.

------------------------------------------------------------------------------------------------------

RESOURCES:

The majority of the tables were pulled from the Magic Item Compendium for D&D 3.5. The skill points 
    and ability score modifiers are from the D&D 3.5 Players Handbook. The character background 
    generator was pulled from Central Casting. 

We don't own or claim authorship for any of these, WotC owns the D&D books, and Task Force Games owns
    Central Casting. What we DID do is assemble everything into one convenient spot and do all the 
    coding for the toolkit. 

------------------------------------------------------------------------------------------------------    
    
KNOWN BUGS:

-The armor does not function correctly. They print blank lines.
-Weapons are generic
-Too many "*"'s when the room number is 10 or higher.

------------------------------------------------------------------------------------------------------

THINGS BEING WORKED ON:

-Room Generator
    -Door type/number
    -# of "*"'s bug
-Weapons only print out total +'s and weapon type
-Armor bug
-Character Generator (per DMG rules, designed for NPC's)

FUTURE STUFF:

-Fractional treasure
-Interface
-Making lists read with a single, easily expandable convention

