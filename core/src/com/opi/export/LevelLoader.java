package com.opi.export;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.opi.export.game.Level;

public class LevelLoader {
	
	public static Level[] load(FileHandle path, FileHandle levelPack) {
		HashMap<String, String> levelProperties = FileParser.load(path);
		ArrayList<Level> levels = new ArrayList<Level>();
		FileHandle levelRootHandle = Gdx.files.internal(levelProperties.get(levelPack));
		
		for(FileHandle levelFile : levelRootHandle.list()) {
			System.out.println(levelFile.name());
		}
		
		return null;
	}
}
