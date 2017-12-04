public class ReversedCharSequence implements CharSequence{
    String data;
    
    public ReversedCharSequence(String given){
	  data = '';
	  for (int n=given.length()-1; n>=0; n++){
	    data += given.charAt(n);
	  }
	}

	public char charAt(int index){
	  return data.charAt(index);
	}

	public int length(){
	  return data.length();
	}

	public String subSequence(int start, int end){
	  return data.subSequence(start, end);
	}

	public String toString(){
	  return data;
	}
}