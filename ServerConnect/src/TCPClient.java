import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String argv[]) throws Exception {
        String fileName;
        File file;
        FileInputStream fileInputStream = null;
        DataOutputStream outToServer = null;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter file name to send: ");
        fileName = inFromUser.readLine();
        
        file = new File(fileName);
        
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        
        //CHECK IP ADDRESS AND SERVER PORT
        Socket clientSocket = new Socket("10.50.18.229", 6789);
        
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        outToServer.writeUTF(file.getName());

        fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int bytesRead;
        long totalBytes = 0;

        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outToServer.write(buffer, 0, bytesRead);
            totalBytes += bytesRead;
        }

        fileInputStream.close();
        outToServer.flush();
        
        System.out.println("Total bytes have been transferred are: " + totalBytes);
        System.out.println("File transfer completed.");
        
        clientSocket.close();
    }
}
