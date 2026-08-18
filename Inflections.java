import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

//Conjugates the verb to the given inflection
public class Inflections
{
    public String getWordBase(String word)
    {
        String base = "";
        for (int i = 0; i < word.length()-1; i++)
        {
            base += word.charAt(i);
        }
        return base;
    }
    public String teForm(List<String> input)
    {
        String word = input.get(1);
        String answer = "";
        if (input.get(4).equals("ichidan"))
        {
            answer += getWordBase(word);
            answer += "て";
            return answer;
        }
        else if (input.get(4).equals("irregular"))
        {
            if (word.equals("する"))
            {
                return "して";
            }
            else if (word.equals("くる"))
            {
                return "きて";
            }
            else
            {
                return "いって";
            }
        }
        else
        {
            if (word.charAt(word.length()-1)=='る'||word.charAt(word.length()-1)=='う'||word.charAt(word.length()-1)=='つ')
            {
                return getWordBase(word) + "って";
            }
            else if (word.charAt(word.length()-1)=='ぶ'||word.charAt(word.length()-1)=='む'||word.charAt(word.length()-1)=='ぬ')
            {
                return getWordBase(word) + "んで";
            }
            else if (word.charAt(word.length()-1)=='く')
            {
                return getWordBase(word) + "いて";
            }
            else if (word.charAt(word.length()-1)=='ぐ')
            {
                return getWordBase(word) + "いで";
            }
            else
            {
                return getWordBase(word) + "して";
            }
        }
    }

    public String taForm(List<String> input)
        {
            String answer = teForm(input);
            if (answer.charAt(answer.length()-1)=='て')
            {
                answer = answer.substring(0,answer.length()-1) + 'た';
            }
            else
            {
                answer = answer.substring(0,answer.length()-1) + 'だ';
            }
            return answer;
        }

    public String naiForm(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = "";
        String word = input.get(1);
        if(input.get(4).equals("ichidan"))
        {
            answer = getWordBase(word) + "ない";
            return answer;
        }
        else if (input.get(4).equals("irregular"))
        {
            if (word.equals("する"))
            {
                return "しない";
            }
            else if (word.equals("くる"))
            {
                return "こない";
            }
            else
            {
                return "いかない";
            }
        }
        else
        {
            String end = Character.toString(word.charAt(word.length()-1));
            answer = getWordBase(word) + kanaRootMap.get(end).get(0) + "ない";
        }
        return answer;
    }

    public String naiFormPast(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = naiForm(input, kanaRootMap);
        answer = answer.substring(0,answer.length()-1) + "かった";
        return answer;
    }

    public String masuForm(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = "";
        String word = input.get(1);
        if(input.get(4).equals("ichidan"))
        {
            answer = getWordBase(word) + "ます";
            return answer;
        }
        else if (input.get(4).equals("irregular"))
        {
            if (word.equals("する"))
            {
                return "します";
            }
            else if (word.equals("くる"))
            {
                return "きます";
            }
            else
            {
                return "いきます";
            }
        }
        else
        {
            String end = Character.toString(word.charAt(word.length()-1));
            answer = getWordBase(word) + kanaRootMap.get(end).get(1) + "ます";
        }
        return answer;
    }

    public String masuFormNegative(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = masuForm(input, kanaRootMap);
        answer = answer.substring(0,answer.length()-1) + "せん";
        return answer;
    }

    public String masuFormPast(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = masuForm(input, kanaRootMap);
        answer = answer.substring(0,answer.length()-1) + "した";
        return answer;
    }
    
    public String masuFormNegativePast(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = masuFormNegative(input, kanaRootMap);
        answer += "でした";
        return answer;
    }

    public String potentialForm(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = "";
        String word = input.get(1);
        if(input.get(4).equals("ichidan"))
        {
            answer = getWordBase(word) + "られる";
            return answer;
        }
        else if (input.get(4).equals("irregular"))
        {
            if (word.equals("する"))
            {
                return "できる";
            }
            else if (word.equals("くる"))
            {
                return "こられる";
            }
            else
            {
                return "いける";
            }
        }
        else
        {
            String end = Character.toString(word.charAt(word.length()-1));
            answer = getWordBase(word) + kanaRootMap.get(end).get(2) + "る";
        }
        return answer;
    }

    public String passiveForm(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = "";
        String word = input.get(1);
        if(input.get(4).equals("ichidan"))
        {
            answer = getWordBase(word) + "られる";
            return answer;
        }
        else if (input.get(4).equals("irregular"))
        {
            if (word.equals("する"))
            {
                return "される";
            }
            else if (word.equals("くる"))
            {
                return "こられる";
            }
            else
            {
                return "いかれる";
            }
        }
        else
        {
            String end = Character.toString(word.charAt(word.length()-1));
            answer = getWordBase(word) + kanaRootMap.get(end).get(0) + "れる";
        }
        return answer;
    }

    public String causativeForm(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = "";
        String word = input.get(1);
        if(input.get(4).equals("ichidan"))
        {
            answer = getWordBase(word) + "させる";
            return answer;
        }
        else if (input.get(4).equals("irregular"))
        {
            if (word.equals("する"))
            {
                return "される";
            }
            else if (word.equals("くる"))
            {
                return "こさせる";
            }
            else
            {
                return "いかせる";
            }
        }
        else
        {
            String end = Character.toString(word.charAt(word.length()-1));
            answer = getWordBase(word) + kanaRootMap.get(end).get(0) + "せる";
        }
        return answer;
    }

    public String causativePassiveForm(List<String> input, Map<String,List<String>> kanaRootMap)
    {
        String answer = causativeForm(input, kanaRootMap);
        answer = answer.substring(0,answer.length()-1) + "られる";
        return answer;
    }
}