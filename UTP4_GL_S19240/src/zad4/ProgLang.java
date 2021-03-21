package zad4;

import java.io.FileReader;
import java.util.*;
import java.util.function.Predicate;


public class ProgLang {
    private Set<String> coders;
    private Map<String, Set<String>> langProg, progLang;
    private Map<String, List<String>> progsMap = new HashMap<>();


    public ProgLang(String string) throws Exception {
        Set<String> nameLang;
        coders = new LinkedHashSet<>();
        langProg = new LinkedHashMap<>();
        Scanner scanner = new Scanner(new FileReader(string));
        String s[];
        while (scanner.hasNext()) {
            nameLang = new LinkedHashSet<>();
            s = scanner.nextLine().split("\\t");
            for (int i = 1; i < s.length; i++) {
                nameLang.add(s[i]);
            }
            langProg.put(s[0], nameLang);
            coders.addAll(nameLang);
        }
    }

    public Map<String, Set<String>> getLangsMap() {
        return langProg;
    }

    public Map<String, Set<String>> getProgsMap() {
        Set<String> setOfLang = langProg.keySet(), langNameSet;
        String coderName, langName;
        progLang = new LinkedHashMap<>();
        for (String coder : coders) {
            langNameSet = new LinkedHashSet<>();
            coderName = coder;
            for (String aKeySet : setOfLang) {
                langName = aKeySet;
                if (langProg.get(langName).contains(coderName))
                    langNameSet.add(langName);
            }
            progLang.put(coderName, langNameSet);
        }
        return progLang;
    }

    public Map<String, Set<String>> getLangsMapSortedByNumOfProgs() {
        return sorted(langProg, this::comparison);
    }

    public Map<String, Set<String>> getProgsMapSortedByNumOfLangs() {
        return sorted(progLang, this::comparison);
    }

    public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan(int i) {
        return filtered(progsMap, p -> p.getValue().size() > i);
    }



    public <T, S> Map<T, Set<S>> sorted(Map<T, Set<S>> thisMap, Comparator<Map.Entry<T, Set<S>>> comperator) {
        Map<T, Set<S>> sorted = new LinkedHashMap<>();
        List<Map.Entry<T, Set<S>>> en = new LinkedList<>();
        en.addAll(thisMap.entrySet());
        en.sort(comperator);


        for (int j = 0; j < en.size(); j++) {
            sorted.put(en.get(j).getKey(), en.get(j).getValue());
        }

        return sorted;
    }

    public static <T, K> LinkedHashMap<T, List<K>> filtered(Map<T, List<K>> map, Predicate<Map.Entry<T, List<K>>> predicate) {
        LinkedHashMap<T, List<K>> filteredMap = new LinkedHashMap<>();

        map.entrySet().stream()
                .filter(predicate)
                .forEach(entry -> filteredMap.put(entry.getKey(), entry.getValue()));

        return filteredMap;
    }

    ;


    private int comparison(Map.Entry<String, Set<String>> e, Map.Entry<String, Set<String>> b) {
        if (b.getValue().size() > e.getValue().size())
            return 1;
        else if (e.getValue().size() > b.getValue().size())
            return -1;
        else if (e.getValue().size() == e.getValue().size()) {
            for (int i = 0; i < e.getKey().length() && i < b.getKey().length(); i++) {
                if (e.getKey().charAt(i) < b.getKey().charAt(i))
                    return -1;
                else if (b.getKey().charAt(i) < e.getKey().charAt(i))
                    return 1;
                else return 0;
            }
        }
        return 0;
    }

}

