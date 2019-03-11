package test;

import junit.framework.TestCase;

import main.Game;

public class TestGame extends TestCase {

	public TestGame(String name) {
		super(name);
	}

	private Game game;

	public void setUp() {
		game = new Game();
	}

	public void testCanRoll() {
		Game game = new Game();
		game.roll(0);
	}

	public void testGutterGame() {
		rollMany(0, 20);
		assertEquals(0, game.getScore());
	}

	public void testAllOnes() {
		rollMany(1, 20);
		assertEquals(20, game.getScore());
	}

	public void testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.getScore());
	}

	public void testOneStrike() {
		rollStrike();
		game.roll(5);
		game.roll(3);
		rollMany(16, 0);
		assertEquals(26, game.getScore());
	}

	public void testPerfectGame() {
		rollMany(10, 10);
		game.roll(10);
		game.roll(10);
		assertEquals(300, game.getScore());
	}

	public void testHalfPerfectGame() {
		rollMany(5, 20);
		game.roll(5);
		assertEquals(150, game.getScore());
	}

	private void rollMany(int pins, int frames) {
		for (int i = 0; i < frames; i++)
			game.roll(pins);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}

	private void rollStrike() {
		game.roll(10);
	}
}
