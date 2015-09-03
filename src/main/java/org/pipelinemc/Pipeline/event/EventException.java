package org.pipelinemc.Pipeline.event;

public class EventException extends Exception{
	private static final long serialVersionUID = 7455067527495104940L;
	private final Throwable cause;

	    public EventException(Throwable throwable) {
	        cause = throwable;
	    }
	    public EventException() {
	        cause = null;
	    }
	    public EventException(Throwable cause, String message) {
	        super(message);
	        this.cause = cause;
	    }
	    public EventException(String message) {
	        super(message);
	        cause = null;
	    }
	    @Override
	    public Throwable getCause() {
	        return cause;
	    }
}
