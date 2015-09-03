package main.java.org.pipelinemc.Pipeline.Connection.message.play.game;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class PlaySoundMessage implements Message {

    private final String sound;
    private final double x, y, z;
    private final float volume, pitch;

}

