public class Barcode{
    String zip;

    public Barcode(String given){
	if (given.charAt(0).isDigit){
	    zip  = given;
	}
	else{
	    zip = toZip(given);
	}
    }

    public String toString(){
		return this.toCode();
	}

	private static String numToBars(int number){
	}

	private String toCode(String given){
		String result = "|";
		int checkingNum = 0;
		for (int n=0; n<given.length(); n++){
			checkingNum += (int)(given.charAt(n));
		}
		for (int r=0; r<given.length(); r++){
			result += numToBars((int)(given.charAt(r)));
		}
		result += numToBars(checkingNum);
		result += "|";
		return result;
	}

	public String getCode(){
		return this.toCode();
	}

	private String toZip(String given){
	}

	public String getZip(){
		return zip;
	}

	public boolean equals(Barcode other){
	}

	public int compareTo(Barcode other){
	}
}