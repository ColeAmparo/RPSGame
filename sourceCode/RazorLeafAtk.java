// Class by Nathan Corpuz

public class RazorLeafAtk {		// creates a class called RazorLeafAtk
	private EZImage pokemonMovePicture;	// create a private EZImage variable called pokemonMovePicture.
	private EZSound pokemonMoveSound= EZ.addSound("SoundEmber.wav");	// creates a private EZSound variable called pokemonMoveSound and assigning it SoundEmber.wav file
	private int x;	// create a private int variable called x.
	private int y;	// create a private int variable called y.

	
	public RazorLeafAtk(String filename, int xPos, int yPos) {	// declaring the properties of the RazorLeafAtk objects
		x = xPos;	//assign xPos to x variable.
		y = yPos;	//assign yPos to y variable.
		pokemonMovePicture = EZ.addImage(filename, x, y); // stores an EZImage called filename at (x, y) coordinates to pokemonMovePicture.
		pokemonMovePicture.scaleTo(0);	// scales pokemonMovePicture image to 0
	}

	// move method
	public void move(int xmove) {	
		pokemonMovePicture.translateTo(xmove, 400);	//moves pokemonMovePicture towards xmove 
		pokemonMovePicture.rotateBy(10);	// spins pokemonMovePicture by 10 degrees every loop
	}
	
	// appearLeft method
	public void appearLeft(int xLeft) {		
		pokemonMovePicture.translateTo(xLeft, 400);		// translates pokemonMovePicture to xLeft, 400 position
		pokemonMovePicture.scaleTo(0.3);	// scales pokemonMovePicture to 0.3
	}
	
	// appearRight method
	public void appearRight(int xRight) {		
		pokemonMovePicture.translateTo(xRight, 400);	//translates pokemonMovePicture to xRight, 400 position
		pokemonMovePicture.scaleTo(0.3);	// scales pokemonMovePicture to 0.3
	}
	
	// getXCenter function
	public int getXCenter() {
		return pokemonMovePicture.getXCenter();		// returns the current x value of pokemonMovePicture when called
		
	}
	
	// lose method
	public void lose() {
		pokemonMoveSound.play();		// plays pokemonMoveSound clip when called
		pokemonMovePicture.scaleTo(0);	// makes pokemonMovePicture disappear off screen
	}
	
	// hide method
	public void hide() {	
		pokemonMovePicture.scaleTo(0);	// hides pokemonMovePicture from screen
	}
}
