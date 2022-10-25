package com.goldenage.project.notice.model.service;

import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.paging.SelectCriteria;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    NoticeDTO selectNoticeDetail(int noticeNo);

    int selectTotalCount(Map<String, String> searchMap);
}
