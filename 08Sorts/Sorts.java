public class Sorts{
	//Naming
	public static String name(){
		return "09.Danylenko.Anton"; 
	}



	//General Helper Functions
	public static void swap(int[] data, int index1, int index2){
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}



	//Insertion Sort
	public static void insertionSort(int[] data){
		for (int n=1; n<data.length; n++){
			int r = n;
			while (r>0 && data[r]<data[r-1]){
				swap(data, r, r-1);
				r--;
			}
		}
	}



	//Selection Sort and Helper Functions
	public static void selectionSort(int[] data){
		for (int n=0; n<data.length; n++){
			swap(data, n, findSmlst(data, n));
		}
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



	//Bubble Sort and Helper Functions
	public static void bubbleSort(int[] data){
		while (!isSorted(data)){
			for (int n=0; n<data.length-1; n++){
				if(data[n]>data[n+1]){
					swap(data, n, n+1);
				}
			}
		}
	}

	public static boolean isSorted(int[] data){
		for (int n=0; n<data.length-1; n++){
			if (data[n]>data[n+1]){
				return false;
			}
		}
		return true;
	}
}
