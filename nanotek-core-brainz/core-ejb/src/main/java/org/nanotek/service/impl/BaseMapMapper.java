package org.nanotek.service.impl;

import java.util.Map;
import java.util.function.Function;

import org.nanotek.Base;

public abstract class BaseMapMapper<T extends Base<?>> implements Function<T,Map<String,Object>> {

}
