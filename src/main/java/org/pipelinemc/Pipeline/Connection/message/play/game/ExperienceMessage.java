package main.java.org.pipelinemc.Pipeline.Connection.message.play.game;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class ExperienceMessage implements Message {

    private final float barValue;
    private final int level, totalExp;

}
