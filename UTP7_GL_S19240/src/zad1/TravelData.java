package zad1;



import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;
import java.util.*;

public class TravelData {
    List<Country> travelData;
    List<Country> guiList;
    String currentDataFormat;
    String lang;


    public TravelData(File dataDir) {
        travelData = new ArrayList<>();
        fileWalker(dataDir);
        guiList = new ArrayList<>();
    }



    private void readFileContent(File fileEntry) {
        try {
            Scanner scanner = new Scanner(fileEntry);
            String s = scanner.nextLine();
            String[] k = s.split("\t");
            travelData.add(new Country(k[0],k[1],k[2],k[3],k[4],k[5],k[6]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
        currentDataFormat = dateFormat;
        lang = locale;
        List<String> returnList = new ArrayList<>();
        Locale.setDefault(new Locale(locale.split("_")[0],locale.split("_")[1]));
        SimpleDateFormat formatOfDate = new SimpleDateFormat(dateFormat);
        NumberFormat numberFormat = null;
        for (Country country :travelData){
            Date d1 = null,d2 = null;
            Number number = null;
            try {
                d1 = formatOfDate.parse(country.getDepartureDay());
                d2 = formatOfDate.parse(country.getReturnDay());
                numberFormat = NumberFormat.getInstance(new Locale(country.getContractorLocation().split("_")[0]));
                number = numberFormat.parse(country.getPrice());
                numberFormat = NumberFormat.getInstance();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            formatOfDate.applyPattern(dateFormat);
            if (!country.getContractorLocation().split("_")[0].equals(locale.split("_")[0])){
                guiList.add(new Country(locale,countryNameTranslate(country,locale.split("_")[0]), formatOfDate.format(d1),formatOfDate.format(d2),translateLocalization(new Locale(country.getContractorLocation().split("_")[0]), country.getPlace(),Locale.getDefault()),numberFormat.format(number), country.getCurrencySymbol()));
                returnList.add(guiList.get(guiList.size()-1).toString());
            }else{
                guiList.add(new Country(locale, country.getCountry(),formatOfDate.format(d1),formatOfDate.format(d2), country.getPlace(),numberFormat.format(number), country.getCurrencySymbol()));
                returnList.add(guiList.get(guiList.size()-1).toString());
            }
        }
        return returnList;
    }

    private void fileWalker(File folder) {
        for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                fileWalker(fileEntry);
            } else {
                readFileContent(fileEntry);
            }
        }
    }



    private String countryNameTranslate(Country country, String outLocale){
        for (Locale loc : Locale.getAvailableLocales()) {
            if (loc.getDisplayCountry(Locale.forLanguageTag(country.getContractorLocation().split("_")[0])).equals(country.getCountry())) {
                return loc.getDisplayCountry(Locale.forLanguageTag(outLocale));
            }
        }
        return country.getCountry();
    }

    private String translateLocalization(Locale currentLang,String word, Locale transaleLang){
        ResourceBundle bun;
        bun = ResourceBundle.getBundle("Resource.Place",currentLang);
        for (int i = 0; i < 3; i++) {
            if (bun.getString(String.valueOf(i)).equals(word)){
                bun = ResourceBundle.getBundle("Resource.Place",transaleLang);
                return bun.getString(String.valueOf(i));
            }
        }

        return word;
    }
}
