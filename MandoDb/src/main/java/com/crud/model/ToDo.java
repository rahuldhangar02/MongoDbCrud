package com.crud.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "ToDo")
public class ToDo {

	    @Id
	    private int id;
	    private String todo;
	    private String description;
	    private Boolean status;
	    private Date createdDate;
	    private Date updateDate;
	    
		public ToDo() {
			super();
			
		}

		public ToDo(int id, String todo, String description, Boolean status, Date createdDate, Date updateDate) {
			super();
			this.id = id;
			this.todo = todo;
			this.description = description;
			this.status = status;
			this.createdDate = createdDate;
			this.updateDate = updateDate;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTodo() {
			return todo;
		}

		public void setTodo(String todo) {
			this.todo = todo;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		@Override
		public String toString() {
			return "ToDo [id=" + id + ", todo=" + todo + ", description=" + description + ", status=" + status
					+ ", createdDate=" + createdDate + ", updateDate=" + updateDate + "]";
		}
	    
	    
	    
	
	
}
