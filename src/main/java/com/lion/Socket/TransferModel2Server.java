package com.lion.Socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO
 */
public class TransferModel2Server {
    private static final String HOST = "localhost";
    private static final int PORT = 8899;
    private static final String FILE_PATH = "/Users/coderjia/Documents/gradle-5.2.1-all.zip";

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(true);
        FileChannel fileChannel = new FileInputStream(FILE_PATH).getChannel();
        /**
         * Linux零拷贝，减少了多个上下文切换
         */
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        fileChannel.close();
    }
}
