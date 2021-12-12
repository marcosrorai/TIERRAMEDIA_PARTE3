package persistencia.comunes;

import java.util.List;


public interface GenericDAO<T> {
	public List<T> getAll();
	public void update(T t);
	public T find(Integer id);
	public int insert(T t);
	public int delete(T t);


}
