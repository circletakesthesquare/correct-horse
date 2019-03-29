package generator;

public class Application {

	public static void main(String[] args) {
		

	}

}


/*goals:

user should be able to choose a number of words they want for their passphrase (should be from 3 - 6 words in length)

choose a length of passphrase, then roll a dice (secureRandom) 5 times, 

whatever that number, go to that line in the text and retrieve that word

then repeat for the number of words chosen

then output the passphrase, but give the user the option to increase the security even further

if they choose this option, add in a _ or & or other symbol to the middle of one of the words eg horse -> hor_se

then display the new password

--maybe give users a 'copy this password' button



diceware warns against using online generators, but is ok with java secureRandom, for our purposes and convenience im ok with using comp generated throws

http://world.std.com/~reinhold/diceware.html
http://world.std.com/~reinhold/dicewarefaq.html#electronic
http://world.std.com/~reinhold/diceware8k.txt
*/