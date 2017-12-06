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

	public String toCode(String given){
		
	}

	public String getCode(){
		return this.toCode();
	}

	public String toZip(String given){
	}

	public String getZip(){
		return zip;
	}

	public boolean equals(Barcode other){
	}

	public int compareTo(Barcode other){
	}
}