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

package ch.inofix.sketchboard.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import ch.inofix.sketchboard.exception.NoSuchSketchBoardException;
import ch.inofix.sketchboard.model.SketchBoard;
import ch.inofix.sketchboard.model.impl.SketchBoardImpl;
import ch.inofix.sketchboard.model.impl.SketchBoardModelImpl;
import ch.inofix.sketchboard.service.persistence.SketchBoardPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the sketch board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoardPersistence
 * @see ch.inofix.sketchboard.service.persistence.SketchBoardUtil
 * @generated
 */
@ProviderType
public class SketchBoardPersistenceImpl extends BasePersistenceImpl<SketchBoard>
	implements SketchBoardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SketchBoardUtil} to access the sketch board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SketchBoardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SketchBoardModelImpl.UUID_COLUMN_BITMASK |
			SketchBoardModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the sketch boards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sketch boards
	 */
	@Override
	public List<SketchBoard> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SketchBoard> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<SketchBoard> findByUuid(String uuid, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<SketchBoard> findByUuid(String uuid, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<SketchBoard> list = null;

		if (retrieveFromCache) {
			list = (List<SketchBoard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SketchBoard sketchBoard : list) {
					if (!Objects.equals(uuid, sketchBoard.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SketchBoardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sketch board in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sketch board
	 * @throws NoSuchSketchBoardException if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard findByUuid_First(String uuid,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByUuid_First(uuid, orderByComparator);

		if (sketchBoard != null) {
			return sketchBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchSketchBoardException(msg.toString());
	}

	/**
	 * Returns the first sketch board in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByUuid_First(String uuid,
		OrderByComparator<SketchBoard> orderByComparator) {
		List<SketchBoard> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sketch board in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sketch board
	 * @throws NoSuchSketchBoardException if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard findByUuid_Last(String uuid,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByUuid_Last(uuid, orderByComparator);

		if (sketchBoard != null) {
			return sketchBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchSketchBoardException(msg.toString());
	}

	/**
	 * Returns the last sketch board in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByUuid_Last(String uuid,
		OrderByComparator<SketchBoard> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SketchBoard> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SketchBoard[] findByUuid_PrevAndNext(long sketchBoardId,
		String uuid, OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = findByPrimaryKey(sketchBoardId);

		Session session = null;

		try {
			session = openSession();

			SketchBoard[] array = new SketchBoardImpl[3];

			array[0] = getByUuid_PrevAndNext(session, sketchBoard, uuid,
					orderByComparator, true);

			array[1] = sketchBoard;

			array[2] = getByUuid_PrevAndNext(session, sketchBoard, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SketchBoard getByUuid_PrevAndNext(Session session,
		SketchBoard sketchBoard, String uuid,
		OrderByComparator<SketchBoard> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SketchBoardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sketchBoard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SketchBoard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sketch boards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SketchBoard sketchBoard : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sketchBoard);
		}
	}

	/**
	 * Returns the number of sketch boards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sketch boards
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SKETCHBOARD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "sketchBoard.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "sketchBoard.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(sketchBoard.uuid IS NULL OR sketchBoard.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SketchBoardModelImpl.UUID_COLUMN_BITMASK |
			SketchBoardModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the sketch board where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSketchBoardException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sketch board
	 * @throws NoSuchSketchBoardException if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard findByUUID_G(String uuid, long groupId)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByUUID_G(uuid, groupId);

		if (sketchBoard == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSketchBoardException(msg.toString());
		}

		return sketchBoard;
	}

	/**
	 * Returns the sketch board where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sketch board where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SketchBoard) {
			SketchBoard sketchBoard = (SketchBoard)result;

			if (!Objects.equals(uuid, sketchBoard.getUuid()) ||
					(groupId != sketchBoard.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<SketchBoard> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SketchBoard sketchBoard = list.get(0);

					result = sketchBoard;

					cacheResult(sketchBoard);

					if ((sketchBoard.getUuid() == null) ||
							!sketchBoard.getUuid().equals(uuid) ||
							(sketchBoard.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, sketchBoard);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SketchBoard)result;
		}
	}

	/**
	 * Removes the sketch board where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sketch board that was removed
	 */
	@Override
	public SketchBoard removeByUUID_G(String uuid, long groupId)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = findByUUID_G(uuid, groupId);

		return remove(sketchBoard);
	}

	/**
	 * Returns the number of sketch boards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sketch boards
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SKETCHBOARD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "sketchBoard.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "sketchBoard.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(sketchBoard.uuid IS NULL OR sketchBoard.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "sketchBoard.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SketchBoardModelImpl.UUID_COLUMN_BITMASK |
			SketchBoardModelImpl.COMPANYID_COLUMN_BITMASK |
			SketchBoardModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the sketch boards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sketch boards
	 */
	@Override
	public List<SketchBoard> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SketchBoard> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<SketchBoard> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<SketchBoard> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<SketchBoard> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<SketchBoard> list = null;

		if (retrieveFromCache) {
			list = (List<SketchBoard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SketchBoard sketchBoard : list) {
					if (!Objects.equals(uuid, sketchBoard.getUuid()) ||
							(companyId != sketchBoard.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SketchBoardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SketchBoard findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (sketchBoard != null) {
			return sketchBoard;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchSketchBoardException(msg.toString());
	}

	/**
	 * Returns the first sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator) {
		List<SketchBoard> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SketchBoard findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (sketchBoard != null) {
			return sketchBoard;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchSketchBoardException(msg.toString());
	}

	/**
	 * Returns the last sketch board in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SketchBoard> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SketchBoard[] findByUuid_C_PrevAndNext(long sketchBoardId,
		String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = findByPrimaryKey(sketchBoardId);

		Session session = null;

		try {
			session = openSession();

			SketchBoard[] array = new SketchBoardImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, sketchBoard, uuid,
					companyId, orderByComparator, true);

			array[1] = sketchBoard;

			array[2] = getByUuid_C_PrevAndNext(session, sketchBoard, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SketchBoard getByUuid_C_PrevAndNext(Session session,
		SketchBoard sketchBoard, String uuid, long companyId,
		OrderByComparator<SketchBoard> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SketchBoardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sketchBoard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SketchBoard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sketch boards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SketchBoard sketchBoard : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sketchBoard);
		}
	}

	/**
	 * Returns the number of sketch boards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sketch boards
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SKETCHBOARD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "sketchBoard.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "sketchBoard.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(sketchBoard.uuid IS NULL OR sketchBoard.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "sketchBoard.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, SketchBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SketchBoardModelImpl.GROUPID_COLUMN_BITMASK |
			SketchBoardModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sketch boards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sketch boards
	 */
	@Override
	public List<SketchBoard> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SketchBoard> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<SketchBoard> findByGroupId(long groupId, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<SketchBoard> findByGroupId(long groupId, int start, int end,
		OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<SketchBoard> list = null;

		if (retrieveFromCache) {
			list = (List<SketchBoard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SketchBoard sketchBoard : list) {
					if ((groupId != sketchBoard.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SketchBoardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sketch board in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sketch board
	 * @throws NoSuchSketchBoardException if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard findByGroupId_First(long groupId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByGroupId_First(groupId,
				orderByComparator);

		if (sketchBoard != null) {
			return sketchBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchSketchBoardException(msg.toString());
	}

	/**
	 * Returns the first sketch board in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByGroupId_First(long groupId,
		OrderByComparator<SketchBoard> orderByComparator) {
		List<SketchBoard> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sketch board in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sketch board
	 * @throws NoSuchSketchBoardException if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard findByGroupId_Last(long groupId,
		OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByGroupId_Last(groupId, orderByComparator);

		if (sketchBoard != null) {
			return sketchBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchSketchBoardException(msg.toString());
	}

	/**
	 * Returns the last sketch board in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sketch board, or <code>null</code> if a matching sketch board could not be found
	 */
	@Override
	public SketchBoard fetchByGroupId_Last(long groupId,
		OrderByComparator<SketchBoard> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SketchBoard> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SketchBoard[] findByGroupId_PrevAndNext(long sketchBoardId,
		long groupId, OrderByComparator<SketchBoard> orderByComparator)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = findByPrimaryKey(sketchBoardId);

		Session session = null;

		try {
			session = openSession();

			SketchBoard[] array = new SketchBoardImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, sketchBoard, groupId,
					orderByComparator, true);

			array[1] = sketchBoard;

			array[2] = getByGroupId_PrevAndNext(session, sketchBoard, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SketchBoard getByGroupId_PrevAndNext(Session session,
		SketchBoard sketchBoard, long groupId,
		OrderByComparator<SketchBoard> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKETCHBOARD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SketchBoardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sketchBoard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SketchBoard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sketch boards where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SketchBoard sketchBoard : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sketchBoard);
		}
	}

	/**
	 * Returns the number of sketch boards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sketch boards
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SKETCHBOARD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "sketchBoard.groupId = ?";

	public SketchBoardPersistenceImpl() {
		setModelClass(SketchBoard.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the sketch board in the entity cache if it is enabled.
	 *
	 * @param sketchBoard the sketch board
	 */
	@Override
	public void cacheResult(SketchBoard sketchBoard) {
		entityCache.putResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardImpl.class, sketchBoard.getPrimaryKey(), sketchBoard);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { sketchBoard.getUuid(), sketchBoard.getGroupId() },
			sketchBoard);

		sketchBoard.resetOriginalValues();
	}

	/**
	 * Caches the sketch boards in the entity cache if it is enabled.
	 *
	 * @param sketchBoards the sketch boards
	 */
	@Override
	public void cacheResult(List<SketchBoard> sketchBoards) {
		for (SketchBoard sketchBoard : sketchBoards) {
			if (entityCache.getResult(
						SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
						SketchBoardImpl.class, sketchBoard.getPrimaryKey()) == null) {
				cacheResult(sketchBoard);
			}
			else {
				sketchBoard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sketch boards.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SketchBoardImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sketch board.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SketchBoard sketchBoard) {
		entityCache.removeResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardImpl.class, sketchBoard.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SketchBoardModelImpl)sketchBoard, true);
	}

	@Override
	public void clearCache(List<SketchBoard> sketchBoards) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SketchBoard sketchBoard : sketchBoards) {
			entityCache.removeResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
				SketchBoardImpl.class, sketchBoard.getPrimaryKey());

			clearUniqueFindersCache((SketchBoardModelImpl)sketchBoard, true);
		}
	}

	protected void cacheUniqueFindersCache(
		SketchBoardModelImpl sketchBoardModelImpl) {
		Object[] args = new Object[] {
				sketchBoardModelImpl.getUuid(),
				sketchBoardModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			sketchBoardModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SketchBoardModelImpl sketchBoardModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					sketchBoardModelImpl.getUuid(),
					sketchBoardModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((sketchBoardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					sketchBoardModelImpl.getOriginalUuid(),
					sketchBoardModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new sketch board with the primary key. Does not add the sketch board to the database.
	 *
	 * @param sketchBoardId the primary key for the new sketch board
	 * @return the new sketch board
	 */
	@Override
	public SketchBoard create(long sketchBoardId) {
		SketchBoard sketchBoard = new SketchBoardImpl();

		sketchBoard.setNew(true);
		sketchBoard.setPrimaryKey(sketchBoardId);

		String uuid = PortalUUIDUtil.generate();

		sketchBoard.setUuid(uuid);

		sketchBoard.setCompanyId(companyProvider.getCompanyId());

		return sketchBoard;
	}

	/**
	 * Removes the sketch board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sketchBoardId the primary key of the sketch board
	 * @return the sketch board that was removed
	 * @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	 */
	@Override
	public SketchBoard remove(long sketchBoardId)
		throws NoSuchSketchBoardException {
		return remove((Serializable)sketchBoardId);
	}

	/**
	 * Removes the sketch board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sketch board
	 * @return the sketch board that was removed
	 * @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	 */
	@Override
	public SketchBoard remove(Serializable primaryKey)
		throws NoSuchSketchBoardException {
		Session session = null;

		try {
			session = openSession();

			SketchBoard sketchBoard = (SketchBoard)session.get(SketchBoardImpl.class,
					primaryKey);

			if (sketchBoard == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSketchBoardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sketchBoard);
		}
		catch (NoSuchSketchBoardException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SketchBoard removeImpl(SketchBoard sketchBoard) {
		sketchBoard = toUnwrappedModel(sketchBoard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sketchBoard)) {
				sketchBoard = (SketchBoard)session.get(SketchBoardImpl.class,
						sketchBoard.getPrimaryKeyObj());
			}

			if (sketchBoard != null) {
				session.delete(sketchBoard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sketchBoard != null) {
			clearCache(sketchBoard);
		}

		return sketchBoard;
	}

	@Override
	public SketchBoard updateImpl(SketchBoard sketchBoard) {
		sketchBoard = toUnwrappedModel(sketchBoard);

		boolean isNew = sketchBoard.isNew();

		SketchBoardModelImpl sketchBoardModelImpl = (SketchBoardModelImpl)sketchBoard;

		if (Validator.isNull(sketchBoard.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			sketchBoard.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (sketchBoard.getCreateDate() == null)) {
			if (serviceContext == null) {
				sketchBoard.setCreateDate(now);
			}
			else {
				sketchBoard.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!sketchBoardModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sketchBoard.setModifiedDate(now);
			}
			else {
				sketchBoard.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (sketchBoard.isNew()) {
				session.save(sketchBoard);

				sketchBoard.setNew(false);
			}
			else {
				sketchBoard = (SketchBoard)session.merge(sketchBoard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SketchBoardModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { sketchBoardModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					sketchBoardModelImpl.getUuid(),
					sketchBoardModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { sketchBoardModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((sketchBoardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sketchBoardModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { sketchBoardModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((sketchBoardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sketchBoardModelImpl.getOriginalUuid(),
						sketchBoardModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						sketchBoardModelImpl.getUuid(),
						sketchBoardModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((sketchBoardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sketchBoardModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { sketchBoardModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		entityCache.putResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
			SketchBoardImpl.class, sketchBoard.getPrimaryKey(), sketchBoard,
			false);

		clearUniqueFindersCache(sketchBoardModelImpl, false);
		cacheUniqueFindersCache(sketchBoardModelImpl);

		sketchBoard.resetOriginalValues();

		return sketchBoard;
	}

	protected SketchBoard toUnwrappedModel(SketchBoard sketchBoard) {
		if (sketchBoard instanceof SketchBoardImpl) {
			return sketchBoard;
		}

		SketchBoardImpl sketchBoardImpl = new SketchBoardImpl();

		sketchBoardImpl.setNew(sketchBoard.isNew());
		sketchBoardImpl.setPrimaryKey(sketchBoard.getPrimaryKey());

		sketchBoardImpl.setUuid(sketchBoard.getUuid());
		sketchBoardImpl.setSketchBoardId(sketchBoard.getSketchBoardId());
		sketchBoardImpl.setGroupId(sketchBoard.getGroupId());
		sketchBoardImpl.setCompanyId(sketchBoard.getCompanyId());
		sketchBoardImpl.setUserId(sketchBoard.getUserId());
		sketchBoardImpl.setUserName(sketchBoard.getUserName());
		sketchBoardImpl.setCreateDate(sketchBoard.getCreateDate());
		sketchBoardImpl.setModifiedDate(sketchBoard.getModifiedDate());
		sketchBoardImpl.setStatus(sketchBoard.getStatus());
		sketchBoardImpl.setStatusByUserId(sketchBoard.getStatusByUserId());
		sketchBoardImpl.setStatusByUserName(sketchBoard.getStatusByUserName());
		sketchBoardImpl.setStatusDate(sketchBoard.getStatusDate());
		sketchBoardImpl.setName(sketchBoard.getName());
		sketchBoardImpl.setConfiguration(sketchBoard.getConfiguration());
		sketchBoardImpl.setSetup(sketchBoard.getSetup());

		return sketchBoardImpl;
	}

	/**
	 * Returns the sketch board with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sketch board
	 * @return the sketch board
	 * @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	 */
	@Override
	public SketchBoard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSketchBoardException {
		SketchBoard sketchBoard = fetchByPrimaryKey(primaryKey);

		if (sketchBoard == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSketchBoardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sketchBoard;
	}

	/**
	 * Returns the sketch board with the primary key or throws a {@link NoSuchSketchBoardException} if it could not be found.
	 *
	 * @param sketchBoardId the primary key of the sketch board
	 * @return the sketch board
	 * @throws NoSuchSketchBoardException if a sketch board with the primary key could not be found
	 */
	@Override
	public SketchBoard findByPrimaryKey(long sketchBoardId)
		throws NoSuchSketchBoardException {
		return findByPrimaryKey((Serializable)sketchBoardId);
	}

	/**
	 * Returns the sketch board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sketch board
	 * @return the sketch board, or <code>null</code> if a sketch board with the primary key could not be found
	 */
	@Override
	public SketchBoard fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
				SketchBoardImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SketchBoard sketchBoard = (SketchBoard)serializable;

		if (sketchBoard == null) {
			Session session = null;

			try {
				session = openSession();

				sketchBoard = (SketchBoard)session.get(SketchBoardImpl.class,
						primaryKey);

				if (sketchBoard != null) {
					cacheResult(sketchBoard);
				}
				else {
					entityCache.putResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
						SketchBoardImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
					SketchBoardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sketchBoard;
	}

	/**
	 * Returns the sketch board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sketchBoardId the primary key of the sketch board
	 * @return the sketch board, or <code>null</code> if a sketch board with the primary key could not be found
	 */
	@Override
	public SketchBoard fetchByPrimaryKey(long sketchBoardId) {
		return fetchByPrimaryKey((Serializable)sketchBoardId);
	}

	@Override
	public Map<Serializable, SketchBoard> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SketchBoard> map = new HashMap<Serializable, SketchBoard>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SketchBoard sketchBoard = fetchByPrimaryKey(primaryKey);

			if (sketchBoard != null) {
				map.put(primaryKey, sketchBoard);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
					SketchBoardImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SketchBoard)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SKETCHBOARD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (SketchBoard sketchBoard : (List<SketchBoard>)q.list()) {
				map.put(sketchBoard.getPrimaryKeyObj(), sketchBoard);

				cacheResult(sketchBoard);

				uncachedPrimaryKeys.remove(sketchBoard.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SketchBoardModelImpl.ENTITY_CACHE_ENABLED,
					SketchBoardImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the sketch boards.
	 *
	 * @return the sketch boards
	 */
	@Override
	public List<SketchBoard> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SketchBoard> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SketchBoard> findAll(int start, int end,
		OrderByComparator<SketchBoard> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SketchBoard> findAll(int start, int end,
		OrderByComparator<SketchBoard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SketchBoard> list = null;

		if (retrieveFromCache) {
			list = (List<SketchBoard>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SKETCHBOARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKETCHBOARD;

				if (pagination) {
					sql = sql.concat(SketchBoardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SketchBoard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sketch boards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SketchBoard sketchBoard : findAll()) {
			remove(sketchBoard);
		}
	}

	/**
	 * Returns the number of sketch boards.
	 *
	 * @return the number of sketch boards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKETCHBOARD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SketchBoardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sketch board persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SketchBoardImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SKETCHBOARD = "SELECT sketchBoard FROM SketchBoard sketchBoard";
	private static final String _SQL_SELECT_SKETCHBOARD_WHERE_PKS_IN = "SELECT sketchBoard FROM SketchBoard sketchBoard WHERE sketchBoardId IN (";
	private static final String _SQL_SELECT_SKETCHBOARD_WHERE = "SELECT sketchBoard FROM SketchBoard sketchBoard WHERE ";
	private static final String _SQL_COUNT_SKETCHBOARD = "SELECT COUNT(sketchBoard) FROM SketchBoard sketchBoard";
	private static final String _SQL_COUNT_SKETCHBOARD_WHERE = "SELECT COUNT(sketchBoard) FROM SketchBoard sketchBoard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sketchBoard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SketchBoard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SketchBoard exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SketchBoardPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}