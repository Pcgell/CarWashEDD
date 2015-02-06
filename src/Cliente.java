
public class Cliente extends Person {

	Cliente(int id, String nombre, String apeido) {
		super(id, nombre, apeido);
	}
	public String getNombreCompleto()
	{
		return this.getNombre() +" "+ this.getApeido();
	}
}
