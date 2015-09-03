package org.pipelinemc.Pipeline.Connection;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class PipeServer {
    private PipeConnectionManager conman;
    public PipeServer(String ip, int port) throws BindException {
        conman = new PipeConnectionManager();
        SocketAddress address;
        if (ip.length() == 0) { address = new InetSocketAddress(port);
        } else { address = new InetSocketAddress(ip, port);}
        System.out.println("Binding to address: [" + address + "]");
        ChannelFuture future = conman.bind(address);
        Channel channel = future.awaitUninterruptibly().channel();
        if (!channel.isActive()) {
            Throwable cause = future.cause();
            if (cause instanceof BindException) {
                throw (BindException) cause;
            }
            throw new RuntimeException("Failed to bind to address", cause);
        }

        System.out.println("Successfully bound to: " + channel.localAddress());
        port = ((InetSocketAddress) channel.localAddress()).getPort();

    }



}