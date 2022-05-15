# wordle-game
### A self-implementation of the game Wordle in Java
The word game called Wordle has recently become extremely popular online. Articles about the game seem to be everywhere you look. 

It even made an appearance in a recent skit on Saturday Night Live!

##### Rules of the game
In **Wordle**, the user is given 6 chances to guess a 5-letter English word. After each guess, the user is given feedback about 

how close their guess was to the “mystery” word (the word they are trying to guess).

In the online version of Wordle, feedback about a guess is given using colored tiles. 

Because our version runs in the console, we’ll take an approach that relies purely on text characters for feedback.

For example, imagine that the mystery word is "depth" and that the user guesses "heart". To provide feedback on that guess,

the program would print the **following:**

**[h] e _ _ [t]**
