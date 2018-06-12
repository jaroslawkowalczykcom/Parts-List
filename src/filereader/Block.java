package filereader;

public class Block implements Comparable {
    private String blockName;
    private int barNumber;
    private int barPieces;
    private String barSymbol;
    private int barDiameter;
    private double barLength;

    public Block() {
    }

    public Block(String blockName, int barNumber, int barPieces, String barSymbol, int barDiameter, double barLength) {
        this.blockName = blockName;
        this.barNumber = barNumber;
        this.barPieces = barPieces;
        this.barSymbol = barSymbol;
        this.barDiameter = barDiameter;
        this.barLength = barLength;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getBarNumber() {
        return barNumber;
    }

    public void setBarNumber(int barNumber) {
        this.barNumber = barNumber;
    }

    public int getBarPieces() {
        return barPieces;
    }

    public void setBarPieces(int barPieces) {
        this.barPieces = barPieces;
    }

    public String getBarSymbol() {
        return barSymbol;
    }

    public void setBarSymbol(String barSymbol) {
        this.barSymbol = barSymbol;
    }

    public int getBarDiameter() {
        return barDiameter;
    }

    public void setBarDiameter(int barDiameter) {
        this.barDiameter = barDiameter;
    }

    public double getBarLength() {
        return barLength;
    }

    public void setBarLength(double barLength) {
        this.barLength = barLength;
    }

    @Override
    public int compareTo(Object t) {
        int compareBarNumber = ((Block) t).getBarNumber();
        // Ascending order
        return this.barNumber - compareBarNumber;
    }

    @Override
    public String toString() {
        return "Block{" + "blockName=" + blockName + ", barNumber=" + barNumber + ", barPieces=" + barPieces + ", barSymbol=" + barSymbol + ", barDiameter=" + barDiameter + ", barLength=" + barLength + '}' +"\n";
    }
}
