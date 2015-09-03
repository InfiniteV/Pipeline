package main.java.org.pipelinemc.Pipeline.Connection.message.play.game;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class PingMessage implements Message {

    private final int pingId;

}
