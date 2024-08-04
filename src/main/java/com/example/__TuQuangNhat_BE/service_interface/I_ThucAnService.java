package com.example.__TuQuangNhat_BE.service_interface;

import com.example.__TuQuangNhat_BE.models.ThucAn;

import java.util.List;

public interface I_ThucAnService {
    public ThucAn saveThucAn(ThucAn thucAn) ;
    public List<ThucAn> getAllThucAns();
    public ThucAn getThucAnById(Long id);
    public void deleteThucAnById(Long id);
    public void updateThucAnById(Long id,ThucAn thucAn);
}
