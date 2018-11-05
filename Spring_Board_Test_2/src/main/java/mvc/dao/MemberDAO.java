package mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.model.Member;

@Repository
public class MemberDAO {
	
	private String strNameSpace = "mvc.model.MemberMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public Member getModel(Member member) {
		return sqlSession.selectOne(strNameSpace + ".getModel", member);
	}
	
	public int join(Member member) {
		return sqlSession.insert(strNameSpace + ".join", member);
	}
	
	public String login(Member member) {
		return sqlSession.selectOne(strNameSpace + ".login", member);
	}
	
	public int modify(Member member) {
		return sqlSession.update(strNameSpace + ".modify", member);
	}
}
