package dao;

import java.util.ArrayList;

public interface Interface <T> {
	
public boolean Create (T object);
	
	public ArrayList<T> Read();
	
	public boolean Update(T object);
	
	public boolean Delete(T object); 
	
	public ArrayList<T> Findby (T object);

}
