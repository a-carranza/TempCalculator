package TempCalculator;
import ThermLog.ThermometerLog;
import org.junit.*;
import static org.junit.Assert.*;

public class TempTest {

    @Test
    public void TempCalc(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.feverLimit == 0.0);
        assert(TM.TemperatureInput == null);
        assert(TM.Log == null);
        assert(TM.userLowRange == null);
        assert(TM.userUpRange == null);
        assert(TM.values.getCapacity() == 10);
        assert(TM.values.getCurrentSize() == 0);
    }
    @Test
    public void TempCalcWithParam1(){
        ThermometerLog TL = new ThermometerLog(7);
        TemperatureCalculator TM = new TemperatureCalculator(98.1, TL);
        assert(TM.feverLimit == 98.1);
        assert(TM.Log == TL);
        assert(TM.Log.getCapacity() == 7);
        assert(TM.TemperatureInput == null);
        assert(TM.userLowRange == null);
        assert(TM.userUpRange == null);
        assert(TM.values.getCapacity() == 10);
        assert(TM.values.getCurrentSize() == 0);

    }
    @Test
    public void TempCalcWithParam2(){
        ThermometerLog TL = new ThermometerLog(5);
        TemperatureCalculator TM = new TemperatureCalculator(98.1, 60.0, 70.0, TL);
        assert(TM.feverLimit == 98.1);
        assert(TM.Log == TL);
        assert(TM.Log.getCapacity() == 5);
        assert(TM.userLowRange == 60.0);
        assert(TM.userUpRange == 70.0);
        assert(TM.TemperatureInput == null);
        assert(TM.values.getCapacity() == 10);
        assert(TM.values.getCurrentSize() == 0);
    }
    @Test
    public void setUnitOfMeasurement(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.unitOfMeasurement.equals(""));
        TM.setUnitOfMeasurement("Celsius");
        assert(TM.unitOfMeasurement.equals("Celsius"));
        TM.setUnitOfMeasurement("Fahrenheit");
        assert(TM.unitOfMeasurement.equals("Fahrenheit"));
    }
    @Test
    public void setTemperatureInput(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.TemperatureInput == null);
        TM.setTemperatureInput(98.1);
        assert(TM.TemperatureInput == 98.1);
        TM.setTemperatureInput(0.0);
        assert(TM.TemperatureInput == 0.0);
    }
    @Test
    public void setFeverRange(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.feverLimit == 0.0);
        TM.setFeverRange(70.9);
        assert(TM.feverLimit == 70.9);
        TM.setFeverRange(0.0);
        assert(TM.feverLimit == 0.0);
    }
    @Test
    public void setUserSpecifiedTemperatureRange(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.userUpRange == null);
        assert(TM.userLowRange == null);
        TM.setUserSpecifiedTemperatureRange(98.0, 98.1);
        assert(TM.userUpRange == 98.1);
        assert(TM.userLowRange == 98.0);
        //check for if cases
    }
    @Test
    public void setLog(){
        ThermometerLog TL = new ThermometerLog();
        ThermometerLog TL2 = new ThermometerLog();
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.Log == null);
        TM.setLog(TL);
        assert(TM.Log == TL);
        TM.setLog(TL2);
        assert(TM.Log == TL2);
    }
    @Test
    public void getTemperatureInput(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.getTemperatureInput() == null);
        TM.setTemperatureInput(34.4);
        assert(TM.getTemperatureInput() == 34.4);
        TM.setTemperatureInput(0.11);
        assert(TM.getTemperatureInput() == 0.11);
    }
    @Test
    public void getFeverLimit(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.getFeverLimit() == 0.0);
        TM.setFeverRange(98.1);
        assert(TM.getFeverLimit() == 98.1);

    }
    @Test
    public void getUserUpFeverRange(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.getUserUpFeverRange() == null);
        TM.setUserSpecifiedTemperatureRange(98.0, 98.1);
        assert(TM.getUserUpFeverRange() == 98.1);
        TM.setUserSpecifiedTemperatureRange(0.0, 102.3);
        assert(TM.getUserUpFeverRange() == 102.3);
    }
    @Test
    public void getUserLowFeverRange(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.getUserLowFeverRange() == null);
        TM.setUserSpecifiedTemperatureRange(98.0, 98.1);
        assert(TM.getUserLowFeverRange() == 98.0);
        TM.setUserSpecifiedTemperatureRange(0.0, 102.3);
        assert(TM.getUserLowFeverRange() == 0.0);
    }
    @Test
    public void getLog(){
        ThermometerLog TL = new ThermometerLog();
        ThermometerLog TL2 = new ThermometerLog();
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.getLog() == null);
        TM.setLog(TL);
        assert(TM.getLog() == TL);
        TM.setLog(TL2);
        assert(TM.getLog() == TL2);
    }
    @Test
    public void getUnitOfMeasurement(){
        TemperatureCalculator TM = new TemperatureCalculator();
        assert(TM.unitOfMeasurement.equals(""));
        TM.setUnitOfMeasurement("Celsius");
        assert(TM.getUnitOfMeasurement().equals("Celsius"));
        TM.setUnitOfMeasurement("Fahrenheit");
        assert(TM.getUnitOfMeasurement().equals("Fahrenheit"));
    }
    @Test
    public void getSavedTemperature(){

    }
    @Test
    public void getInputTemperatures(){
        ThermometerLog Log = new ThermometerLog();
        ThermometerLog Log2 = new ThermometerLog(15);
        TemperatureCalculator TC = new TemperatureCalculator();
        TemperatureCalculator TC2 = new TemperatureCalculator();
        TC.setLog(Log);
        assert(TC.getInputTemperatures().equals("There is nothing in Log"));

        for (double i = 1.0; i <= Log.getCapacity(); i++){
            Log.add(i);
        }
        assert(TC.getInputTemperatures().equals("1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0"));

        TC2.setLog(Log2);
        assert(TC2.getInputTemperatures().equals("There is nothing in Log"));
        double l = 1.0;
        for (double j = 1.0; j <= Log2.getCapacity(); j++){
            Log2.add(l);
            l+=1.1;
        }
        assert(TC2.getInputTemperatures().equals("1.0, 2.1, 3.2, 4.3, 5.4, 6.5, 7.6, 8.7, 9.8, 10.9, 12.0, 13.1, 14.2, 15.3, 16.4"));
    }

    @Test
    public void measureTemperature(){
        ThermometerLog myList = new ThermometerLog(20);
        TemperatureCalculator myCalc = new TemperatureCalculator(80.0, myList);

        myList.add(78.9);
        myList.add(79.0);
        myList.add(79.1);
        myList.add(78.0);
        myList.add(77.8); //shouldn't add to values list //
        myList.add(79.9);
        myList.add(77.9); //6 - edge case
        myList.add(78.9); //7 - repeating case
        myList.add(79.2);
        myList.add(79.4);
        myList.add(79.7);
        myList.add(79.8);
        myList.add(79.6);
        myList.add(79.5);
        myList.add(79.3);
        myList.add(78.8);
        myList.add(78.7);
        myList.add(78.6);
        myList.add(78.5);
        myList.add(78.3);
        myCalc.measureTemperature(myList);
        assert(myCalc.getInputTemperatures().equals("78.9, 79.0, 79.1, 78.0, 77.8, 79.9, 77.9, 78.9, 79.2, 79.4, 79.7, 79.8, 79.6, 79.5, 79.3, 78.8, 78.7, 78.6, 78.5, 78.3"));
        assert(myCalc.getSavedTemperatures().equals("78.9, 79.0, 79.1, 78.0, 77.9, 78.9, 79.2, 79.4, 79.7, 79.8"));

        ThermometerLog myList2 = new ThermometerLog(5); //calculates the average even if it hasn't received 10 values
        TemperatureCalculator myCalc2 = new TemperatureCalculator(); //also discards outliers.
        myCalc2.setLog(myList2);
        myCalc2.setFeverRange(98.1);

        myList2.add(88.4); //discards the first one because it was an outlier.
        myList2.add(67.0);
        myList2.add(67.1);
        myList2.add(67.2);
        myList2.add(67.7);
        myCalc2.measureTemperature(myList2);
        assert(myCalc2.getInputTemperatures().equals("88.4, 67.0, 67.1, 67.2, 67.7"));
        assert(myCalc2.getSavedTemperatures().equals("67.0, 67.1, 67.2, 67.7"));

        //commented out for now because of beepingsound.
//        ThermometerLog myList3 = new ThermometerLog(3);
//        TemperatureCalculator myCalc3 = new TemperatureCalculator(80.0, myList3);
//
//        myList3.add(79.5);
//        myList3.add(80.3); //should produce beeping sound
//        myList3.add(78.8);
//        myCalc3.measureTemperature(myList3); //should produce beeping sound
//        System.out.println(myCalc3.getInputTemperatures());
//        System.out.println(myCalc3.getSavedTemperatures());
//
//        assert(myCalc3.getInputTemperatures().equals("79.5, 80.3, 78.8"));
//        assert(myCalc3.getSavedTemperatures().equals("79.5")); // doesn't receive the last one
    }
//    @Test
//    public void produceBeepingSound(){
//        TemperatureCalculator TM = new TemperatureCalculator();
//        assertTrue(TM.produceBeepingSound(1));
//        assertTrue(TM.produceBeepingSound(3));
//    }
}
