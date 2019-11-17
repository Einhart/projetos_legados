package org.nanotek.opencsv;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.nanotek.Base;

/**
 * TODO: Change the class to "create a equivalence validator" on Target Class - and the Map class. 
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 */
//Avoiding the Usage of this. Type & AnnotatedElement & GenericDeclaration & Serializable & Base<?>
@SuppressWarnings("serial")
public class BaseMap<T extends Base<?>> extends HashMap<String,Integer> implements Base<String>{

	//works fine with the "Bean Name";
	protected String id;
	protected T target; 
	protected Integer targetSize; 
	
	public BaseMap() {
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	public T getTarget() {
		return target;
	}

	public void setTarget(T type) {
		this.target = type;
	}

	public Base<?> newInstance() throws InstantiationException,
			IllegalAccessException {
		return target.newInstance();
	}

	public Integer getTargetSize() {
		return targetSize;
	}

	public void setTargetSize(Integer targetSize) {
		this.targetSize = targetSize;
	}

}