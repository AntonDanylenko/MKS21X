public class ReversedCharSequence implements CharSequence{
    private String data;
    
    public ReversedCharSequence(String given){
	  data = "";
	  for (int n=given.length()-1; n>=0; n--){
	    data += given.charAt(n);
	  }
	}

	public char charAt(int index){
	  return data.charAt(index);
	}

	public int length(){
	  return data.length();
	}

	public CharSequence subSequence(int start, int end){
	  return data.subSequence(start, end);
	}

	public String toString(){
	  return data;
	}

	public static void main(String[]args){
		String a = "abcdefg";
		
		ReversedCharSequence b = new ReversedCharSequence(a);

		System.out.println("b: " + b);

		System.out.println("First char of b: " + b.charAt(0));

		System.out.println("Length of b: " + b.length());

		System.out.println("Subsequence: " + b.subSequence(1,4));
	}
}