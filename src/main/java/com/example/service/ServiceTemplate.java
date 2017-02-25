package com.example.service;

import com.example.util.CollectionRequest;
import com.example.util.CollectionResponse;

interface ServiceTemplate<T> {

	CollectionResponse<T> getMany(CollectionRequest pageRequest);

	T getOne(Long id);

	T addOne(T object);

	T updateOne(Long id, T object);

	void deleteOne(Long id);

}
