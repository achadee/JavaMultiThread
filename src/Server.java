import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length != 2){
			printError("Invalid amount of arguments specified, you need two!");
			System.out.println("Port Number");
			System.out.println("Max Threads");
		}
		
		 // Register service on port 1234
        ServerSocket s = new ServerSocket(Integer.parseInt(args[0]));
        ExecutorService pool = Executors.newFixedThreadPool(Integer.parseInt(args[1]));

        // listen for new connections, create new request handler to process request
        try {
                while (true) {
                        pool.execute(new ThreadInstance(s.accept()));
                }
        } catch (IOException ioe) {
                pool.shutdown();
        }

        s.close();
		
	}

	private static void printError(String error) {
		// TODO Auto-generated method stub
		System.out.println("An Error Occured:");
		System.out.println(error);
	}

}


