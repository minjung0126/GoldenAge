package com.goldenage.project.space.controller;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.space.model.dto.SpaceDTO;
import com.goldenage.project.space.model.service.SpaceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/space/*")
public class SpaceController {

    private final SpaceServiceImpl spaceService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SpaceController(SpaceServiceImpl spaceService) {
        this.spaceService = spaceService;
    }

    // 관리자 연습실 리스트 출력
    @GetMapping("/spaceList")
    public ModelAndView spaceList(ModelAndView mv, HttpServletRequest request){

        List<SpaceDTO> spaceList = spaceService.selectSpaceList();

        log.info("뭘까정말" + spaceList);

        mv.addObject("spaceList", spaceList);
        mv.setViewName("space/spaceList");

        return mv;

    }

    // 관리자 연습실 추가 화면보기
    @GetMapping("/spaceInsert")
    public String spaceInsertView(){

        return "space/spaceInsert";
    }

    //연습실 삭제
    @GetMapping("/delete")
    public String spaceDelete(HttpServletRequest request, RedirectAttributes rttr) throws SpaceDeleteException {

        int spaceNum = Integer.parseInt(request.getParameter("spaceNum"));

        int result = spaceService.deleteSpace(spaceNum);

        rttr.addFlashAttribute("message", "연습실 삭제 성공!");

        return "redirect:/space/spaceList";
    }

    @GetMapping("/theater")
    public String theaher(){

        return "space/theater";
    }
}
