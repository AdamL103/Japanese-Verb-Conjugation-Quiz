# Japanese-Verb-Conjugation-Quiz
Java-based Japanese grammar quiz that generates randomized verb conjugation questions and validates hiragana or romaji answers.

Verb conjugation quiz to help Japanese language learners practice Japanese verb
conjugation. The program displays a Japanese verb and asks the user to conjugate it to the
given form, accepting answers in both the Latin alphabet and Japanese hiragana. The user can
also skip the current question by entering “skip”, and quit the quiz by entering “quit”.
The program works by creating a map of verbs from the “verbs.txt” file, which includes verbs in
Japanese as well as some information about them, such as their reading in the Latin alphabet
and their meaning. The program does the same for the files “KanatoLatin.txt” and
“HiraganaRoots.txt”. The program then determines if a verb is ichidan, godan, or irregular
depending on its ending.
When prompted to start the quiz, the program chooses a random verb from the map of verbs as
well as a random conjugation. The program conjugates the verb depending on what type of verb
it is (in Inflections.java), and returns the answer in Japanese hiragana. Depending on the
conjugation, the program may run the verb through multiple inflections. The answer is also input
to kanaToLatin(), which returns the answer transcribed in the Latin alphabet. The user is then
prompted to conjugate the chosen verb to the chosen conjugation, and compares the user’s
answer with the answer obtained through Inflections.java and the output of kanaToLatin(),
returning true if it matches one of these. The program loops this process until prompted to quit
by the user.
