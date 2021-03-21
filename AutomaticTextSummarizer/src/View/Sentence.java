package View;

import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class Sentence {
	private String fjalia;
	private LinkedHashMap<String,Integer> fjalet;
	private int [] vector;
	private StopWords sp;
	private double value;
	private int index;
	private int num = 0;
	
	public Sentence(String f) {
		this.fjalia = f;
		this.fjalet = new LinkedHashMap<String,Integer>();
		this.sp = new StopWords();
	}
	
	public void shtoFjalen(String fjala) {
		if(sp.stopWords(fjala)) return;
		if(fjalet.containsKey(fjala)) {
			fjalet.put(fjala, fjalet.get(fjala)+1);
			num++;
			return;
		}
		fjalet.put(fjala, 1);
		num++;
	}
	
	public String getFjalia() {
		return fjalia;
	}
	public void setVector(int N) {
		vector = new int[N];
		int n = N - fjalet.size();

		for(Entry<String,Integer> word: fjalet.entrySet()) {
			vector[n] = word.getValue();
			n++;
		}
	}

	public int numriIFjaleve() {
		return num;
	}

	public int[] getVector() {
		return vector;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double val) throws SummerizerException{
		this.value = val;
	}

	public void setIndex(int i) {
		this.index = i;		
	}

	public int getIndex() {
		return index;
	}
}