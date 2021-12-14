package TempCalculator;
import ThermLog.ThermometerLog;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class TemperatureCalculator {
    public Double feverLimit;
    public Double userUpRange;
    public Double userLowRange;
    public Double TemperatureInput; // the result or current Temperature that is read.
    public String unitOfMeasurement;
    public ThermometerLog values; //holds 10 temperature inputs within 0.1
    public ThermometerLog Log;

    public TemperatureCalculator(){
        feverLimit = 0.0; // what are standard values?
        unitOfMeasurement = "";
        userLowRange = null;
        userUpRange = null;
        Log = null;
        TemperatureInput = null; // we don't have the result of the calculation yet
        values = new ThermometerLog();
    }
    public TemperatureCalculator(Double FR, ThermometerLog inputs){
        feverLimit = FR;
        Log = inputs;
        unitOfMeasurement = "";
        userLowRange = null;
        userUpRange = null;
        TemperatureInput = null;
        values = new ThermometerLog();
    }
    public TemperatureCalculator(Double FR, Double userLow, Double userUp, ThermometerLog inputs){
        feverLimit = FR;
        Log = inputs;
        userLowRange = userLow;
        userUpRange = userUp;
        unitOfMeasurement = "";
        TemperatureInput = null;
        values = new ThermometerLog();
    }

    public double measureTemperature(ThermometerLog Inputs) {
        int factor = 1;
        for (int i = 0; i < Inputs.getCapacity(); i++) {
            double x = Inputs.getElement(i); //get element
            System.out.println("\nReceived input: " + x);
            if (x >= this.feverLimit){ //checks if it is a fever or within userSpecified range
                System.out.println("Oh no! You have a fever: " + x);
                produceBeepingSound(3);
                this.setTemperatureInput(x);
                return this.getTemperatureInput();

            } else if ((userLowRange != null && userUpRange!= null) && (x >= userLowRange && x <= userUpRange)){
                System.out.println("Detected Temperature within the User Specified Range");
                produceBeepingSound(2);
                this.setTemperatureInput(x);
                return this.getTemperatureInput();

            } else if ((this.values.getCurrentSize()) > 0 && (this.values.getCurrentSize() < (this.values.getCapacity()))){ //if cap not reached, add based on the first element
                System.out.println("Checking if values size: " + this.values.getCurrentSize() + " is greater than 0 but less than its capacity: " + this.values.getCapacity());
                System.out.println("index i: " + i);
                System.out.println("factor: " + factor);
                System.out.println("value: " + this.values.getElement(i-factor)+", element: " + x);

                double difference = Math.round(((this.values.getElement(i - factor)) - x) * 100.0)/100.0;
                System.out.println("Difference: " + difference);

                if (difference == 1.0 || (difference < 1.0 && difference > (-1.0))){
                    System.out.println("Element is within 1.0 of first input. Adding element: " + x + " to values list");
                    this.values.add(x);
                    factor+=1;
                    if(i == Inputs.getCapacity()-1){
                        this.setTemperatureInput(findAverage(this.values));
                        return this.getTemperatureInput();
                    }

                } else if (difference >= 3.5 || difference <= -3.5){ //check if the next value is at least 3.5 degress higher if farenheit or 2 if celsius
                    System.out.println("Checking if element varies from a degree of 3.5");
                    System.out.println("Emptying out the values list and replacing first element with: " + x);
                    emptyValuesList(this.values); // loop to empty the list and replace the first one with the next one
                    this.values.add(x);
                    factor +=1;
                    System.out.println("factor: "+factor);
                    System.out.println("Values size: " + this.values.getCurrentSize());


                } else if((this.unitOfMeasurement.equals("Celsius")) && (difference >= 2.0 || difference <= -2.0)){
                    System.out.println("Checking if element varies from a degree of 2");
                    System.out.println("Emptying out the values list and replacing first element with: " + x);
                    emptyValuesList(this.values);
                    this.values.add(x);
                } else {
                    System.out.println("Didn't add element: " + x);
                    System.out.println("Adjusting factor");
                    factor += 1;
                }

            } else if(this.values.getCurrentSize() == 0){ //if the values list is empty, add regardless
                System.out.println("Adding the first element: " + x);
                this.values.add(x);

            } else { //if we have our 10 values or there is no more input to read from, then average the remaining values
                System.out.println("Unfortunately, size has reached capacity. Element: "+ x + " was not added");
                this.setTemperatureInput(findAverage(this.values));
                return this.getTemperatureInput();
            }
        }
        return this.getTemperatureInput();
    }

    public Boolean produceBeepingSound(int times){
        int count = times;
        for(int i =0; i < count; i++){
            java.awt.Toolkit.getDefaultToolkit().beep();
            try{
                    Thread.sleep(350);
            } catch (InterruptedException e){
                return false;
            }
        }
        return true;
    }
    public double findAverage(ThermometerLog values){
        double numbers = 0;
        for(int j = 0; j < values.getCurrentSize(); j++){
            numbers += values.getElement(j);
        }
        return numbers/values.getCapacity();
    }
    public void emptyValuesList(ThermometerLog values){
        for(int k = 0; k < values.getCurrentSize(); k++){
            values.remove();
        }
    }
    public void setTemperatureInput(Double input){
        TemperatureInput = input;
    }
    public void setUnitOfMeasurement(String unit){
        this.unitOfMeasurement = unit;
    }
    public void setFeverRange(Double lim){
        feverLimit = lim;
    }
    public void setUserSpecifiedTemperatureRange(Double min, Double max){
        if(min > max){
            System.out.println("First param must be less than second param: (min, max). Try Again. ");
            return;
        } else if(min == max){
            System.out.println("Both parameters must be different numbers. Try Again. ");
            return;
        }
        userLowRange = min;
        userUpRange = max;
    }
    public void setLog(ThermometerLog thisList){
        this.Log = thisList;
    }
    public Double getTemperatureInput(){
        return this.TemperatureInput;
    }
    public Double getFeverLimit() {
        return this.feverLimit;
    }
    public Double getUserUpFeverRange(){
        return this.userUpRange;
    }
    public Double getUserLowFeverRange(){
        return this.userLowRange;
    }
    public String getUnitOfMeasurement(){
        return this.unitOfMeasurement;
    }
    public ThermometerLog getLog(){
        return this.Log;
    }
    public String getInputTemperatures(){
        if (this.Log.getCurrentSize()!= 0){
            return this.Log.displaySavedTemperatures();
        }
        return "There is nothing in Log";
    }
    public String getSavedTemperatures() {
        if (this.values.getCurrentSize() != 0) {
            return this.values.displaySavedTemperatures();
        }
        return "There are no values";
    }
}
