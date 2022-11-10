package com.goldenage.project.space.model.dao;

import com.goldenage.project.space.model.dto.SpaceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpaceMapper {
    List<SpaceDTO> selectSpaceList();

    int insertSpace(SpaceDTO space);

    int deleteSpaceFile(int spaceNum);

    int deleteSpace(int spaceNum);

    int insertSpacePhoto(Map<String, String> pho);

    int selectNum();
}
