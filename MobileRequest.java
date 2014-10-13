package randomRequestGenerator;

/*
Created by Radhika - gives the details of each of mobile request generated;
*/
public class MobileRequest 
{
	//Request number
	private int requestIdentfier;
	//Storage in MB
	private int storageQuantity;
	//CPU parameters
	private  CpuRequest cpuQuantity;
	//Network in MBPS
	private int networkQuantity;
	
	
	//Constructors - the constructor has to have Request number minimum.
	
	public MobileRequest(int requestNo) 
	{
		//the default values given are 25MB; linux-64bit-1 GB and 20MBPS
		requestIdentfier= requestNo;
		storageQuantity= 25;
		cpuQuantity = new CpuRequest();
		networkQuantity= 20;
	}
	
	public MobileRequest(int requestNo,int requiredStorage, String OSType, int OSBits, int OSRam,int requiredNw)
	{
		requestIdentfier= requestNo;
		storageQuantity=requiredStorage;
		cpuQuantity=new CpuRequest(OSType,OSBits,OSRam);
		networkQuantity=requiredNw;
	}
	
	
	public MobileRequest(int requestNo,int requiredStorage, CpuRequest cpuRequestParameters ,int requiredNw)
	{
		requestIdentfier= requestNo;
		storageQuantity=requiredStorage;
		cpuQuantity=cpuRequestParameters;
		networkQuantity=requiredNw;
	}

	
	
	//setters and getters
	
	public int getRequestIdentfier() {
		return requestIdentfier;
	}

	public void setRequestIdentfier(int requestIdentfier) {
		this.requestIdentfier = requestIdentfier;
	}

	public int getStorageQuantity() {
		return storageQuantity;
	}

	public void setStorageQuantity(int storageQuantity) {
		this.storageQuantity = storageQuantity;
	}

	public CpuRequest getCpuQuantity() {
		return cpuQuantity;
	}

	public void setCpuQuantity(CpuRequest cpuQuantity) {
		this.cpuQuantity = cpuQuantity;
	}

	public int getNetworkQuantity() {
		return networkQuantity;
	}

	public void setNetworkQuantity(int networkQuantity) {
		this.networkQuantity = networkQuantity;
	}
	
	
	

}
