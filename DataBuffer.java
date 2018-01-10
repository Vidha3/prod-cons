/**
* DataBuffer.java
*
*@author: Vidhathri
*@author: Arjun 
*/

/**
 *  This class implements the DataBuffer. Contains
 *  the buffer which is a string array list. Executes 
 *  the functions of produce and consume.
 */

import java.util.*;
public class DataBuffer {
    final int size;
    static List<String> buffer = new ArrayList<String>();
    /*
    * Constructor to set the size of the buffer
    *
    */
    DataBuffer(int size){
        this.size = size;
    }

    /**
    * produce() - waits if the buffer size has exceeded the limit.
    *  -  else adds data produced by the thread to the buffer.
    *  - once added, notifies the other threads
    *  
    * @param txt - the string to be produced into buffer
    *
    */
    public synchronized void produce(String txt) {
        while (getCount()>=size) {
            try {
                wait();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
        }
        buffer.add(txt);
        System.out.println("Produced data " + txt);
        notify();
    }
    /**
    * produce() - waits if the buffer is empty
    *  -  else, thread consumes the data from buffer.
    *  - once consumed, notifies the other threads 
    *
    */
    public synchronized void consume(int x) {
        
            while (getCount() <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumed data by "+x+" "+buffer.get(getCount()-1));        
            buffer.remove(getCount()-1);
            notify();
    }
    /**
    *getCount() - returns the current size of the buffer.
    */
     public int getCount() {
        return buffer.size();
    }
}