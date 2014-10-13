package randomRequestGenerator;

import java.util.*;

public class RequestGenerator {
	
	//can be set to maximum number of requests needed multiples of 5 (like) 10 / 100 / 1000 
	
	static int maxNumberOfRequests = 10;
	
	static int loopCount=1;
	static int randomNumberCount = 1;
	
	//can be set to 1 / 10 / 24 corresponding to time frame hours
	static int timeDelayFactor = 1;
	
	static Timer timer = new Timer();
	static ArrayList<Integer> randomNumbersList = new ArrayList<Integer>();   
	
	static ArrayList<MobileRequest> mobileRequestList = new ArrayList<MobileRequest>();
	
    static class Task extends TimerTask {
        
        public void run() {
        	
            //variable to store selected random number
            int selectedRandomNumber;
            
            //list of resources available
           /* String[] CPU1, Storage1, Network1;
            CPU1 = new String[]{"Ubuntu, 64Bit, 1GB", "Ubuntu, 64Bit, 1GB", "Ubuntu, 64Bit, 1GB", "Ubuntu, 64Bit, 1GB", "Ubuntu, 64Bit, 1GB"};
            Storage1 = new String[]{"5MB", "40MB", "25MB", "20MB", "50MB"};
            Network1 = new String[]{"20MBPS", "40MBPS", "50MBPS", "25MBPS", "15MBPS"};*/
            
            //Radhika - making them int so that they can easily be put into class variables of an mobileRequest object.  
            
            int[]  Storage1, Network1;
            String[]  CPU1;
            CPU1 = new String[]{"Ubuntu,64,1", "Ubuntu,64,1", "Ubuntu,64,1", "Ubuntu,64,1", "Ubuntu, 64,1"};
            //Storage in MB
            Storage1 = new int[]{5,40,25,20,50};
            //NW is MBPS
            Network1 = new int[]{ 20,40,50,25,15};
            
            
            
            //start the loop to generate 10 requests in random time intervals
            
         
            if (loopCount <= maxNumberOfRequests){
            	
            	//generating random numbers without duplicates
            	if (randomNumberCount>5) { 
            		randomNumberCount = 1; 
            		randomNumbersList.clear();
            	}
            	
            	if (randomNumberCount==1) {
            		
            		for(int i = 1; i <= 5; i++)  {     
            			randomNumbersList.add(i);  
            		} 
            		
        			Collections.shuffle(randomNumbersList);
        	   	}
        		     
        		 
            	selectedRandomNumber = (int) randomNumbersList.get((randomNumberCount-1));
        		        		
        		//delay is calculated in milliseconds so multiplied by 1000
        		int delay = ((selectedRandomNumber) * 1000)*timeDelayFactor;
        		
        		//printing request details, delay time and request generated time
                System.out.println("Request Number --> "+ loopCount +"----Random Number-->" +selectedRandomNumber );
                System.out.println("CPU: "+CPU1[selectedRandomNumber-1]+"\nStorage: "+Storage1[selectedRandomNumber-1]+"\nBandwidth: "+Network1[selectedRandomNumber-1]);
                System.out.println("The time delay for next request is "+delay/1000 + " Seconds.");
                timer.schedule(new Task(), delay);
                System.out.println("Request generated at " +new Date()+"\n");
                
                
                //forming the requestArrayList
                
                //Splitting the String;
                
                String CPUParameter = CPU1[selectedRandomNumber-1];
                //splitting to get OS type
                String OSType= CPUParameter.substring(0,CPUParameter.indexOf(','));
                CPUParameter=CPUParameter.substring(CPUParameter.indexOf(',')+1);
                //splitting to get OS bit size
                String OSBit= CPUParameter.substring(0,CPUParameter.indexOf(','));
                int OSBit1 = Integer.parseInt(OSBit.trim());
                //splitting to get Ram Size
                String OSRam=CPUParameter.substring(CPUParameter.indexOf(',')+1);
                int OSRam1 = Integer.parseInt(OSRam.trim());
                
                //forming the mobile request and adding the request to the mobileRequestList
                mobileRequestList.add(new MobileRequest(selectedRandomNumber, Storage1[selectedRandomNumber-1], OSType, OSBit1, OSRam1, Network1[selectedRandomNumber-1]));
                
                
                
                //incrementing the static counters
                loopCount++;
                randomNumberCount++;
                 
            }
            else {
            	System.out.println("\n---All " + maxNumberOfRequests +" Requests has been created--- ");
            	timer.cancel();
            }
        		
            	
            
        }
    }

	 

    public static void main(String[] args) throws Exception {
    	
        new Task().run();
    	
    }
}