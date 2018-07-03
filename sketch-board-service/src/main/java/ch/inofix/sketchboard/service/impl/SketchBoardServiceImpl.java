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

package ch.inofix.sketchboard.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import ch.inofix.sketchboard.model.SketchBoard;
import ch.inofix.sketchboard.service.base.SketchBoardServiceBaseImpl;

/**
 * The implementation of the sketch board remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link ch.inofix.sketchboard.service.SketchBoardService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 * </p>
 *
 * @author Michael Lustenberger
 * @created 2018-06-22
 * @modified 2018-06-22
 * @version 1.0.0
 * @see SketchBoardServiceBaseImpl
 * @see ch.inofix.sketchboard.service.SketchBoardServiceUtil
 */
public class SketchBoardServiceImpl extends SketchBoardServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * {@link ch.inofix.sketchboard.service.SketchBoardServiceUtil} to access the
	 * sketch board remote service.
	 */
    public SketchBoard addSketchBoard(long userId, String name,
            String description, String configuration, String setup,
            ServiceContext serviceContext) throws PortalException {

        return sketchBoardLocalService.addSketchBoard(
            userId, name, description, configuration, setup, serviceContext);
    }

    public SketchBoard updateSketchBoard(long userId, long sketchBoardId,
            String name, String description, String configuration,
            String setup, ServiceContext serviceContext)
            throws PortalException, SystemException {

        return sketchBoardLocalService.updateSketchBoard(
            userId, sketchBoardId, name, description, configuration,
            setup, serviceContext);
    }

    public SketchBoard deleteSketchBoard(long sketchBoardId,
            ServiceContext serviceContext) throws PortalException {

        return sketchBoardLocalService.deleteSketchBoard(sketchBoardId,
                serviceContext);
    }

    public SketchBoard getSketchBoard(long sketchBoardId)
                                            throws PortalException {

        return sketchBoardLocalService.getSketchBoard(sketchBoardId);
    }

    public List<SketchBoard> getSketchBoards(long groupId, int start,
                        int end, OrderByComparator<SketchBoard> obc) {

        return sketchBoardLocalService.getSketchBoards(groupId, start,
                                                        end, obc);
    }

    public List<SketchBoard> getSketchBoards(long groupId, int start,
                                                        int end) {
        return sketchBoardLocalService.getSketchBoards(groupId, start, end);
    }

    public int getSketchBoardsCount(long groupId) {

        return sketchBoardLocalService.getSketchBoardsCount(groupId);
    }
}

