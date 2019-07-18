package TwentyExpress;

import java.util.*;
import java.lang.Math;

public class TwentyExpress {
	// 20 is a lucky card, which can replace any thing.
	ArrayList<Integer> cards = new ArrayList<Integer>();
	StringBuilder order = new StringBuilder();
	String dashLine = "";
	StringBuilder playerOutput = new StringBuilder(60);
	StringBuilder computerOutput = new StringBuilder(60);
	ArrayList<Integer> playerChosen = new ArrayList<Integer>();
	ArrayList<Integer> computerChosen = new ArrayList<Integer>();
	int[] playerResult = new int[20];
	int[] computerResult = new int[20];

	
	/**Initialize the card deck and the output formats
	 * */
	public TwentyExpress() {
		for (int i = 1; i < 31; i++) {
			if (i > 10 && i <= 20) {
				cards.add(i);
				cards.add(i);
			} else {
				cards.add(i);
			}
		}
		for (int i = 1; i < 21; i++) {
			if (i < 10)
				order.append(i + "  ");
			else
				order.append(i + " ");
		}

		for (int i = 1; i < 21; i++) {
			dashLine += "↓  ";
			playerOutput.append("   ");
			computerOutput.append("   ");
		}

		// System.out.println(cards);
		play();
	}

	/**The main play method to run the game.
	 * */
	public void play() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the 20Express Game! Let's begin");
		printOutput(playerOutput);
		boolean again = false;
		int playerNewCard = 0;

		for (int i = 1; i < 21; i++) {
			// player input
			if (!again) {
				playerNewCard = randomAssign();
				System.out.println("\n\nIt's your turn. Your new card is " + playerNewCard);
				System.out.println("Type the index of the dashline you want to put the number :)");
			}
			int index = input.nextInt();
			if (index > 0 && index < 31) {
				if (playerChosen.contains(index)) {
					again = true;
					System.out.println("You have already chosen this position, type in a new one please.\n");
					i--;
				} else {
					again = false;
					playerChosen.add(index);
					playerResult[index - 1] = playerNewCard;
					changeOutput(index, playerNewCard, playerOutput);
				}
			} else {
				System.out.println("Please type a valid integer from 1 to 30");
				again = true;
				i--;
			}
			printOutput(playerOutput);

			// computer input
			if (!again) {
				int computerNewCard = randomAssign();
				System.out.println("\nIt's my turn. My new card is " + computerNewCard);
				index = computerChoose(computerNewCard);
				computerResult[index - 1] = computerNewCard;
				changeOutput(index, computerNewCard, computerOutput);
				printOutput(computerOutput);
			}
		}
		
//		for(int i:playerResult) {
//			System.out.print(i + " ");
//		}
//		for(int i:computerResult) {
//			System.out.print(i + " ");
//		}
		
		int playerScore = calculatePoints(playerResult);
		int computerScore = calculatePoints(computerResult);
		System.out.println("Your score is " + playerScore);
		System.out.println("My score is " + computerScore);
		if (playerScore > computerScore) {
			System.out.println("You win!");
		} else if (playerScore == computerScore) {
			System.out.println("A draw!");
		} else {
			System.out.println("I win!");
		}


	}
	
	/** A general print method to bundle each output statement.
	 * */
	public void printOutput(StringBuilder output) {
		System.out.println(order);
		System.out.println(dashLine);
		System.out.println(output);
	}

	/** Algorithm for computer to rationally choose where to put the number based on the probability of each number
	 * */
	public int computerChoose(int newCard) {
		// 0-9 probability: 1/40, 10-19: 1/20, 20-30:1/40
		// 0-9 and 20-30
		if (newCard < 11) {
			return generateOutput((newCard - 1) / 2) + 1;
		} else if (newCard > 20) {
			return generateOutput(15 + (newCard - 21) / 2) + 1;
		} else {
			return generateOutput(newCard - 6) + 1;
		}

	}
	
	/** Specific steps to achieve the choosing process.
	 * @param output is the designated output place
	 * @return result the computer's final choice
	 * */
	public int generateOutput(int output) {
		int result = 0;
		if (computerOutput.charAt(output * 3) == ' ') {
			result = output;
		} else {
			if (output != 19 && computerOutput.charAt((output + 1) * 3) == ' ')
				result = output + 1;
			else if (output != 0 && computerOutput.charAt((output - 1) * 3) == ' ')
				result = output - 1;
			else {
				boolean c = true;
				int random = 0;
				while (c) {
					random = (int) (Math.random() * 20 + 1);
					if (!computerChosen.contains(random))
						c = false;
				}
				result = random - 1;
			}
		}
		computerChosen.add(result + 1);
		return result;
	}
	
	
	/** Display the output in a well organized way.
	 * @param index where to change the output
	 * @param newCard the replacing value
	 * @param output the specific StringBuilder intended to be changed
	 * 
	 * */

	public void changeOutput(int index, int newCard, StringBuilder output) {
		if (newCard > 0 && newCard < 10) {
			output.replace(3 * (index - 1), 3 * (index - 1) + 1, newCard + "");
		} else {
			output.replace(3 * (index - 1), 3 * (index - 1) + 2, newCard + "");
		}
	}

	
	/** Random assign number to each player
	 * @return randomCard a random number from the available deck
	 * */
	public int randomAssign() {
		int random = (int) (Math.random() * (cards.size()));
		int randomCard = cards.get(random);
		cards.remove(random);
		return randomCard;
	}
	
	
	
	/** Calculate result for each player
	 * @param output is the number series that will be calculated
	 * @return points is the total point for the output
	 * */
	public int calculatePoints(int[] output) {
		int points = 0;
		for (int i = 0; i < output.length; i++) {
			int length = 1;
			while (i < output.length - 1 && output[i + 1] >= output[i]) {
				length++;
				i++;
			}
			if(length>1) {
				points += Math.pow(2, length - 1);
			}		
		}
		return points;
	}

	public static void main(String[] args) {
		TwentyExpress myGame = new TwentyExpress();
	}
}
