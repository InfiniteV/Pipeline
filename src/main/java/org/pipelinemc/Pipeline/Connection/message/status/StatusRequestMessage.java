package org.pipelinemc.Pipeline.Connection.message.status;

import com.flowpowered.networking.AsyncableMessage;
import lombok.Data;

@Data
public final class StatusRequestMessage implements AsyncableMessage {

    @Override
    public boolean isAsync() {
        return true;
    }

}
