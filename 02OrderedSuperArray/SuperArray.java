public class SuperArray{
    private String[] data;
    private int size;

    //0.
    public SuperArray(){
		data = new String[10];
		size = 0;
    }

    //4.
    public String toString(){
		String result = "[";
		for (int n=0; n<size-1; n++){
			result += data[n] + ", ";
		}
		if (size!=0){
			result+=data[size-1];
		}
		return result + "]";
    }

    //1.
    public void clear(){
		data = new String[size];
		size = 0;
    }

    //2a.
    public int size(){
		return size;
    }

    //2b.
    public boolean isEmpty(){
	        return size==0;
    }

    //3.
    public void add(String element){
		if (size == data.length){
			resize();
		}
		data[size] = element;
		size+=1;
		//System.out.println("Size : " + size());
		//System.out.println("Array: " + toString());
    }

	//5.
    public String get(int index){
		if (index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}

	//6.
	public String set(int index, String element){
		if (index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}
		String old = data[index];
		data[index] = element;
		return old;
	}

	//7.
	private void resize(){
		String[] dataTemp = new String[size * 2 +1];
		for (int n=0; n<size; n++){
			dataTemp[n] = data[n];
		}
		data = dataTemp;
	}

	//8.
	public boolean contains(String target){
		for (int n=0; n<size; n++){
			if (data[n].equals(target)){
				return true;
			}
		}
		return false;
	}

	//9a.
	public int indexOf(String target){
		for (int n=0; n<size; n++){
			if (data[n].equals(target)){
				return n;
			}
		}
		return -1;
	}

	//9b.
	public int lastIndexOf(String target){
		int index = -1;
		for (int n=0; n<size; n++){
			if (data[n].equals(target)){
				index = n;
			}
		}
		return index;
	}

	//10.
	public void add(int index, String element){
		if (index<0 || index>size){
			throw new IndexOutOfBoundsException();
		}
		if (size == data.length){
			resize();
		}
		for (int n=size-1; n>=index; n-=1){
			data[n+1] = data[n];
			//System.out.println(data[n+1]);
		}
		data[index] = element;
		size+=1;
	}

	//11.
	public String remove(int index){
		if (index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}
		String removedElement = data[index];
		for (int n=index; n<size-1; n++){
			data[n] = data[n+1];
		}
		data[size-1] = null;
		size-=1;
		return removedElement;
	}

	//12.
	public boolean remove(String element){
	        int index = indexOf(element);
		if (index == -1){
			return false;
		}
		for (int n=index; n<size-1; n++){
			data[n] = data[n+1];
		}
		data[size-1] = null;
		size-=1;
		return true;
	}
}
