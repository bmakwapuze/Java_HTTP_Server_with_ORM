package com.simple.httpserver;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
public class DoStuff {

    static final Logger log = Logger.getLogger(String.valueOf(DoStuff.class));
    public static void main(String args[]) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/test", new  MyHttpHandler());
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

        server.setExecutor(threadPoolExecutor);
        server.start();

        log.info(" Server started on port 8001");
    }

}
