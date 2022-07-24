package kopo.poly.service.impl;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("NoticeService")
public class NoticeService implements INoticeService { // 이게 뭔데...?

    private final INoticeMapper noticeMapper;

    @Autowired
    public NoticeService(INoticeMapper noticeMapper) {this.noticeMapper = noticeMapper; }  // 궁금해요!!

    @Override
    public int InsertNoticeInfo(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + " InsertNoticeInfo Start (○｀ 3′○)!!");
        int res = noticeMapper.InsertNoticeInfo(pDTO); // = 뒤에가 값을 저장하는 로직인가요...?
        log.info(this.getClass().getName() + " InsertNoticeInfo End o(><；)oo!!");
        return res;
    }

    @Override
    public List<NoticeDTO> getNoticeList() throws Exception {
        log.info(this.getClass().getName() + " getNoticeList Start (○｀ 3′○)!!");
        List<NoticeDTO> rList = noticeMapper.getNoticeList();
        log.info(this.getClass().getName() + " getNoticeList End o(><；)oo!!");
        return rList;
    }

    @Override
    public NoticeDTO getNoticeDetail(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + " getNoticeDetail Start (○｀ 3′○)!!");
        NoticeDTO rDTO = noticeMapper.getNoticeDetail(pDTO);
        log.info(this.getClass().getName() + " getNoticeDetail End o(><；)oo!!");
        return rDTO;
    }
}
