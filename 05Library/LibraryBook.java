public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN);
	this.callNumber = callNumber;
    }

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public String getCallNumber(){
	return callNumber;
    }
    
    public void compareTo(Book other){
	return this.callNumber.compareTo(other.callNumber);
    }

    public String toString(){
	return super() + ", " +  getCallNumber() + ", " + circulationStatus();
    }
}
