/**
* MyProdCons.java
*
*@author: Vidhathri
*@author: Arjun 
*/

/**
 *  This class implements the main function
 *  It intantiates the data buffer object, creates a buffer
 *  Starts the producer and consumer threads.
 */

class MyProdCons{
	public static void main(String[] args) {
		if(args.length != 3){
			System.out.println("java MyProdCons buffer_size no_of_producers no_of_consumers");
			System.exit(-1);
		}
		int buf_size = Integer.parseInt(args[0]);
		int prod = Integer.parseInt(args[1]);
        int cons = Integer.parseInt(args[2]);
        DataBuffer p = new DataBuffer(buf_size);
        int i;
        MyProd[] producer = new MyProd[prod];
        MyCons[] consumer = new MyCons[cons];

        for(i=0; i<prod; i++){
        	producer[i] = new MyProd(p,i);
        	producer[i].start();
        }
        for(i=0; i<cons; i++){
        	consumer[i] = new MyCons(p,i);
        	consumer[i].start();
    	}
    	/*try{
    		for(i=0; i<prod; i++){
        		producer[i].join();
       		}
        	for(i=0; i<cons; i++){
        		consumer[i].join();
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}*/
    	/*limitation: goes into deadlock state because at one point there are no consumer
    	 threads and all producers are waiting for consumers to eat something but then consumers 
    	 are waiting for producers to notify them so we add an infinite while, 
    	 now it is producing one consuming one and so on*/
    }
}