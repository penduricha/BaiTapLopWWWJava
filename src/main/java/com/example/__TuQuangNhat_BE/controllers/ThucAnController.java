package com.example.__TuQuangNhat_BE.controllers;

import com.example.__TuQuangNhat_BE.models.ThucAn;
import com.example.__TuQuangNhat_BE.services.ThucAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thucans")
//https://localhost:8080/api/thucans
public class ThucAnController {
    private final ThucAnService thucAnService;
    @Autowired
    public ThucAnController(ThucAnService thucAnService) {
        this.thucAnService = thucAnService;
    }
    @GetMapping
    public List<ThucAn> getAllThucAns() throws JpaSystemException {
        return thucAnService.getAllThucAns();
    }
    //phuong thuc POST
    @PostMapping
    public ThucAn createThucAn(@RequestBody ThucAn thucAn) throws JpaSystemException{
        return thucAnService.saveThucAn(thucAn);
        //return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ThucAn> getThucAnById(@PathVariable Long id) throws JpaSystemException {
        ThucAn thucAn=thucAnService.getThucAnById(id);
        return ResponseEntity.ok(thucAn);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ThucAn> updateThucAnById(@PathVariable Long id, @RequestBody ThucAn updateThucAn)throws JpaSystemException{
        try {
            if(thucAnService.getThucAnById(id)!=null){
                thucAnService.updateThucAnById(id,updateThucAn);
                return ResponseEntity.ok(updateThucAn);
            }
            return ResponseEntity.notFound().build();
        } catch (JpaSystemException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThucAnById(@PathVariable Long id) {
        try {
            ThucAn thucAn = thucAnService.getThucAnById(id);
            if (thucAn != null) {
                thucAnService.deleteThucAnById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (JpaSystemException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
