import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Gametest {

	@Test
	/* returns true if the user enters
	 * svartra, tunholmen, applaro, godafton, or q to quit.
	 */
	void checkvalidmove() {
		assertFalse(Game.checkvalidmove("loldude"));
		assertFalse(Game.checkvalidmove(""));
		assertFalse(Game.checkvalidmove("svar"));
		assertTrue(Game.checkvalidmove("svartra"));
		assertTrue(Game.checkvalidmove("godafton"));
	}
	
	@Test
	/* returns true if user enters
	 * y or n
	 */
	void checkstartmenu() {
		assertTrue(Game.checkstartmenu("y"));
		assertTrue(Game.checkstartmenu("n"));
		assertFalse(Game.checkstartmenu("c"));
	}
	
	@Test
	/* capitalizes the first letter of a string
	 * this was necessary to make the output look nicer
	 */
	void capitalizefirst() {
		assertEquals(Game.capitalizefirst("svartra"), "Svartra");
		assertEquals(Game.capitalizefirst("godafton"), "Godafton");
	}
	
	@Test
	/* checks which string should win according to havsta rules
	 * returns blank if the moves are the same
	 */
	void checkhigher() {
		assertEquals(Game.checkhigher("svartra", "tunholmen"), "svartra");
		assertEquals(Game.checkhigher("svartra", "svartra"), "");
	}
	
	@Test
	/* returns a move given an integer number
	 * 
	 */
	void computermove() {
		assertEquals(Game.computermove(0), "svartra");
		assertEquals(Game.computermove(1), "applaro");
		assertEquals(Game.computermove(2), "tunholmen");
		assertEquals(Game.computermove(3), "godafton");
	}

}
