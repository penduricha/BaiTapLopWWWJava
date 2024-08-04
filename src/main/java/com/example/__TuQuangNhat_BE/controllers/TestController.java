package com.example.__TuQuangNhat_BE.controllers;

import com.example.__TuQuangNhat_BE.models.ThucAn;
import com.example.__TuQuangNhat_BE.services.ThucAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final ThucAnService thucAnService;
    @Autowired
    public TestController(ThucAnService thucAnService) {
        this.thucAnService = thucAnService;
    }
    @RequestMapping("/post")
    public String postDataThucAn()throws JpaSystemException {
        /*
            @Id
            private Long id;
            @Column(columnDefinition = "varchar(30)", nullable=false)
            private String tenThucAn;
            @Column(columnDefinition = "varchar(30)", nullable=false)
            private String diaChi;
            @Column(nullable=false)
            private double giaVon;
            @Column(columnDefinition = "varchar(30)", nullable=false)
            private String loai;
            @Column(columnDefinition = "varchar(30)", nullable=false)
            private String nhaCungCap;
         */
        //nap du lieu
        ThucAn thucAn=new ThucAn(1L,
                "Cam heo",
                "1 Quang Trung",
                1000,
                "Thuc an tho",
                "Tuong an");

        if(thucAnService.saveThucAn(thucAn)!=null){
            return "Adding successfully";
        }else{
            return "Adding failed";
        }
    }
}
