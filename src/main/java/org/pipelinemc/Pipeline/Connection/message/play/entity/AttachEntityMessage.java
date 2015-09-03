package main.java.org.pipelinemc.Pipeline.Connection.message.play.entity;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class AttachEntityMessage implements Message {

    private final int id, vehicle;
    private final boolean leash;

}
