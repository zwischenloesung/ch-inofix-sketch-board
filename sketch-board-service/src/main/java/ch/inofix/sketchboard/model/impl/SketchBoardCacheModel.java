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

package ch.inofix.sketchboard.model.impl;

import aQute.bnd.annotation.ProviderType;

import ch.inofix.sketchboard.model.SketchBoard;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SketchBoard in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoard
 * @generated
 */
@ProviderType
public class SketchBoardCacheModel implements CacheModel<SketchBoard>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SketchBoardCacheModel)) {
			return false;
		}

		SketchBoardCacheModel sketchBoardCacheModel = (SketchBoardCacheModel)obj;

		if (sketchBoardId == sketchBoardCacheModel.sketchBoardId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sketchBoardId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sketchBoardId=");
		sb.append(sketchBoardId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", configuration=");
		sb.append(configuration);
		sb.append(", setup=");
		sb.append(setup);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SketchBoard toEntityModel() {
		SketchBoardImpl sketchBoardImpl = new SketchBoardImpl();

		if (uuid == null) {
			sketchBoardImpl.setUuid("");
		}
		else {
			sketchBoardImpl.setUuid(uuid);
		}

		sketchBoardImpl.setSketchBoardId(sketchBoardId);
		sketchBoardImpl.setGroupId(groupId);
		sketchBoardImpl.setCompanyId(companyId);
		sketchBoardImpl.setUserId(userId);

		if (userName == null) {
			sketchBoardImpl.setUserName("");
		}
		else {
			sketchBoardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sketchBoardImpl.setCreateDate(null);
		}
		else {
			sketchBoardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sketchBoardImpl.setModifiedDate(null);
		}
		else {
			sketchBoardImpl.setModifiedDate(new Date(modifiedDate));
		}

		sketchBoardImpl.setStatus(status);
		sketchBoardImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			sketchBoardImpl.setStatusByUserName("");
		}
		else {
			sketchBoardImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			sketchBoardImpl.setStatusDate(null);
		}
		else {
			sketchBoardImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			sketchBoardImpl.setName("");
		}
		else {
			sketchBoardImpl.setName(name);
		}

		if (configuration == null) {
			sketchBoardImpl.setConfiguration("");
		}
		else {
			sketchBoardImpl.setConfiguration(configuration);
		}

		if (setup == null) {
			sketchBoardImpl.setSetup("");
		}
		else {
			sketchBoardImpl.setSetup(setup);
		}

		sketchBoardImpl.resetOriginalValues();

		return sketchBoardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sketchBoardId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		configuration = objectInput.readUTF();
		setup = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sketchBoardId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (configuration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(configuration);
		}

		if (setup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(setup);
		}
	}

	public String uuid;
	public long sketchBoardId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String configuration;
	public String setup;
}