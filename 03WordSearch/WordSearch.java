import java.util.*;
import java.io.*;
public class WordSearch{
    private char[][] data;
	private ArrayList<String> wordsToAdd;
	private ArrayList<String> wordsAdded;
	private Random rng;
	private int randSeed;
	private int[] randomNumsRows;
	private int[] randomNumsCols;
	private int[] randomNumsRInc;
	private int[] randomNumsCInc;
	private char[][] solution;

	public WordSearch(){
	  System.out.println("Welcome to the Word Search Creator.");
	  System.out.println("To create a new word search input the number of rows and columns you want it to have.");
      System.out.println("Additionally, input the name of the file that includes the words you want to use.");
	  System.out.println("If you want a certain word search, add the seed too.");
	  System.out.println("Finally, if you want the solution to your word search, just add the String key to the end of your input.");
	}

    public WordSearch(int rows, int cols, String fileName){
	  data = new char[rows][cols];
	  solution = new char[rows][cols];
	  clear();
	  randSeed = (int)(System.currentTimeMillis()%1000);
	  rng = new Random(randSeed);
	  makeWordsToAdd(rows, cols, fileName);
	  //System.out.println("WordsToAdd: " + wordsToAdd);
	  addAllWords(rows, cols);
	  //copy2DArray(data, solution);
	  addRandLetters(rows, cols);
    }

	public WordSearch(int rows, int cols, String fileName, int randSeed){
	  data = new char[rows][cols];
	  clear();
	  rng = new Random(randSeed);
	  makeWordsToAdd(rows, cols, fileName);
	  addAllWords(rows, cols);
	  //copy2DArray(data, solution);
	  addRandLetters(rows, cols);
    }

	public WordSearch(int rows, int cols, String fileName, int randSeed, String answers){
	  data = new char[rows][cols];
	  clear();
	  rng = new Random(randSeed);
	  makeWordsToAdd(rows, cols, fileName);
	  addAllWords(rows, cols);
	  if (!answers.equals("key")){
	    addRandLetters(rows, cols);
	  }
	}


	public int getSeed(){
	  return randSeed;
	}

	/*public String getSolution(){
	  String result = "";
	  for (int n=0; n<solution.length; n++){
		for (int r=0; r<solution[n].length; r++){
		  result = result + solution[n][r] + " ";
		}
		result+="\n";
	  }
	  return result;
    }*/

	/*private void copy2DArray(char[][] old, char[][] result){
	  for (int n=0; n<old.length; n++){
		for (int r=0; r<old[n].length; r++){
		  result[n][r]=old[n][r];
		}
	  }
	}*/

    private void clear(){
	  for (int n=0; n<data.length; n++){
		for (int r=0; r<data[n].length; r++){
		  data[n][r]='_';
		}
	  }
    }

    public String toString(){
	  String result = "";
	  for (int n=0; n<data.length; n++){
		for (int r=0; r<data[n].length; r++){
		  result = result + data[n][r] + " ";
		}
		result+="\n";
	  }
	  return result;
    }



	private void makeWordsToAdd(int rows, int cols, String fileName){
	  wordsToAdd = new ArrayList<String>();
	  try{
		File f = new File(fileName);
		Scanner in = new Scanner(f);
	    while(in.hasNext()){
		  String word = in.next();
		  //System.out.println(word);
		  if (word.length()<=rows || word.length()<=cols){
		    wordsToAdd.add(word);
		  }
	    }
	  }
	  catch (FileNotFoundException e){
		System.out.println("File not found: " + fileName);
        System.exit(1);
	  }
	}



	private void makeRandomNumsRows(int rows, Random rng){
	  randomNumsRows = new int[wordsToAdd.size()];
	  for (int n=0; n<wordsToAdd.size(); n++){
		randomNumsRows[n] = Math.floorMod(rng.nextInt(), rows);
	  }
	}

	private void makeRandomNumsCols(int cols, Random rng){
	  randomNumsCols = new int[wordsToAdd.size()];
	  for (int n=0; n<wordsToAdd.size(); n++){
		randomNumsCols[n] = Math.floorMod(rng.nextInt(), cols);
	  }
	}

	private void makeRandomNumsRInc(Random rng){
	  randomNumsRInc = new int[wordsToAdd.size()];
	  int[] increments = {-1, 0, 1};
	  for (int n=0; n<wordsToAdd.size(); n++){
		//System.out.println(Math.floorMod(rng.nextInt(), 3));
		randomNumsRInc[n] = increments[Math.floorMod(rng.nextInt(), 3)];
	  }
	}

	private void makeRandomNumsCInc(Random rng){
	  randomNumsCInc = new int[wordsToAdd.size()];
	  int[] increments = {-1, 0, 1};
	  for (int n=0; n<wordsToAdd.size(); n++){
		randomNumsCInc[n] = increments[Math.floorMod(rng.nextInt(), 3)];
	  }
	}



	private boolean addWord(String word, int row, int col, int rInc, int cInc){
	  if (row<0 || col<0 || row>data.length || col>data.length ||
		  row + (word.length() * rInc)<0 || row + (word.length() * rInc) > data.length ||
	      col + (word.length() * cInc)<0 || col + (word.length() * cInc) > data[0].length ||
		  (rInc==0 && cInc==0)){
        return false;
	  }
      for (int n=0; n<word.length(); n++){
	    if (data[row+(n*rInc)][col+(n*cInc)]!='_' && data[row+(n*rInc)][col+(n*cInc)]!=word.charAt(n)){
	      return false;
        }
	  }
      for (int n=0; n<word.length(); n++){
	    data[row+(n*rInc)][col+(n*cInc)] = word.charAt(n);
	  }
	  return true;
	}

	private boolean addAllWords(int rows, int cols){
	  wordsAdded = new ArrayList<String>();
	  for (int r=0; r<50; r++){
		//System.out.println(wordsAdded);
	    for (int n=0; n<wordsToAdd.size(); n++){
		  makeRandomNumsRows(rows, rng);
		  //System.out.println("RandomNumsRows: " + Arrays.toString(randomNumsRows));
		  makeRandomNumsCols(cols, rng);
		  //System.out.println("RandomNumsCols: " + Arrays.toString(randomNumsCols));
		  makeRandomNumsRInc(rng);
		  //System.out.println("RandomNumsRInc: " + Arrays.toString(randomNumsRInc));
		  makeRandomNumsCInc(rng);
		  //System.out.println("RandomNumsCInc: " + Arrays.toString(randomNumsCInc));
		  if (addWord(wordsToAdd.get(n), randomNumsRows[n], randomNumsCols[n], randomNumsRInc[n], randomNumsCInc[n])){
			wordsAdded.add(wordsToAdd.get(n));
			wordsToAdd.remove(wordsToAdd.get(n));
			
		  }
		}
	  }
	  if (wordsAdded.size()>0){
	    return true;
	  }
	  return false;
	}

	private void addRandLetters(int rows, int cols){
	  for (int n=0; n<rows; n++){
		for (int r=0; r<cols; r++){
		  if (data[n][r]=='_'){
			data[n][r] = (char)(Math.floorMod(rng.nextInt(), 26)+97);
		  }
		}
	  }
	}
}































