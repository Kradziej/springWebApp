package springWeb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table (name="posts")
public class Post {
	
	
	@Id
	@GeneratedValue
	@Column(name="postID")
	private Integer postId;
	@Column(name="posterName")
	private String posterName;
	@Column(name="message")
	private String message;
	@Column(name="imageName")
	private String imageName;
	@Column(name="imageID")
	private String imageId;
	@Column(name="date")
	private Date date;
	
	Post(String posterName, String message, String imageName, String imageId) {
		
		this.posterName = posterName;
		this.message = message;
		this.imageName = imageName;
		this.imageId = imageId;
	}
	
	Post(String posterName, String imageName, String imageId) {
		
		this.posterName = posterName;
		this.imageName = imageName;
		this.imageId = imageId;
	}
	
	Post(String message) {
		
		this.message = message;
	}
	
	@PrePersist
	public void createTimestamp() {
		this.date = new Date();
	}
	
	
	
	// GETTERS SETTERS
	

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}


