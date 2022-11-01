package com.goldenage.project.space.model.service;

import com.goldenage.project.space.model.dao.SpaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("spaceService")
public class SpaceServiceImpl implements SpaceService{

    private SpaceMapper spaceMapper;

    @Autowired
    public SpaceServiceImpl(SpaceMapper spaceMapper){
        this.spaceMapper = spaceMapper;
    }

}

