package main.java.org.pipelinemc.Pipeline.Connection.message.play.player;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class PlayerActionMessage implements Message {

    private final int id, action, jumpBoost;

}

