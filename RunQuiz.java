/*
Adam Laboissonniere
Driver program for Japanese Verb Conjugation Quiz
*/

import java.util.*;
import java.io.*;

public class RunQuiz
{
    public static void main (String [] args)
    {
        try
        {
            Scanner verbs = new Scanner(new File("verbs.txt"), "UTF-8");
            Scanner kanaLatin = new Scanner(new File("KanatoLatin.txt"), "UTF-8");
            Scanner kanaRoots = new Scanner(new File("HiraganaRoots.txt"), "UTF-8");
            Scanner input = new Scanner(System.in);
            QuizGenerator q = new QuizGenerator();
            Map<String,List<String>> verbMap = q.getList(verbs);
            Map<String,String> kanaList = q.getList2(kanaLatin);
            Map<String,List<String>> kanaRootMap = q.getList(kanaRoots);
            verbMap = q.getVerbType(verbMap);
            System.out.println("Welcome to the Japanese grammar quiz!");
            String choice = "";
            while (true)
            {
                System.out.println("Type 'start' to start, 'rules', for the rules, or 'quit' to quit.");
                choice = input.nextLine();
                if (choice.toLowerCase().equals("start"))
                {
                    System.out.println("Starting quiz...");
                    System.out.println("");
                    q.startGame(verbMap, kanaList, kanaRootMap);
                    break;
                }
                else if (choice.toLowerCase().equals("rules"))
                {
                    Scanner rules = new Scanner(new File("rules.txt"));
                    q.printFile(rules);
                }
                else if (choice.toLowerCase().equals("quit"))
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input.");
                }
            }
            input.close();
            verbs.close();
            kanaLatin.close();
            kanaRoots.close();
        }
        catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
}
