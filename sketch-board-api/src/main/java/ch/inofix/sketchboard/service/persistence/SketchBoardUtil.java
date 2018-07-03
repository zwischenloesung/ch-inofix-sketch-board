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

package ch.inofix.sketchboard.service.persistence;

import aQute.bnd.annotation.ProviderType;

import ch.inofix.sketchboard.model.SketchBoard;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the sketch board service. This utility wraps {@link ch.inofix.sketchboard.service.persistence.impl.SketchBoardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoardPersistence
 * @see ch.inofix.sketchboard.service.persistence.impl.SketchBoardPersistenceImpl
 * @generated
 */
@ProviderType
public class SketchBoardUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SketchBoard sketchBoard) {
		getPersistence().clearCache(sketchBoard);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SketchBoard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SketchBoard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SketchBoard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SketchBoard update(SketchBoard sketchBoard) {
		return getPersistence().update(sketchBoard);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SketchBoard update(SketchBoard sketchBoard,
		ServiceContext serviceContext) {
		return getPersistence().update(sketchBoard, serviceContext);
	}

	/**
	* Returns all the sketch boards where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching sketch boards
	*/
	public static List<SketchBoard> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the sketch boards where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @return the range of matching sketch boards
	*/
	public static List<SketchBoard> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the sketch boards where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sketch boards
	*/
	public static List<SketchBoard> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sketch boards where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sketch boards
	*/
	public static List<SketchBoard> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByUuid_First(java.lang.String uuid,
		OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByUuid_Last(java.lang.String uuid,
		OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the sketch boards before and after the current sketch board in the ordered set where uuid = &#63;.
	*
	* @param sketchBoardId the primary key of the current sketch board
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public static SketchBoard[] findByUuid_PrevAndNext(long sketchBoardId,
		java.lang.String uuid, OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence()
				   .findByUuid_PrevAndNext(sketchBoardId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the sketch boards where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of sketch boards where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching sketch boards
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the sketch board where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSketchBoardException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByUUID_G(java.lang.String uuid, long groupId)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the sketch board where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the sketch board where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the sketch board where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the sketch board that was removed
	*/
	public static SketchBoard removeByUUID_G(java.lang.String uuid, long groupId)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of sketch boards where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching sketch boards
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching sketch boards
	*/
	public static List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @return the range of matching sketch boards
	*/
	public static List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sketch boards
	*/
	public static List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sketch boards
	*/
	public static List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the sketch boards before and after the current sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param sketchBoardId the primary key of the current sketch board
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public static SketchBoard[] findByUuid_C_PrevAndNext(long sketchBoardId,
		java.lang.String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(sketchBoardId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the sketch boards where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching sketch boards
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the sketch boards where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching sketch boards
	*/
	public static List<SketchBoard> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the sketch boards where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @return the range of matching sketch boards
	*/
	public static List<SketchBoard> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the sketch boards where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sketch boards
	*/
	public static List<SketchBoard> findByGroupId(long groupId, int start,
		int end, OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sketch boards where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sketch boards
	*/
	public static List<SketchBoard> findByGroupId(long groupId, int start,
		int end, OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByGroupId_First(long groupId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByGroupId_First(long groupId,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public static SketchBoard findByGroupId_Last(long groupId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public static SketchBoard fetchByGroupId_Last(long groupId,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the sketch boards before and after the current sketch board in the ordered set where groupId = &#63;.
	*
	* @param sketchBoardId the primary key of the current sketch board
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public static SketchBoard[] findByGroupId_PrevAndNext(long sketchBoardId,
		long groupId, OrderByComparator<SketchBoard> orderByComparator)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(sketchBoardId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the sketch boards where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of sketch boards where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching sketch boards
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the sketch board in the entity cache if it is enabled.
	*
	* @param sketchBoard the sketch board
	*/
	public static void cacheResult(SketchBoard sketchBoard) {
		getPersistence().cacheResult(sketchBoard);
	}

	/**
	* Caches the sketch boards in the entity cache if it is enabled.
	*
	* @param sketchBoards the sketch boards
	*/
	public static void cacheResult(List<SketchBoard> sketchBoards) {
		getPersistence().cacheResult(sketchBoards);
	}

	/**
	* Creates a new sketch board with the primary key. Does not add the sketch board to the database.
	*
	* @param sketchBoardId the primary key for the new sketch board
	* @return the new sketch board
	*/
	public static SketchBoard create(long sketchBoardId) {
		return getPersistence().create(sketchBoardId);
	}

	/**
	* Removes the sketch board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board that was removed
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public static SketchBoard remove(long sketchBoardId)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().remove(sketchBoardId);
	}

	public static SketchBoard updateImpl(SketchBoard sketchBoard) {
		return getPersistence().updateImpl(sketchBoard);
	}

	/**
	* Returns the sketch board with the primary key or throws a {@link NoSuchSketchBoardException} if it could not be found.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public static SketchBoard findByPrimaryKey(long sketchBoardId)
		throws ch.inofix.sketchboard.exception.NoSuchSketchBoardException {
		return getPersistence().findByPrimaryKey(sketchBoardId);
	}

	/**
	* Returns the sketch board with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board, or <code>null</code> if a sketch board with the primary key could not be found
	*/
	public static SketchBoard fetchByPrimaryKey(long sketchBoardId) {
		return getPersistence().fetchByPrimaryKey(sketchBoardId);
	}

	public static java.util.Map<java.io.Serializable, SketchBoard> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the sketch boards.
	*
	* @return the sketch boards
	*/
	public static List<SketchBoard> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sketch boards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @return the range of sketch boards
	*/
	public static List<SketchBoard> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sketch boards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sketch boards
	*/
	public static List<SketchBoard> findAll(int start, int end,
		OrderByComparator<SketchBoard> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sketch boards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SketchBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sketch boards
	* @param end the upper bound of the range of sketch boards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sketch boards
	*/
	public static List<SketchBoard> findAll(int start, int end,
		OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sketch boards from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sketch boards.
	*
	* @return the number of sketch boards
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SketchBoardPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SketchBoardPersistence, SketchBoardPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SketchBoardPersistence.class);
}