package org.pipelinemc.Pipeline.Connection.handler.play.inv;

import com.flowpowered.networking.MessageHandler;
import org.pipelinemc.Pipeline.Connection.PipeSession;


public final class HeldItemHandler implements MessageHandler<GlowSession, HeldItemMessage> {
    @Override
    public void handle(PipeSession session, HeldItemMessage message) {
        final int slot = message.getSlot();
        if (slot < 0 || slot > 8) {
            // sanity check
            return;
        }

        final GlowPlayer player = session.getPlayer();
        final int oldSlot = player.getInventory().getHeldItemSlot();
        if (slot == oldSlot) return;
        PlayerItemHeldEvent event = new PlayerItemHeldEvent(player, oldSlot, slot);
        EventFactory.callEvent(event);

        if (!event.isCancelled()) {

            player.getInventory().setRawHeldItemSlot(slot);

        } else {

            player.getInventory().setHeldItemSlot(oldSlot);
        }
    }
}
