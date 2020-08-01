package com.cwp.study.dao.user.mapper;

import com.cwp.study.dao.user.entity.StudyUser;

public interface StudyUserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(StudyUser record);

    int insertSelective(StudyUser record);

    StudyUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(StudyUser record);

    int updateByPrimaryKey(StudyUser record);
}