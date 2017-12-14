import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
	private JButton b;
	private JButton b2;
    
    public TemperatureWindow() {
        this.setTitle("Temperature Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane = this.getContentPane();
        pane.setLayout(new FlowLayout());

        t = new JTextField(12);
		b = new JButton("Celcius to Fahrenheit");
		b2 = new JButton("Fahrenheit to Celcius");

        t.addActionListener(this);
        b.addActionListener(this);
        b2.addActionListener(this);

        pane.add(t);
		pane.add(b);
		pane.add(b2);
    }
    
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		double temperature = Double.parseDouble(t.getText());
		if (s.equals("Celcius to Fahrenheit")){
			t.setText(CtoF(temperature) + "");
		}
		else{
			t.setText(FtoC(temperature) + "");
		}
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
