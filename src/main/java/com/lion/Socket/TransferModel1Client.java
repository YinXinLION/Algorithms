package com.lion.Socket;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * BIO
 */
public class TransferModel1Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8899;
    private static final String FILE_PATH = "/Users/coderjia/Documents/gradle-5.2.1-all.zip";
    private static final int MB = 1024 * 1024;


    public static void main(String[] args) throws Exception {
        Socket socket= new Socket(HOST, PORT);
        InputStream inputStream = new FileInputStream(FILE_PATH);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[MB];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
