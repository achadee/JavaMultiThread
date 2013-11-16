import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1){
			printError("Invalid amount of arguments specified, you need one!");
			System.out.println("Port Number");
		}
		
		//define the max amount of users
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		
		
	}

	private static void printError(String error) {
		// TODO Auto-generated method stub
		System.out.println("An Error Occured:");
		System.out.println(error);
	}

}


