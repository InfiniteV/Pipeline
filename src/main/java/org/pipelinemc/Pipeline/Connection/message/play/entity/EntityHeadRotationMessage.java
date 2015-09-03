package org.pipelinemc.Pipeline.Connection.message.play.entity;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class EntityHeadRotationMessage implements Message {

    private final int id;
    private final int rotation;

}

