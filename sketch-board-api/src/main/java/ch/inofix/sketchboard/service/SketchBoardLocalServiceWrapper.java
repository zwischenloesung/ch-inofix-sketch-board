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

package ch.inofix.sketchboard.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SketchBoardLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoardLocalService
 * @generated
 */
@ProviderType
public class SketchBoardLocalServiceWrapper implements SketchBoardLocalService,
	ServiceWrapper<SketchBoardLocalService> {
	public SketchBoardLocalServiceWrapper(
		SketchBoardLocalService sketchBoardLocalService) {
		_sketchBoardLocalService = sketchBoardLocalService;
	}

	@Override
	public ch.inofix.sketchboard.model.SketchBoard addSketchBoard(long userId,
		java.lang.String name, java.lang.String description,
		java.lang.String configuration, java.lang.String setup,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sketchBoardLocalService.addSketchBoard(userId, name,
			description, configuration, setup, serviceContext);
	}

	/**
	* Adds the sketch board to the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoard the sketch board
	* @return the sketch board that was added
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard addSketchBoard(
		ch.inofix.sketchboard.model.SketchBoard sketchBoard) {
		return _sketchBoardLocalService.addSketchBoard(sketchBoard);
	}

	/**
	* Creates a new sketch board with the primary key. Does not add the sketch board to the database.
	*
	* @param sketchBoardId the primary key for the new sketch board
	* @return the new sketch board
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard createSketchBoard(
		long sketchBoardId) {
		return _sketchBoardLocalService.createSketchBoard(sketchBoardId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sketchBoardLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the sketch board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board that was removed
	* @throws PortalException if a sketch board with the primary key could not be found
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard deleteSketchBoard(
		long sketchBoardId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sketchBoardLocalService.deleteSketchBoard(sketchBoardId);
	}

	/**
	* Deletes the sketch board from the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoard the sketch board
	* @return the sketch board that was removed
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard deleteSketchBoard(
		ch.inofix.sketchboard.model.SketchBoard sketchBoard) {
		return _sketchBoardLocalService.deleteSketchBoard(sketchBoard);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sketchBoardLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _sketchBoardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ch.inofix.sketchboard.model.impl.SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _sketchBoardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ch.inofix.sketchboard.model.impl.SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _sketchBoardLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _sketchBoardLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _sketchBoardLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ch.inofix.sketchboard.model.SketchBoard fetchSketchBoard(
		long sketchBoardId) {
		return _sketchBoardLocalService.fetchSketchBoard(sketchBoardId);
	}

	/**
	* Returns the sketch board matching the UUID and group.
	*
	* @param uuid the sketch board's UUID
	* @param groupId the primary key of the group
	* @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard fetchSketchBoardByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _sketchBoardLocalService.fetchSketchBoardByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _sketchBoardLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _sketchBoardLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _sketchBoardLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _sketchBoardLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sketchBoardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the sketch board with the primary key.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board
	* @throws PortalException if a sketch board with the primary key could not be found
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard getSketchBoard(
		long sketchBoardId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sketchBoardLocalService.getSketchBoard(sketchBoardId);
	}

	/**
	* Returns the sketch board matching the UUID and group.
	*
	* @param uuid the sketch board's UUID
	* @param groupId the primary key of the group
	* @return the matching sketch board
	* @throws PortalException if a matching sketch board could not be found
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard getSketchBoardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sketchBoardLocalService.getSketchBoardByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the sketch boards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ch.inofix.sketchboard.model.impl.SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @return the range of sketch boards
	*/
	@Override
	public java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		int start, int end) {
		return _sketchBoardLocalService.getSketchBoards(start, end);
	}

	@Override
	public java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		long groupId) {
		return _sketchBoardLocalService.getSketchBoards(groupId);
	}

	@Override
	public java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		long groupId, int start, int end) {
		return _sketchBoardLocalService.getSketchBoards(groupId, start, end);
	}

	@Override
	public java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ch.inofix.sketchboard.model.SketchBoard> obc) {
		return _sketchBoardLocalService.getSketchBoards(groupId, start, end, obc);
	}

	/**
	* Returns all the sketch boards matching the UUID and company.
	*
	* @param uuid the UUID of the sketch boards
	* @param companyId the primary key of the company
	* @return the matching sketch boards, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoardsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _sketchBoardLocalService.getSketchBoardsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of sketch boards matching the UUID and company.
	*
	* @param uuid the UUID of the sketch boards
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching sketch boards, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoardsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ch.inofix.sketchboard.model.SketchBoard> orderByComparator) {
		return _sketchBoardLocalService.getSketchBoardsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of sketch boards.
	*
	* @return the number of sketch boards
	*/
	@Override
	public int getSketchBoardsCount() {
		return _sketchBoardLocalService.getSketchBoardsCount();
	}

	@Override
	public int getSketchBoardsCount(long groupId) {
		return _sketchBoardLocalService.getSketchBoardsCount(groupId);
	}

	/**
	* Updates the sketch board in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sketchBoard the sketch board
	* @return the sketch board that was updated
	*/
	@Override
	public ch.inofix.sketchboard.model.SketchBoard updateSketchBoard(
		ch.inofix.sketchboard.model.SketchBoard sketchBoard) {
		return _sketchBoardLocalService.updateSketchBoard(sketchBoard);
	}

	@Override
	public SketchBoardLocalService getWrappedService() {
		return _sketchBoardLocalService;
	}

	@Override
	public void setWrappedService(
		SketchBoardLocalService sketchBoardLocalService) {
		_sketchBoardLocalService = sketchBoardLocalService;
	}

	private SketchBoardLocalService _sketchBoardLocalService;
}