package org.pipelinemc.Pipeline.event;

public interface Cancellable {
	boolean isCancelled();
	void setCancelled(boolean cancelled);
}
