package org.nanotek;

import java.util.Optional;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.nanotek.beans.csv.BaseBean;
import org.nanotek.opencsv.WrappedBaseClass;
import org.nanotek.stream.KongStream;

public interface WrappedEntityBase<K extends BaseBean<?>> extends Wrapper <K>{
	
	static <K extends WrappedBaseClass<?> , I extends BaseBean<?>> Optional<K> newBaseBeanInstance(I instance) throws BaseInstantiationException { 
		try {
			 return WrappedEntityBase.newInstance(WrappedBaseClass.class.asSubclass(WrappedEntityBase.class)  , Arrays.array(instance) , BaseBean.class);
		} catch (Exception e) {
			throw new BaseInstantiationException(e);
		}
	}
	
	static <K extends WrappedBaseClass<S> , I extends BaseBean<?> , S extends I> Optional<?> newBaseBeanInstance(Class<I> beanClass,I instance) throws BaseInstantiationException { 
		try {
			 Stream<?> k = KongStream.of(beanClass.asSubclass(Kong.class)).add(Kong.class.cast(instance)).build();
			return  Optional.empty();//newInstance(WrappedBaseClass.class, new Object[] {beanClass, instance},  beanClass);
		} catch (Exception e) {
			throw new BaseInstantiationException(e);
		}
	}
	
	static <K extends WrappedBaseClass<?>> Optional<K> newInstance(Class<K> clazz , Object[] args , Class<?>... classArgs  ) throws BaseInstantiationException { 
		try {
			return Optional.of(clazz.getDeclaredConstructor(classArgs).newInstance(args));
		} catch (Exception e) {
			throw new BaseInstantiationException(e);
		}
	}
	
}