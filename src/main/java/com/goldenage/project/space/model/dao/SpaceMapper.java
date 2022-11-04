package com.goldenage.project.space.model.dao;

import com.goldenage.project.space.model.dto.SpaceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpaceMapper {
    List<SpaceDTO> selectSpaceList();

    int deleteSpaceFile(int spaceNum);

    int deleteSpace(int spaceNum);
}
