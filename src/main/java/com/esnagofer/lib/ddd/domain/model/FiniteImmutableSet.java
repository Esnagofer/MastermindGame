package com.esnagofer.lib.ddd.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.esnagofer.lib.ddd.domain.model.core.DomainValueObject;

/**
 * The Class FiniteImmutableSet.
 *
 * @param <T> the generic type
 */
public class FiniteImmutableSet<T> extends DomainValueObject {
	
	/** The items. */
	protected List<T> elements = new ArrayList<>();
	
	/**
	 * Instantiates a new four ordered items.
	 */
	protected FiniteImmutableSet() {
		super();
	}
	
	/**
	 * Instantiates a new finite immutable set.
	 *
	 * @param elements the elements
	 */
	protected FiniteImmutableSet (List<T> elements) {
		super();
		transferState(elements);
		validateSize();
	}

	/**
	 * Transfer state.
	 *
	 * @param elements the items
	 */
	private void transferState(List<T> elements) {
		this.elements = Collections.unmodifiableList(elements.stream().filter(this::isNotNull).collect(Collectors.toList()));
	}

	/**
	 * Validate size.
	 */
	protected void validateSize() {}
	
	/**
	 * Checks if is not null.
	 *
	 * @param element the item
	 * @return true, if is not null
	 */
	private boolean isNotNull(T element) {
		return element != null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return elements.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null || !otherObject.getClass().isAssignableFrom(this.getClass())) return false;
		FiniteImmutableSet<?> finiteImmutableSet = FiniteImmutableSet.class.cast(otherObject);
		return elements.equals(finiteImmutableSet.elements);
	}

	@Override
	public String toString() {
		Acabar ésto
		return String.format("[%s]", elements.stream().map(Object::toString));
	}
	
	/**
	 * Elements.
	 *
	 * @return the list
	 */
	public List<T> elements() {
		return elements;
	}
		
	/**
	 * New instance.
	 *
	 * @param <T> the generic type
	 * @param elements the elements
	 * @return the finite immutable set
	 */
	public static <T> FiniteImmutableSet<T> newInstance(List<T> elements){
		return new FiniteImmutableSet<>(elements);
	}

	/**
	 * New instance.
	 *
	 * @param <T> the generic type
	 * @param elements the elements
	 * @return the finite immutable set
	 */
	@SafeVarargs
	public static <T> FiniteImmutableSet<T> newInstance(T...elements){
		return new FiniteImmutableSet<>(Arrays.asList(elements));
	}
	
}