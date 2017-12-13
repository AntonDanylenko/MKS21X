import javax.swing.*;
public class TemperatureWindow extends JFrame{
    public TemperatureWindow() {
        this.setTitle("Temperature Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //Celcius to Fahrenheit
    public static double CtoF(double t){
	    return t * 1.8 + 32;
    }

    //Fahrenheit to Celcius
    public static double FtoC(double t){
	    return (t - 32) / 1.8;
    }

    public static void main(String[] args) {
        TemperatureWindow g = new TemperatureWindow();
        g.setVisible(true);
    }
}
