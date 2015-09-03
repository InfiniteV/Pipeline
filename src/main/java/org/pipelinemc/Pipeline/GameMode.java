package org.pipelinemc.Pipeline;

public enum GameMode {
	SURVIVAL(0), CREATIVE(1), ADVENTURE(2), SPECTATOR(3);
	int mode;
	GameMode(int gamemode){
		this.mode = gamemode;
	}
	public static GameMode fromInt(int mode) throws Exception{
		for(GameMode gamemode: values()){
			if(gamemode.mode == mode) return gamemode;
		}
		throw new Exception("The gamemode you have specified is not valid!");
	}
}
