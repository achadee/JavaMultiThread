import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ThreadInstance implements Runnable {

    private Socket s;
    private Dictionary dictionary;
	
	public ThreadInstance(Socket clientSocket){
        this.s = clientSocket;
        this.dictionary = new Dictionary();
	}

    public void run()
    {
            try {
                    InputStream sin = s.getInputStream();
                    DataInputStream dis = new DataInputStream(sin);
                    String word = new String(dis.readUTF());

                    String meaning = new String(dictionary.getMeaning(word));

                    OutputStream sout = s.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(sout);
                    dos.writeUTF(meaning);

                    dos.close();
                    sout.close();
                    s.close();
            }
            catch (IOException ioe) {
                    ioe.printStackTrace();
            }
    }

}
