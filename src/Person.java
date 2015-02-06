
public class Person {
	private int id;
	private String nombre;
	private String apeido;

	Person(int id, String nombre, String apeido)
	{
		this.id = id;
		this.nombre = nombre;
		this.apeido = apeido;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getApeido()
	{
		return this.apeido;
	}
}
