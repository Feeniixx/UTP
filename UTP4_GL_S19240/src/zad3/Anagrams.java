package zad3;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Anagrams {


    private List<String> allWords = new LinkedList<>();
    private List<List> listas = new LinkedList<>();

    public Anagrams(String fname) {
        try {
            File file = new File(fname);
            BufferedReader bfr;
            bfr = new BufferedReader(new FileReader(file));
            String text;

            if ((text = bfr.readLine()) != null) {
                do {
                    String[] arr = text.split("( )");
                    allWords.addAll(Arrays.asList(arr));
                } while ((text = bfr.readLine()) != null);
            }
        } catch (IOException e) {
            System.out.println("Problem z plikom");
            e.printStackTrace();
        }
    }

    public List<List> getSortedByAnQty() {

        List<String> nowy = new ArrayList<String>();
        for (int i = allWords.size() - 1; i >= 0; i--) {
            if (nowy.contains(allWords.get(i))) {
                continue;
            }
            List<String> tymczasowy = new ArrayList<String>();
            int j = 0;
            while (j < allWords.size()) {
                if (porownanie(allWords.get(i), allWords.get(j))) {
                    nowy.add(allWords.get(j));
                    tymczasowy.add(allWords.get(j));
                }
                j++;
            }
            listas.add(tymczasowy);
        }
        listas.sort(new Comparator<List>() {
            @Override
            public int compare(List o1, List o2) {
                return o2.size() - o1.size();
            }
        });
        return listas;
    }
    private static boolean porownanie(String jeden, String dwa) {
        char Pierwszy[] = jeden.toLowerCase().toCharArray();
        char Drugi[] = dwa.toLowerCase().toCharArray();
        if (Pierwszy.length != Drugi.length)
            return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < Drugi.length; i++) {
            alphabet[Pierwszy[i] - 97]++;
            alphabet[Drugi[i] - 97]--;
        }
        for (int i = 0; i < 26; i++)
            if (alphabet[i] != 0) {
                return false;
            }
        return true;
    }

    public String getAnagramsFor(String word) {
        String wynik = word;
        for (int i = 0, listasSize = listas.size(); i < listasSize; i++) {
            List list = listas.get(i);
            if (!list.contains(word)) {
                continue;
            }
            list.remove(word);
            wynik = word + ": " + list;
            break;
        }
        return wynik;
    }



}




