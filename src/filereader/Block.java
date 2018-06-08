package filereader;

public class Block {
    private int liczba;
    private String nazwa;
    private int dlugosc;
    private int nrPoz;
    private int srednica;
    private int sztuki;
    
    public Block() {  
    }
    
    public Block(int liczba, String nazwa, int dlugosc, int nrPoz, int srednica, int sztuki) {
        this.liczba = liczba;
        this.nazwa = nazwa;
        this.dlugosc = dlugosc;
        this.nrPoz = nrPoz;
        this.srednica = srednica;
        this.sztuki = sztuki;
    }

//    public Block(String inputRecord) {
//        String[] fields = inputRecord.split("\\s+");
//    }
    
    public int getLiczba() {
        return this.liczba;
    }
    
    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }
    
    public String getNazwa() {
        return this.nazwa;
    }
    
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    public int getDlugosc() {
        return this.dlugosc;
    }
    
    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }
    
    public int getNrPoz() {
        return this.nrPoz;
    }
    
    public void setNrPoz(int nrPoz) {
        this.nrPoz = nrPoz;
    }
    
    public int getSrednica() {
        return this.srednica;
    }
    
    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }
    
    public int getSztuki() {
        return this.sztuki;
    }
    
    public void setSztuki(int sztuki) {
        this.sztuki = sztuki;
    } 
    
    public String toString(){
        return "Blok: " +getLiczba() + " " + getNazwa() + " " + getDlugosc() + " " + getNrPoz() + " " + getSrednica() + " " + getSztuki();
    }
}
