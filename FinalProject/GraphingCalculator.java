public class GraphingCalculator{
    private double[][] points;

    public GraphingCalculator(String equation){
	points = new double[101][2];
	for (int n=-50; n<51; n++){
	    double ycord = 0;
	    points[n+50][0] = n;
	    double a = 1;
	    for (int r=2; r<equation.length(); r++){
		if (Character.isDigit(equation.charAt(r)) ||
		    equation.charAt(r)=='.'){
		    int s=r;
		    while (Character.isDigit(equation.charAt(s)) ||
			   equation.charAt(s)=='.'){
			s++;
		    }
		    a = Double.parseDouble(equation.substring(r,s));
		    r=s-1;
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
	for (int n=0; n<points.length; n++){
	    result += "[";
	    result += points[n][0];
	    result += ",";
	    result += points[n][1];
	    result += "] ";
	}
	result += "]";
	return result;
    }

    public static void main(String[]args){
	GraphingCalculator g = new GraphingCalculator("y=1.5x");
	System.out.println(g);
    }
}
