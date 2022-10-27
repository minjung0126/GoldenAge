package com.goldenage.project.company.model.service;

import com.goldenage.project.company.model.dto.CompanyDTO;

public interface CompanyService {

    CompanyDTO selectComInfo();

    CompanyDTO selectComInfos();

    int updateCompany(CompanyDTO company);
}
