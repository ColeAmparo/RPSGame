// Class by Nathan Corpuz

public class EmberAtk {		// creates a class called EmberAtk
	
	private EZImage pokemonMovePicture;	// create a private EZImage variable called housePicture.
	private EZSound pokemonMoveSound= EZ.addSound("SoundEmber.wav");	// creates a private EZSound variable called pokemonMoveSound and assigning it SoundEmber.wav file
	private int x;	// create a private int variable called x.
	private int y;	// create a private int variable called y.

	public EmberAtk(String filename, int xPos, int yPos) {	// declaring the properties of the EmberAtk objects
		x = xPos;	//assign xPos to x variable.
		y = yPos;	//assign yPos to y variable.
		pokemonMovePicture = EZ.addImage(filename, x, y); // stores an EZImage called filename at (x, y) coordinates to pokemonMovePicture.
		pokemonMovePicture.scaleTo(0);	// scales pokemonMovePicture image by 0
	}
	
	// move method
	public void move(int units) {
		pokemonMovePicture.moveForward(units);		// moves pokemonMovePicture forward every time its called
	}
		
	// appearLeft method
	public void appearLeft(int xLeft) {		
		pokemonMovePicture.translateTo(xLeft, 400);		// translates pokemonMovePicture to xLeft, 400 position
		pokemonMovePicture.scaleTo(0.12);		// scales pokemonMovePicture to 0.12
	}
		
	// appearRight method
	public void appearRight(int xRight) {
		pokemonMovePicture.translateTo(xRight, 400);	//translates pokemonMovePicture to xRight, 400 position
		pokemonMovePicture.scaleTo(0.12);	// scales pokemonMovePicture to 0.12
		pokemonMovePicture.rotateBy(180);	// rotates pokemonMovePicture by 180 degrees
	}
	
	// resetRight method
	public void resetRight() {
		pokemonMovePicture.rotateBy(180);	// resets orientation of pokemonMovePicture when called
	}
	
	// getXCenter function
	public int getXCenter() {		
		return pokemonMovePicture.getXCenter();		// returns the current x value of pokemonMovePicture when called
	}
	
	// lose method
	public void lose() {
		pokemonMoveSound.play();	// plays pokemonMoveSound when called
		pokemonMovePicture.scaleTo(0);	// scales pokemonMovePicture to 0
	}
	
	// hide method
	public void hide() {
		pokemonMovePicture.scaleTo(0);	// hides pokemonMovePicture image from screen
	}
}