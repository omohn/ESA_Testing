package kuehlschrank;

public class Kuehlschrank {

    private Sensor sensor;
    private int kuehlStufe;
    private int tempSoll = 4;

    public Kuehlschrank(Sensor sensor, int tempSoll) {
        kuehlStufe = 3;
        this.sensor = sensor;
        this.tempSoll = tempSoll;
    }

    public int getKuehlStufe() {
        return kuehlStufe;
    }

    public int increaseKuehlStufe() {
        System.out.println("Kühlung erhöht");
        return ++kuehlStufe;
    }

    public int decreaseKuehlStufe() {
        System.out.println("Kühlung reduziert");
        return --kuehlStufe;
    }

    public int passeKuehlStufeAn() {
        if (sensor.getTemperatur() < tempSoll - 1) {
            return decreaseKuehlStufe();
        } else if (sensor.getTemperatur() > tempSoll + 1) {
            return increaseKuehlStufe();
        } else {
            System.out.println("Kühlung unverändert");
            return kuehlStufe;
        }
    }
}
