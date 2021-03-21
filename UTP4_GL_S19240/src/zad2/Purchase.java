package zad2;




public class Purchase{
    private String id,name_surname,nazwa_towaru;
    private double cena,zakupiona_ilosc,koszt;

    public Purchase(String s, String id, String name_surname, String nazwa_towaru, double zakupionaIlosc, double cena, double zakupiona_ilosc) {
        this.id = id;
        this.name_surname = name_surname;
        this.nazwa_towaru = nazwa_towaru;
        this.cena = cena;
        this.zakupiona_ilosc = zakupiona_ilosc;
        this.koszt = cena*zakupiona_ilosc;
    }

    public String getId() {
        return id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public String getNazwa_towaru() {
        return nazwa_towaru;
    }

    public double getCena() {
        return cena;
    }

    public double getZakupiona_ilosc() {
        return zakupiona_ilosc;
    }

    public double getKoszt() {
        return koszt;
    }

    @Override
    public String toString() {
        return id+";"+name_surname+";"+nazwa_towaru+";"+cena+";"+zakupiona_ilosc;
    }
}
