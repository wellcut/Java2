package co.micol.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.service.Impl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeWdate(Date.valueOf(request.getParameter("noticeWdate")));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		
		ns.noticeInsert(vo);
//		if(n != 0 ) {
//			request.setAttribute("message", "게시글 작성 성공");
//		}else {
//			request.setAttribute("message", "게시글 작성 실패");
//		}
		return "noticeList.do";
	}

}
