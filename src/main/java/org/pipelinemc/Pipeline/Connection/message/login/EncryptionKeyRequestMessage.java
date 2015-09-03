package main.java.org.pipelinemc.Pipeline.Connection.message.login;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class EncryptionKeyRequestMessage implements Message {

    private final String sessionId;
    private final byte[] publicKey;
    private final byte[] verifyToken;

}
