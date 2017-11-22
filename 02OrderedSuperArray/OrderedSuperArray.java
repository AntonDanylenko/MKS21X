public class OrderedSuperArray extends SuperArray{

  //constructor initializes an empty List
  public OrderedSuperArray(){
    super();
  }

  //constructor initializes an empty List with initial capacity of capacity.
  public OrderedSuperArray(int capacity){
    super(capacity);
  }

  //constructor that already has all elements from ary, but in order.
  public OrderedSuperArray(String[] ary){
    super();
    for (int n=0; n<ary.length; n++){
      add(ary[n]);
    }
  }

  //call the proper add.
  public void add(int index, String value){
    add(value);
  }

  //add that places value in the correct spot.
  public void add(String value){
	int index = findIndex(value);
	//System.out.println("Index: " + index);
    super.add(index, value);
  }

  //find the correct index for value in the array.
  private int findIndex(String value){
    for (int n=0; n<size(); n++){
      if (get(n).compareTo(value)==0 || get(n).compareTo(value)>0){
        return n;
      }
    }
    return size();
  }

  /*private int findIndexBinary(String value){
	System.out.println("-------------" + value + "----------------");
	System.out.println(toString());
    int front = 0;
    int end = size();
    for (int n=0; n<Math.log(size())/Math.log(2); n++){
	  System.out.println("N: " + n);
	  if (get((front+end)/2).compareTo(value) == 0){
		//System.out.println("Equal");
	    return (front+end)/2;
	  }
	  else if (get((int)(Math.ceil((front+end)/2.0)-1.0)).compareTo(value) < 0){
		//System.out.println("Change front");
	    if(size()==2){
          front = (front+end)/2 + 1;
        }
        else{
          front = (front+end)/2;
        }
	  }
	  else {
		//System.out.println("Change end");
	    end = (int)(Math.ceil((front+end)/2.0));
	  }
	  System.out.println("Front: " + front);
	  System.out.println("End: " + end);
    }
	return(front+end)/2;
  }*/

  public String set(int index, String element){
    throw new UnsupportedOperationException();
  }

  public int indexOf(String element){
    for (int n=0; n<size(); n++){
      if (get(n).equals(element)){
        return n;
      }
    }
    return -1;
  }

  /*public int indexOfBinary(String element){
    int front = 0;
    int end = size();
    for (int n=0; n<Math.log(size())/Math.log(2); n++){
	  System.out.println("N: " + n);
	  if (get((front+end)/2).compareTo(element) == 0){
		//System.out.println("Equal");
	    return (front+end)/2;
	  }
	  else if (get((int)(Math.ceil((front+end)/2.0)-1.0)).compareTo(element) < 0){
		//System.out.println("Change front");
	    if(size()==2){
          front = (front+end)/2 + 1;
        }
        else{
          front = (front+end)/2;
        }
	  }
	  else {
		//System.out.println("Change end");
	    end = (int)(Math.ceil((front+end)/2.0));
	  }
	  System.out.println("Front: " + front);
	  System.out.println("End: " + end);
    }
	return(front+end)/2;
  }*/
}






























