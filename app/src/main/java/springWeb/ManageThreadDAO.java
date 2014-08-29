package springWeb;

public interface ManageThreadDAO {
	
	void createThread(Post post);
	void deleteThread(Integer threadId);
	void changeTopic(String topic);
}
