package org.pipelinemc.Pipeline.event;

public abstract class Event {
	private String name;
	private boolean async;
	
	public Event(){
		this(false);
	}
	public Event(boolean isAsync){
		this.async = isAsync;
	}
    public String getEventName() {
        if (name == null) {
            name = getClass().getSimpleName();
        }
        return name;
    }
    
    public final boolean isAsynchronous() {
        return async;
    }
}
