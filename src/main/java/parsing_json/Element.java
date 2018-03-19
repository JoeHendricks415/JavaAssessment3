package parsing_json;

import java.util.ArrayList;

public class Element {

    private String name;
    private String appearance;
    private Double atomic_mass;
    private Double boil;
    private String category;
    private String color;
    private Double density;
    private String discovered_by;
    private Double melt;
    private Double molar_heat;
    private String named_by;
    private int number;
    private int period;
    private String phase;
    private String source;
    private String spectral_img;
    private String summary;
    private String symbol;
    private int xpos;
    private int ypos;
    private ArrayList<Integer> shells;

    public Element(String name, String appearance, Double atomicMass, Double boil, String category, String color, Double density, String discoveredBy, Double melt, Double molarHeat, String namedBy, int number, int period, String phase, String source, String spectralImg, String summary, String symbol, int xPos, int yPos, ArrayList<Integer> shells) {
        this.name = name;
        this.appearance = appearance;
        this.atomic_mass = atomicMass;
        this.boil = boil;
        this.category = category;
        this.color = color;
        this.density = density;
        this.discovered_by = discoveredBy;
        this.melt = melt;
        this.molar_heat = molarHeat;
        this.named_by = namedBy;
        this.number = number;
        this.period = period;
        this.phase = phase;
        this.source = source;
        this.spectral_img = spectralImg;
        this.summary = summary;
        this.symbol = symbol;
        this.xpos = xPos;
        this.ypos = yPos;
        this.shells = shells;
    }

    public String getName(){
        return name;
    }

    public String getAppearance(){
        return appearance;
    }

    public Double getAtomic_mass(){
        return atomic_mass;
    }

    public Double getBoil(){
        return boil;
    }

    public String getCategory(){
        return category;
    }

    public String getColor(){
        return color;
    }

    public Double getDensity(){
        return density;
    }

    public String getDiscovered_by(){
        return discovered_by;
    }

    public Double getMelt(){
        return melt;
    }

    public Double getMolar_heat(){
        return molar_heat;
    }

    public String getNamed_by(){
        return named_by;
    }

    public int getNumber(){
        return number;
    }

    public int getPeriod(){
        return period;
    }

    public String getPhase(){
        return phase;
    }

    public String getSource(){
        return source;
    }

    public String getSpectral_img(){
        return spectral_img;
    }

    public String getSummary(){
        return summary;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getXpos(){
        return xpos;
    }

    public int getYpos(){
        return ypos;
    }

    public ArrayList<Integer> getShells(){
        return shells;
    }

}