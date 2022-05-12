import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<T>{
    private Object[] myList;
    private int size=0;



    public <T> MyList(){

        this.myList= (T[]) new Object[10];
    }

    public <T>  MyList( int capacity){
        this.myList= (T[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    public int getCapacity(){
        return myList.length;
    }

    public void add(T data){
        if(size== myList.length){
            Object[] temp =  myList;

            myList = new Object[temp.length*2];
            for(int i=0;i<size;i++)
                myList[i]=temp[i];


        }
            myList[size++]=data;
    }

    public T get(int index){
        if(index<0 || index>= myList.length)
            return null;
        return (T) myList[index];
    }

    public T set(int index, T data){
        if(index<0 || index>= myList.length)
            return null;
        if(myList[index]==null)  {
            myList[index]=data;
            size++;
        }
        return (T)myList[index];
    }

    public T remove(int index){
        Object data= myList[index];

        if(index<0 || index>= myList.length)
            return null;
        if(myList[index]!=null) {

            for (int i = index+1; i < myList.length; i++)
                myList[i-1] = myList[i];
            myList[size] = null;
            size--;
        }
        return (T)data;
    }
    public String toString(){
        String str ="";
        if(size>0)
        {
            for(int i=0;i<size;i++)
            {
                str +=myList[i] +",";
            }
            str=str.substring(0,str.length()-1);
        }
        str="["+ str +"]";




        return str;
    }

    public int indexOf(T data){
        for(int i=0;i<size;i++){
            if(myList[i].equals(data))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int index=-1;
        for(int i=0;i<size;i++){
            if(myList[i].equals(data))
                index= i;
        }
        return index;
    }
    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }
    public T[] toArray(){
        Object[] arr =new Object[size];
        for(int i=0;i<size;i++)
            arr[i]=myList[i];

        return (T[])arr;
    }
    public void clear(){
        for(int i=0;i<size;i++)
            myList[i]=null;

        size=0;
    }
    public MyList<T> sublist(int start,int finish){
        MyList<T> arr = new MyList<>(finish-start+1);
        int indis=0;
        for(int i=start;i<finish-start+1;i++)
        {
            arr.add((T)myList[i]);
        }
        return arr;
    }

    public boolean contains(T data){
        for(int i=0;i<size;i++){
            if(myList[i].equals(data))
                return true;
        }
        return false;
    }
}
