package Aula7;

public class Agency {
    private String agencyName = "Sora's International Travel Agency";
    private String agencyAddress = "soratravel@sita.com";

    public String getAgencyName() {
        return agencyName;
    }
    public String getAgencyAddress() {
        return agencyAddress;
    }
    
    @Override
    public String toString(){
        return "TRAVEL AGENCY: " + agencyName + " / " + agencyAddress;
    }
}
