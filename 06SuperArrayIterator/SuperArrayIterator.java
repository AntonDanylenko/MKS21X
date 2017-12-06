import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
	SuperArray SA;
	int index;

	public SuperArrayIterator(SuperArray SA, int index){
		this.SA = SA;
		this.index = index;
	}

	public String next(){
		if (hasNext()){
			index++;
		}
		else{
			System.exit(0);
		}
		return index-1;
	}

	public boolean hasNext(){
		return index<SA.size();
	}

	public void remove(){
		throw new UnsupportedOperationException();
    }
}