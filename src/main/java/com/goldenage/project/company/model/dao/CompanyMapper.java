package com.goldenage.project.company.model.dao;

import com.goldenage.project.company.model.dto.CompanyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    CompanyDTO selectComInfo();

    CompanyDTO selectComInfos();

    int updateComInfo(CompanyDTO company);
}
