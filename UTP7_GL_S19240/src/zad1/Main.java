/**
 *
 *  @author Golunko Lizaveta S19240
 *
 */

package zad1;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File dataDir = new File("data");
        TravelData travelData = new TravelData(dataDir);
        String dateFormat = "yyyy-MM-dd";
        for (String locale : Arrays.asList("pl_PL", "en_GB")) {
            List<String> odlist = travelData.getOffersDescriptionsList(locale, dateFormat);
            for (String od : odlist) System.out.println(od);
        }

        String url =  "jdbc:oracle:thin:s17155/oracle12@( description=(address_list=( address=(protocol=tcp) (host=db-oracle.pjwstk.edu.pl)(port=1521)))(source_route=yes) (connect_data=(sid=baza)))";
        Database db = new Database(url, travelData);
        db.create();
        db.showGui();
    }

}
