package org.pipelinemc.Pipeline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.Socket;

/**
 * Master class, handles networking.
 */
public class Pipeline {
    private static Server server;

    public static void main(String[] args) {
        server = new Server();
        try {
            server.loadServer();
            Socket echoSocket = new Socket(server.getIP(), server.getPort());
            PrintWriter out =
                    new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            Logger.log("Loading server libraries, please wait...");
            server.startServer();
            server.startConsole(stdIn);
        } catch(BindException e) {
            Logger.critical("FAILED TO BIND PORT: " + server.getPort());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Server getServer(){
    	return server;
    }
}
