/**
* MyCons.java
*
*@author: Vidhathri
*@author: Arjun 
*/

/**
 *  This class implements the Consumer thread. Each consumer thread
 *  consumes some data off the buffer, as long as the buffer is not empty.
 *	When buffer is empty, it waits for producer to produce data and then
 *  proceeds.
 *
 */
public class MyCons extends Thread {
    private DataBuffer db;
    int j;

    /*
	* Constructor to initialize each thread with the
	* object which holds the buffer
	*
	*/
    public MyCons(DataBuffer db, int j) {
        this.db = db;
        this.j = j+1;
    }
 
 	/**
	* run() - overrides run method of Thread class
	* When thread starts, consumes some data from the 
	* buffer
	* 
	*/
    public void run() {
        int i;
        while(db.getCount()>0){
        if(db.getCount()>=j){
        	for (i=0; i<j; i++){
        		//System.out.print("Cons "+i);
         	   	db.consume(j);
            	try {
                	sleep(100);
            	} catch (InterruptedException e) {
                	e.printStackTrace();
            	}
            	
        	} 
    	}	
    }
    }
}