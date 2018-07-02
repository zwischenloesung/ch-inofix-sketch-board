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
 * Provides the remote service utility for SketchBoard. This utility wraps
 * {@link ch.inofix.sketchboard.service.impl.SketchBoardServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SketchBoardService
 * @see ch.inofix.sketchboard.service.base.SketchBoardServiceBaseImpl
 * @see ch.inofix.sketchboard.service.impl.SketchBoardServiceImpl
 * @generated
 */
@ProviderType
public class SketchBoardServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ch.inofix.sketchboard.service.impl.SketchBoardServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static ch.inofix.sketchboard.model.SketchBoard deleteSketchBoard(
		long sketchBoardId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSketchBoard(sketchBoardId, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ch.inofix.sketchboard.model.SketchBoard getSketchBoard(
		long sketchBoardId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSketchBoard(sketchBoardId);
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

	public static int getSketchBoardsCount(long groupId) {
		return getService().getSketchBoardsCount(groupId);
	}

	public static ch.inofix.sketchboard.model.SketchBoard updateSketchBoard(
		long userId, long sketchBoardId, java.lang.String name,
		java.lang.String description, java.lang.String configuration,
		java.lang.String setup,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSketchBoard(userId, sketchBoardId, name, description,
			configuration, setup, serviceContext);
	}

	public static SketchBoardService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SketchBoardService, SketchBoardService> _serviceTracker =
		ServiceTrackerFactory.open(SketchBoardService.class);
}