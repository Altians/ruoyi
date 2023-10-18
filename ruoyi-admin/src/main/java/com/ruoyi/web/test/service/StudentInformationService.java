package com.ruoyi.web.test.service;


import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.test.domain.StudentInformation;



public interface StudentInformationService {
    TableDataInfo pageQuery(StudentInformation studentInformation);
    StudentInformation queryId(Long id);
    StudentInformation insertInformation(StudentInformation studentInformation);
    StudentInformation updateInformation(StudentInformation studentInformation);
    boolean del(Long id);
    boolean delArr(Long[] ids);
}
