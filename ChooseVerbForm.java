import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

//Chooses a random verb conjugation
public class ChooseVerbForm {
    public List<String> chooseForm(List<String> chosenWord, Map<String,String> kanaList, Map<String,List<String>> kanaRootMap)
    {
        List<String> answerList = new ArrayList<>();
        QuizGenerator gen = new QuizGenerator();
        Inflections inflect = new Inflections();
        int rand = (int)(Math.random() * 44) + 1;
        if (rand==1)
        {
            answerList.add(inflect.teForm(chosenWord));
            answerList.add("Conjugate the verb to the て (te) form: ");
            return answerList;
        }
        else if (rand==2)
        {
            answerList.add(inflect.taForm(chosenWord));
            answerList.add("Conjugate the verb to past form: ");
            return answerList;
        }
        else if (rand==3)
        {
            answerList.add(inflect.naiForm(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the negative form: ");
            return answerList;
        }
        else if (rand==4)
        {
            answerList.add(inflect.naiFormPast(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the negative past form: ");
            return answerList;
        }
        else if (rand==5)
        {
            answerList.add(inflect.masuForm(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the polite form: ");
            return answerList;
        }
        else if (rand==6)
        {
            answerList.add(inflect.masuFormNegative(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the negative polite form: ");
            return answerList;
        }
        else if (rand==7)
        {
            answerList.add(inflect.masuFormPast(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the polite past form: ");
            return answerList;
        }
        else if (rand==8)
        {
            answerList.add(inflect.masuFormNegativePast(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the negative polite past form: ");
            return answerList;
        }
        else if (rand==9)
        {
            answerList.add(inflect.potentialForm(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the potential form: ");
            return answerList;
        }
        else if (rand==10)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiForm(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative potential form: ");
            return answerList;
        }
        else if (rand==11)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiFormPast(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative potential past form: ");
            return answerList;
        }
        else if (rand==12)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.teForm(firstAnswer));
            answerList.add("Conjugate the verb to the potential て (te) form: ");
            return answerList;
        }
        else if (rand==13)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.taForm(firstAnswer));
            answerList.add("Conjugate the verb to the potential past form: ");
            return answerList;
        }
        else if (rand==14)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuForm(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the potential form (polite): ");
            return answerList;
        }
        else if (rand==15)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegative(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative potential form (polite): ");
            return answerList;
        }
        else if (rand==16)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormPast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the potential past form (polite): ");
            return answerList;
        }
        else if (rand==17)
        {
            String answer = inflect.potentialForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegativePast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative potential past form (polite): ");
            return answerList;
        }
        else if (rand==18)
        {
            answerList.add(inflect.passiveForm(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the passive form: ");
            return answerList;
        }
        else if (rand==19)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiForm(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative passive form: ");
            return answerList;
        }
        else if (rand==20)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiFormPast(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative passive past form: ");
            return answerList;
        }
        else if (rand==21)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.teForm(firstAnswer));
            answerList.add("Conjugate the verb to the passive て (te) form: ");
            return answerList;
        }
        else if (rand==22)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.taForm(firstAnswer));
            answerList.add("Conjugate the verb to the passive past form: ");
            return answerList;
        }
        else if (rand==23)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuForm(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the passive form (polite): ");
            return answerList;
        }
        else if (rand==24)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegative(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative passive form (polite): ");
            return answerList;
        }
        else if (rand==25)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormPast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the passive past form (polite): ");
            return answerList;
        }
        else if (rand==26)
        {
            String answer = inflect.passiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegativePast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative passive past form (polite): ");
            return answerList;
        }
        else if (rand==27)
        {
            answerList.add(inflect.causativeForm(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the causative form: ");
            return answerList;
        }
        else if (rand==28)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiForm(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative causitive form: ");
            return answerList;
        }
        else if (rand==29)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiFormPast(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative causative past form: ");
            return answerList;
        }
        else if (rand==30)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.teForm(firstAnswer));
            answerList.add("Conjugate the verb to the causative て (te) form: ");
            return answerList;
        }
        else if (rand==31)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.taForm(firstAnswer));
            answerList.add("Conjugate the verb to the causative past form: ");
            return answerList;
        }
        else if (rand==32)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuForm(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the causative form (polite): ");
            return answerList;
        }
        else if (rand==33)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegative(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative causative form (polite): ");
            return answerList;
        }
        else if (rand==34)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormPast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the causative past form (polite): ");
            return answerList;
        }
        else if (rand==35)
        {
            String answer = inflect.causativeForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegativePast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative causative past form (polite): ");
            return answerList;
        }
        else if (rand==36)
        {
            answerList.add(inflect.causativePassiveForm(chosenWord, kanaRootMap));
            answerList.add("Conjugate the verb to the causative passive form: ");
            return answerList;
        }
        else if (rand==37)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiForm(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative causitve passive form: ");
            return answerList;
        }
        else if (rand==38)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.naiFormPast(firstAnswer, kanaRootMap));
            answerList.add("Conjugate the verb to the negative causative passive past form: ");
            return answerList;
        }
        else if (rand==39)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.teForm(firstAnswer));
            answerList.add("Conjugate the verb to the causative passive て (te) form: ");
            return answerList;
        }
        else if (rand==40)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.taForm(firstAnswer));
            answerList.add("Conjugate the verb to the causative passive past form: ");
            return answerList;
        }
        else if (rand==41)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuForm(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the causative passive form (polite): ");
            return answerList;
        }
        else if (rand==42)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegative(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative causative passive form (polite): ");
            return answerList;
        }
        else if (rand==43)
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormPast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the causative passive past form (polite): ");
            return answerList;
        }
        else
        {
            String answer = inflect.causativePassiveForm(chosenWord, kanaRootMap);
            List<String> firstAnswer = gen.wrapWord(answer, kanaList, chosenWord.get(3));
            answerList.add(inflect.masuFormNegativePast(firstAnswer,kanaRootMap));
            answerList.add("Conjugate the verb to the negative causative passive past form (polite): ");
            return answerList;
        }
    }
}
