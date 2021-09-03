//Class by Cole Amparo 


import java.awt.Color;

public class Lifebar {
		
	private EZRectangle lifeOneThird;        //sets three rectangles for the health bar
	private EZRectangle lifeTwoThird;
	private EZRectangle lifeThreeThird;
	private int rectWidth;
	private int rectHeight;                //sets the widths and heights
	
	private int posX1;      //coordinates up the positions
	private int posY1;
	private int posX2;
	private int posY2;
	private int posX3;
	private int posY3;
	private int damageCount = 0;
	private int deathCount = 0;
	public Lifebar( int x1, int y1,int x2, int y2, int x3, int y3,    //takes the inputs from the main program
					int width, int height) {
		
		 lifeOneThird = EZ.addRectangle(x1, y1, width, height, Color.white , true);
		 lifeTwoThird = EZ.addRectangle(x2, y2, width, height, Color.white, true);
		 lifeThreeThird = EZ.addRectangle(x3, y3, width, height, Color.white, true);
		 
		 posX1 = x1;	rectWidth = width;       
		 posY1 = y1;	rectHeight = height;               //sets the variables form the main program to private one to use in the class
		 posX2 = x2;	
		 posY2 = y2;	
		 posX3 = x3;	
		 posY3 = y3;	
		
		}
	
	void loseHealth() {
		
	healthLoop:	while(true) {
		
		
		if(lifeThreeThird.getXCenter() != lifeTwoThird.getXCenter() && damageCount == 0){    //uses a integer call damage count to check how much damage they have taken
		lifeThreeThird.moveForward(-1);            //moves the outer rectangle until it is on the same coordinate as the middle rectangle
		EZ.refreshScreen();
		}else {
			lifeThreeThird.translateTo(-100, -100);        //moves rect 3 off screen
			damageCount++;
			if(lifeThreeThird.getXCenter() == -100 && damageCount == 1) {
				lifeTwoThird.setColor(Color.ORANGE);                  //sets the health bar to orange 
				lifeOneThird.setColor(Color.ORANGE);
				break healthLoop;
			}
			if(lifeTwoThird.getXCenter() != lifeOneThird.getXCenter() && damageCount > 1) {
				lifeTwoThird.moveForward(-1);		   // moves rect 2 to the same coordinates as rect 1
				EZ.refreshScreen();
				
				}else {
					deathCount++;
					if(deathCount == 1) {
						lifeTwoThird.setColor(Color.RED);       //uses the integer death count to see if the health bar is at 1/3
						lifeOneThird.setColor(Color.RED);
						break healthLoop;
					}
					if(deathCount > 1) {
						for(int i = 1; i <= 100; i++) {
							lifeTwoThird.setWidth(100-i); //decreases the smallest healthbar
							lifeOneThird.setWidth(100-i);
							EZ.refreshScreen();
						}
						lifeTwoThird.translateTo(-200,-200);
						lifeOneThird.translateTo(-200, -200);  
						break healthLoop;                    //once the health bar is gone the while loop for the health bar is broken
					}
				}	
			
			}
		
		}
	
	}
	
	boolean check() {                                 //checks if the last rectangle is off screen (which means that player is dead)
		if(lifeOneThird.getXCenter()==-200) {
			return true;      //returns true
		}else {
			return false;
		}
	}
	
	 public void setColor(Color color) {   //sets color of the hp bar
		lifeOneThird.setColor(color);
		lifeTwoThird.setColor(color);
		lifeThreeThird.setColor(color);
	}
	
	boolean redCheck() {        //checks if the health bar is in the red to play the critical health music
		if(lifeOneThird.getXCenter() == lifeTwoThird.getXCenter()) {
			return true;  // returns true 
		}else {
			return false;
		}
	}

	
	
}

