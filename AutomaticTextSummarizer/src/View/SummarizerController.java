package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SummarizerController{

	String [] sentences;
	Sentence [] sntncs;
	String text;
	StopWords sp;
	CosineSimilarity cs ;
	int max = 0;
	
	public SummarizerController(String text,int p) throws SummerizerException, IOException {
		sp = new StopWords();
		getText(text);
		String s = ktheText(p);
		System.out.println(s);
	}
	

	public void getText(String file) throws IOException, SummerizerException {
		File f = new File(file);
		getTxt(getT(f));
	}
	
	
	private String getT(File f) throws IOException {
		String text = null;
		String sentence;
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		while((sentence = br.readLine()) != null) {
			text += sentence; 
		}
		return text;
	}
	
	public void getTxt(String text) throws SummerizerException {
	    this.text = text;
		sentences = text.split(".");
		sntncs = new Sentence[sentences.length];
		int n = 0;
		for(int i = 0; i < sentences.length; i++) {
			Sentence s = new Sentence(sentences[i]);
			s.setIndex(i);
			String [] fjalet = sentences[i].split(" ");
			for(String fjala : fjalet) {
				s.shtoFjalen(fjala);
			}
			sntncs[i] = s;
			n = s.numriIFjaleve();
			if(n > max) max = n;
		}
		createVectors();
		cs = new CosineSimilarity(sntncs);
	}
	
	public String ktheText(int p) {
		String s = cs.getT(p);
		return s;
	}
	
	public void createVectors() {
		for(Sentence s : sntncs) {
			s.setVector(max);
		}
	}
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Shtyp emrin e file-it:");
		String file = scan.next();
		System.out.println("Shtyp perqindjen e permbledhjes:");
		int p = scan.nextInt();
		SummarizerController s = null;
		try {
			s = new SummarizerController(file,p);
		} catch (SummerizerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}