package com.cwp.study.dao.user.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * study_user
 * @author 
 */
@Data
public class StudyUser implements Serializable {
    private Long userId;

    private String userName;

    private Integer age;

    private static final long serialVersionUID = 1L;
}