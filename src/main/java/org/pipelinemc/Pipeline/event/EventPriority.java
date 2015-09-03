package org.pipelinemc.Pipeline.event;

public enum EventPriority {
	LOWEST(0),LOW(1),NORMAL(2),HIGH(3),HIGHEST(4),MONITOR(5);
	
	int power;
	EventPriority(int power){
		this.power = power;
	}
	public int getPower(){
		return power;
	}
}
