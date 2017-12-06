public class Barcode{
    String zip;

    public Barcode(String given){
	if (given.length()!=5){
	    throw new IllegalArgumentException;
	}
	for (int n=0; n<given.length(); n++){
		if (!given.charAt(n).isDigit()){
			throw new IllegalArgumentException;
		}
	}
	zip = given;
    }

    public String toString(){
		return this.toCode();
	}

	private static String numToBars(int number){
		if (number==0){
			return "||:::";
		}
		else if (number==1){
			return ":::||";
		}
		else if (number==2){
			return "::|:|";
		}
		else if (number==3){
			return "::||:";
		}
		else if (number==4){
			return ":|::|";
		}
		else if (number==5){
			return ":|:|:";
		}
		else if (number==6){
			return ":||::";
		}
		else if (number==7){
			return "|:::|";
		}
		else if (number==8){
			return "|::|:";
		}
		else{
			return "|:|::";
		}
	}

	public static String toCode(String given){
		if (given.length()!=5){
			throw new IllegalArgumentException;
		}
		for (int n=0; n<given.length(); n++){
			if (!given.charAt(n).isDigit()){
				throw new IllegalArgumentException;
			}
		}
		String result = "|";
		int checkingNum = 0;
		for (int n=0; n<given.length(); n++){
			checkingNum += (int)(given.charAt(n));
		}
		checkingNum = checkingNum%10;
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

	public static String toZip(String given){
		String justCode = given.subString(1,26);
		for (int n=0; n<justCode.length(); n+=5){
			
	}

	public String getZip(){
		return zip;
	}

	public boolean equals(Barcode other){
		return this.getZip().equals(other.getZip());
	}

	public int compareTo(Barcode other){
		return (int)(this.getZip()) - (int)(other.getZip());
	}
}