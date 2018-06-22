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

import ch.inofix.sketchboard.exception.NoSuchSketchBoardException;
import ch.inofix.sketchboard.model.SketchBoard;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the sketch board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ch.inofix.sketchboard.service.persistence.impl.SketchBoardPersistenceImpl
 * @see SketchBoardUtil
 * @generated
 */
@ProviderType
public interface SketchBoardPersistence extends BasePersistence<SketchBoard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SketchBoardUtil} to access the sketch board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sketch boards where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching sketch boards
	*/
	public java.util.List<SketchBoard> findByUuid(java.lang.String uuid);

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
	public java.util.List<SketchBoard> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<SketchBoard> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

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
	public java.util.List<SketchBoard> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

	/**
	* Returns the sketch boards before and after the current sketch board in the ordered set where uuid = &#63;.
	*
	* @param sketchBoardId the primary key of the current sketch board
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public SketchBoard[] findByUuid_PrevAndNext(long sketchBoardId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Removes all the sketch boards where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of sketch boards where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching sketch boards
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the sketch board where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSketchBoardException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchSketchBoardException;

	/**
	* Returns the sketch board where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the sketch board where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the sketch board where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the sketch board that was removed
	*/
	public SketchBoard removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchSketchBoardException;

	/**
	* Returns the number of sketch boards where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching sketch boards
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching sketch boards
	*/
	public java.util.List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

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
	public java.util.List<SketchBoard> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Returns the first sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Returns the last sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

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
	public SketchBoard[] findByUuid_C_PrevAndNext(long sketchBoardId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Removes all the sketch boards where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of sketch boards where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching sketch boards
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the sketch boards where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching sketch boards
	*/
	public java.util.List<SketchBoard> findByGroupId(long groupId);

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
	public java.util.List<SketchBoard> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<SketchBoard> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

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
	public java.util.List<SketchBoard> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Returns the first sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

	/**
	* Returns the last sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board
	* @throws NoSuchSketchBoardException if a matching sketch board could not be found
	*/
	public SketchBoard findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Returns the last sketch board in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	*/
	public SketchBoard fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

	/**
	* Returns the sketch boards before and after the current sketch board in the ordered set where groupId = &#63;.
	*
	* @param sketchBoardId the primary key of the current sketch board
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public SketchBoard[] findByGroupId_PrevAndNext(long sketchBoardId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException;

	/**
	* Removes all the sketch boards where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of sketch boards where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching sketch boards
	*/
	public int countByGroupId(long groupId);

	/**
	* Caches the sketch board in the entity cache if it is enabled.
	*
	* @param sketchBoard the sketch board
	*/
	public void cacheResult(SketchBoard sketchBoard);

	/**
	* Caches the sketch boards in the entity cache if it is enabled.
	*
	* @param sketchBoards the sketch boards
	*/
	public void cacheResult(java.util.List<SketchBoard> sketchBoards);

	/**
	* Creates a new sketch board with the primary key. Does not add the sketch board to the database.
	*
	* @param sketchBoardId the primary key for the new sketch board
	* @return the new sketch board
	*/
	public SketchBoard create(long sketchBoardId);

	/**
	* Removes the sketch board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board that was removed
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public SketchBoard remove(long sketchBoardId)
		throws NoSuchSketchBoardException;

	public SketchBoard updateImpl(SketchBoard sketchBoard);

	/**
	* Returns the sketch board with the primary key or throws a {@link NoSuchSketchBoardException} if it could not be found.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board
	* @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	*/
	public SketchBoard findByPrimaryKey(long sketchBoardId)
		throws NoSuchSketchBoardException;

	/**
	* Returns the sketch board with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sketchBoardId the primary key of the sketch board
	* @return the sketch board, or <code>null</code> if a sketch board with the primary key could not be found
	*/
	public SketchBoard fetchByPrimaryKey(long sketchBoardId);

	@Override
	public java.util.Map<java.io.Serializable, SketchBoard> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the sketch boards.
	*
	* @return the sketch boards
	*/
	public java.util.List<SketchBoard> findAll();

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
	public java.util.List<SketchBoard> findAll(int start, int end);

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
	public java.util.List<SketchBoard> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator);

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
	public java.util.List<SketchBoard> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sketch boards from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of sketch boards.
	*
	* @return the number of sketch boards
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}