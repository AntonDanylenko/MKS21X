import java.util.Arrays;

public class Driver{
  //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static final int EMPTY = 4;

  private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    if(type == EMPTY){
      ans = new int[0];
    }
    return ans;
  }

  public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

	int [][] all = new int[10000][size];
	for (int n=0; n<10000; n++){
		all[n] = makeArray(size, type);
	}
	int [][] results = new int[10000][size];
	for (int r=0; r<10000; r++){
		results[r] = Arrays.copyOf(all[r], size);
	}
	for (int s=0; s<10000; s++){
		Arrays.sort(results[s]);
	}
    
    long startTime = System.currentTimeMillis();
	for (int n=0; n<10000; n++){
		Sorts.insertionSort(all[n]);
	}
    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println(name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
  }
}
