package at.cc.jku.countervalues;

public class EnergyCounterNameVO {
    int id;
    String counterName;
    String unit;

    public EnergyCounterNameVO(int id, String counterName, String unit) {
        this.id = id;
        this.counterName = counterName;
        this.unit = unit;
    }

    public EnergyCounterNameVO(String counterName, String unit) {
        this.counterName = counterName;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public String getCounterName() {
        return counterName;
    }

    public String getUnit() {
        return unit;
    }
}
