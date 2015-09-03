package main.java.org.pipelinemc.Pipeline.Connection.message.play.game;

import com.flowpowered.networking.Message;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public final class BlockChangeMessage implements Message {

    private final int x, y, z, type;

    public BlockChangeMessage(int x, int y, int z, int type, int metadata) {
        this(x, y, z, (type << 4) | (metadata & 0xf));
    }

}
