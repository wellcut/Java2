package co.micol.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.member.service.MemberService;
import co.micol.notice.member.service.MemberVO;
import co.micol.notice.member.serviceImpl.MemberServiceImpl;

public class AjaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크(Ajax리턴)
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo = ms.memberSelect(vo);
		String str = "Ajax:";
		
		if(vo != null)
			str += "No"; 
		else
			str += "Yes";
		return str;
	}
}
