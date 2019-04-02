# correct-horse

# Diceware Passphrase Generator


This project was inspired by the system of generating a memorable (but largely uncrackable) passphrase using dice, also called Diceware.
Read more about this system here: http://world.std.com/~reinhold/diceware.html
Obviously this project doesn't use real dice but simulated ones, for the sake of convenience and speed in generating a new 
yet entirely random passphrase each time the program is run.

## Installing / Getting started

To run this program, clone the repository and import the project to your IDE, then compile and run the Application.java class.


When a user runs the program, they will be prompted to enter a number of words they wish to use for their passphrase, with a few suggestions. More words is more secure, but also could prove harder to remember/memorize. 

Once a valid number has been chosen, the program will begin 'rolling dice' to create the secure numbers to look up in the textfile included in the repository. In the 'diceware.wordlist.txt' file, there is a long list of words, in the following format: 
'11124	ababa' - the 5 numbers before the password are numbers generated by rolling a dice 5 times. 

We speed this process up using Java's secureRandom (see here - http://world.std.com/~reinhold/dicewarefaq.html#electronic) , but in the real world physical dice are always preferred. For our purposes and convenience, secureRandom is random enough and quickly gives us our lookup numbers (each word in the phrase requires 5 rolls).

Once we have these numbers we look them up in the text file and string together our newly generated passphrase.

## Features

Using this program, a user can pick a passphrase of varying strength, from 4-8 words long (any more than 8 is overkill for the most part, but a determined user could certainly program this functionality easily enough) and then receive a passphrase of the chosen length. The words that make up these phrases are carefully chosen from the english language and you can read more about it on the sites listed below under Sources.

## Examples

Example:
Enter a number from 4 - 8:    5

Output: 
Passphrase completed! Here is your newly generated passphrase:
==================================================================================
oz floppy curse 7777 filler
==================================================================================

Example:
Enter a number from 4 - 8:    8

Output: 
Passphrase completed! Here is your newly generated passphrase:
==================================================================================
under pearl showy being maxim novo drool fur
==================================================================================

Note: These are just examples and should not be chosen as a real password!! Always create and store your own password somewhere safe, do not share a real password over any internet webpages!

## Contributing

If you'd like to contribute, please fork the repository and use a feature
branch. Pull requests are warmly welcome.

## Links


- Repository: https://github.com/circletakesthesquare/correct-horse/
- Sources: http://world.std.com/~reinhold/diceware.html
- Sources: http://world.std.com/~reinhold/dicewarefaq.html#electronic
- Text file used from the site listed above: http://world.std.com/~reinhold/diceware8k.txt

- Related projects:
  - Weightlifting 1-Rep-Max Calculator: https://github.com/circletakesthesquare/pounds-or-kilos



## Licensing

The code in this project is licensed under MIT license.