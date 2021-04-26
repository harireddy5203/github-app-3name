/*
 * Copyright (c) 2021 REPLACE_CUSTOMER_NAME. All rights reserved.
 *
 * This file is part of github-app-3name.
 *
 * github-app-3name project and associated code cannot be copied
 * and/or distributed without a written permission of REPLACE_CUSTOMER_NAME,
 * and/or its subsidiaries.
 */
package com.test.commons.data.jpa.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.test.commons.data.persistence.ISoftDeletable;

/**
 * Abstract implementation of an entity that supports soft-deletion functionality for an entity whose primary key is
 * auto-generated.
 *
 * @param <ID>
 *         Type of the primary key.
 *
 * @author Mahalingam Iyer
 */
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true, of = {})
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractSoftDeletableIdGeneratedEntity<ID extends Serializable> extends AbstractIdGeneratedEntity<ID> implements ISoftDeletable {
    /** Boolean to indicate if this record is deleted or not. */
    @Column(name = "deleted")
    private boolean deleted;

    /** Timestamp in epoch format indicating when the record was deleted. */
    @Column(name = "deleted_ts")
    private Long deletedTimestamp;
}
