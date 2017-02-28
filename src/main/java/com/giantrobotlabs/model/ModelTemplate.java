package com.giantrobotlabs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;
import org.springframework.data.annotation.ReadOnlyProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.giantrobotlabs.resource.ResourceTemplate;

@Entity
@JsonInclude(Include.NON_NULL)
abstract public class ModelTemplate<T> implements Serializable {

	private static final long serialVersionUID = -4072426133045167484L;

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

	public DateTime getCreated() {
		return created;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public Long getModelId() {
		return this.modelId;
	}

	/**
	 * Create resource links from the resource controller class
	 * 
	 * @param resource
	 */
	public void addLinks(Class<? extends ResourceTemplate<?>> resource) {

	}

	/**
	 * Override this method to safely populate fields from one instance to
	 * another.
	 * 
	 * @param model
	 * @return
	 */
	abstract public T update(T model);

}
