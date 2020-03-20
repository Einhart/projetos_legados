package org.nanotek.opencsv;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.springframework.beans.factory.InitializingBean;

public abstract class HolderBaseMap<K extends IdBase<K,ID>, ID extends IdBase<?,?>> 
extends BaseMap<K, ID> implements InitializingBean{

	private static final long serialVersionUID = 8945888004557753179L;

	protected K immutable;
	
	public HolderBaseMap(K immutable , ID id) {
		super(id);
		this.immutable = immutable;
	}
	
	public HolderBaseMap(K immutable ) {
		this.immutable = immutable;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Class<?> clazz = Optional.ofNullable(immutable).orElseThrow(BaseException::new).getClass();
		Field[] fields = clazz.getDeclaredFields();
		Arrays.asList(fields).stream().forEach(f->{
			put(f.getName(), 0);
		});
		Optional.ofNullable(keySet().contains("immutable")).orElseThrow(BaseException::new);
	}

}