package service.users.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.users.face.UsersDao;
import dao.users.impl.UsersDaoImpl;
import dto.users.Users;
import service.users.face.UsersService;

public class UsersServiceImpl implements UsersService {
	
	private UsersDao uDao = new UsersDaoImpl();
	
	@Override
	public Users getParam(HttpServletRequest req, HttpServletResponse resp) {
		String u_id = req.getParameter("u_id");
		String u_pw = req.getParameter("u_pw");
		
		Users u = new Users();
		u.setU_id(u_id);
		u.setU_pw(u_pw);
		
		return u;
	}

	@Override
	public boolean login(Users user) {

		return uDao.login(user);
	}

	@Override
	public Users getUserByUid(Users user) {
		
		return uDao.selectUserByUid(user);
	}


}
