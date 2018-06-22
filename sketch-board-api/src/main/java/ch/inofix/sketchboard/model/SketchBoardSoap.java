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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ch.inofix.sketchboard.service.http.SketchBoardServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ch.inofix.sketchboard.service.http.SketchBoardServiceSoap
 * @generated
 */
@ProviderType
public class SketchBoardSoap implements Serializable {
	public static SketchBoardSoap toSoapModel(SketchBoard model) {
		SketchBoardSoap soapModel = new SketchBoardSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSketchBoardId(model.getSketchBoardId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setName(model.getName());
		soapModel.setConfiguration(model.getConfiguration());
		soapModel.setSetup(model.getSetup());

		return soapModel;
	}

	public static SketchBoardSoap[] toSoapModels(SketchBoard[] models) {
		SketchBoardSoap[] soapModels = new SketchBoardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SketchBoardSoap[][] toSoapModels(SketchBoard[][] models) {
		SketchBoardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SketchBoardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SketchBoardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SketchBoardSoap[] toSoapModels(List<SketchBoard> models) {
		List<SketchBoardSoap> soapModels = new ArrayList<SketchBoardSoap>(models.size());

		for (SketchBoard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SketchBoardSoap[soapModels.size()]);
	}

	public SketchBoardSoap() {
	}

	public long getPrimaryKey() {
		return _sketchBoardId;
	}

	public void setPrimaryKey(long pk) {
		setSketchBoardId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSketchBoardId() {
		return _sketchBoardId;
	}

	public void setSketchBoardId(long sketchBoardId) {
		_sketchBoardId = sketchBoardId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getConfiguration() {
		return _configuration;
	}

	public void setConfiguration(String configuration) {
		_configuration = configuration;
	}

	public String getSetup() {
		return _setup;
	}

	public void setSetup(String setup) {
		_setup = setup;
	}

	private String _uuid;
	private long _sketchBoardId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _configuration;
	private String _setup;
}