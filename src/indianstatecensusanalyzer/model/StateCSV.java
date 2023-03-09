package indianstatecensusanalyzer.model;

public class StateCSV {

    public Integer srNo;
    public String stateName;
    public Integer tin;
    public String stateCode;

    public StateCSV() {

    }

    public StateCSV(Integer srNo, String stateName, Integer tin, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "StateCSV [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
                + "]";
    }
}
