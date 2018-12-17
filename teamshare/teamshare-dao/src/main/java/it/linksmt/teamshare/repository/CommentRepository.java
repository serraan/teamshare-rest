package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
