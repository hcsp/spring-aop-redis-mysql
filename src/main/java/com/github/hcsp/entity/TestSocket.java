package com.github.hcsp.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.contains;

public class TestSocket {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            final String line = bufferedReader.readLine();
//            System.out.println(line);
            List<String> httpRequestHeaderLines = new ArrayList<>();
            String line;
            while (!(line = bufferedReader.readLine()).isEmpty()) {
                System.out.println(line);
                httpRequestHeaderLines.add(line);
            }

            String firstLine = httpRequestHeaderLines.get(0);
            int begin = firstLine.indexOf("/");
            int to = firstLine.substring(begin).indexOf(" ") + begin;
            String resourceName = firstLine.substring(begin, to);
            System.out.println(resourceName);
            if (resourceName.contains(".js") || resourceName.endsWith(".css") || resourceName.endsWith(".jpg")) {
                socket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
                if (resourceName.contains(".js")) {
                    socket.getOutputStream().write("content-type: application/javascript;charset=utf8\r\n".getBytes());
                }else if(resourceName.endsWith(".css")){
                    socket.getOutputStream().write("content-type: text/css;charset=utf8\r\n".getBytes());

                }else if(resourceName.endsWith(".jpg")){
                    socket.getOutputStream().write("content-type: image:jpeg\r\n".getBytes());

                }
                socket.getOutputStream().write("\r\n".getBytes());
                InputStream is = TestSocket.class.getResourceAsStream(resourceName);
                if(resourceName.endsWith(".jpg")){
                    int a;
                    while((a=is.read())!=-1){
                        socket.getOutputStream().write(a);
                    }
                }else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String jsLine;
                    while ((jsLine = br.readLine()) != null) {
                        socket.getOutputStream().write(jsLine.getBytes());
                    }
                }
                socket.getOutputStream().flush();
                socket.close();


            } else {
                socket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
                socket.getOutputStream().write("content-type: text/html\r\n".getBytes());
                socket.getOutputStream().write("\r\n".getBytes());
                socket.getOutputStream().write(("<html>" +
                        "<h1>hello</h1><p>world</p>" +
                        "<head> \n" +
                        "        <link rel=\"stylesheet\" href=\"/my.css\" /> \n" +
                        "</head> " +
                        "<img src='my.jpg'/>" +
                        "<h1 class='good'>hello</h1>" +
                        "<script src='/yourscript.js'></script>" +
                        "</html>").getBytes());
                socket.getOutputStream().flush();
                socket.close();
            }
        }

    }
}
