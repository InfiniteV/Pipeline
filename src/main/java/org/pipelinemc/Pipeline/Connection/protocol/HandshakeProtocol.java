package org.pipelinemc.Pipeline.Connection.protocol;


import org.pipelinemc.Pipeline.Connection.codec.handshake.HandshakeCodec;
import sun.security.ssl.HandshakeMessage;

/**
 * Created by JessiePeek on 9/3/2015.
 */
public class HandshakeProtocol extends PipeProtocol{
    public HandshakeProtocol() {
        super("HANDSHAKE", 0);
        inbound(0x00, HandshakeMessage.class, HandshakeCodec.class, HandshakeHandler.class);
    }
}
