package org.pipelinemc.Pipeline.Connection.pipe;

import com.flowpowered.networking.ConnectionManager;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import net.glowstone.net.protocol.ProtocolType;

/**
 * Used to initialize the channels.
 */
public final class PipeChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final ConnectionManager connectionManager;

    public PipeChannelInitializer(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    protected void initChannel(SocketChannel c) {
        MessageHandler handler = new MessageHandler(connectionManager);
        CodecsHandler codecs = new CodecsHandler(ProtocolType.HANDSHAKE.getProtocol());
        FramingHandler framing = new FramingHandler();

        c.pipeline()
                .addLast("encryption", NoopHandler.INSTANCE)
                .addLast("framing", framing)
                .addLast("compression", NoopHandler.INSTANCE)
                .addLast("codecs", codecs)
                .addLast("handler", handler);
    }
}
