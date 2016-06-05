package com.udemy.dropbookmarks.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.udemy.dropbookmarks.core.Bookmark;
import com.udemy.dropbookmarks.core.User;
import com.udemy.dropbookmarks.db.BookmarkDAO;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/bookmarks") //https://localhost:8443/bookmarks
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class BookmarksResource {
	
	private BookmarkDAO dao;
	
	public BookmarksResource(BookmarkDAO dao) {
		this.dao = dao;
	}
	
	@GET
	@UnitOfWork
	public List<Bookmark> getBookmarks(@Auth User user) {
		return dao.findForUser(user.getId());
	}
}
