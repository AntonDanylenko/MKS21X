public class Sorts{
	public static String name(){
		return "01.Danylenko.Anton"; 
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

	public static void replace(int[] data; int value1; int value2){
		int temp = data[value1];
		data[value1] = data[value2];
		data[value2] = temp;
	}

	public static void selectionSort(int[] data){
		for (int n=0; n<data.length; n++){
			replace(data, data[n], findSmlst(data, n));
		}
	}
}