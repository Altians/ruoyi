package com.ruoyi.web.test.mapper;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.test.domain.StudentInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentInformationMapper {
    List<StudentInformation> queryAllByLimit(StudentInformation studentInformation);

    List<StudentInformation> queryNameByLimit(StudentInformation studentInformation);

    StudentInformation queryId(Long id);

    long count(StudentInformation studentInformation);

    long countName(StudentInformation studentInformation);

    int insertInformation(StudentInformation studentInformation);

    int update(StudentInformation studentInformation);

    int del(Long id);

}
