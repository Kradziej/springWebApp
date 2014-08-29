package springWeb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagePostImpl implements ManagePostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createPost(Post post) {
		
		Session posting = sessionFactory.getCurrentSession();
		posting.save(post);
		posting.flush();
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPost(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTopic(String topic) {
		// TODO Auto-generated method stub
		
	}
	
	
	// GETTERS SETTERS

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
