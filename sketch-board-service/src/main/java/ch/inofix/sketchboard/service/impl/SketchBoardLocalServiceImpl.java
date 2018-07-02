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

import ch.inofix.sketchboard.service.base.SketchBoardLocalServiceBaseImpl;
import ch.inofix.sketchboard.exception.SketchBoardNameException;
import ch.inofix.sketchboard.exception.SketchBoardConfigurationException;
import ch.inofix.sketchboard.exception.SketchBoardSetupException;
import ch.inofix.sketchboard.model.SketchBoard;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the sketch board local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link ch.inofix.sketchboard.service.SketchBoardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can
 * only be accessed from within the same VM.
 * </p>
 *
 * @author Michael Lustenberger
 * @created 2018-06-22
 * @modified 2018-06-22
 * @version 1.0.0
 * @see SketchBoardLocalServiceBaseImpl
 * @see ch.inofix.sketchboard.service.SketchBoardLocalServiceUtil
 */
public class SketchBoardLocalServiceImpl
                extends SketchBoardLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use
     * {@link ch.inofix.sketchboard.service.SketchBoardLocalServiceUtil} to
     * access the sketch board local service.
     */
    public SketchBoard addSketchBoard(long userId, String name,
            String description, String configuration, String setup,
            ServiceContext serviceContext) throws PortalException {

        long groupId = serviceContext.getScopeGroupId();

        User user = userLocalService.getUserById(userId);

        Date now = new Date();

        validate(name, configuration, setup);

        long sketchBoardId = counterLocalService.increment();

        SketchBoard sketchBoard = sketchBoardPersistence.create(sketchBoardId);

        sketchBoard.setUuid(serviceContext.getUuid());
        sketchBoard.setUserId(userId);
        sketchBoard.setGroupId(groupId);
        sketchBoard.setCompanyId(user.getCompanyId());
        sketchBoard.setUserName(user.getFullName());
        sketchBoard.setCreateDate(serviceContext.getCreateDate(now));
        sketchBoard.setModifiedDate(serviceContext.getModifiedDate(now));
        sketchBoard.setName(name);
        sketchBoard.setDescription(description);
        sketchBoard.setConfiguration(configuration);
        sketchBoard.setSetup(setup);
//        sketchBoard.setExpandoBridgeAttributes(serviceContext);

        sketchBoardPersistence.update(sketchBoard);

        return sketchBoard;
    }

    public SketchBoard updateSketchBoard (
        long userId, long sketchBoardId, String name, String description,
        String configuration, String setup, ServiceContext serviceContext)
        throws PortalException, SystemException {

        Date now = new Date();

        validate(name, configuration, setup);

        SketchBoard sketchBoard = getSketchBoard(sketchBoardId);

        User user = userLocalService.getUserById(userId);

        sketchBoard.setUserId(userId);
        sketchBoard.setUserName(user.getFullName());
        sketchBoard.setModifiedDate(serviceContext.getModifiedDate(now));
        sketchBoard.setName(name);
        sketchBoard.setDescription(description);
        sketchBoard.setConfiguration(configuration);
        sketchBoard.setSetup(setup);

        sketchBoardPersistence.update(sketchBoard);

        return sketchBoard;
    }

    public SketchBoard deleteSketchBoard (long sketchBoardId,
            ServiceContext serviceContext) throws PortalException {

        SketchBoard sketchBoard = getSketchBoard(sketchBoardId);

        sketchBoard = deleteSketchBoard(sketchBoardId);

        return sketchBoard;
    }

    public List<SketchBoard> getSketchBoards(long groupId) {

        return sketchBoardPersistence.findByGroupId(groupId);
    }

    public List<SketchBoard> getSketchBoards(long groupId, int start, int end,
        OrderByComparator<SketchBoard> obc) {

        return sketchBoardPersistence.findByGroupId(groupId, start, end, obc);
    }

    public List<SketchBoard> getSketchBoards(long groupId, int start, int end) {

        return sketchBoardPersistence.findByGroupId(groupId, start, end);
    }

    public int getSketchBoardsCount(long groupId) {

        return sketchBoardPersistence.countByGroupId(groupId);
    }

    protected void validate(String name, String configuration, String setup)
            throws PortalException {
        if (Validator.isNull(name)) {
            throw new SketchBoardNameException();
        }
        if (Validator.isNull(name)) {
            throw new SketchBoardConfigurationException();
        }
        if (Validator.isNull(name)) {
            throw new SketchBoardSetupException();
        }
    }
}
