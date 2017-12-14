public class GraphingCalculator{
    private double[][] points;

    public GraphingCalculator(String equation){
	points = new double[101][2];
	for (int n=-50; n<51; n++){
	    double ycord = 0;
	    points[n+50][0] = n;
	    for (int r=2; r<equation.length(); r++){
		if (equation.charAt(r).isDigit() || equation.charAt(r)=='.'){
		    double a;
		    int s=r;
		    while (equation.charAt(s).isDigit() || equation.charAt(s)=='.'){
			s++;
		    }
		    double a = Double.parseDouble(equation.substring(r,s+1));
		    r=s;
		}
		else if(equation.charAt(r)=='x'){
		    ycord = a * n;
		}
	    }
	    points[n+50][1] = ycord;
	}
    }

    public String toString(){
	String result = "[";
	for (int n=0; n<points.length-1; n++){
	    result += "[";
	    result += points[n][r];
	    result += ",";
	    result += points[n][1];
	    result += "] ";
	}
	result += "]";
    }

    public static void main(String[]args){
	GraphingCalculator g = new GraphingCalculator("y=3.5x");
	System.out.println(g);
    }
}
