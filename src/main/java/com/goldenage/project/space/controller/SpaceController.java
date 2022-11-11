package com.goldenage.project.space.controller;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.space.model.dto.SpaceDTO;
import com.goldenage.project.space.model.dto.SpacePhoDTO;
import com.goldenage.project.space.model.service.SpaceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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

    //관리자 연습실 추가하기
    @PostMapping("/spaceInsert")
    public String insertSpace(@ModelAttribute SpaceDTO space
            , @RequestParam(value="multiFiles", required = false) List<MultipartFile> multiFiles
            , RedirectAttributes rttr) throws Exception {

        SpacePhoDTO spacePho = new SpacePhoDTO();

        int result = spaceService.insertSpace(space);

        if(result> 0){

            space.setSpaceNum(spaceService.selectNum());

            log.info("num 을 알려줘 " + space.getSpaceNum());
        }

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/images/space";

        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        log.info("뭔데" + multiFiles.get(0).getOriginalFilename());
        log.info("dmd?" + multiFiles.size());
        if(multiFiles.size() > 0){
            Map<String,String> files = new HashMap<>();
            for(int i = 0; i < multiFiles.size(); i++) {

                String spaceOriName = "";
                String ext = "";
                String spaceFileName = "";
                int spaceNum = 0;

                spaceOriName = multiFiles.get(i).getOriginalFilename();
                ext = spaceOriName.substring(spaceOriName.lastIndexOf("."));
                spaceFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                spaceNum = space.getSpaceNum();

                files.put("spaceOriName", spaceOriName);
                files.put("spaceFileName", spaceFileName);
                files.put("spaceNum", String.valueOf(spaceNum));

                spaceService.insertSpacePho(files);
            }

                try {

                    for (int j = 0; j < multiFiles.size(); j++) {

                        Map<String, String> pho = files;
                        multiFiles.get(j).transferTo(new File(filePath + "/" + pho.get("spaceFileName")));
                    }
                } catch (IOException e) {

                    for (int j = 0; j < multiFiles.size(); j++) {

                        Map<String, String> pho = files;
                        new File(filePath + "/" + pho.get("spaceFileName")).delete();
                    }
                }
        }else if(multiFiles.size() == 0){
            Map<String,String> files = new HashMap<>();

            String spaceOriName = "";
            String spaceFileName = "";
            int spaceNum = 0;

            spaceNum = space.getSpaceNum();

            files.put("spaceOriName", spaceOriName);
            files.put("spaceFileName", spaceFileName);
            files.put("spaceNum", String.valueOf(spaceNum));

            spaceService.insertSpacePho(files);

        }
        rttr.addFlashAttribute("message", "연습실 등록 성공!");

        return "redirect:/space/spaceList";

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
    public ModelAndView theaher(ModelAndView mv,HttpServletRequest request){

//        int num = Integer.parseInt(request.getParameter("spaceNum"));
//        log.info("num : " + num);

        int spaceNum = 138;

        List<SpaceDTO> spaceList = spaceService.selectSpaceListView();
        List<SpacePhoDTO> phoList = spaceService.selectPho(spaceNum);

        mv.addObject("spaceList", spaceList);
        mv.addObject("spacePhoList", phoList);
        mv.setViewName("space/theater");

        return mv;
    }
}

