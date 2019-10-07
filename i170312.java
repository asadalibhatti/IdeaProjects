//Lab 2
//Asad Ali Bhatti
//i170312
//6 sep 2019

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class i170312<T> {
    private static final int DEFAULT_CAP = 10;
    private T[] iValues;
    private int iSize;

    public i170312(){
        iValues=(T[]) new Object[DEFAULT_CAP];
        iSize=0;
    }

    public i170312( int initialCap) {
        assert initialCap > 0 : "Exception" + "initialCap<0" + initialCap;
        iValues =(T[]) new Object[initialCap];
        iSize = 0;
    }

    void add(T x) {

        if (iSize == iValues.length)
            resize();


        assert 0 <= iSize && iSize < iValues.length;
        iValues[iSize] = x;
        iSize++;
    }

    public void resize() {
        T [] temp =  (T[])new Object[iValues.length * 2];
        System.arraycopy(iValues, 0, temp, 0, iValues.length);
        iValues = temp;
    }

    public String toString() {
        String result = "Size : " + iSize + ", elements : [";
        for (int i = 0; i < iSize - 1; i++) {
            result += (T)iValues[i] + ",";
        }
        if (iSize > 0) {
            result += (T)iValues[iSize - 1];
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
            result.append((T)iValues[i] + ",");
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
    void insert(int pos, T x) {
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
    T remove(int pos) {
        if (pos >= iSize) {
            System.out.println("index out of range");
            return null;
        }


        T res= (T)iValues[pos];
        for (int i = pos; i < iSize-1; i++) {
            iValues[i] = iValues[i + 1];
        }



        iSize--;
        System.out.println("removed Successfully");
        return res;


    }
    public static void main(String[] args) {
        i170312<Integer> o1=new i170312<Integer>();
        o1.add(2);
        o1.add(4);
        o1.add(6);
        o1.add(8);
        o1.add(10);
        o1.add(12);
        System.out.println(o1.toString());
        o1.ensureCapcity();
        System.out.println(o1.size());
        o1.insert(6,14);
        System.out.println(o1.toString());
        o1.add(16);//7
        o1.add(18);//8
        o1.add(20);//9
        System.out.println(o1.toString());
        o1.insert(0,0);
        System.out.println(o1.toString());
        o1.insert(11,22);
        o1.insert(5,11);
        System.out.println(o1.toString());
        o1.remove(0);
        o1.remove(11);
        System.out.println(o1.toString());
        o1.insert(0,22);
        o1.insert(11,11);
        System.out.println(o1.toString());
        o1.printToFile("task2v1.txt");
    }
}