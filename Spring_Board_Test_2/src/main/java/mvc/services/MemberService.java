package mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.MemberDAO;
import mvc.model.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	
	
	public Member getModel(Member member) {
		return dao.getModel(member);
	}
	
	public int join(Member member) {
		return dao.join(member);
	}
	
	public Member login(Member member) {
		if(member.getPw().equals(dao.login(member))) {
			return dao.getModel(member);
		} else {
			return null;
		}
	}
	
	public Member modify(Member member) {
		int re = dao.modify(member);
		if(re == 1) {
			return dao.getModel(member);
		} else {
			return null;
		}
	}
}
