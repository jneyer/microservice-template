package com.giantrobotlabs.resource;

import com.giantrobotlabs.util.CollectionRequest;
import com.giantrobotlabs.util.CollectionResponse;

public interface ResourceTemplate<T> {

	CollectionResponse<T> getMany(CollectionRequest pageRequest);

	T getOne(Long id);

	T addOne(T object);

	T updateOne(Long id, T object);

	void deleteOne(Long id);

}
