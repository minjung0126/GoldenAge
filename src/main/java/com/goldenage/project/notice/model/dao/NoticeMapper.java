package com.goldenage.project.notice.model.dao;

import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    NoticeDTO selectNoticeDetail(int noticeNo);

    int selectTotalCount(Map<String, String> searchMap);
}
