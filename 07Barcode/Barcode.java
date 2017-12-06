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

	private static String convert(int num){
		String[] codes = ["||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"];
		return codes[num];
	}

	private static String convert(String bars){
		String[] codes = ["||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"];
		for (int n=0; n<codes.length(); n++){
			if (bars.equals(codes[n])){
				return n;
			}
		}
		throw new IllegalArgumentException;
		return;
	}

	/*private static String numToBars(int number){
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
	}*/

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
			result += convert((int)(given.charAt(r)));
		}
		result += convert(checkingNum);
		result += "|";
		return result;
	}

	public String getCode(){
		return this.toCode();
	}

	public static String toZip(String given){
		String result = "";
		if (given.length()!=32){
			throw new IllegalArgumentException;
		}
		if (given.charAt(0)!="|" || given.charAt(31)!="|"){
			throw new IllegalArgumentException;
		}
		for (int r=0; r<given.length(); r++){
			if (given.charAt(r)!="|" || given.charAT(r)!=":"){
				throw new IllegalArgumentException;
			}
		}
		int checkSum = 0;
		String justCode = given.subString(1,26);
		for (int n=0; n<justCode.length(); n+=5){
			if (given.subString(n,n+5).equals(":::::") || given.subString(n,n+5).equals("|||||")){
				throw new IllegalArgumentException;
			}
			result += convert(given.subString(n,n+5));
			checkSum += convert(given.subString(n,n+5));
		}
		if (checkSum!=convert(given.subString(26,31))){
			throw new IllegalArgumentException;
		}
		return result;
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