package CheatingHangman;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheatingHangman {

	ArrayList<String> Words = new ArrayList<String>();
	int wordLength;
	int round = 1;
	int maxRound;
	boolean win = false;
	char c;
	StringBuilder output = new StringBuilder();
	StringBuilder characters = new StringBuilder();
	StringBuilder available = new StringBuilder();

	public CheatingHangman() {
		play();
	}

	public static void main(String[] args) {
		CheatingHangman myCheatingHangman = new CheatingHangman();
	}

	/**
	 * This method is created the general control play method that keeps the program
	 * running and determine if the player wins or loses.
	 * 
	 * @return void
	 */
	public void play() {
		Scanner input = new Scanner(System.in);
		System.out.println(
				"Please enter the length of a word you want to guess. \nHint: The longer word has a better chance of winning!");
		wordLength = input.nextInt();
		System.out.println("Easy: 1, Intermediate: 2, Hard: 3. Type the level you want to try.");
		int level = input.nextInt();
		if (level == 1) {
			maxRound = 23;
		} else if (level == 2) {
			maxRound = 18;
		} else if (level == 3) {
			maxRound = 12;
		}
		System.out.println("You have totally " + maxRound + " rounds to guess.");
		extract();

		for (int i = 0; i < wordLength; i++) {
			output.append("_ ");
		}

		for (int i = 0; i < 26; i++) {
			available.append((char) ('a' + i));
		}

		while (round < maxRound && !win) {
			// printOutput();
			System.out.println(output);
			System.out.println("\nChosen characters: " + characters);
			System.out.println("Available characters: " + available);
			System.out.println("\nRound " + round + ": Please enter an acceptible character.");

			c = input.next().toLowerCase().charAt(0);

			if (characters.indexOf(c + "") > -1) {
				System.out.println("Sorry, you have already chosen this one. Try one of the available:) \n\n");
			} else if (checkCode()) {
				characters.append(c + " ");
				available.delete(available.indexOf(c + ""), available.indexOf(c + "") + 1);
				if (!contains()) {
					System.out.println("\nThe character is not in the word.\n");
				} else {
					if (notAllContains()) {
						sameDelete();
					} else {
						System.out.println("\nYou are right. The character is in the word!\n");
						display();
					}
				}

				round++;
			} else {
				System.out.println("\nInvalid input.");
			}
			String result = trimWord();
			if (Words.size() == 1 && result.equals(Words.get(0)))
				win = true;

		}

		if (win)
			System.out.println("This is the right word! You win!");
		else
			System.out.println("Sorry, you loose.");

		System.out.println("The word is " + Words.get(0));
		input.close();
	}

	/**
	 * This method trims all the white space in the string.
	 * 
	 * @return trimmed string
	 */

	public String trimWord() {
		StringBuilder result = new StringBuilder(output.toString());
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == ' ') {
				result.delete(i, i + 1);
				i--;
			}
		}
		return result.toString();
	}

	/**
	 * This method is created to print out the remaining words in the word list.
	 * This helps programmer to check if the program actually works.
	 * 
	 * @return void
	 */

	public void printOutput() {
		for (int i = 0; i < Words.size(); i++) {
			System.out.println(Words.get(i));
		}
	}

	/**
	 * This method is created to extract all the words in the dictionary with a
	 * certain length.
	 * 
	 * @param s a word in the dictionary
	 * 
	 * @return void
	 */
	public void extract() {
		try {
			Scanner sc = new Scanner(new File("dictionary.txt"));
			while (sc.hasNext()) {
				String s = sc.nextLine();
				if (s.length() == wordLength) {
					Words.add(s.toLowerCase());
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is created to check if any of the word contains the letter that
	 * the player enters. If no word contains the letter, no word can be deleted
	 * from the ArrayList.
	 * 
	 * @return boolean
	 */

	public boolean contains() {
		// if (notAllContains()) {
		for (int i = 0; i < Words.size(); i++) {
			if (Words.get(i).indexOf(c) >= 0) {
				return true;
			}
		}
		// }
		return false;
	}

	/**
	 * This method is created to delete all the words that contain the letter the
	 * player enters.
	 * 
	 * @return void
	 */
	public void sameDelete() {
		for (int i = 0; i < Words.size(); i++) {
			if (Words.get(i).indexOf(c + "") >= 0) {
				Words.remove(i);
				i--;
			}
		}
		System.out.println("The word does not contain this letter.");
	}

	/**
	 * This gets the index of the most frequent character and display the output.
	 * 
	 * @return void
	 */

	public void display() {
		getWord();
		int charPlace = Words.get(0).indexOf(c + "");
		boolean displayAgain = true;
		while (displayAgain) {
			output.replace(2 * charPlace, 2 * charPlace + 2, c + " ");
			System.out.println(output);
			charPlace = Words.get(0).indexOf(c + "", charPlace + 1);
			if (charPlace < 0)
				displayAgain = false;
		}

	}

	/**
	 * This generates a boolean showing whether all of the strings in this array
	 * list contain the input character.
	 * 
	 * @return true if some of words don't contain the character
	 */
	public boolean notAllContains() {
		for (int i = 0; i < Words.size(); i++) {
			if (!Words.get(i).contains("" + c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This check if the input is a valid character.
	 * 
	 * @return true if valid.
	 */

	public boolean checkCode() {
		if ('a' <= c && 'z' >= c) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This filters out all the words with all input character at the exact same
	 * positions.
	 * 
	 * @param s a word randomly picked from the available words
	 * @return void
	 */
	public void getWord() {
		String s = Words.get((int) Math.random() * Words.size());
		for (int i = 0; i < s.length(); i++) {
			if (c == s.charAt(i)) {
				for (int j = 0; j < Words.size(); j++) {
					if (Words.get(j).charAt(i) != c) {
						Words.remove(j);
						j--;
					}
				}
			}
		}
	}
}
