package springWeb;

public interface ManagePostDAO {
	
	void createPost(Post post);
	void deletePost(Integer postId);
	void editPost(String msg);
	void changeTopic(String topic);
}
