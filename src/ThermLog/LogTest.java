package ThermLog;
import java.lang.*;
import org.junit.Test;

public class LogTest {

    @Test
    public void getCapacity(){
        ThermometerLog Log = new ThermometerLog();
        assert(Log.getCapacity() == 10);
        ThermometerLog Log2 = new ThermometerLog(5);
        assert(Log2.getCapacity() == 5);
    }
    @Test
    public void ThermometerLog(){
        ThermometerLog Log = new ThermometerLog();
        assert(Log.getCapacity() == 10);
        ThermometerLog Log2 = new ThermometerLog();
        assert(Log2.getCapacity() == 10);
    }
    @Test
    public void ThermometerLogWithParam(){
        ThermometerLog Log = new ThermometerLog(3);
        assert(Log.getCapacity() == 3);
        ThermometerLog Log2 = new ThermometerLog(11);
        assert(Log2.getCapacity() == 11);
    }
    @Test
    public void getCurrentSize(){
        ThermometerLog Log = new ThermometerLog();
        assert(Log.getCurrentSize() == 0);
        Log.add(22.2);
        assert(Log.getCurrentSize() == 1);
        Log.add(33.3);
        assert(Log.getCurrentSize() == 2);

    }
    @Test
    public void getElement(){
        ThermometerLog Log = new ThermometerLog();
        Log.add(22.2);
        assert(Log.getElement(0) == 22.2);
        Log.add(33.3);
        assert(Log.getElement(1) == 33.3);
    }
    @Test
    public void getLog(){
        ThermometerLog first = new ThermometerLog();
        ThermometerLog second = new ThermometerLog();
        assert(first.Log == first.getLog());
        assert(second.Log == second.getLog());
    }
    @Test
    public void setLog(){
        ThermometerLog first = new ThermometerLog();
        ThermometerLog second = new ThermometerLog();
        assert(first.Log == first.getLog());
        assert(second.Log == second.getLog());
        first.setLog(second.getLog());
        assert(first.getLog() == second.getLog());

    }
    @Test
    public void displaySavedTemperatures(){
        ThermometerLog Log = new ThermometerLog();
        ThermometerLog Log2 = new ThermometerLog(15);

        for (double i = 1.0; i <= Log.getCapacity(); i++){
            Log.add(i);
        }
        assert(Log.displaySavedTemperatures().equals("1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0"));
        double l = 1.0;
        for (double j = 1.0; j <= Log2.getCapacity(); j++){
            Log2.add(l);
            l+=1.1;
        }
        assert(Log2.displaySavedTemperatures().equals("1.0, 2.1, 3.2, 4.3, 5.4, 6.5, 7.6, 8.7, 9.8, 10.9, 12.0, 13.1, 14.2, 15.3, 16.4"));
    }

    @Test
    public void remove(){
        ThermometerLog Log = new ThermometerLog();
        assert(Log.getCurrentSize() == 0);
        Log.add(22.2);
        assert(Log.getCurrentSize() == 1);
        assert(Log.getElement(0) == 22.2);
        Log.add(33.3);
        assert(Log.getElement(1) == 33.3);
        assert(Log.getCurrentSize() == 2);

        Log.remove();
        assert(Log.getCurrentSize() == 1);
        assert(Log.getElement(0) == 22.2);
        Log.remove();
        assert(Log.getCurrentSize() == 0);
    }
    @Test
    public void removeWithParam(){
        ThermometerLog Log = new ThermometerLog();
        for (double i = 1.0; i <= Log.getCapacity(); i++){
            Log.add(i);
        }
        assert(Log.getCurrentSize() == 10);
        assert(Log.getElement(1) == 2.0);
        Log.remove(2.0);
        assert(Log.getCurrentSize() == 9);
        assert(Log.getElement(1) == 3.0);
    }
    @Test
    public void add(){
        ThermometerLog Log = new ThermometerLog();
        assert(Log.getCurrentSize() == 0);
        Log.add(1.0);
        assert(Log.getCurrentSize() == 1);
        assert(Log.getElement(0) == 1.0);
        Log.add(2.0);
        assert(Log.getCurrentSize() == 2);
        assert(Log.getElement(1) == 2.0);
    }
}
