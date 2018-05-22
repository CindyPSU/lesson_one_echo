
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author IST 411 - Group 3 (Christopher Ferrino, Arlan Hamilton, Raymond Han, Cynthia Hilgeman)
 */
public class Server {
  
    public static void main(String[] args) throws IOException 
    {
        System.out.println("Hello from Server");
        Socket clientSocket; 
        
        try (ServerSocket serverSocket = new ServerSocket(6000))
        {
            System.out.println("Waiting for connection...");
            clientSocket = serverSocket.accept();
            System.out.println("Connected to client");
        
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) 
            {
                String inputLine;
                while ((inputLine = br.readLine()) != null) 
                {
                    System.out.println("Server: " + inputLine);
                    out.println(inputLine);
                } 
            }

        }
        catch (IOException ex) 
        {
            //Code to handle exceptions goes here
        }

    }      
}
  
