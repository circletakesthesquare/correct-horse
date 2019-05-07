package generator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

	public static void main(String[] args) {

		runApplication();

	}

	private static void runApplication() {

		System.out.println("=================================================================================="
				+ "\nHello, welcome to the Diceware Strong Passphrase Generator"
				+ "\n=================================================================================="
				+ "\nThis program allows a user to create a strong passphrase to use for security purposes. "
				+ "\n\nHow strong would you like your password to be?" + "\n4 words: Strength = good"
				+ "\n5 words: Strength = great"
				+ "\n6 words: Strength = excellent"
				+ "\n7-8 words: this is most likely overkill, but may be useful for things like bitcoin passwords, virtual wallets, etc.");

		getPassphraseStrength();

	}

	// throws error Input Mismatch Exception

	private static void getPassphraseStrength(){
		Scanner userInput = new Scanner(System.in);

		boolean goodInput = false;

		int numberWords = -1;

		do {
			try {
				System.out.print("\nEnter a number from 4 - 8:    ");
				numberWords = userInput.nextInt();

				if (numberWords < 4 || numberWords > 8) {
					goodInput = false;
					userInput.nextLine();
				} else {
					goodInput = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				userInput.next();
			}
		} while (goodInput != true);

		userInput.close();

		System.out.println("\nPassphrase strength selected, begin simulated dice roll...");

		diceRoll(numberWords);
	}

	private static void diceRoll(int numberOfWordsSelected) {

		System.out.println("\nRolling dice...");

		SecureRandom dice = new SecureRandom();

		StringBuilder numberBuilder = new StringBuilder();

		String[] idNumbers = new String[numberOfWordsSelected];

		for (int entry = 0; entry < numberOfWordsSelected; entry++) {
			for (int i = 0; i < 5; i++) {
				int randomInt = (dice.nextInt(6) + 1);
				numberBuilder.append(randomInt);
			}

			idNumbers[entry] = numberBuilder.toString();
			numberBuilder.setLength(0);
		}

		System.out.println("\nDice rolling complete, password ID numbers generated.");

		lookUpWords(idNumbers);

	}

	private static void lookUpWords(String[] idNumbers) {

		System.out.println("\nLooking up words in diceware dictionary...");

		List<String> wordList = new ArrayList<String>();

		try {
			wordList = Files.readAllLines(Paths.get("diceware.wordlist.txt"));
		} catch (IOException e) {
			System.out.println("Unable to read file.");
		}

		String diceNumber;
		String[] passwordList = new String[idNumbers.length];

		for (int i = 0; i < idNumbers.length; i++) {

			diceNumber = idNumbers[i];

			for (String currentLine : wordList) {

				if (currentLine.startsWith(diceNumber)) {
					passwordList[i] = currentLine;
				}
			}

		}

		System.out.println("\nPasswords compiled, generating passphrase...");

		createPassphrase(passwordList);

	}

	private static void createPassphrase(String[] passwordList) {

		String trimmedPassword;

		StringBuilder passphraseBuilder = new StringBuilder();

		for (int i = 0; i < passwordList.length; i++) {

			trimmedPassword = trimAndClean(passwordList[i]);

			// spacing formatting
			if (i == passwordList.length - 1)
				passphraseBuilder.append(trimmedPassword);
			else
				passphraseBuilder.append(trimmedPassword + " ");
		}

		System.out.println("\nPassphrase completed! Here is your newly generated passphrase:\n"
				+"==================================================================================\n"
				+passphraseBuilder.toString()
				+ "\n=================================================================================="
				+ "\n\nMemorize this passphrase, or store it in a safe place. Don't like this passphrase? "
				+ "Generate a new one!");

	}

	private static String trimAndClean(String line) {

		// remove leading digits, remove whitespace
		line = line.replaceFirst("\\d\\d\\d\\d\\d", "").replaceAll("\\s", "");

		return line;
	}

}
