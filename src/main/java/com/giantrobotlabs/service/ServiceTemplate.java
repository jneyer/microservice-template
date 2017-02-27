package com.giantrobotlabs.service;

import com.giantrobotlabs.util.CollectionRequest;
import com.giantrobotlabs.util.CollectionResponse;

public interface ServiceTemplate<T> {

	CollectionResponse<T> getMany(CollectionRequest pageRequest);

	T getOne(Long id);

	T addOne(T object);

	T updateOne(Long id, T object);

	void deleteOne(Long id);

}
