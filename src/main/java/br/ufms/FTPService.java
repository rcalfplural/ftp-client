package br.ufms;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;

public class FTPService {
    public FTPClient loginFtp(String host, int port, String username, String password) throws Exception {
        FTPClient client = new FTPClient();

        // Command Listener
        client.addProtocolCommandListener(new CommandListener());

        // Conecta e loga no servidor FTP
        client.connect(host, port);
        client.enterRemotePassiveMode();
        client.login(username, password);
        return client;
    }

    public void printTree(String path, FTPClient ftpClient) throws Exception{
        for(FTPFile ftpFile: ftpClient.listFiles(path)){
            System.out.println();
            System.out.printf("[printTree][%d]\n", System.currentTimeMillis());
            System.out.printf("[printTree][%d] Get name : %s \n", System.currentTimeMillis(), ftpFile.getName());
            System.out.printf("[printTree][%d] Get timestamp : %s \n", System.currentTimeMillis(), ftpFile.getTimestamp().getTimeInMillis());
            System.out.printf("[printTree][%d] Get group : %s \n", System.currentTimeMillis(), ftpFile.getGroup());
            System.out.printf("[printTree][%d] Get link : %s \n", System.currentTimeMillis(), ftpFile.getLink());
            System.out.printf("[printTree][%d] Get user : %s \n", System.currentTimeMillis(), ftpFile.getUser());
            System.out.printf("[printTree][%d] Get type : %s \n", System.currentTimeMillis(), ftpFile.getType());
            System.out.printf("[printTree][%d] Is file : %s \n", System.currentTimeMillis(), ftpFile.isFile());
            System.out.printf("[printTree][%d] Is directory : %s \n", System.currentTimeMillis(), ftpFile.isDirectory());
            System.out.printf("[printTree][%d] Formatted string : %s \n", System.currentTimeMillis(), ftpFile.toFormattedString());
            System.out.println();

            if(ftpFile.isDirectory()){
                printTree(path + File.separator + ftpFile.getName(), ftpClient);
            }
        }

    }
    public void uploadFile(String localPath, String remotePath, FTPClient ftpClient) throws Exception{

    }
}
