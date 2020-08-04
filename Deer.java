//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Jungle Park 2000)
// Files: (JunglePark.java ParkGUI.java Animal.java Tiger.java Deer.java AddAnimalButton.java
//////////////////// ClearButton.java JungkeParkTests.java)
// Course: (001 SUMMER 2019)
//
// Author: (Rosalie CAI)
// Email: (rcai25@wisc.edu)
// Lecturer's Name: (Mouna KACEM)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (Jiong Chen)
// Partner Email: (jchen672@wisc.edu)
// Partner Lecturer's Name: (Mouna KACEM)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (NONE)
// Online Sources: (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class represents the Deer animal extends the Animal class
 * 
 * @author rosaliecarrow
 *
 */
public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  // Constructor that creates a new Deer object positioned at a random position of the display
  // window
  public Deer(JunglePark processing) {
    super(processing, IMAGE_FILE_NAME);

    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current deer
    nextID++;
  }

  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   * 
   * @param scanRange an integer that represents the range of the area to be scanned around the
   *                  animal
   * @return result of the scan (whether there is a threat around)
   */
  public boolean scanForThreat(int scanRange) {
    boolean isClose = false;

    for (int i = 0; i < processing.listGUI.size(); i++) {
      if (processing.listGUI.get(i) instanceof Tiger) {
        if (this.isClose((Tiger) processing.listGUI.get(i), scanRange)) {
          isClose = true;
          break;
        }
      }
    }

    return isClose;
  }

  /**
   * Defines the behavior of a Deer object in the Jungle park
   */
  @Override
  public void action() {
    if (this.scanForThreat(SCAN_RANGE)) {
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(),
          this.getPositionY() - this.image.height / 2 - 4);
    }
  }


}
