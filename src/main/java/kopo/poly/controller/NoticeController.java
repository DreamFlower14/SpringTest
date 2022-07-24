package kopo.poly.controller;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class NoticeController {

    @Resource(name = "NoticeService")
    private INoticeService noticeService; // 여기 궁금해요

    // jsp 로 이동하는 기초 실습
    /*
    @GetMapping(value = "Index")
    public String IndexPage() throws Exception{
        log.info(this.getClass().getName() + " .IndexPage Start (○｀ 3′○)!!");
        log.info(this.getClass().getName() + " .IndexPage End o(><；)oo!!");
        return "index";
    }*/

    // Form 에 저장한 내용 확인하기
    @RequestMapping(value = "getNoticeData")
    public String getNoticeData(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .getNoticeData Start (○｀ 3′○)!!");
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("작성자 : " + reg_id);
        log.info("제목 : " + title);
        log.info("글 : " + contents);

        model.addAttribute("reg_id",reg_id);
        model.addAttribute("title",title);
        model.addAttribute("contents",contents);

        log.info(this.getClass().getName() + " .getNoticeData End o(><；)oo!!");
        return "getNoticeData";
    }

    // Form.jsp 로  연결
    @GetMapping(value = "Form")
    public String Form() throws Exception{
        log.info(this.getClass().getName() + " .Form Start (○｀ 3′○)!!");
        log.info(this.getClass().getName() + " .Form End o(><；)oo!!");
        return "form";
    }

    // Form 에 입력한 값을 DB에 저장하기 
    @RequestMapping(value = "getInsertNotice")
    public String getInsertNotice(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .getInsertNotice Start (○｀ 3′○)!!");
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("작성자 : " + reg_id);
        log.info("제목 : " + title);
        log.info("글 : " + contents);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setReg_id(reg_id);
        pDTO.setTitle(title);
        pDTO.setContents(contents);

        int res = noticeService.InsertNoticeInfo(pDTO);
        String msg;
        String url = "getNoticeList";

        if (res > 0) {
            msg = "등록에 성공하셨습니다! O(∩_∩)O ";
        } else {
            msg = "등록에 실패하셨습니다 .·´¯`(>▂<)´¯`·.  ";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url",url);

        log.info(this.getClass().getName() + " .getInsertNotice End o(><；)oo!!");
        return "redirect";
    }
    
    // Form 에 저장한 내용들 확인하기
    @RequestMapping(value = "getNoticeList")
    public String getNoticeList(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .getNoticeList Start (○｀ 3′○)!!");

        List<NoticeDTO> rList = noticeService.getNoticeList();
        log.info(String.valueOf(rList.size())); // valueof 가 뭐였지

        if ( rList == null){
             rList = new ArrayList<>();
        }

        model.addAttribute("rList",rList);

        log.info(this.getClass().getName() + " .getNoticeList End o(><；)oo!!");
        return "noticeList";
    }
    
    // 게시판에 있는 내용 상세보기
    @RequestMapping(value = "NoticeDetail")
    public String NoticeDetail(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " NoticeDetail Start (○｀ 3′○)!!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no")); // "no" 라는 key 의 파라미터를 가지고 온다.

        NoticeDTO pDTO = new NoticeDTO(); // dto 인스턴스를 만들고 pDTO 라고 선언한다.
        pDTO.setNotice_seq(notice_seq); // pDTO 인스턴스 안에 Notice_seq 라는 곳에 아까 "no" 의 파라미터를 넣어둔다.

        NoticeDTO rDTO = noticeService.getNoticeDetail(pDTO); // 새로 rDTO 를 만드는데 이 안에는 noticeService 파일 안에 있는 getNoticeDetail 이라는 이름의 함수에 pDTO 를 넣은 값이다.
        if (rDTO == null){ // rDTO 에 있는 값이 null 값이면 값이 없다는 것이므로
            model.addAttribute("msg","없는 게시물이야..! (｡･∀･)ﾉﾞ"); // 없다는 메시지와 함께
            model.addAttribute("url","getNoticeList"); // 다시 게시판으로 돌아간다.
            return "redirect";
        }

        model.addAttribute("rDTO",rDTO);
        log.info(this.getClass().getName() + " NoticeDetail End o(><；)oo!!");
        return "noticeDetail";
    }
}
