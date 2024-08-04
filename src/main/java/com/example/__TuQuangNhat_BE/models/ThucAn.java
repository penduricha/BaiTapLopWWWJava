package com.example.__TuQuangNhat_BE.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Entity
@Data
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table( name="thucan")
public class ThucAn implements Serializable {

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

}
