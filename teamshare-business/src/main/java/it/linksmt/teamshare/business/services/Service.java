package it.linksmt.teamshare.business.services;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface Service<T, S>{

	public List<T> getAll();
	public T getById(Integer id);
	public T add(S requestDto);
	public T update(S requestDto);
	public void delete(Integer id);
	
}
