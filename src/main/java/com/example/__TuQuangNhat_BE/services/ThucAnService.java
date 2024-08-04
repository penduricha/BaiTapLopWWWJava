package com.example.__TuQuangNhat_BE.services;

import com.example.__TuQuangNhat_BE.models.ThucAn;
import com.example.__TuQuangNhat_BE.repositories.ThucAnRepository;
import com.example.__TuQuangNhat_BE.service_interface.I_ThucAnService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ThucAnService implements I_ThucAnService {
    private final ThucAnRepository thucAnRepository;

    public ThucAnService(ThucAnRepository thucAnRepository) {
        this.thucAnRepository = thucAnRepository;
    }

    @Override
    public ThucAn saveThucAn(ThucAn thucAn) throws JpaSystemException {
        return thucAnRepository.save(thucAn);
    }

    @Override
    public List<ThucAn> getAllThucAns() throws JpaSystemException{
        return thucAnRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public ThucAn getThucAnById(Long id) throws JpaSystemException{
        return thucAnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException( "Thuc An not found"));
    }

    @Override
    public void deleteThucAnById(Long id)throws JpaSystemException {
        ThucAn thucAn=getThucAnById(id);
        if(thucAn!=null){
            thucAnRepository.delete(thucAn);
        } else {
            // Xử lý trường hợp không tìm thấy user
            // Ví dụ, trả về mã lỗi 404 (Not Found)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Thuc An not found");
        }
    }

    @Override
    public void updateThucAnById(Long id, ThucAn thucAn) throws JpaSystemException{
        ThucAn thucAnFind=getThucAnById(id);
        if(thucAnFind!=null){
            thucAnFind.setTenThucAn(thucAn.getTenThucAn());
            thucAnFind.setLoai(thucAn.getLoai());
            thucAnFind.setDiaChi(thucAn.getDiaChi());
            thucAnFind.setGiaVon(thucAn.getGiaVon());
            thucAnFind.setNhaCungCap(thucAn.getNhaCungCap());
            thucAnRepository.save(thucAnFind);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Thuc An not found");
        }

    }
}
