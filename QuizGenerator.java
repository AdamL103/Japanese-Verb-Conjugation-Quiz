//Adam Laboissonniere

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class QuizGenerator {
    public final static List<String> ichidanIndicator = Arrays.asList
		(new String[]{"い","き","し","ち","に","ひ","み","り","ぎ","じ","ぢ","び","ぴ",
            "え","け","せ","て","ね","へ","め","れ","げ","ぜ","で","べ","ぺ"
        });

    public final static List<String> Irregulars = Arrays.asList
		(new String[]{"する","くる","いく"});

    public final static List<String> godanIrregulars = Arrays.asList
		(new String[]{"きる","はいる","はしる"});

    public void printFile(Scanner s)
    {
        while (s.hasNextLine())
        {
            System.out.println(s.nextLine());
        }
    }

    //Reads in a file and returns a map of its entries
    public Map<String,List<String>> getList(Scanner s)
    {
        Map<String,List<String>> verbList = new TreeMap<>();
        while(s.hasNextLine())
        {
            List<String> verbInfo = new ArrayList<>();
            String segmentedLine[] = s.nextLine().split(",");
            verbInfo.addAll(Arrays.asList(segmentedLine).subList(1,segmentedLine.length));
            verbList.put(segmentedLine[0],verbInfo);
        }
        return verbList;
    }

    public Map<String,String> getList2(Scanner s)
    {
        Map<String,String> kanaList = new TreeMap<>();
        while(s.hasNextLine())
        {
            String segmentedLine[] = s.nextLine().split(",");
            kanaList.put(segmentedLine[0],segmentedLine[1]);
        }
        return kanaList;
    }

    //Determines the type of verb a given verb is
    public Map<String,List<String>> getVerbType(Map<String,List<String>> verbs)
    {
        for (Map.Entry<String,List<String>> entry : verbs.entrySet())
        {
            List<String> mapList = entry.getValue();
            String testWord = mapList.get(0);
            if (Irregulars.contains(testWord))
            {
                mapList.add("irregular");
                continue;
            }
            else if (godanIrregulars.contains(testWord))
            {
                mapList.add("godan");
                continue;
            }
            else if (testWord.charAt(testWord.length()-1)=='る')
            {
                if (ichidanIndicator.contains(String.valueOf(testWord.charAt(testWord.length()-2))))
                {
                    mapList.add("ichidan");
                    continue;
                }
                else
                {
                    mapList.add("godan");
                    continue;
                }
            }
            else
            {
                mapList.add("godan");
            }
        }
        return verbs;
    }

    //Chooses a random word (key) from a map
    public List<String> chooseWord(Map<String,List<String>> verbs)
    {
        int mapSize = verbs.size();
        int rand = (int)(Math.random() * mapSize-1);
        List<String> keys = new ArrayList<>(verbs.keySet());
        String chosenWord = keys.get(rand);
        List<String> wordInfo = verbs.get(chosenWord);
        if (wordInfo.size()<5)
        {
            wordInfo.add(0, chosenWord);
        }
        return wordInfo;
    }

    //Transcribes Japanese hiragana to the Latin alphabet
    public String kanaToLatin(String kana, Map<String,String> kanaList)
    {
        String latinWord = "";
        for (int i = 0; i < kana.length(); i++)
        {
            String currentKana = Character.toString(kana.charAt(i));
            latinWord += kanaList.get(currentKana);
        }
        for (int i = 0; i < latinWord.length(); i++)
        {
            if (latinWord.charAt(i)=='っ')
            {
                String wordReference = latinWord;
                latinWord = "";
                for (int j = 0; j < wordReference.length(); j++)
                {
                    if (wordReference.charAt(j)=='っ')
                    {
                        latinWord += wordReference.charAt(i+1);
                    }
                    else
                    {
                        latinWord += wordReference.charAt(j);
                    }
                }
            }
        }
        return latinWord;
    }

    //Returns true if user's input matches the correct answer
    public boolean isCorrect(String answer, String input, Map<String,String> kanaList)
    {
        String latinAnswer = kanaToLatin(answer, kanaList);
        if (input.equals(answer)||input.equals(latinAnswer))
        {
            return true;
        }
        return false;
    }

    //Wraps a string to a list (matching the input of the inflection methods)
    public List<String> wrapWord(String word, Map<String,String> kanaList, String translation)
    {
        List<String> wordInfo = new ArrayList<>();
        wordInfo.add(word);
        wordInfo.add(word);
        wordInfo.add(kanaToLatin(word, kanaList));
        wordInfo.add(translation);
        wordInfo.add("ichidan");
        return wordInfo;
    }

    //Starts quiz
    public void startGame(Map<String,List<String>> verbs, Map<String,String> kanaList, Map<String,List<String>> kanaRootMap)
    {
        Scanner input = new Scanner(System.in);
        ChooseVerbForm choose = new ChooseVerbForm();
        boolean end = false;
        boolean showAnswers = false;
        boolean inJapanese = false;
        while (true)
        {
            System.out.println("Display answers? Type 'y' for yes or 'n' for no.");
            String response = input.nextLine();
            if (response.equals("y"))
            {
                showAnswers = true;
                break;
            }
            else if (response.equals("n"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid input.");
            }
        }
        while (true)
        {
            System.out.println("To display words in Japanese, enter '1', and for the Latin alphabet, type '2'.");
            String response = input.nextLine();
            if (response.equals("1"))
            {
                inJapanese = true;
                break;
            }
            else if (response.equals("2"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid input.");
            }
        }
        while (!end)
        {
            List<String> chosenWord = chooseWord(verbs);
            List<String> answerList = choose.chooseForm(chosenWord, kanaList, kanaRootMap);
            String answer = answerList.get(0);
            while (true)
            {
                if (inJapanese)
                {
                    System.out.println("Word: " + chosenWord.get(0) + "   " + "(" + chosenWord.get(1) + ")");
                }
                else
                {
                    System.out.println("Word: " + chosenWord.get(2));
                }
                System.out.println("Meaning: " + chosenWord.get(3));
                if (showAnswers)
                {
                    System.out.println("Answer: " + kanaToLatin(answer, kanaList));
                }
                System.out.println("");
                System.out.print(answerList.get(1));
                String response = input.nextLine();
                if (isCorrect(answer, response, kanaList))
                {
                    System.out.println("Correct!");
                    System.out.println("");
                    break;
                }
                else if (response.equals("quit"))
                {
                    end = true;
                    break;
                }
                else if (response.equals("skip"))
                {
                    System.out.println("The correct answer was " + answer + " " + "(" + kanaToLatin(answer, kanaList) + ").");
                    System.out.println("");
                    break;
                }
                else
                {
                    System.out.println("Incorrect");
                    System.out.println("Try again");
                    System.out.println("");
                }
            }
        }
        input.close();
    }
}
