package modelos.nullobjects;


import modelos.Usuario;

public class NullUser extends Usuario{
	public static Usuario build() {
		return new NullUser();
	}
	
	public NullUser() {
		super("", 0.0, 0.0, null, 0, false);
	}
	
	public boolean isNull() {
		return true;
	}
}
