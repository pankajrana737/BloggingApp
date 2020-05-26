package com.example.arv.bloggingapp.api.v1.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BlogPostDTO {

	private String _id;
	private String title;
	private String subtitle;
	private String content;
	private List<String> comments = new ArrayList<>();

	private LocalDateTime published;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}


	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "BlogPostDTO [_id=" + _id + ", title=" + title + ", content=" + content + ", subtitle=" + subtitle + "]";
	}

	public LocalDateTime getPublished() {
		return published;
	}

	public void setPublished(LocalDateTime published) {
		this.published = published;
	}

}
