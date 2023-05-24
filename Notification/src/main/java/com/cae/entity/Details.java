package com.cae.entity;

import java.util.Map;

public class Details {

	private String subject;
	private String attachment;
	private Map<String, Object> attributes_;

	public Map<String, Object> getAttributes_() {
		return attributes_;
	}

	public void setAttributes_(Map<String, Object> attributes_) {
		this.attributes_ = attributes_;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}