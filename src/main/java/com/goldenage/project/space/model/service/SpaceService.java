package com.goldenage.project.space.model.service;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.space.model.dto.SpaceDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpaceService {
    // 관리자 연습실 리스트
    List<SpaceDTO> selectSpaceList();

    //연습실 삭제
    @Transactional
    int deleteSpace(int spaceNum) throws NoticeDeleteException, SpaceDeleteException;
}
