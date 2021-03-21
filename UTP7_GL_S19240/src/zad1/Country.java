package zad1;

public class Country {
    private String contractorLocation;
    private String country;
    private String departureDay;
    private String returnDay;
    private String place;
    private String price;
    private String currencySymbol;

    public Country(String contractorLocation, String country, String departureDay, String returnDay, String place, String price, String currencySymbol) {
        this.contractorLocation = contractorLocation;
        this.country = country;
        this.departureDay = departureDay;
        this.returnDay = returnDay;
        this.place = place;
        this.price = price;
        this.currencySymbol = currencySymbol;
    }

    public String getContractorLocation() {
        return contractorLocation;
    }

    public String getCountry() {
        return country;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public String getPlace() {
        return place;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    @Override
    public String toString() {
        return country+" "+departureDay+" "+returnDay+" "+place+" "+price+" "+currencySymbol;
    }
}
