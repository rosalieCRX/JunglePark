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
public class AddAnimalButton extends Button {

  private String type; // type of the animal to add

  /**
   * constructor for addAnimalButton class
   * 
   * @param type name of the animal
   * @param x    x-coordinate of the button
   * @param y    y-coordinate of the button
   * @param park the park graphic display window
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park);
    this.type = type.toLowerCase();
    this.label = "Add " + type;
  }

  /**
   * add relevant animal when specific button pressed
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          // TODO create a new Tiger and add it to the JunglePark
          processing.listGUI.add(new Tiger(processing));
          break;
        case "deer":
          // TODO create a new Deer and add it to the JunglePark
          processing.listGUI.add(new Deer(processing));
          break;
      }
    }
  }

}
