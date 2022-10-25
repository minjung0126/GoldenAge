package com.goldenage.project.company.model.service;

import com.goldenage.project.company.model.dao.CompanyMapper;
import com.goldenage.project.company.model.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

    private CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyDTO selectComInfo() {

        CompanyDTO comInfo = companyMapper.selectComInfo();

        return comInfo;
    }

    @Override
    public CompanyDTO selectComInfos(){

        CompanyDTO comInfo = companyMapper.selectComInfos();

        return comInfo;
    }
}
