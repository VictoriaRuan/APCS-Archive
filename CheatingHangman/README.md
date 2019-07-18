# CheatingHangman

Hangman is a paper and pencil guessing game for two players. One player thinks of a word and the other tries to guess it by suggesting letters. The word to guess is represented by a pattern that initially contains a sequence of underscores (_). Herewith, each underscore represents a letter of the word. The number of underscores in the initial pattern thus corresponds to the number of letters in the word to guess.



If the guessing player suggests a letter which occurs in the word, the other player fills up the pattern at all open positions (indicated by underscores) where the letter occurs in the word. If the suggested letter does not occur in the word, the other player draws one element of a hanged man stick figure as a tally mark. The guessing player wins the game if he completes all letters of the word before all elements of the hanged man stick figure have been drawn. Otherwise the other player wins the game.



The aim of this assignment is to make an implementation of the player of the hangman game that thinks of a word that the other player must guess. Only words containing lowercase letters are considered. The player, however, make use of a cheating strategy that makes it as a hard as possible for the other player to win the game. The idea behind this strategy is simple. Instead of choosing a fixed word of a given length 𝑛n at the start of the game, the player initially considers all words of length 𝑛n as possible candidates. Each time the other player suggests a new letter, the player fills the pattern in such a way that the number of remaining candidates that are consistent with the pattern and all suggested letters is maximized.