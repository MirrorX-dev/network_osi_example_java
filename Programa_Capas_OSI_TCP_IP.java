package ejercicio_clase;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;


public class Programa_Capas_OSI_TCP_IP {
	public static int opcion;
	public static Scanner sc = new Scanner(System.in);
	
	public static void Programa_Capas_OSI_TCP_IP_Programa() throws IOException {
		
		//Men�:
		do {
			System.out.println("\n*-*-*-* MEN�  *-*-*-*\n"+
								"[7] | Aplicaci�n\n"+
								"[6] | Presentaci�n\n"+
								"[5] | Sesi�n\n"+
								"[4] | Transporte\n"+
								"[3] | Red\n"+
								"[2] | Enlace\n"+
								"[1] | F�sica\n"+
								"[0] | Salir\n");
			opcion = sc.nextInt();
			
			if (opcion==7) {
				System.out.println("*-*-* Aplicaci�n *-*-*\n");
				Aplicacion();
				
			} else if (opcion==6) {
				System.out.println("*-*-* Presentaci�n *-*-*\n");
				Presentacion();
				
			} else if (opcion==5) {
				System.out.println("*-*-* Sesi�n *-*-*\n");
				Sesi�n();
				
			} else if (opcion==4) {
				System.out.println("*-*-* Transporte *-*-*\n");
				Transporte();
				
			} else if (opcion==3) {
				System.out.println("*-*-* Red *-*-*\n");
				Red();
				
			} else if (opcion==2) {
				System.out.println("*-*-* Enlace *-*-*\n");
				Enlace();
				
			} else if (opcion==1) {
				System.out.println("*-*-* F�sica *-*-*\n");
				F�sica();
				
			} else if (opcion==0) {
				System.out.println("*-*-* Salir *-*-*");
				Salir();
			}
		} while (!(opcion==0));
	}
	
	// Funciones de las opciones del Men�:
	// 7.
	public static void Aplicacion()
	{	System.out.print("Introduzca nombre de la Aplicaci�n: ");
		String nombre_app;
		nombre_app = sc.next();
		
		// N� Puerto Aleatorio:
		int min=1024,max=49151;
		int puertoAlea = (int) (min+(Math.random()*(max-min+1)));
		System.out.println("Nombre Aplicaci�n: "+nombre_app+" | Su N� de puerto es: "+puertoAlea);
		
	}
	
	// 6.
	public static void Presentacion()
	{	System.out.print("Introduzca N� Entero positivo: ");
		int num_presentacion;
		num_presentacion = sc.nextInt();
		
		int resto, division = num_presentacion;
		char digitos[] = {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F'};
		
		String hexadecimal = "";
		while (division>0) {
			resto=division % 16;
			hexadecimal=digitos[resto]+hexadecimal;
			division /= 16; //numero / 16, 1 cifra. 
		}
		System.out.println("N� Decimal: "+num_presentacion+" |  C�digo traducido a Hexadecimal es: "+hexadecimal);
	}
	
	// 5.
	public static void Sesi�n()
	{	String usuario;
		String password;
		String auxUsuario;
		String auxPassword;
		
		System.out.println(" //CREACI�N DE DIALOGO.// ");
		System.out.print("Introduzca Usuario: ");
		usuario = sc.next();
		
		System.out.print("Introduzca Password: ");
		password = sc.next();
		
		do {
			System.out.println(" \n//PROCESO DE DIALOGO CONFIRMACI�N.// ");
			System.out.print("Introduzca Usuario: ");
			auxUsuario = sc.next();
			
			System.out.print("Introduzca Password: ");
			auxPassword = sc.next();
			
			if (auxUsuario.equals(usuario)) {
			} else {
				System.out.println("No se produjo dialogo. ");
			}
			
			if (auxPassword.equals(password)) {	
			} else {
				System.out.println("No se produjo dialogo. ");
			}
		} while (!(auxUsuario.equals(usuario)&&(auxPassword.equals(password)) ));
		System.out.println("Dialogo realizado Correctamente.");
	}
	
	// 4.
	public static void Transporte()
	{	int min=999,max=39000;
		int numPuertoOrigenAlea = (int) (min+(Math.random()*(max-min+1)));
		int numPuertoDestinoAlea = (int) (min+(Math.random()*(max-min+1)));
		
		System.out.print("Introduzca palabra: ");
		String palabra = sc.next();
		char aux=0;
		for (byte c=0; c<palabra.length(); c++) {
			palabra.charAt(aux);
			System.out.println("Puerto Origen: "+numPuertoOrigenAlea+" - Puerto Destino:"+numPuertoDestinoAlea+" - "+palabra.charAt(aux));
			aux++;
		}
	}
	
	// 3.
	public static void Red() throws IOException
	{	String localIpAddress = InetAddress.getLocalHost().getHostAddress();
		String ipDestino = "192.168.20.3";
		System.out.print("Introduzca palabra: ");
		String palabra = null;
		
		palabra = sc.next();
		System.out.println(localIpAddress+" | "+ipDestino+" | "+palabra);
	}
	
	// 2.
	public static void Enlace() throws IOException
	{	// Obtener Mac a partir de servicio. Mediante Ejecucci�n de c�digo:
		// https://stackoverflow.com/questions/6164167/get-mac-address-on-local-machine-with-java
		// Autor: Olantobi.
		Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
	    java.io.BufferedReader in = new java.io.BufferedReader(new  java.io.InputStreamReader(p.getInputStream()));
	    String line;
	    line = in.readLine();        
	    String[] result = line.split(",");
        
	    
	    // Continuaci�n del ejercicio: 
		String mac_destino = "93-E3-BD-F1-71-DD";
		String palabra = null;
		System.out.print("Introduzca palabra: ");
		palabra = sc.next();
		System.out.println(result[0].replace('"', ' ').trim()+" | "+mac_destino+" | "+palabra);
	}
	
	// 1.
	public static void F�sica() throws IOException
	{	System.out.print("Introduzca N� Entero positivo: ");
		int numero = sc.nextInt();

		String binario = "";
		if (numero==0 || numero==1) {
			if (numero==0) binario="0";
			if (numero==1) binario="1";
		} else {
			int resto=numero%2;
			int division=numero/2;
			binario=Integer.toString(resto);
			
			while (division>1) {
				resto=division%2;
				division=division/2;
				binario=Integer.toString(resto)+binario;
			}
			binario=Integer.toString(division)+binario;
		}
		System.out.println("La codificaci�n a binario es: "+binario);
	}
	
	// 0.
	public static void Salir()
	{	System.out.print("Gracias por usar el Programa. Hasta pronto! ^_^");
	}
	
	
	public static void main(String[] args) throws IOException {
		Programa_Capas_OSI_TCP_IP_Programa();
	}

}
