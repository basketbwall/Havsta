// William Huang section 5
// Februrary 18 2019
// Assignment 5. A Game
//
//This program simulates the two-player game of Havsta. The user plays against the computer.

import java.util.Scanner;
import java.util.Random;

public class Game {
	
	static int roundsplayed = 0;
	static int computerwon = 0;
	static int humanwon = 0;
	
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		showrules();
		System.out.println("Would you like to play? y/n");
		String gamestatus = kb.next().toLowerCase();
		while (checkstartmenu(gamestatus) == false) { //if not y or n, keep asking
			System.out.println("Please enter y or n.");
			gamestatus = kb.next().toLowerCase();
		}
		while (gamestatus.equals("y")) { //if user said y, game will run
			String humanmove = ask(kb);
			while (checkvalidmove(humanmove) == false) { //if not valid move, keep asking
				System.out.println("That's not one of the choices");
				humanmove = ask(kb);
			}
			if (humanmove.equals("q") == false) { //if user didn't choose q to quit, play a round
				System.out.print("You chose " + capitalizefirst(humanmove) + '!');
				roundsplayed ++;
				Random rand = new Random();
				int x = rand.nextInt(4); // generates random number to input into computermove method
				announcewinner(humanmove, computermove(x));
			} else {
				gamestatus = "n"; //user chose q so gamestatus set to n, so while loop finishes
			}
			System.out.println("Would you like to continue playing? y/n");
			gamestatus = kb.next().toLowerCase();
			while (checkstartmenu(gamestatus) == false) {
				System.out.println("Please enter y or n.");
				gamestatus = kb.next().toLowerCase();
			}
		}
		kb.close();
		System.out.println("See you next time! " + "Rounds played: " + roundsplayed + ',' +
				" Times you have won: " + humanwon + ',' + " Times computer has won: " + computerwon);
		
	}
	
	public static void showrules() { 
		System.out.println("Here are the rules:\n" + "Applaro beats Svartra and Tunholmen\n" + "Svartra beats Tunholmen\n"
				+ "Tunholmen beats Godafton\n" + "Godafton beats Applaro and Svartra\n" + 
				"The Computer wins in the event of a tie.\n");
	}
	
	public static String ask(Scanner response) { 
		System.out.println("Enter your choice: Svartra, Tunholmen, Applaro, or Godafton or Q to open start menu.");
		String answer = response.next().toLowerCase();
		return answer;
	}
	
	public static boolean checkvalidmove(String s) { 
		if (s.equals("svartra")) {
			return true;
		} else if (s.equals("applaro")) {
			return true;
		} else if (s.equals("tunholmen")) {
			return true;
		} else if (s.equals("godafton")) {
			return true;
		} else if (s.equals("q")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void announcewinner(String human, String computer) { //calls method below it for help
		String totalmoves = human + computer;
		String higher = checkhigher(human, computer);
		if (higher == "") { //this only happens if the strings are the same, so tie, computer wins
			System.out.println("Tie! Computer wins!");
			computerwon++;
		} else if (totalmoves.indexOf(higher) < totalmoves.indexOf(computer)){ //uses index of totalmoves to figure out winner
			humanwon++;
			System.out.println("You win!");
		} else {
			computerwon++;
			System.out.println("Computer wins!");
		}
	}
	
	public static String checkhigher(String human, String computer) { //checks which string is the winner
		String totalmoves = human + computer;
		String higher = "";
		if (totalmoves.contains("svartra") && totalmoves.contains("tunholmen")) {
			System.out.println("Svartra beats Tunholmen");
			higher = "svartra";
		} else if (totalmoves.contains("svartra") && totalmoves.contains("applaro")) {
			System.out.println("Applaro beats Svartra");
			higher = "applaro";
		} else if (totalmoves.contains("svartra") && totalmoves.contains("godafton")) {
			System.out.println("Godafton beats Svartra");
			higher = "godafton";
		} else if (totalmoves.contains("applaro") && totalmoves.contains("godafton")) {
			System.out.println("Godafton beats Applaro");
			higher = "godafton";
		} else if (totalmoves.contains("tunholmen") && totalmoves.contains("godafton")) {
			System.out.println("Tunholmen beats Godafton");
			higher = "tunholmen";
		} else if (totalmoves.contains("tunholmen") && totalmoves.contains("applaro")) {
			System.out.println("Applaro beats Tunholmen");
			higher = "applaro";
		}
		return higher;
	}
	
	public static String computermove(int x) { 
		if (x == 0) {
			System.out.println(" Computer chose Svartra!");
			return "svartra";
		} else if (x == 1) {
			System.out.println(" Computer chose Applaro!");
			return "applaro";
		} else if (x == 2) {
			System.out.println(" Computer chose Tunholmen!");
			return "tunholmen";
		} else {
			System.out.println(" Computer chose Godafton!");
			return "godafton";
		}
	}
	
	public static boolean checkstartmenu(String n) { 
		if (n.equals("y")) {
			return true;
		} else if (n.equals("n")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String capitalizefirst(String x) { 
		String firstletter = x.substring(0,1).toUpperCase();
		return (firstletter + x.substring(1));
	}
	
}
