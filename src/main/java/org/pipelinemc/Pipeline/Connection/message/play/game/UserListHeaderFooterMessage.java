package main.java.org.pipelinemc.Pipeline.Connection.message.play.game;

import com.flowpowered.networking.Message;
import lombok.Data;
import net.glowstone.util.TextMessage;

@Data
public final class UserListHeaderFooterMessage implements Message {

    private final TextMessage header, footer;

}
