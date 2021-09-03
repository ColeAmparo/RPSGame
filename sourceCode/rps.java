// Class by Nathan Corpuz

public class rps {	// creates a class called rps

	private EZImage rpsPicture;	// create a private EZImage variable called rpsPicture
	private EZSound pokemonMoveSound= EZ.addSound("SoundSuperEffective.wav");
	
	private int x;	// create a private int variable called x.
	private int y;	// create a private int variable called y.

	
	public rps(String filename, int xPos, int yPos) {	// declaring the properties of the rps objects
		x = xPos;	//assign xPos to x variable.
		y = yPos;	//assign yPos to y variable.
		rpsPicture = EZ.addImage(filename, x, y); // stores an EZImage called filename at (x, y) coordinates to rpsPicture.
		rpsPicture.scaleTo(0);	// scales housePicture image to 0
		
	}	
	// teleport method
	public void tp(int xPos, int yPos) {	
		rpsPicture.translateTo(xPos, yPos);	// moves rpsPicture to xPos and yPos position
	}
	// appear method
	public void appear() {		
			rpsPicture.scaleTo(0.15);	// scales rpsPicture back onto screen
	}
	//hide method
	public void hide() {
		rpsPicture.scaleTo(0);	// scales rpsPicture to 0 so that it is hidden
	}
	
	//superEffectiveSound method
	public void superEffectiveSound() {	
		pokemonMoveSound.play();	// plays pokemonMoveSound clip when called
	}
	
	
}