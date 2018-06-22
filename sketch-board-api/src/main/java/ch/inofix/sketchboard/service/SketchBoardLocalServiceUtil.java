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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SketchBoard. This utility wraps
 * {@link ch.inofix.sketchboard.service.impl.SketchBoardLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoardLocalService
 * @see ch.inofix.sketchboard.service.base.SketchBoardLocalServiceBaseImpl
 * @see ch.inofix.sketchboard.service.impl.SketchBoardLocalServiceImpl
 * @generated
 */
@ProviderType
public class SketchBoardLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ch.inofix.sketchboard.service.impl.SketchBoardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static ch.inofix.sketchboard.model.SketchBoard addSketchBoard(
		long userId, java.lang.String name, java.lang.String description,
		java.lang.String configuration, java.lang.String setup,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addSketchBoard(userId, name, description, configuration,
			setup, serviceContext);
	}

	/**
	* Adds the sketch board to the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoard the sketch board
	* @return the sketch board that was added
	*/
	public static ch.inofix.sketchboard.model.SketchBoard addSketchBoard(
		ch.inofix.sketchboard.model.SketchBoard sketchBoard) {
		return getService().addSketchBoard(sketchBoard);
	}

	/**
	* Creates a new sketch board with the primary key. Does not add the sketch board to the database.
	*
	* @param sketchBoardId the primary key for the new sketch board
	* @return the new sketch board
	*/
	public static ch.inofix.sketchboard.model.SketchBoard createSketchBoard(
		long sketchBoardId) {
		return getService().createSketchBoard(sketchBoardId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the sketch board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board that was removed
	* @throws PortalException if a sketch board with the primary key could not be found
	*/
	public static ch.inofix.sketchboard.model.SketchBoard deleteSketchBoard(
		long sketchBoardId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSketchBoard(sketchBoardId);
	}

	/**
	* Deletes the sketch board from the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoard the sketch board
	* @return the sketch board that was removed
	*/
	public static ch.inofix.sketchboard.model.SketchBoard deleteSketchBoard(
		ch.inofix.sketchboard.model.SketchBoard sketchBoard) {
		return getService().deleteSketchBoard(sketchBoard);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ch.inofix.sketchboard.model.SketchBoard fetchSketchBoard(
		long sketchBoardId) {
		return getService().fetchSketchBoard(sketchBoardId);
	}

	/**
	* Returns the sketch board matching the UUID and group.
	*
	* @param uuid the sketch board's UUID
	* @param groupId the primary key of the group
	* @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static ch.inofix.sketchboard.model.SketchBoard fetchSketchBoardByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchSketchBoardByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the sketch board with the primary key.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board
	* @throws PortalException if a sketch board with the primary key could not be found
	*/
	public static ch.inofix.sketchboard.model.SketchBoard getSketchBoard(
		long sketchBoardId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSketchBoard(sketchBoardId);
	}

	/**
	* Returns the sketch board matching the UUID and group.
	*
	* @param uuid the sketch board's UUID
	* @param groupId the primary key of the group
	* @return the matching sketch board
	* @throws PortalException if a matching sketch board could not be found
	*/
	public static ch.inofix.sketchboard.model.SketchBoard getSketchBoardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSketchBoardByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		int start, int end) {
		return getService().getSketchBoards(start, end);
	}

	public static java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		long groupId) {
		return getService().getSketchBoards(groupId);
	}

	public static java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		long groupId, int start, int end) {
		return getService().getSketchBoards(groupId, start, end);
	}

	public static java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoards(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ch.inofix.sketchboard.model.SketchBoard> obc) {
		return getService().getSketchBoards(groupId, start, end, obc);
	}

	/**
	* Returns all the sketch boards matching the UUID and company.
	*
	* @param uuid the UUID of the sketch boards
	* @param companyId the primary key of the company
	* @return the matching sketch boards, or an empty list if no matches were found
	*/
	public static java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoardsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getSketchBoardsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<ch.inofix.sketchboard.model.SketchBoard> getSketchBoardsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ch.inofix.sketchboard.model.SketchBoard> orderByComparator) {
		return getService()
				   .getSketchBoardsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of sketch boards.
	*
	* @return the number of sketch boards
	*/
	public static int getSketchBoardsCount() {
		return getService().getSketchBoardsCount();
	}

	public static int getSketchBoardsCount(long groupId) {
		return getService().getSketchBoardsCount(groupId);
	}

	/**
	* Updates the sketch board in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sketchBoard the sketch board
	* @return the sketch board that was updated
	*/
	public static ch.inofix.sketchboard.model.SketchBoard updateSketchBoard(
		ch.inofix.sketchboard.model.SketchBoard sketchBoard) {
		return getService().updateSketchBoard(sketchBoard);
	}

	public static SketchBoardLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SketchBoardLocalService, SketchBoardLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SketchBoardLocalService.class);
}