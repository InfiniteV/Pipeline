package main.java.org.pipelinemc.Pipeline.Connection.message.handshake;

import com.flowpowered.networking.AsyncableMessage;
import lombok.Data;

@Data
public final class HandshakeMessage implements AsyncableMessage {

    private final int version;
    private final String address;
    private final int port;
    private final int state;

    @Override
    public boolean isAsync() {
        return true;
    }

}
