package indianstatecensusanalyzer.model;

public class IndianCensusData {

    public String state;
    public long population;
    public long areaSqKm;
    public int densityPerSqKm;

    public IndianCensusData() {

    }

    public IndianCensusData(String state, long population, long areaSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaSqKm = areaSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }
}
