package br.com.cwust.celebrity.engine;

import java.util.Collection;
import java.util.function.Function;

public abstract class Util {
	
	@SuppressWarnings("unchecked")
	public static <T, R> R[] toArrayConverted(Collection<T> list, Function<T, R> converter) {
		Object[] result = list.stream().map(converter).toArray(Object[]::new);
		return (R[]) result;
	}
}
