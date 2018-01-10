/**
* MyProd.java
*
*@author: Vidhathri
*@author: Arjun 
*/

/**
 *  This class implements the Producer thread. Each producer thread
 *  feeds some data to the buffer, as long as the buffer is not full.
 *	When buffer is full, it waits for consumer to consume data and then
 *  proceeds.
 *
 */
public class MyProd extends Thread {
	int i;
	DataBuffer p;
	/*
	* Constructor to initialize each thread with a number and the
	* object which holds the buffer
	*
	*/
    public MyProd(DataBuffer p, int i) {
        this.p = p;
        this.i = i+1;
    }
    /**
	* run() - overrides run method of Thread class
	* When thread starts, produces some data into the 
	* buffer
	* 
	*/
    public void run(){
    	int empty = p.size - p.getCount();
    	int j;
    	while(empty!=0){

    	 	if(i<=empty){
    			for(j=0; j<i; j++){
    			//buffer isnt full
    				p.produce("Thread-"+this.i+"-"+j);
    				try {
                		sleep(100);
            		} 	
            		catch (InterruptedException e) {
                		e.printStackTrace();
            		}
    			}
    		}
    	}
    }
 }

