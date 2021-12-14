package ThermLog;
import TempCalculator.TemperatureCalculator;
import java.util.*;
public class ThermometerLog {

    public ArrayList<Double> Log;
    static int Capacity;

    public ThermometerLog(){
        this.Log = new ArrayList<Double>(10);
        this.Capacity = 10;
    }

    public ThermometerLog(int capacity){
        this.Log = new ArrayList<Double>(capacity);
        this.Capacity = capacity;
    }

    public void add(Double temperature){
        double round = Math.round(temperature * 100.0)/ 100.0;
        this.Log.add(round);
    }

    public void remove(){
        this.Log.remove(getCurrentSize() - 1);

    }

    public void remove(Double temperature){
        this.Log.remove(temperature);

    }
    public String displaySavedTemperatures(){
        String string = "";

        for(int i = 0; i < this.Log.size(); i ++){
            string += this.Log.get(i) + ", ";
        }
        string = string.substring(0, string.length() - 2);
        return string;
    }
    public void setLog(ArrayList<Double> thisLog){
        this.Log = thisLog;
    }
    public ArrayList<Double> getLog(){
        return this.Log;
    }
    public int getCurrentSize(){
        return this.Log.size();
    }
    public int getCapacity(){
        return this.Capacity;
    }
    public Double getElement(int i){
        return this.Log.get(i);
    }
}
