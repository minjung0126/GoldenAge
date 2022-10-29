package com.goldenage.project.notice.controller;

import com.goldenage.project.exception.notice.NoticeInsertException;
import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.notice.model.dto.NoticeFileDTO;
import com.goldenage.project.notice.model.service.NoticeServiceImpl;
import com.goldenage.project.paging.Pagenation;
import com.goldenage.project.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

    private final NoticeServiceImpl noticeService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public NoticeController(NoticeServiceImpl noticeService) {
        this.noticeService = noticeService;
    }

    // 공지사항 리스트
    @GetMapping("/notice")
    public ModelAndView noticeList(ModelAndView mv,  HttpServletRequest request){

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = noticeService.selectTotalCount(searchMap);

        int limit = 5;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<NoticeDTO> noticeList = noticeService.selectNoticeList(selectCriteria);

        mv.addObject("noticeList", noticeList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("notice/notice");

        return mv;
    }

    // 공지사항 상세보기
    @GetMapping("/notice_view")
    public ModelAndView noticeDetail(ModelAndView mv, HttpServletRequest request){

        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        log.info("noticeNo 무엇 : " + noticeNo);
        NoticeDTO noticeDetail = noticeService.selectNoticeDetail(noticeNo);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("notice/notice_view");

        return mv;
    }

    //관리자 공지사항 등록페이지 보기
    @GetMapping("/insert")
    public String noticeInsertPage(){

        return "notice/notice_insert";
    }

    @PostMapping("/insert")
    public String uploadFile(@ModelAttribute NoticeDTO notice
                            , @RequestParam(value="file", required=false) MultipartFile file
                            , RedirectAttributes rttr) throws IOException, NoticeInsertException {

        NoticeFileDTO noticeFile = new NoticeFileDTO();

        int result = noticeService.noticeInsert(notice);

        log.info("[NoticeController]" + notice);
        log.info("[NoticeController]" + file);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/uploadFiles";

        log.info("루트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + filePath);

        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        String noticeOriName = "";
        String ext = "";
        String noticeFileName = "";
        String savedPath = "";

        if(file.getSize() > 0) {
            noticeOriName = file.getOriginalFilename();
            ext = noticeOriName.substring(noticeOriName.lastIndexOf("."));
            noticeFileName = UUID.randomUUID().toString().replace("-",  "");
            savedPath = filePath + "/" + noticeFileName + ext;

            noticeFile.setNoticeOriName(noticeOriName);
            noticeFile.setNoticeFileName(noticeFileName + ext);
            noticeFile.setSavedPath(savedPath);

            noticeService.noticeFileInsert(noticeFile);

            try {
                file.transferTo(new File(filePath + "\\" + noticeFileName + ext));
            } catch (IOException e) {

                e.printStackTrace();
                new File(filePath + "\\" + noticeFileName + ext).delete();
            }
        }else if(file.getSize() == 0){

            noticeFile.setNoticeOriName(null);
            noticeFile.setNoticeFileName(null);
            noticeFile.setSavedPath(null);

            noticeService.noticeFileInsert(noticeFile);

        }

        rttr.addFlashAttribute("message", "공지사항 등록 성공!");

        return "redirect:/notice/notice";
    }
}
