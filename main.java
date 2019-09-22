//Lab 2
//Asad Ali Bhatti
//i170312
//6 sep 2019

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class i170312 {
    private static final int DEFAULT_CAP = 10;
     int[] iValues;
     int iSize;

    public i170312() {
        this(DEFAULT_CAP);
    }

    public i170312(int initialCap) {
        assert initialCap > 0 : "Exception" + "initialCap<0" + initialCap;
        iValues = new int[initialCap];
        iSize = 0;
    }

     void add(int x) {
        if (iSize == iValues.length)
            resize();


        assert 0 <= iSize && iSize < iValues.length;
        iValues[iSize] = x;
        iSize++;
    }

    public void resize() {
        int[] temp = new int[iValues.length * 2];
        System.arraycopy(iValues, 0, temp, 0, iValues.length);
        iValues = temp;
    }

    public String toString() {
        String result = "Size : " + iSize + ", elements : [";
        for (int i = 0; i < iSize - 1; i++) {
            result += iValues[i] + ",";
        }
        if (iSize > 0) {
            result += iValues[iSize - 1];
        }
        result += "]";
        return result;
    }

    public String toStringUsingBuffer() {
        StringBuffer result = new StringBuffer();

        result.append("Size: ");
        result.append(iSize);
        result.append(", elements : [");
        for (int i = 0; i < iSize - 1; i++) {
            result.append(iValues[i] + ",");
        }
        result.append("]");
        return result.toString();
    }

    // int size() – Return the Size of he list
    public int size() {
        return iValues.length;
    }

    public void ensureCapcity() {
        if (iSize < size()) {
            System.out.println("yes");


        }
        else
            System.out.println("No");
    }
    void printToFile(String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }// catch (IOException e) {
           // e.printStackTrace();
        //}
    }
    void insert(int pos, int x) {
        if (pos > iSize) {
            System.out.println("At this time ,pos should be< " + iSize);
        }


        if (iSize == iValues.length) {
            resize();
        }


        if (pos == iSize) {
            iValues[iSize] = x;

        }
        else if (pos < iSize) {

            for (int i = iSize; i > pos; i--) {
                iValues[i] = iValues[i - 1];
            }
            iValues[pos] = x;

        }
        iSize++;
        System.out.println("Inserted Successfully");


    }
    int remove(int pos) {
        if (pos >= iSize) {
            System.out.println("index out of range");
            return -1;
        }


       int res= iValues[pos];
            for (int i = pos; i < iSize-1; i++) {
                iValues[i] = iValues[i + 1];
            }



        iSize--;
        System.out.println("removed Successfully");
        return res;


    }


}
class SortedIntList extends i170312{
    public SortedIntList() {
    }

    public SortedIntList(int initialCap) {
        super(initialCap);
    }

    void sort(){
        for(int i=0;i<iSize;i++){
            for(int j=i+1;j<iSize;j++){
                if(iValues[i]>iValues[j]){
                    int temp=iValues[i];
                    iValues[i]=iValues[j];
                    iValues[j]=temp;
                }
            }
        }
    }
    void insert(int pos, int x) {
        super.insert(pos,x);
        sort();
    }
    void add(int x){
        super.add(x);
        sort();
    }

}
class main{
    public static void main(String[] args) {
        SortedIntList l=new SortedIntList();
        l.add(3);
        l.add(4);
        l.add(2);
        l.add(1);
        l.insert(0,0);
        System.out.println(l.toString());

    }

}



