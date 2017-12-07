public class Sorts{
	public static String name(){
		return "09.Danylenko.Anton"; 
	}

	public static int findSmlst(int[] data, int start){
		int posSmlst = start;
		for (int n=start; n<data.length; n++){
			if (data[n] < data[posSmlst]){
				posSmlst = n;
			}
		}
		return posSmlst;
	}

    public static void swap(int[] data, int value1, int value2){
		int temp = data[value1];
		data[value1] = data[value2];
		data[value2] = temp;
	}

	public static void selectionSort(int[] data){
		for (int n=0; n<data.length; n++){
			swap(data, n, findSmlst(data, n));
		}
	}


    
    public static void main(String[]args){
	int[] randish = new int[15];
	for (int i=0; i<randish.length; i++){
	    randish[i]=(int)(Math.random()*100);
	}
	String toPrint = "";
	for (int r=0; r<randish.length; r++){
	    toPrint +=  randish[r];
	    toPrint += ", ";
	}
	System.out.println("Unsorted: " + toPrint);
        selectionSort(randish);
	String toPrint2 = "";
	for (int r=0; r<randish.length; r++){
	    toPrint2 += randish[r];
	    toPrint2 += ", ";
	}
	System.out.println("Sorted: " + toPrint2);
    }
}
