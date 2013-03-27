package smallbean;

public class MyService {
	
	private MyRepository myRepository;

	public MyService(MyRepository myRepository) {
		this.myRepository = myRepository;
	}

	public MyRepository getMyRepository() {
		return myRepository;
	}

}
