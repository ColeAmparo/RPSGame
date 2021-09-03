/* Cole Amparo and Nathan Corpuz
 * Pokemon themed rock paper scissors game for ICS 111 Project 3
 * File Reading/Parsing and private/public member variables and member functions were used in this project.
 * Nathan's classes: rps, RazorLeafAtk, and EmberAtk
 * Cole's classes: LifeBar and BubbleAtk
 * We also both worked on Start.java
 */


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws java.io.IOException {
		
			int choice1=10;		//setup integer values
			int choice2=10;
			int ready1=0;
			int ready2=0;
			int xLeft0 =300;
			int xLeft1 =330;
			int xLeft2 =360;
			int xRight0 =840;
			int xRight1	= 870;
			int xRight2 =900;
			int critMusicCounter = 0;
			int player1Victor = 0;
			int player2Victor = 0;
			
			
			EZSound backgroundMusic= EZ.addSound("backgroundMusic.wav");	//setup sound clips
			EZSound critHealthMusic = EZ.addSound("critHealthMusic.wav");
			EZSound victoryMusic = EZ.addSound("victoryMusic.wav");
			EZSound selectionSound = EZ.addSound("SoundSelect.wav");
			EZSound selectionSound2 = EZ.addSound("SoundSelect2.wav");
			
			EZ.initialize(1200,700); // Setup EZ graphics system with a 1200x700 pixels screen.

			EZ.setBackgroundColor(new Color(0, 0, 0)); // sets background color of screen to the color black.
			
			EZText key1 = EZ.addText(25, 200, "1", new Color(0, 0, 0), 30);		// strings to indicate which button is each pokemon
			EZText key2 = EZ.addText(25, 400, "2", new Color(0, 0, 0), 30);
			EZText key3 = EZ.addText(25, 600, "3", new Color(0, 0, 0), 30);
			EZText key7 = EZ.addText(1175, 200, "7", new Color(0, 0, 0), 30);
			EZText key8 = EZ.addText(1175, 400, "8", new Color(0, 0, 0), 30);
			EZText key9 = EZ.addText(1175, 600, "9", new Color(0, 0, 0), 30);
			EZText player1 = EZ.addText(200, 30, "PLAYER 1", new Color(0,0,0),35);
			EZText player2 = EZ.addText(1000, 30, "PLAYER 2", new Color(0,0,0),35);
			EZText instructions1 = EZ.addText(200, 105, "Choose pokemon with 1, 2, or 3",new Color(0,0,0),18);
			EZText instructions2 = EZ.addText(1000, 105, "Choose pokemon with 7, 8, or 9",new Color(0,0,0),18);
			EZText instructions3 = EZ.addText(600, 25, "Win the pokemon battle!",new Color(0,0,0),18);
			
			key1.setFont("8-BIT WONDER.TTF");	//changing fonts of all strings
			key2.setFont("8-BIT WONDER.TTF");
			key3.setFont("8-BIT WONDER.TTF");
			key7.setFont("8-BIT WONDER.TTF");
			key8.setFont("8-BIT WONDER.TTF");
			key9.setFont("8-BIT WONDER.TTF");
			player1.setFont("8-BIT WONDER.TTF");
			player2.setFont("8-BIT WONDER.TTF");
	
			
			EZImage backgroundSides = EZ.addImage("backgroundImage4.png", 600, 350);	//setup background and start screen images
			EZImage backgroundImage = EZ.addImage("backgroundImage3.png", 600, 400);	
			EZImage startScreen = EZ.addImage("startScreen.png",600,350);
	
			FileReader fr = new FileReader("rps cords.txt");	// setup a fileReader called fr to the "rps cords.txt" file.
			Scanner sc = new Scanner(fr);	// setup a scanner sc that scans the fileReader fr.
		
			rps pokemon[] = new rps[6]; //an array callled pokemon which was created from the rps class with a length of 6.
			for (int i=0; i<6; i++) {	// a for loop that spawns 6 pokemon
				String rps = sc.next();	// the next string in in the scanner variable is assigned to the variable rps
				int x = sc.nextInt();	// the next integer in the sc scanner variable is assigned to the variable x
				int y = sc.nextInt();	// the next integer in the sc scanner variable is assigned to the variable y
				pokemon[i] = new rps(rps +".png",x,y);	// creates a pokemon image at the (x,y) which loops 5 times
			}
			sc.close();	//close scanner
			
			EZImage time = EZ.addImage("paper.png", 0, 0);	// creates an invisible image called time
			time.scaleTo(0);
			
			
			RazorLeafAtk razor[] = new RazorLeafAtk[6];		// an array that spawns 6 razor leaves
			for (int i =0; i<6;i++) {
				razor[i] = new RazorLeafAtk("razorLeaf.png",-100,0);
			}
			
			
			BubbleAtk bubble[] = new BubbleAtk[6];		// an array that spawns 6 bubbles
			for (int i =0; i<6;i++) {
				bubble[i] = new BubbleAtk("bubble3.png",-200,0);
			}
			
			
			EmberAtk ember[] = new EmberAtk[6];		// an array that spawns 6 fire images
			for (int i =0; i<6;i++) {
				ember[i] = new EmberAtk("ember.png",-300,0);
			}
			
			Lifebar player1Life = new Lifebar(100, 70, 200, 70, 300, 70, 100, 50);       //player 1 hp bar
			Lifebar player2Life = new Lifebar(900, 70, 1000, 70, 1100, 70, 100, 50);   // player 2 hp bar
			
			
			while (true) {
	
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_SPACE)) {	// when space is pressed, game starts
						
						selectionSound2.play();		// select sound is played						
						backgroundMusic.play();		// plays background music			
						
						for (int j = 0;j<34;j++) {		// code to stall for time
							time.moveForward(8);
							EZ.refreshScreen();
						}							
						
						startScreen.scaleTo(0);			// hide start screen		
						
						player1Life.setColor(Color.green);
						player2Life.setColor(Color.green);				
						
						for (int i =0; i<6;i++) {	//makes pokemon appears on screen
							pokemon[i].appear();						
						}				
						
						key1.pullToFront();		//brings strings to front of screen
						key2.pullToFront();
						key3.pullToFront();
						key7.pullToFront();
						key8.pullToFront();
						key9.pullToFront();
						player1.pullToFront();
						player2.pullToFront();		
						instructions1.pullToFront();
						instructions2.pullToFront();
						instructions3.pullToFront();
					}
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_1)) {	// buttons to indicate both player's selection
						choice1 = 0;
						ready1=1;
						selectionSound.play();
					}
					
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_2)) {
						choice1 = 1;
						ready1=1;
						selectionSound.play();
					}
					
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_3)) {
						choice1 = 2;
						ready1=1;
						selectionSound.play();
					}
					
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_7)) {
						choice2 = 3;
						ready2=1;
						selectionSound.play();
					}
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_8)) {
						choice2 = 4;
						ready2=1;
						selectionSound.play();
					}
					if(EZInteraction.wasKeyPressed(KeyEvent.VK_9)) {
						choice2 = 5;
						ready2=1;
						selectionSound.play();
					}
				
					
				if(ready1 == 1 && ready2 == 1) {	// checks if both players have selected
				
				case1: if(choice1 == 0 && choice2 == 3) {		// rock and rock (GRASS AND GRASS)
						
							pokemon[0].tp(300,400);		// teleport pokemon to middle
							pokemon[3].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							razor[0].appearLeft(xLeft0);	// show razor leaf projectiles on left side
							razor[1].appearLeft(xLeft1);
							razor[2].appearLeft(xLeft2);
							
							razor[3].appearRight(xRight0);	// show razor projectiles on right side
							razor[4].appearRight(xRight1);
							razor[5].appearRight(xRight2);
							
							for (int i = 0;i<105;i++) {		
								
								razor[0].move(xLeft0);		// move razor leaf projectiles 					
								razor[1].move(xLeft1);						
								razor[2].move(xLeft2);
								
								razor[3].move(xRight0);		// move razor projectiles
								razor[4].move(xRight1);
								razor[5].move(xRight2);
								
								if (razor[0].getXCenter() == 600) {	//once razor leaves reaches middle, they disappear
									razor[0].lose();
									razor[3].lose();
								}
								if (razor[1].getXCenter() == 570) {
									razor[1].lose();
									razor[4].lose();
								}
								if (razor[2].getXCenter() == 540) {
									razor[2].lose();
									razor[5].lose();
								}
								
								EZ.refreshScreen();
							
								xLeft0= xLeft0 + 5;		//increment xLeft variables by 5 for each loop
								xLeft1= xLeft1 + 5;
								xLeft2= xLeft2 + 5;
								
								xRight0= xRight0 - 5;	//increment xRight variables by -5 for each loop
								xRight1= xRight1 - 5;
								xRight2= xRight2 - 5;
								
								}
					
								for (int j = 0;j<34;j++) {		// code to stall for time
									time.moveForward(8);
									EZ.refreshScreen();
								}
								
								pokemon[0].tp(100,200);		// reset pokemon back to original spots
								pokemon[3].tp(1100,200);
						}
					
					

				case2: if(choice1 == 0 && choice2 == 4) {		// rock and paper (GRASS AND FIRE)
						
							pokemon[0].tp(300,400);		// teleport pokemon to middle
							pokemon[4].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							razor[0].appearLeft(xLeft0);	// show razor leaf projectiles on left side
							razor[1].appearLeft(xLeft1);
							razor[2].appearLeft(xLeft2);
							
							ember[3].appearRight(xRight0);	// show ember projectiles on right side
							ember[4].appearRight(xRight1);
							ember[5].appearRight(xRight2);
							
							for (int i = 0;i<105;i++) {		
								
								razor[0].move(xLeft0);		// move razor leaf projectiles 					
								razor[1].move(xLeft1);						
								razor[2].move(xLeft2);
								
								ember[3].move(5);		// move ember projectiles
								ember[4].move(5);	
								ember[5].move(5);	
								
								if (razor[0].getXCenter() == 600) {	//once razor leaves reaches middle, they disappear
									razor[0].lose();
								}
								if (razor[1].getXCenter() == 570) {
									razor[1].lose();
								}
								if (razor[2].getXCenter() == 540) {
									razor[2].lose();
								}
								
								EZ.refreshScreen();
							
								xLeft0= xLeft0 + 5;		//increment xLeft variables by 5 for each loop
								xLeft1= xLeft1 + 5;
								xLeft2= xLeft2 + 5;
							}
							
							pokemon[5].superEffectiveSound();	// play super effective sound
							
							ember[3].resetRight();		// reset ember image orientation
							ember[4].resetRight();
							ember[5].resetRight();
							
							for (int i = 0;i<6;i++) {
								
								ember[3].hide();		//hide ember at current position
								ember[4].hide();
								ember[5].hide();
								
								
								pokemon[0].hide();			// animation for pokemon getting hit
								for (int j = 0;j<6;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
								pokemon[0].appear();
								for (int j = 0;j<5;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
							}
							player1Life.loseHealth();        // player 1 loses health
							
							if(player1Life.redCheck() == true && critMusicCounter == 0) { // plays critical health music when hp is red
								backgroundMusic.pause();
								critHealthMusic.play();
								critMusicCounter++;
							}
							
							if(player1Life.check()== true) {  // checks if player 1 is dead
								player2Victor++;
								break;
							}
							
							
							pokemon[0].tp(100,200);		// reset pokemon back to original spots
							pokemon[4].tp(1100,400);
						}
					
					
		
				case3: if(choice1 == 0 && choice2 == 5) {		// rock and scissors (GRASS AND WATER)
						
							pokemon[0].tp(300,400);		// teleport pokemon to middle
							pokemon[5].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							razor[0].appearLeft(xLeft0);	// show razor leaf projectiles on left side
							razor[1].appearLeft(xLeft1);
							razor[2].appearLeft(xLeft2);
							
							bubble[3].appearRight(xRight0);	// show bubble projectiles on right side
							bubble[4].appearRight(xRight1);
							bubble[5].appearRight(xRight2);
							
							for (int i = 0;i<110;i++) {		
								
								razor[0].move(xLeft0);		// move razor leaf projectiles 					
								razor[1].move(xLeft1);						
								razor[2].move(xLeft2);
								
								bubble[3].move(-5);		// move bubble projectiles
								bubble[4].move(-5);	
								bubble[5].move(-5);	
								
								if (bubble[3].getXCenter() == 600) {	//once bubbles reaches middle, they disappear
									bubble[3].lose();
								}
								if (bubble[4].getXCenter() == 630) {
									bubble[4].lose();
								}
								if (bubble[5].getXCenter() == 660) {
									bubble[5].lose();
								}
								
								EZ.refreshScreen();
							
								xLeft0= xLeft0 + 5;		//increment xLeft variables by 5 for each loop
								xLeft1= xLeft1 + 5;
								xLeft2= xLeft2 + 5;
							}
							
							pokemon[5].superEffectiveSound();	// play super effective sound
							
							for (int i = 0;i<6;i++) {
								
								razor[0].hide();		//hide razor leaves at current position
								razor[1].hide();
								razor[2].hide();
								
								pokemon[5].hide();			// animation for pokemon getting hit
								for (int j = 0;j<6;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
								pokemon[5].appear();
								for (int j = 0;j<5;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
							}
	
							
							player2Life.loseHealth();       // player 2 loses health 
							
							if(player2Life.redCheck() == true && critMusicCounter == 0) { // plays critical health music when hp is red
								backgroundMusic.pause();
								critHealthMusic.play();
								critMusicCounter++;
							}
							
							if(player2Life.check()== true) {  // checks is player 2 is dead
								player1Victor++;
								break;
							}
							
							pokemon[0].tp(100,200);		// reset pokemon back to original spots
							pokemon[5].tp(1100,600);
						}
		
					
				case4: if(choice1 == 1 && choice2 == 3) {		// paper and rock (Fire AND Grass)
					
							pokemon[1].tp(300,400);		// teleport pokemon to middle
							pokemon[3].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							ember[0].appearLeft(xLeft0);	// show ember projectiles on left side
							ember[1].appearLeft(xLeft1);
							ember[2].appearLeft(xLeft2);
							
							razor[3].appearRight(xRight0);	// show razor leaf projectiles on right side
							razor[4].appearRight(xRight1);
							razor[5].appearRight(xRight2);
							
							for (int i = 0;i<105;i++) {		
								
								ember[0].move(5);		// move ember projectiles 					
								ember[1].move(5);						
								ember[2].move(5);
								
								razor[3].move(xRight0);		// move razor leaf projectiles
								razor[4].move(xRight1);	
								razor[5].move(xRight2);	
								
								if (razor[3].getXCenter() == 600) {	//once razor leaf reaches middle, they disappear
									razor[3].lose();
								}
								if (razor[4].getXCenter() == 630) {
									razor[4].lose();
								}
								if (razor[5].getXCenter() == 660) {
									razor[5].lose();
								}
								
								EZ.refreshScreen();
							
								xRight0= xRight0 - 5;	// increment xRight variables by -5 each loop
								xRight1= xRight1 - 5;
								xRight2= xRight2 - 5;
							}
							
							pokemon[3].superEffectiveSound();	// play super effective sound
												
							for (int i = 0;i<6;i++) {
								
								ember[0].hide();		//hide ember at current position
								ember[1].hide();
								ember[2].hide();
				
								pokemon[3].hide();			// animation for pokemon getting hit
								for (int j = 0;j<6;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
								pokemon[3].appear();
								for (int j = 0;j<5;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
							}
		
							
							
							player2Life.loseHealth();        // player 2 loses health 
							
							if(player2Life.redCheck() == true && critMusicCounter == 0) { // plays critical health music when hp is red
								backgroundMusic.pause();
								critHealthMusic.play();
								critMusicCounter++;
							}
							
							if(player2Life.check()== true) {   // checks is player 2 is dead
								player1Victor++;
								break;
							}
							
							pokemon[1].tp(100,400);		// reset pokemon back to original spots
							pokemon[3].tp(1100,200);
						}
					
				
						
				case5: if(choice1 == 1 && choice2 == 4) {		// paper and paper (Fire AND Fire)
							
							pokemon[1].tp(300,400);		// teleport pokemon to middle
							pokemon[4].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							ember[0].appearLeft(xLeft0);	// show ember projectiles on left side
							ember[1].appearLeft(xLeft1);
							ember[2].appearLeft(xLeft2);
							
							ember[3].appearRight(xRight0);	// show ember projectiles on right side
							ember[4].appearRight(xRight1);
							ember[5].appearRight(xRight2);
							
							for (int i = 0;i<105;i++) {		
								
								ember[0].move(5);		// move ember projectiles 					
								ember[1].move(5);						
								ember[2].move(5);
								
								ember[3].move(5);		// move ember projectiles
								ember[4].move(5);	
								ember[5].move(5);	
								
								if (ember[3].getXCenter() == 600) {	//once ember reaches middle, they disappear
									ember[3].lose();
									ember[0].lose();
								}
								if (ember[4].getXCenter() == 630) {
									ember[4].lose();
									ember[1].lose();
								}
								if (ember[5].getXCenter() == 660) {
									ember[5].lose();
									ember[2].lose();
								}
								
								EZ.refreshScreen();
							
							
							}
							
						
							ember[3].resetRight();		// reset ember image orientation
							ember[4].resetRight();
							ember[5].resetRight();
							
	
							for (int j = 0;j<34;j++) {		// code to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							pokemon[1].tp(100,400);		// reset pokemon back to original spots
							pokemon[4].tp(1100,400);
						}		
						
						
						
						
				case6: if(choice1 == 1 && choice2 == 5) {		// paper and scissor (Fire AND Water)
							
							pokemon[1].tp(300,400);		// teleport pokemon to middle
							pokemon[5].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							ember[0].appearLeft(xLeft0);	// show ember projectiles on left side
							ember[1].appearLeft(xLeft1);
							ember[2].appearLeft(xLeft2);
							
							bubble[3].appearRight(xRight0);	// show bubble projectiles on right side
							bubble[4].appearRight(xRight1);
							bubble[5].appearRight(xRight2);
							
							for (int i = 0;i<105;i++) {		
								
								ember[0].move(5);		// move ember projectiles 					
								ember[1].move(5);						
								ember[2].move(5);
								
								bubble[3].move(-5);		// move bubble projectiles
								bubble[4].move(-5);	
								bubble[5].move(-5);	
								
								if (ember[0].getXCenter() == 600) {	//once ember reaches middle, they disappear
									ember[0].lose();
								}
								if (ember[1].getXCenter() == 570) {
									ember[1].lose();
								}
								if (ember[2].getXCenter() == 540) {
									ember[2].lose();
								}
								
								EZ.refreshScreen();
							}
							
							pokemon[1].superEffectiveSound();	// play super effective sound

							for (int i = 0;i<6;i++) {
								
								bubble[3].hide();		//hide bubbles at current position
								bubble[4].hide();
								bubble[5].hide();
				
								pokemon[1].hide();			// animation for pokemon getting hit
								for (int j = 0;j<6;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
								pokemon[1].appear();
								for (int j = 0;j<5;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
							}
			
							player1Life.loseHealth();       // player 1 loses health
							
							if(player1Life.redCheck() == true && critMusicCounter == 0) { // plays critical health music when hp is red
								backgroundMusic.pause();
								critHealthMusic.play();
								critMusicCounter++;
							}
							
							if(player1Life.check()== true) {   // checks is player 1 is dead
								player2Victor++;
								break;
							}
							
							
							pokemon[1].tp(100,400);		// reset pokemon back to original spots
							pokemon[5].tp(1100,600);
						}
						
						
				case7: if(choice1 == 2 && choice2 == 3) {		// scissors and rock (Water AND Grass)
							
							pokemon[2].tp(300,400);		// teleport pokemon to middle
							pokemon[3].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							bubble[0].appearLeft(xLeft0);	// show bubble projectiles on left side
							bubble[1].appearLeft(xLeft1);
							bubble[2].appearLeft(xLeft2);
							
							razor[3].appearRight(xRight0);	// show razor projectiles on right side
							razor[4].appearRight(xRight1);
							razor[5].appearRight(xRight2);
							
							for (int i = 0;i<110;i++) {		
								
								bubble[0].move(5);		// move bubble projectiles 					
								bubble[1].move(5);						
								bubble[2].move(5);
								
								razor[3].move(xRight0);		// move razor projectiles
								razor[4].move(xRight1);	
								razor[5].move(xRight2);	
								
								if (bubble[0].getXCenter() == 600) {	//once bubbles reaches middle, they disappear
									bubble[0].lose();
								}
								if (bubble[1].getXCenter() == 570) {
									bubble[1].lose();
								}
								if (bubble[2].getXCenter() == 540) {
									bubble[2].lose();
								}
								
								EZ.refreshScreen();
							
								xRight0= xRight0 - 5;		//increment xRight variables by 5 for each loop
								xRight1= xRight1 - 5;
								xRight2= xRight2 - 5;
							}
							
							pokemon[2].superEffectiveSound();	// play super effective sound
							
							for (int i = 0;i<6;i++) {
								
								razor[3].hide();		//hide razor leaves at current position
								razor[4].hide();
								razor[5].hide();
								
								pokemon[2].hide();			// animation for pokemon getting hit
								for (int j = 0;j<6;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
								pokemon[2].appear();
								for (int j = 0;j<5;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
							}
	
							
							
							player1Life.loseHealth();         //player 1 loses health 
							
							if(player1Life.redCheck() == true && critMusicCounter == 0) { // plays critical health music when hp is red
								backgroundMusic.pause();
								critHealthMusic.play();
								critMusicCounter++;
							}
							
							if(player1Life.check()== true) {  // Checks is player 1 is dead 
								player2Victor++;
								break;
							}
							
							pokemon[2].tp(100,600);		// reset pokemon back to original spots
							pokemon[3].tp(1100,200);
						}		
					
						
						
						
				case8: if(choice1 == 2 && choice2 == 4) {		// scissors and paper (Water AND Fire)
							
							pokemon[2].tp(300,400);		// teleport pokemon to middle
							pokemon[4].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							bubble[0].appearLeft(xLeft0);	// show razor leaf projectiles on left side
							bubble[1].appearLeft(xLeft1);
							bubble[2].appearLeft(xLeft2);
							
							ember[3].appearRight(xRight0);	// show bubble projectiles on right side
							ember[4].appearRight(xRight1);
							ember[5].appearRight(xRight2);
							
							for (int i = 0;i<110;i++) {		
								
								bubble[0].move(5);		// move razor leaf projectiles 					
								bubble[1].move(5);						
								bubble[2].move(5);
								
								ember[3].move(5);		// move bubble projectiles
								ember[4].move(5);	
								ember[5].move(5);	
								
								if (ember[3].getXCenter() == 600) {	//once ember reaches middle, they disappear
									ember[3].lose();
								}
								if (ember[4].getXCenter() == 630) {
									ember[4].lose();
								}
								if (ember[5].getXCenter() == 660) {
									ember[5].lose();
								}
								
								EZ.refreshScreen();
					
							}
							
							pokemon[2].superEffectiveSound();	// play super effective sound
							
							ember[3].resetRight();		// reset ember image orientation
							ember[4].resetRight();
							ember[5].resetRight();
							
							for (int i = 0;i<6;i++) {
								
								bubble[0].hide();		//hide bubbles at current position
								bubble[1].hide();
								bubble[2].hide();
								
								pokemon[4].hide();			// animation for pokemon getting hit
								for (int j = 0;j<6;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
								pokemon[4].appear();
								for (int j = 0;j<5;j++) {
									time.moveForward(8);
									EZ.refreshScreen();
								}
							}
	
							
							
							player2Life.loseHealth();      // player 2 loses health
							
							if(player2Life.redCheck() == true && critMusicCounter == 0) { // plays critical health music when hp is red
								backgroundMusic.pause();
								critHealthMusic.play();
								critMusicCounter++;
							}
							
							if(player2Life.check()== true) { // checks if player 2 is dead
								player1Victor++;
								break;
							}
							
							
							pokemon[2].tp(100,600);		// reset pokemon back to original spots
							pokemon[4].tp(1100,400);
						}	
						
				case9: if(choice1 == 2 && choice2 == 5) {		// scissor and scissor (Water AND Water)
							
							pokemon[2].tp(300,400);		// teleport pokemon to middle
							pokemon[5].tp(900,400);		
			
							for (int j = 0;j<30;j++) {		// for loop to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							bubble[0].appearLeft(xLeft0);	// show bubble projectiles on left side
							bubble[1].appearLeft(xLeft1);
							bubble[2].appearLeft(xLeft2);
							
							bubble[3].appearRight(xRight0);	// show bubble projectiles on right side
							bubble[4].appearRight(xRight1);
							bubble[5].appearRight(xRight2);
							
							for (int i = 0;i<105;i++) {		
								
								bubble[0].move(5);		// move bubble projectiles 					
								bubble[1].move(5);						
								bubble[2].move(5);
								
								bubble[3].move(-5);		// move bubble projectiles
								bubble[4].move(-5);	
								bubble[5].move(-5);	
								
								if (bubble[3].getXCenter() == 600) {	//once bubble reaches middle, they disappear
									bubble[3].lose();
									bubble[0].lose();
								}
								if (bubble[4].getXCenter() == 630) {
									bubble[4].lose();
									bubble[1].lose();
								}
								if (bubble[5].getXCenter() == 660) {
									bubble[5].lose();
									bubble[2].lose();
								}
								
								EZ.refreshScreen();
		
							}

							for (int j = 0;j<34;j++) {		// code to stall for time
								time.moveForward(8);
								EZ.refreshScreen();
							}
							
							pokemon[2].tp(100,600);		// reset pokemon back to original spots
							pokemon[5].tp(1100,600);
						}				
									
					choice1 = 0;		// reset all variables to original values
					choice2 = 0;
					ready1 = 0;
					ready2 = 0;
					xLeft0 =300;
					xLeft1 =330;
					xLeft2 =360;
					xRight0 =900;
					xRight1	= 870;
					xRight2 =840;	
			}
				
			EZ.refreshScreen();
		}
			
		instructions1.pushToBack();		// pushes instructions to the back of screen once game ends
		instructions2.pushToBack();
		instructions3.pushToBack();
		
		if(player1Victor == 1) {
			critHealthMusic.pause();
			victoryMusic.play();
			Color c = new Color(0, 0, 150);  // change color of font
			int fontsize= 50; 			// change font size
			EZText text = EZ.addText(600, 140, "PLAYER 1 WINS", c, fontsize);  // add text "YOU LOSE"
			text.setFont("8-BIT WONDER.TTF");
		}
		
		if(player2Victor == 1) {
			critHealthMusic.pause();
			victoryMusic.play();
			Color c = new Color(0, 0, 150);  // change color of font
			int fontsize= 50; 			// change font size
			EZText text = EZ.addText(600, 140, "PLAYER 2 WINS", c, fontsize);  // add text "YOU LOSE"
			text.setFont("8-BIT WONDER.TTF");
		}
					
	}

}
