package main.java.org.pipelinemc.Pipeline.Connection;

import com.flowpowered.networking.ConnectionManager;
import com.flowpowered.networking.session.Session;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import main.java.org.pipelinemc.Pipeline.Connection.pipe.PipeChannelInitializer;

import java.net.SocketAddress;

public class PipeConnectionManager implements ConnectionManager {
    private final ServerBootstrap bootstrap = new ServerBootstrap();
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private final PipeServer server;

    public PipeConnectionManager(PipeServer server) {
        this.server = server;
        bootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new PipeChannelInitializer(this))
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
    }

    @Override
    public Session newSession(Channel c) {
        PipeSession session = new PipeSession(server, c);
        server.getSessionRegistry().add(session);
        return session;
    }

    @Override
    public void sessionInactivated(Session session) {
        server.getSessionRegistry().remove((PipeSession) session);
    }

    public ChannelFuture bind(final SocketAddress address) {
        return bootstrap.bind(address);
    }

    @Override
    public void shutdown() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}
