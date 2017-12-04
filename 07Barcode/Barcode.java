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

    

}
