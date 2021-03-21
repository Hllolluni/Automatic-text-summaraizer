package View;
/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
*/
public class CosineSimilarity {
	Sentence [] sentences;
	Sentence [] scs;
	double [][] matrix;
	MergeSort mg;
	
	public CosineSimilarity(Sentence []sentences) throws SummerizerException{
		this.sentences = sentences;
		this.matrix = new double[sentences.length][sentences.length];
		this.mg = new MergeSort();
		createMatrix();
		values();
		mg.sortByDouble(sentences,0,sentences.length);
	}
	
	public void createMatrix() throws SummerizerException {
		for(int i = 0; i < sentences.length; i++) {
			for(int j = i+1; j < sentences.length; j++) {
				double sim = cosSim(sentences[i],sentences[j]);
				if(i == j) {
					matrix[i][j] = sim;
					continue;
				}
				matrix[i][j] = sim;
				matrix[i][j] = sim;
			}
		}
	}
	public double cosSim(Sentence right, Sentence left) throws SummerizerException {
		int [] rightV = right.getVector();
		int [] leftV = left.getVector();
		return dotProd(rightV,leftV)/dotModProd(rightV,leftV);
	}
	
	public double dotProd(int [] v1, int [] v2) throws SummerizerException {
		
		if(v1.length != v2.length) {
			throw new SummerizerException("Duhet te jene te gjatesive te njejta!");
		}
		int N = v1.length;
		double prod = 0;
		for(int i = 0; i < N; i++) {
			prod += v1[i]*v2[i];
		}
		return prod;
	}
	
	public double dotModProd(int [] v1, int [] v2) {
		double mod1 = 0;
		double mod2 = 0;
		for(int i = 0; i < v1.length; i++) {
			mod1 += Math.pow(v1[i], 2);
			mod2 += Math.pow(v2[i], 2);
		}
		return Math.sqrt(mod1)*Math.sqrt(mod2);
	}
	
	public void values() throws SummerizerException {
		
		for(int i = 0; i < matrix.length; i++) {
			double d = 0;
			for(int j = 0; j < matrix[i].length; j++) {
				d += matrix[i][j];
			}
			sentences[i].setValue(d);
		}
	}
	
	public String getT(int p) {
		String s = "";
		double pt = p/100 * sentences.length;
		mg.sortByInt(scs, 0, (int)pt);
		for(int i = 0; i < (int)pt; i++) {
			s += "\n"+sentences[i].getFjalia();
		}
		return s;
	}
}