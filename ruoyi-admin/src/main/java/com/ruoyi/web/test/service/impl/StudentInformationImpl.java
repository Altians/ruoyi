package com.ruoyi.web.test.service.impl;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.test.domain.StudentInformation;
import com.ruoyi.web.test.mapper.StudentInformationMapper;
import com.ruoyi.web.test.service.StudentInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentInformationImpl implements StudentInformationService {
    @Resource
    private StudentInformationMapper studentInformationMapper;

    @Override
    public TableDataInfo pageQuery(StudentInformation studentInformation) {
        if (studentInformation.getOff() != null && studentInformation.getNum() != null) {
            studentInformation.setOff((studentInformation.getOff() - 1) * studentInformation.getNum());
        }
        List<StudentInformation> list = null;
        long total = 0;
        System.out.println("studentInformation.getName()===>" + studentInformation.getName());
        if (studentInformation.getName() == null) {
            list = studentInformationMapper.queryAllByLimit(studentInformation);
            total = studentInformationMapper.count(studentInformation);
            System.out.println("listAll===>" + list);
        } else {
            list = studentInformationMapper.queryNameByLimit(studentInformation);
            total = studentInformationMapper.countName(studentInformation);
            System.out.println("listName===>" + list);
        }
        System.out.println("list===>" + list);
        TableDataInfo data = new TableDataInfo();
        data.setRows(list);
        data.setTotal(total);
        return data;
    }

    @Override
    public StudentInformation queryId(Long id) {
        return studentInformationMapper.queryId(id);
    }

    @Override
    public StudentInformation insertInformation(StudentInformation studentInformation) {
        studentInformationMapper.insertInformation(studentInformation);
        return studentInformation;
    }

    @Override
    public StudentInformation updateInformation(StudentInformation studentInformation) {
        studentInformationMapper.update(studentInformation);
        return studentInformation;
    }

    @Override
    public boolean del(Long id) {
        int total = studentInformationMapper.del(id);
        return total > 0;
    }

    @Override
    public boolean delArr(Long[] ids) {
        int total = 0;
        for (Long id : ids) {
             total =studentInformationMapper.del(id);
        }
        return total>0;
    }
}
