package main.java.org.pipelinemc.Pipeline.Connection.protocol;

/**
 * Created by JessiePeek on 9/3/2015.
 */
public enum ProtocolType {
    HANDSHAKE(new HandshakeProtocol()),
    STATUS(new StatusProtocol()),
    LOGIN(new LoginProtocol()),
    PLAY(new PlayProtocol());

    private final PipeProtocol protocol;

    ProtocolType(PipeProtocol protocol) {
        this.protocol = protocol;
    }
    public PipeProtocol getProtocol() {
        return protocol;
    }
    public static ProtocolType getById(int id) {
        final ProtocolType[] values = values();
        if (id < 0 || id >= values.length) {
            return null;
        }
        return values[id];
    }
}
