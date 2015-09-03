package org.pipelinemc.Pipeline;

import org.pipelinemc.Pipeline.Connection.PipeServer;

import java.net.BindException;

/**
 * Master class, handles networking.
 */
public class Pipeline {
    private static Server server;

    public static void main(String[] args) {
        server = new Server();
        try {
            server.loadServer();
            PipeServer pipeServer = PipeServer.start(server.getIP(), server.getPort());
            Logger.log("Loading server libraries, please wait...");
            server.startServer();
            server.startConsole(null);
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
