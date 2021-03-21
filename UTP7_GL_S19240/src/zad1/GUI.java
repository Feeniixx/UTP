package zad1;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GUI extends JFrame {
    Object[][] data;
    String[] colsName;

    public GUI(ArrayList<Country> l) throws HeadlessException {
        setTitle(LocalDate.now().toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel mainJP = new JPanel();
        mainJP.setPreferredSize(new Dimension(600, 400));
        createDateList(l);
        mainJP.add(new JTable(data,colsName));
        add(mainJP);
        pack();
        setVisible(true);
    }



    private void createDateList(ArrayList<Country> l) {
        data = new Object[l.size()][6];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = l.get(i).getCountry();
            data[i][1] = l.get(i).getDepartureDay();
            data[i][2] = l.get(i).getReturnDay();
            data[i][3] = l.get(i).getPlace();
            data[i][4] = l.get(i).getPrice();
            data[i][5] = l.get(i).getCurrencySymbol();
        }

        colsName = new String[]{"Country", "DepartureDay", "ReturnDay", "Place", "Price", "CurrencySymbol"};
    }
}
