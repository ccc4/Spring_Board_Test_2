package mvc.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.BoardDAO;
import mvc.model.Board;
import mvc.model.Paging;

@Service
public class BoardService {
	
	private static final int ONE_PAGE = 5;
	private static final int ONE_SECTION = 5;
	
	@Autowired
	private BoardDAO dao;
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	

	
	public int write(Board board) {
		return dao.write(board);
	}
	
	public Board view(int idx) {
		dao.read_cnt_plus(idx);
		return dao.view(idx);
	}
	
	public int modify(Board board) {
		return dao.modify(board);
	}
	
	public int delete(int idx) {
		return dao.delete(idx);
	}
	
	public Paging list(int page) {
		
		int allCount = dao.allCount();
		int onePage = ONE_PAGE;
		int oneSection = ONE_SECTION;
		
		int totalPage = allCount / onePage + (allCount % onePage != 0 ? 1 : 0);
		
		if(page < 1 || page > totalPage) {
			return null;
		}
		
		int startPage = (page - 1) / oneSection * oneSection;
		if(startPage % oneSection == 0) startPage += 1;
		
		int endPage = startPage + oneSection - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		Map<String, Integer> map = new HashMap<>();
		map.put("p1", (page - 1) * onePage);
		map.put("p2", onePage);
		
		return new Paging(dao.list(map), page, totalPage, startPage, endPage);
	}
}
