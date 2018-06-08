package filereader;

public class BlockHeader {
    private String liczba;
    private String nazwa;
    private String dlugosc;
    private String nrPoz;
    private String srednica;
    private String sztuki;
    
    public BlockHeader() {  
    }
    
    public BlockHeader(String liczba, String nazwa, String dlugosc, String nrPoz, String srednica, String sztuki) {
        this.liczba = liczba;
        this.nazwa = nazwa;
        this.dlugosc = dlugosc;
        this.nrPoz = nrPoz;
        this.srednica = srednica;
        this.sztuki = sztuki;
    }

//    public BlockHeader(String inputRecord) {
//        String[] fields = inputRecord.split("\\s+");
//    }
    
    public String getLiczba() {
        return this.liczba;
    }
    
    public void setLiczba(String liczba) {
        this.liczba = liczba;
    }
    
    public String getNazwa() {
        return this.nazwa;
    }
    
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    public String getDlugosc() {
        return this.dlugosc;
    }
    
    public void setDlugosc(String dlugosc) {
        this.dlugosc = dlugosc;
    }
    
    public String getNrPoz() {
        return this.nrPoz;
    }
    
    public void setNrPoz(String nrPoz) {
        this.nrPoz = nrPoz;
    }
    
    public String getSrednica() {
        return this.srednica;
    }
    
    public void setSrednica(String srednica) {
        this.srednica = srednica;
    }
    
    public String getSztuki() {
        return this.sztuki;
    }
    
    public void setSztuki(String sztuki) {
        this.sztuki = sztuki;
    } 
    
    public String toString(){
        return "Blok: " +getLiczba() + " " + getNazwa() + " " + getDlugosc() + " " + getNrPoz() + " " + getSrednica() + " " + getSztuki();
    }
}
