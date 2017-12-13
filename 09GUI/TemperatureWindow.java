import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JCheckBox c;
    
    public TemperatureWindow() {
        this.setTitle("Temperature Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
        pane.setLayout(new FlowLayout());

        t = new JTextField(12);
        c = new JCheckBox("");
        pane.add(t);
        pane.add(c);
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
	textField = new JTextField(20);
    }
}
