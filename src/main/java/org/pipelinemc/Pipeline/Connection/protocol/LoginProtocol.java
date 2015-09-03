package main.java.org.pipelinemc.Pipeline.Connection.protocol;

/**
 * Created by JessiePeek on 9/3/2015.
 */
public class LoginProtocol extends PipeProtocol {
    public LoginProtocol() {
        super("LOGIN", 5);

        inbound(0x00, LoginStartMessage.class, LoginStartCodec.class, LoginStartHandler.class);
        inbound(0x01, EncryptionKeyResponseMessage.class, EncryptionKeyResponseCodec.class, EncryptionKeyResponseHandler.class);

        outbound(0x00, KickMessage.class, KickCodec.class);
        outbound(0x01, EncryptionKeyRequestMessage.class, EncryptionKeyRequestCodec.class);
        outbound(0x02, LoginSuccessMessage.class, LoginSuccessCodec.class);
        outbound(0x03, SetCompressionMessage.class, SetCompressionCodec.class);
    }
}
