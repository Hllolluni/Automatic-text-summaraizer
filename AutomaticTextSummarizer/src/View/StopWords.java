package View;

public class StopWords {

	public boolean stopWords(String text) {
		if(text.length() <= 3) return false;
		return true;
	}

}