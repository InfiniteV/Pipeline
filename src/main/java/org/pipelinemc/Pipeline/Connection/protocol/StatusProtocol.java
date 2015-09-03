package org.pipelinemc.Pipeline.Connection.protocol;

/**
 * Created by JessiePeek on 9/3/2015.
 */
public class StatusProtocol extends PipeProtocol{
    public StatusProtocol() {
        super("STATUS", 2);

        inbound(0x00, StatusRequestMessage.class, StatusRequestCodec.class, StatusRequestHandler.class);
        inbound(0x01, StatusPingMessage.class, StatusPingCodec.class, StatusPingHandler.class);

        outbound(0x00, StatusResponseMessage.class, StatusResponseCodec.class);
        outbound(0x01, StatusPingMessage.class, StatusPingCodec.class);
    }
}
