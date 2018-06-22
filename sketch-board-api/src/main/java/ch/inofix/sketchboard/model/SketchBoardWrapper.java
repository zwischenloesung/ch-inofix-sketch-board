/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ch.inofix.sketchboard.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SketchBoard}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoard
 * @generated
 */
@ProviderType
public class SketchBoardWrapper implements SketchBoard,
	ModelWrapper<SketchBoard> {
	public SketchBoardWrapper(SketchBoard sketchBoard) {
		_sketchBoard = sketchBoard;
	}

	@Override
	public Class<?> getModelClass() {
		return SketchBoard.class;
	}

	@Override
	public String getModelClassName() {
		return SketchBoard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sketchBoardId", getSketchBoardId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("configuration", getConfiguration());
		attributes.put("setup", getSetup());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sketchBoardId = (Long)attributes.get("sketchBoardId");

		if (sketchBoardId != null) {
			setSketchBoardId(sketchBoardId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String configuration = (String)attributes.get("configuration");

		if (configuration != null) {
			setConfiguration(configuration);
		}

		String setup = (String)attributes.get("setup");

		if (setup != null) {
			setSetup(setup);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new SketchBoardWrapper((SketchBoard)_sketchBoard.clone());
	}

	@Override
	public int compareTo(SketchBoard sketchBoard) {
		return _sketchBoard.compareTo(sketchBoard);
	}

	/**
	* Returns the company ID of this sketch board.
	*
	* @return the company ID of this sketch board
	*/
	@Override
	public long getCompanyId() {
		return _sketchBoard.getCompanyId();
	}

	/**
	* Returns the configuration of this sketch board.
	*
	* @return the configuration of this sketch board
	*/
	@Override
	public java.lang.String getConfiguration() {
		return _sketchBoard.getConfiguration();
	}

	/**
	* Returns the create date of this sketch board.
	*
	* @return the create date of this sketch board
	*/
	@Override
	public Date getCreateDate() {
		return _sketchBoard.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sketchBoard.getExpandoBridge();
	}

	/**
	* Returns the group ID of this sketch board.
	*
	* @return the group ID of this sketch board
	*/
	@Override
	public long getGroupId() {
		return _sketchBoard.getGroupId();
	}

	/**
	* Returns the modified date of this sketch board.
	*
	* @return the modified date of this sketch board
	*/
	@Override
	public Date getModifiedDate() {
		return _sketchBoard.getModifiedDate();
	}

	/**
	* Returns the name of this sketch board.
	*
	* @return the name of this sketch board
	*/
	@Override
	public java.lang.String getName() {
		return _sketchBoard.getName();
	}

	/**
	* Returns the primary key of this sketch board.
	*
	* @return the primary key of this sketch board
	*/
	@Override
	public long getPrimaryKey() {
		return _sketchBoard.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sketchBoard.getPrimaryKeyObj();
	}

	/**
	* Returns the setup of this sketch board.
	*
	* @return the setup of this sketch board
	*/
	@Override
	public java.lang.String getSetup() {
		return _sketchBoard.getSetup();
	}

	/**
	* Returns the sketch board ID of this sketch board.
	*
	* @return the sketch board ID of this sketch board
	*/
	@Override
	public long getSketchBoardId() {
		return _sketchBoard.getSketchBoardId();
	}

	/**
	* Returns the status of this sketch board.
	*
	* @return the status of this sketch board
	*/
	@Override
	public int getStatus() {
		return _sketchBoard.getStatus();
	}

	/**
	* Returns the status by user ID of this sketch board.
	*
	* @return the status by user ID of this sketch board
	*/
	@Override
	public long getStatusByUserId() {
		return _sketchBoard.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this sketch board.
	*
	* @return the status by user name of this sketch board
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _sketchBoard.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this sketch board.
	*
	* @return the status by user uuid of this sketch board
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _sketchBoard.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this sketch board.
	*
	* @return the status date of this sketch board
	*/
	@Override
	public Date getStatusDate() {
		return _sketchBoard.getStatusDate();
	}

	/**
	* Returns the user ID of this sketch board.
	*
	* @return the user ID of this sketch board
	*/
	@Override
	public long getUserId() {
		return _sketchBoard.getUserId();
	}

	/**
	* Returns the user name of this sketch board.
	*
	* @return the user name of this sketch board
	*/
	@Override
	public java.lang.String getUserName() {
		return _sketchBoard.getUserName();
	}

	/**
	* Returns the user uuid of this sketch board.
	*
	* @return the user uuid of this sketch board
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _sketchBoard.getUserUuid();
	}

	/**
	* Returns the uuid of this sketch board.
	*
	* @return the uuid of this sketch board
	*/
	@Override
	public java.lang.String getUuid() {
		return _sketchBoard.getUuid();
	}

	@Override
	public int hashCode() {
		return _sketchBoard.hashCode();
	}

	/**
	* Returns <code>true</code> if this sketch board is approved.
	*
	* @return <code>true</code> if this sketch board is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _sketchBoard.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _sketchBoard.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this sketch board is denied.
	*
	* @return <code>true</code> if this sketch board is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _sketchBoard.isDenied();
	}

	/**
	* Returns <code>true</code> if this sketch board is a draft.
	*
	* @return <code>true</code> if this sketch board is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _sketchBoard.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _sketchBoard.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this sketch board is expired.
	*
	* @return <code>true</code> if this sketch board is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _sketchBoard.isExpired();
	}

	/**
	* Returns <code>true</code> if this sketch board is inactive.
	*
	* @return <code>true</code> if this sketch board is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _sketchBoard.isInactive();
	}

	/**
	* Returns <code>true</code> if this sketch board is incomplete.
	*
	* @return <code>true</code> if this sketch board is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _sketchBoard.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _sketchBoard.isNew();
	}

	/**
	* Returns <code>true</code> if this sketch board is pending.
	*
	* @return <code>true</code> if this sketch board is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _sketchBoard.isPending();
	}

	/**
	* Returns <code>true</code> if this sketch board is scheduled.
	*
	* @return <code>true</code> if this sketch board is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _sketchBoard.isScheduled();
	}

	@Override
	public void persist() {
		_sketchBoard.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sketchBoard.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this sketch board.
	*
	* @param companyId the company ID of this sketch board
	*/
	@Override
	public void setCompanyId(long companyId) {
		_sketchBoard.setCompanyId(companyId);
	}

	/**
	* Sets the configuration of this sketch board.
	*
	* @param configuration the configuration of this sketch board
	*/
	@Override
	public void setConfiguration(java.lang.String configuration) {
		_sketchBoard.setConfiguration(configuration);
	}

	/**
	* Sets the create date of this sketch board.
	*
	* @param createDate the create date of this sketch board
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_sketchBoard.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_sketchBoard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sketchBoard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sketchBoard.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this sketch board.
	*
	* @param groupId the group ID of this sketch board
	*/
	@Override
	public void setGroupId(long groupId) {
		_sketchBoard.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this sketch board.
	*
	* @param modifiedDate the modified date of this sketch board
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_sketchBoard.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this sketch board.
	*
	* @param name the name of this sketch board
	*/
	@Override
	public void setName(java.lang.String name) {
		_sketchBoard.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_sketchBoard.setNew(n);
	}

	/**
	* Sets the primary key of this sketch board.
	*
	* @param primaryKey the primary key of this sketch board
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sketchBoard.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sketchBoard.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the setup of this sketch board.
	*
	* @param setup the setup of this sketch board
	*/
	@Override
	public void setSetup(java.lang.String setup) {
		_sketchBoard.setSetup(setup);
	}

	/**
	* Sets the sketch board ID of this sketch board.
	*
	* @param sketchBoardId the sketch board ID of this sketch board
	*/
	@Override
	public void setSketchBoardId(long sketchBoardId) {
		_sketchBoard.setSketchBoardId(sketchBoardId);
	}

	/**
	* Sets the status of this sketch board.
	*
	* @param status the status of this sketch board
	*/
	@Override
	public void setStatus(int status) {
		_sketchBoard.setStatus(status);
	}

	/**
	* Sets the status by user ID of this sketch board.
	*
	* @param statusByUserId the status by user ID of this sketch board
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_sketchBoard.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this sketch board.
	*
	* @param statusByUserName the status by user name of this sketch board
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_sketchBoard.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this sketch board.
	*
	* @param statusByUserUuid the status by user uuid of this sketch board
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_sketchBoard.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this sketch board.
	*
	* @param statusDate the status date of this sketch board
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_sketchBoard.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this sketch board.
	*
	* @param userId the user ID of this sketch board
	*/
	@Override
	public void setUserId(long userId) {
		_sketchBoard.setUserId(userId);
	}

	/**
	* Sets the user name of this sketch board.
	*
	* @param userName the user name of this sketch board
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_sketchBoard.setUserName(userName);
	}

	/**
	* Sets the user uuid of this sketch board.
	*
	* @param userUuid the user uuid of this sketch board
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sketchBoard.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this sketch board.
	*
	* @param uuid the uuid of this sketch board
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_sketchBoard.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SketchBoard> toCacheModel() {
		return _sketchBoard.toCacheModel();
	}

	@Override
	public SketchBoard toEscapedModel() {
		return new SketchBoardWrapper(_sketchBoard.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sketchBoard.toString();
	}

	@Override
	public SketchBoard toUnescapedModel() {
		return new SketchBoardWrapper(_sketchBoard.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _sketchBoard.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SketchBoardWrapper)) {
			return false;
		}

		SketchBoardWrapper sketchBoardWrapper = (SketchBoardWrapper)obj;

		if (Objects.equals(_sketchBoard, sketchBoardWrapper._sketchBoard)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _sketchBoard.getStagedModelType();
	}

	@Override
	public SketchBoard getWrappedModel() {
		return _sketchBoard;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sketchBoard.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sketchBoard.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sketchBoard.resetOriginalValues();
	}

	private final SketchBoard _sketchBoard;
}