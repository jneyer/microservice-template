package com.example.resource;

import com.example.util.CollectionRequest;
import com.example.util.CollectionResponse;

interface ResourceTemplate<T> {

	CollectionResponse<T> getMany(CollectionRequest pageRequest);

	T getOne(Long id);

	T addOne(T object);

	T updateOne(Long id, T object);

	void deleteOne(Long id);

}
