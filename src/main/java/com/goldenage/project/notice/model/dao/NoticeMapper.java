package com.goldenage.project.notice.model.dao;

import com.goldenage.project.notice.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectNoticeList();
}
