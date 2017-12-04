public class Book{
    private String author, title, ISBN;

    public Book(){
    }

    public Book(String author, String title, String ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }
}
