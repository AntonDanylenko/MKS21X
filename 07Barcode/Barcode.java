public class Barcode{
    String zip;

    public Barcode(String zip){
	if (zip.charAt(0).isDigit){
	    this.zip = zip;
	}
	else{
	}
    }

}
