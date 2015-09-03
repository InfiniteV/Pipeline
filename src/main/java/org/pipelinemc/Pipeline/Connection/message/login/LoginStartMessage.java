package org.pipelinemc.Pipeline.Connection.message.login;

import com.flowpowered.networking.Message;
import lombok.Data;

@Data
public final class LoginStartMessage implements Message {

    private final String username;

}
