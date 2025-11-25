import java.util.Scanner;

import Trie.*;

// класс Main реализован просто (с помощью тестов), тк в условии лабораторной работы не было сказано про сложную и более удобную чтению реализацию
// да, можно было бы сделать while(true), добавить scanner класс и пользователь бы сам определял работу программы, но вроде бы как
// было лишь сказано про то, чтобы реализовать класс префиксного дерева
// поэтому в Main просто наглядно демонстрируется корректная работа конкретно префиксного дерева
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrefixTrie trie = new PrefixTrie();

        String[] listWords = {"red", "java", "apple", "warhammer", "matrix", "alpha", "javascript", "rust", "javadoc"};

        System.out.println("[start]\n");

        // тест 1 на добавлению слов
        for (int i = 0; i < listWords.length; i++) {
            System.out.println("[+] добавлено слово: " + listWords[i]);
            trie.insert(listWords[i]);
        }

        System.out.println("\n[ ! ] Проверка методов префиксного дерева:");

        System.out.println("\n[1] Проверка наличия слова: ");

        // тест 2 на наличие слов в дереве
        for (int i = 0; i < listWords.length; i++) {
            System.out.println(listWords[i] + " " + ">> " + trie.contains(listWords[i]));
        }

        // тест 3 на проверку наличия определённых слов с конкретным префиксом
        System.out.print("\n[2] Проверка существования слов с префиксом: ");

        String wordOfCheckPrefix1 = "ja"; // произвольный префикс
        System.out.println(wordOfCheckPrefix1);

        System.out.println("[result] " + trie.startsWith(wordOfCheckPrefix1) + "\n");

        // тест 4 на вывод всех слов, которые соответствуют конкретному префиксу
        System.out.print("[3] Проверка получения всех слов по префиксу: ");

        String wordOfCheckPrefix2 = "java"; // произвольный префикс
        System.out.println(wordOfCheckPrefix2);

        LinkedList result = trie.getByPrefix(wordOfCheckPrefix2);

        if (result.isEmpty()) {
            System.out.println("[result] совпадений нет..");
        } else {
            LinkedList.Node currentWord = result.getHead();

            int count = 0;
            while (currentWord != null) {
                count++;
                System.out.println("{"+ count +"} "+currentWord.data);
                currentWord = currentWord.next;
            }
        }
    }
}
