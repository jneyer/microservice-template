package com.giantrobotlabs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.giantrobotlabs.resource.ResourceTemplate;

@Entity
@JsonInclude(Include.NON_NULL)
abstract public class ModelTemplate extends ResourceSupport {

	@Id
	@GeneratedValue
	@ReadOnlyProperty
	@Column(name = "model_id", nullable = false)
	protected Long modelId;

	@ReadOnlyProperty
	@Column(name = "created")
	protected DateTime created;

	@ReadOnlyProperty
	@Column(name = "updated")
	protected DateTime updated;

	@PrePersist
	protected void onCreate() {
		this.created = new DateTime();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updated = new DateTime();
	}

	public Long getModelId() {
		return this.modelId;
	}

	public DateTime getCreated() {
		return created;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void addLinks(Class<? extends ResourceTemplate<?>> resource) {

	}

}
