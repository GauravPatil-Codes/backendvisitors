package com.minister.visitorsapp.helpers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class FTPClientHelper {

    private static final String SERVER = "89.117.188.211"; // Use the IP address directly
    private static final int PORT = 21;
    private static final String USER = "u703629182.visitorsapp";
    private static final String PASS = "Kitintellect@123";

    public String uploadFile(InputStream inputStream, String remoteFileName) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(SERVER, PORT);
            System.out.println("Connected to FTP server: " + SERVER);

            boolean login = ftpClient.login(USER, PASS);

            if (!login) {
                System.out.println("FTP login failed.");
                return null;
            }

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Verify working directory
            String workingDir = ftpClient.printWorkingDirectory();
            System.out.println("Current working directory: " + workingDir);

            String remoteFilePath = "/" + remoteFileName;
            System.out.println("Uploading file to: " + remoteFilePath);

            boolean done = ftpClient.storeFile(remoteFilePath, inputStream);
            inputStream.close();

            if (done) {
                System.out.println("The file is uploaded successfully.");
                return "https://kitintellect.tech/visitorsapp/" + remoteFileName;
            } else {
                System.out.println("Could not upload the file.");
                int replyCode = ftpClient.getReplyCode();
                System.out.println("FTP reply code: " + replyCode);
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}