import java.util.ArrayList;
import java.util.Scanner;


public class CarWash {
	private Scanner sc;
	ArrayList clientes;
	ArrayList cajeros;
	final float PRECIO_LAVADO = 100.0f;
	final float PRECIO_MOTOR = 150.0f;
	final float PRECIO_ASPIRADO = 200.0f;
	final float IMPUESTO_DE_VENTA = 1.15f;

	public void Init() {
		sc = new Scanner(System.in);
		clientes = new ArrayList();
		cajeros = new ArrayList();
	}

	public void Run() {
		int[] Opciones = new int[3];
		int OpcionContinuar;
		do{	
		CicloCompra(Opciones);
		Cliente C = CicloCliente();
		ImprimirFactura(Opciones,C.getNombre(),C.getApeido());
		System.out.println("\nDesea Continuar?  1.Otra Factura 2.Salir");
		OpcionContinuar = sc.nextInt();
		Opciones = new int[3];
		}while(OpcionContinuar == 1);	
	}

	public void Finish() {
		cajeros.clear();
		clientes.clear();
		sc.close();
	}
	
	private Cliente CicloCliente() {
		System.out.println("Ingrese el id del Cliente?");
		int id = sc.nextInt();
		Cliente C;
		String nombre;
		String apeido;
		int indice = -1;
		for(int i = 0; i< clientes.size(); i++)
		{
			if(((Cliente)clientes.get(i)).getId() == id)
			{
				indice = i;
			}
		}
		if(indice!=-1)
		{
			C = (Cliente)clientes.get(indice);
		}else
		{
			System.out.println("Cliente no existe.");
			
			System.out.println("Ingrese el Nombre?");
			nombre = sc.next();
			
			System.out.println("Ingrese el Apeido?");
			apeido = sc.next();
			
			C = new Cliente(id, nombre, apeido);
			clientes.add(C);
		}
		return C;
	}

	private void ImprimirFactura(int[] Opciones,String nombre, String apeido) {
		float totalizar = (Opciones[0] * PRECIO_LAVADO 
						 + Opciones[1] * PRECIO_MOTOR 
						 + Opciones[2] * PRECIO_ASPIRADO) 
						 * IMPUESTO_DE_VENTA;
		Object[] args = {nombre,apeido,new Float(totalizar) };
		System.out.println(String.format("Gracias %s %s por su Compra!! \n\n\nEl total a pagar es: L.%s", args));
	}

	private void CicloCompra(int[] Opciones) {
		int OpcionLavado;
		do{
			System.out.println("\t\t\t\tLavados to Go!!");
			System.out.println();
			System.out.println();
			System.out.println("Opciones :");
			
			System.out.println();
			System.out.println("1. lavado.\t\t\t L.100");
			
			System.out.println();
			System.out.println("2. lavado motor.\t\t L.150");
			
			System.out.println();
			System.out.println("3. aspirado.\t\t\t L.200");
			
			System.out.println();
			System.out.println("4. Totalizar.");
			
			OpcionLavado = sc.nextInt();
			
			if(1 == OpcionLavado)
			{
				Opciones[0]++;
			}
			if(2 == OpcionLavado)
			{
				Opciones[1]++;
			}
			if(3 == OpcionLavado)
			{
				Opciones[2]++;
			}
			
		}while(OpcionLavado != 4 );
	}


}
