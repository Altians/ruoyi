package com.ruoyi.web.test.controller;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.test.domain.StudentInformation;
import com.ruoyi.web.test.service.StudentInformationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StudentInformation")
public class StudentInformationController {
    @Autowired
    private StudentInformationService studentInformationService;

    @GetMapping("/list")
    public TableDataInfo pageList(StudentInformation studentInformation) {
        return studentInformationService.pageQuery(studentInformation);
    }

    @GetMapping("/queryId")
    public ResponseEntity<StudentInformation> queryId(Long id) {
        return ResponseEntity.ok(studentInformationService.queryId(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<StudentInformation> insert(@RequestBody StudentInformation studentInformation) {
        return ResponseEntity.ok(studentInformationService.insertInformation(studentInformation));
    }

    @PostMapping("/update")
    public ResponseEntity<StudentInformation> update(@RequestBody StudentInformation studentInformation) {
        return ResponseEntity.ok(studentInformationService.updateInformation(studentInformation));
    }

    @DeleteMapping("/del")
    public ResponseEntity<Boolean> del(Long id) {
        return ResponseEntity.ok(studentInformationService.del(id));
    }

    @DeleteMapping("/delArr")
    public ResponseEntity<Boolean> delArr(@RequestBody Long[] ids) {
        return ResponseEntity.ok(studentInformationService.delArr(ids));
    }
}
