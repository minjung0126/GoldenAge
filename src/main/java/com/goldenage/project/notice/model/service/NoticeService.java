package com.goldenage.project.notice.model.service;

import com.goldenage.project.notice.model.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {
    List<NoticeDTO> selectNoticeList();
}
