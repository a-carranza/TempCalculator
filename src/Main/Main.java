package Main;
import TempCalculator.TemperatureCalculator;
import ThermLog.ThermometerLog;
public class Main {
    public static void main(String[] args) {
//        ThermometerLog myList = new ThermometerLog(3);
//        TemperatureCalculator myCalc = new TemperatureCalculator(80.0, myList);
//
//        myList.add(79.5);
//        myList.add(80.3); //should produce beeping sound
//        myList.add(78.8);
//        myCalc.measureTemperature(myList); //should produce beeping sound
//        System.out.println();
//        System.out.println(myCalc.getInputTemperatures());
//        System.out.println(myCalc.getSavedTemperatures()); // doesn't save the last one since a fever was detected


        ThermometerLog myList = new ThermometerLog(5); //calculates the average even if it hasn't received 10 values
        TemperatureCalculator myCalc = new TemperatureCalculator();
        myCalc.setLog(myList);
        myCalc.setFeverRange(98.1);

        myList.add(88.4); //discards the first one because it was an outlier.
        myList.add(67.0);
        myList.add(67.1);
        myList.add(67.2);
        myList.add(67.7);
        myCalc.measureTemperature(myList);
        System.out.println(myCalc.getInputTemperatures());
        System.out.println(myCalc.getSavedTemperatures());
    }
}
