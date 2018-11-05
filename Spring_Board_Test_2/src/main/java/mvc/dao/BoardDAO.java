package mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.model.Board;
import mvc.model.Member;

@Repository
public class BoardDAO {
	
	private String strNameSpace = "mvc.model.BoardMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int allCount() {
		return sqlSession.selectOne(strNameSpace + ".allCount");
	}
	
	public List<Board> list(Map<String, Integer> map) {
		return sqlSession.selectList(strNameSpace + ".list", map);
	}
	
	public int write(Board board) {
		return sqlSession.insert(strNameSpace + ".write", board);
	}
	
	public int read_cnt_plus(int idx) {
		return sqlSession.update(strNameSpace + ".read_cnt_plus", idx);
	}
	
	public Board view(int idx) {
		return sqlSession.selectOne(strNameSpace + ".view", idx);
	}
	
	public int modify(Board board) {
		return sqlSession.update(strNameSpace + ".modify", board);
	}
	
	public int delete(int idx) {
		return sqlSession.delete(strNameSpace + ".delete", idx);
	}
}
