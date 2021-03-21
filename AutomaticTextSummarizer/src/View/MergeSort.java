package View;

public class MergeSort {

	void mergeByInt(Sentence arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        Sentence L[] = new Sentence[n1];
        Sentence R[] = new Sentence[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getIndex() <= R[j].getIndex()) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sortByInt(Sentence arr[], int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;
 
            sortByInt(arr, l, m);
            sortByInt(arr, m + 1, r);
 
            mergeByInt(arr, l, m, r);
        }
    }
    
    void mergeByDouble(Sentence arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        Sentence L[] = new Sentence[n1];
        Sentence R[] = new Sentence[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getValue() <= R[j].getValue()) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sortByDouble(Sentence arr[], int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;
 
            sortByDouble(arr, l, m);
            sortByDouble(arr, m + 1, r);
 
            mergeByDouble(arr, l, m, r);
        }
    }
    
    
}
