package main.java.org.pipelinemc.Pipeline.Connection.handler.play.game;

import com.flowpowered.networking.MessageHandler;
import net.glowstone.net.GlowSession;
import net.glowstone.net.message.play.game.IncomingChatMessage;

public final class IncomingChatHandler implements MessageHandler<GlowSession, IncomingChatMessage> {

    @Override
    public void handle(GlowSession session, IncomingChatMessage message) {
        session.getPlayer().chat(message.getText(), message.isAsync());
    }
}
