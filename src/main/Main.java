package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	static Game game = new Game();
	static Scanner scan = new Scanner(System.in);
	static int roll1, roll2, frameScore = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new FrontView();

		newGame();

	}

	private static void newGame() throws IOException, FileNotFoundException {

		String fileName = "newFile.txt";
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		
		System.out.print("플레이어 몇 명? ");
		int numberOfPlayer = scan.nextInt();

		for (int i = 0; i < numberOfPlayer; i++) {
			boolean flag = false;

			System.out.print("첫번째 볼 ");
			roll1 = scan.nextInt();
			game.roll(roll1);
			if (roll1 == 10) {

				System.out.println("스트라이크");
				game.roll(0);
				flag = true;
			}

				if (flag == false) {
			
				System.out.print("두번째 볼 ");
				roll2 = scan.nextInt();
				game.roll(roll2);
				if (roll1 + roll2 == 10) {
					System.out.println("스페어");
				}
			}
			frameScore = game.getScore();
			
			scoreList.add(roll1);
			scoreList.add(roll2);
			scoreList.add(frameScore);

			//bw = new BufferedWriter(new FileWriter(file));
			bw.write(scoreList.get(i));
			bw.write(scoreList.get(i + 1));
			bw.write(scoreList.get(i + 2));
			bw.newLine();
			bw.flush();
			bw.close();
			System.out.println(scoreList.get(i));
			System.out.println(scoreList.get(i+1));
			System.out.println(scoreList.get(i+2));
			System.out.println("저장");
		}
	}

}
/*
class scoreArray {
	int pins1, pins2, score;

	public scoreArray() {
	}

	public scoreArray(int p1, int p2, int s) {
		pins1 = p1;
		pins2 = p2;
		score = s;
	}

	public int getPins1() {
		return pins1;
	}

	public int getPins2() {
		return pins2;
	}

	public int getScore() {
		return score;
	}

	public void setPins1() {
		this.pins1 = pins1;
	}

	public void setPins2() {
		this.pins2 = pins2;
	}

	public void setScore() {
		this.score = score;
	}
}
*/