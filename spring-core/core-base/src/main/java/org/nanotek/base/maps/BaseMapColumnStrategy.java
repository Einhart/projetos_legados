package org.nanotek.base.maps;

import org.nanotek.Base;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;


public class BaseMapColumnStrategy<T extends Base<?>> extends MapColumnStrategy<BaseMap<T>, T>{

	private static final long serialVersionUID = 2528373300321092539L;

	public String fileLocation; 
	
	public String fileName;
	
	public BaseMapColumnStrategy() {
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
