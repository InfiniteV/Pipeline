package main.java.org.pipelinemc.Pipeline.Connection.message.play.inv;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class HeldItemMessage implements Message {

    private final int slot;

}

