package br.com.fiap.netgifx.interfaces;

import java.util.List;

public interface HelperInterface<T> {

	public boolean save(T reg);
	public boolean delete(T reg);
	public T find(int id);
	public T find(String jpql, Object... params);
	public List<T> list();
	public List<T> list(String jpql, Object... params);
	boolean update(T reg);
}
