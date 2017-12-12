public class Temperature{
	//Naming
	public static String name(){
		return "09.Danylenko.Anton"; 
	}


	//Celcius to Fahrenheit
	public static double CtoF(double t){
		return t * 1.8 + 32;
	}


	//Fahrenheit to Celcius
	public static double FtoC(double t){
		return (t - 32) / 1.8;
	}
}