package com.opi.export;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;

public class Save {

	public int levelID;
	public String level_pack;
	
	public static Save load() {
		HashMap<String, String> saveProperties = FileParser.load(Gdx.files.internal("save.dat"));
		int levelID = Integer.parseInt(saveProperties.get("levelID"));
		String level_pack = saveProperties.get("level_pack");
		
		Save save = new Save();
		save.levelID = levelID;
		save.level_pack = level_pack;
		
		return save;
	}
}
