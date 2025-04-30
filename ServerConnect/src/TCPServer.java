import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Server is running and waiting for file transfer...");
        
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Client connected.");
            
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
            
            String fileName = inFromClient.readUTF();
            System.out.println("Receiving file: " + fileName);
            
            String outputDir = System.getProperty("user.dir");
            String outputFilePath = outputDir + File.separator + "received_" + fileName;
            
            FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytes = 0;

            while ((bytesRead = inFromClient.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            fileOutputStream.close();
            
            System.out.println("Total bytes have been read are: " + totalBytes);
            System.out.println("File received successfully: " + outputFilePath);
            
            connectionSocket.close();
        }
    }
}
