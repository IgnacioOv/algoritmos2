package metodos;

import java.util.Random;

import apis.ColaPrioridadTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import apis.DiccionarioSimpleTDA;
import apis.PilaTDA;
import impl.ColaPU;
import impl.ColaPrioridadDA;
import impl.ConjuntoTA;
import impl.PilaTF;
import impl.PilaTI;

public class Ejercicios {
	public static void pasar(PilaTDA p1, PilaTDA p2) {
		while(!p1.pilaVacia()) {
			p2.apilar(p1.tope());
			p1.desapilar();
		}
		
	}
	public static void pasar(ColaTDA c1, ColaTDA c2) {
		while(!c1.colaVacia()) {
			c2.acolar(c1.primero());
			c1.desacolar();
		}		
	}
	
	public static void pasar(PilaTDA p1, ColaTDA c2) {
		while(!p1.pilaVacia()) {
			int x=p1.tope();
			c2.acolar(x);
			p1.desapilar();
		}
		
	}
	public static void pasar(ColaPrioridadTDA cola, ColaPrioridadTDA c) {
		while (!cola.colaVacia()) {
			c.acolarPrioridad(cola.primero(), cola.prioridad());				
			cola.desacolar();
		}
	}
	//--------------------------------------------------------CONJUNTOS--------------------------------------------------------------
	public static void pasar(ConjuntoTDA o, ConjuntoTDA d) {
		while (!o.conjuntoVacio()) {
			int e=o.elegir();
			d.agregar(e);
			o.sacar(e);
		}
	}
	public static void copiar(PilaTDA p1, PilaTDA p2) {	
			PilaTDA aux = new PilaTI();
			aux.inicializarPila();
			pasar(p1, aux);
		while(!aux.pilaVacia()) {
			p2.apilar(aux.tope());p1.apilar(aux.tope());
			aux.desapilar();
		}
		
	}
	
	public static void copiar(ColaTDA origen, ColaTDA destino) {
		ColaTDA aux = new ColaPU();
		aux.inicializarCola();
		pasar(origen,aux);
		while(!aux.colaVacia()) {
			origen.acolar(aux.primero());
			destino.acolar(aux.primero());
			aux.desacolar();
		}
	}
	public static void copiar(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
		ColaPrioridadTDA aux = new ColaPrioridadDA();
		aux.inicializarCola();
		pasar(c1, aux);
		while(!aux.colaVacia()) {
			c1.acolarPrioridad(aux.primero(), aux.prioridad());
			c2.acolarPrioridad(aux.primero(), aux.prioridad());
			aux.desacolar();
		}
		
	}
	
	public static void copiar(ConjuntoTDA o, ConjuntoTDA d) {
		ConjuntoTDA aux= new ConjuntoTA();
		aux.inicializarConjunto();
		while(!o.conjuntoVacio()) {
			int e=o.elegir();
			aux.agregar(e);
			d.agregar(e);
			o.sacar(e);
		}
		pasar(aux,o);
	}
	
	
	/* 
	 * Ejercicio TP 3. 3 g
	 * Determinar si los elementos de una Pila P son los mismos que 
	 * los de una Cola C. No interesa el orden ni si est�n repetidos o no.
	 */
	
	public static boolean mismosElementos(PilaTDA p, ColaTDA c) {
		PilaTDA paux=new PilaTF();
		paux.inicializarPila();
		ColaTDA caux=new ColaPU();
		caux.inicializarCola();
		copiar(p,paux);
		copiar(c,caux);
		ConjuntoTDA cc =new ConjuntoTA();cc.inicializarConjunto();
		ConjuntoTDA cp =new ConjuntoTA();cp.inicializarConjunto();
		
		while(!paux.pilaVacia()) {
			cp.agregar(paux.tope());
			paux.desapilar();	
		}
		
		while(!caux.colaVacia()) {
			cc.agregar(caux.primero());
			caux.desacolar();	
		}
		return sonIguales(cp,cc); 
	}
	
	
	
	// Ejercicios TP1.2.e
	public static float sumar(PilaTDA p1) {
		PilaTDA aux=new PilaTF();
		aux.inicializarPila();
		copiar(p1,aux);
		int sum=0; 
		while(!aux.pilaVacia()) {
			sum+=aux.tope();
			aux.desapilar();	
		}
		return sum; 
	}
	// Ejercicios TP1.2.f
	public static float promedio(PilaTDA p1) {
		PilaTDA aux=new PilaTF();
		aux.inicializarPila();
		copiar(p1,aux);
		float sum=0; // Lo declaro float para que al dividir tome el tipo float
		int cont=0;
		while(!aux.pilaVacia()) {
			cont++;
			sum+=aux.tope();
			aux.desapilar();	
		}
		return sum/cont; // Como sum es float y cont es int, el cociente queda float
	}
	// Ejercicios TP1.4.e
	public static boolean esCapicua(ColaTDA c) {
		PilaTDA p=new PilaTF();
		p.inicializarPila();
		ColaTDA caux=new ColaPU();
		caux.inicializarCola();		
		int cont=0;
		while(!c.colaVacia()) {
			p.apilar(c.primero());caux.acolar(c.primero());
			c.desacolar();cont++;
		}
		copiar(caux,c);
		int mitad=cont/2;	
		while(!caux.colaVacia() &&  mitad > 0 && caux.primero()==p.tope() ) {
			caux.desacolar();p.desapilar();	
			mitad--;		
		}
		return cont > 0 && mitad==0  ;
		
	}
	
	
	// Ejercicios TP3.1.b	
	public void eliminarRepetidos(PilaTF pila) {
		PilaTF aux = new PilaTF();
		aux.inicializarPila();
		pasar(pila,aux);
		ConjuntoTDA c=new ConjuntoTA();
		c.inicializarConjunto();
    	while(!aux.pilaVacia()){
    		if ( !c.pertenece(aux.tope()) ){
    			 c.agregar(aux.tope()); 
    			 pila.apilar(aux.tope());  			 
    		}
  			aux.desapilar();
    	}			
	}
	// Ejercicios TP1.2.c
	public static void invertir(PilaTDA p) {
		ColaTDA c=new ColaPU();
		c.inicializarCola();
		// Paso de la pila a la cola
        while (!p.pilaVacia()) {
            int tope = p.tope();
            c.acolar(tope);
            p.desapilar();
        }
        // Paso de la cola a la pila (se invierte) 
        while (!c.colaVacia()) {
            int primero = c.primero();
            p.apilar(primero);
            c.desacolar();
        }
    }
	
	
	// Ejercicios TP1.4.c
	public static void invertirCola(ColaTDA c) {
		ColaTDA a=new ColaPU();a.inicializarCola();
		ColaTDA b=new ColaPU();b.inicializarCola();
		// Paso de la cola a la cola b
		int N=0;
        while (!c.colaVacia()) {
            int primero = c.primero();
            c.desacolar();
            a.acolar(primero);
            N++;
        }
       
        while (N>1) {
        	for(int i=1;i<N;i++) {// Pasa a b todo menos el �ltmo elemento
        		b.acolar(a.primero());
        		a.desacolar();       		
        	}
        	c.acolar(a.primero()); // Pasa a c el �ltimo.
        	a.desacolar();
        	N--;
        	ColaTDA aux=a; 
        	a=b;b=aux;// Intercambio a con b.
        }
        c.acolar(a.primero());
    }
	
	// Ejercicios TP1.4.c con Recursividad
	public static void invertirColaRecursivo(ColaTDA c) {
        if (!c.colaVacia()) {
            int primero = c.primero();
            c.desacolar();
            invertirColaRecursivo(c);
            c.acolar(primero);
        }
    }
	// Ejercicios TP1.4.b
	public static void invertirColaConPila(ColaTDA c) {
		PilaTDA p=new PilaTF();
		p.inicializarPila();
		// Paso de la cola a la Pila p (se invierte)
        while (!c.colaVacia()) {
            int primero = c.primero();
            c.desacolar();
            p.apilar(primero);
        }
        // Paso de la pila p a la cola 
        while (!p.pilaVacia()) {
            int tope = p.tope();
            c.acolar(tope);
            p.desapilar();
        }
    }
	
	
	
	public static ConjuntoTDA diferencia(ConjuntoTDA a, ConjuntoTDA b) {
		ConjuntoTA aux1= new ConjuntoTA();
		aux1.inicializarConjunto();
		copiar(a,aux1);
		ConjuntoTA aux2= new ConjuntoTA();
		aux2.inicializarConjunto();
		copiar(a,aux2);
		
		while(!aux1.conjuntoVacio()) {
			int e=aux1.elegir();
			if (b.pertenece(e)) 
				aux2.sacar(e);
			
			aux1.sacar(e);
		}
		return aux2;
	}
		
	public static ConjuntoTDA union(ConjuntoTDA a, ConjuntoTDA b) {
		ConjuntoTDA aux= new ConjuntoTA();
		aux.inicializarConjunto();
		copiar(a,aux);
		copiar(b,aux);
		return aux;
		
	}
	public static ConjuntoTDA interseccion(ConjuntoTDA a, ConjuntoTDA b) {
		ConjuntoTA aux1= new ConjuntoTA();
		aux1.inicializarConjunto();
		ConjuntoTA aux2= new ConjuntoTA();
		aux2.inicializarConjunto();
		while (!a.conjuntoVacio()) {
			int e=a.elegir();
			if (b.pertenece(e)) {
				aux1.agregar(e);
			}
			aux2.agregar(e);
			a.sacar(e);
		}
		pasar(aux2,a);
		return aux1;
	}
	// Ejercicios TP3 3.1.1
	public static ConjuntoTDA diferenciaSimetricaSinOperaciones(ConjuntoTDA a, ConjuntoTDA b) {
		ConjuntoTA aux1= new ConjuntoTA();
		aux1.inicializarConjunto();
		ConjuntoTA aux2= new ConjuntoTA();
		aux2.inicializarConjunto();
		ConjuntoTA aux3= new ConjuntoTA();
		aux3.inicializarConjunto();
		copiar(a,aux1);
		copiar(b,aux3);
		while(!aux1.conjuntoVacio()) {
			int e=aux1.elegir();
			if (b.pertenece(e)) 
			    aux3.sacar(e);
			else
				aux2.agregar(e);
			aux1.sacar(e);
		}		
		return union(aux2,aux3);
	}
	
	public static ConjuntoTDA diferenciaSimetricaUnionDiferencia(ConjuntoTDA a, ConjuntoTDA b) {	
		return union(diferencia(a,b), diferencia(b,a));
	}
	
	// Ejercicios TP3 3.1.2
	public static ConjuntoTDA diferenciaSimetricaUnionInterseccionDiferencia(ConjuntoTDA a, ConjuntoTDA b) {	
		return diferencia(union(a,b), interseccion(a,b));
	}
	
	// Ejercicios TP1 3.2
	public static boolean sonIguales(ConjuntoTDA a, ConjuntoTDA b) {
		// Todos los elementos de a tienen que estar en b y todos los de b en a
		ConjuntoTA aux1= new ConjuntoTA();
		aux1.inicializarConjunto();
		copiar(a,aux1);
		boolean iguales=true;
		// Verifico que todos los de a est�n en b
		while (!aux1.conjuntoVacio() && iguales) {
			int e=aux1.elegir();
			if (!b.pertenece(e))
				iguales=false;				
			aux1.sacar(e);
		}
		if (iguales) {
			// Verifico que todos los de b est�n en a
			copiar(b,aux1);
			while (!aux1.conjuntoVacio() && iguales) {
				int e=aux1.elegir();
				if (!a.pertenece(e))
					iguales=false;				
				aux1.sacar(e);
			}
		}		
		return iguales;
	}
	public static void llenar(PilaTDA pila, int n) {
		pila.inicializarPila();
		for (int x = 0; x < n; x++) {
			pila.apilar(x);
			pila.apilar(x);
		}
	}
	
	public static void llenar(ColaTDA cola, int n) {
		cola.inicializarCola();
		
		for (int x = 0; x < n; x++) {
			cola.acolar(x);
		}
	}
	
	public static void llenar(ColaPrioridadTDA cola, int n) {
		Random rnd = new Random();
		cola.inicializarCola();
		
		for (int x = 0; x < n; x++) {
			int rndNumber = rnd.nextInt(n);
			cola.acolarPrioridad(x, rndNumber);
		}
	}
	
	public static void llenar(DiccionarioMultipleTDA dm, int n) {
		Random rnd = new Random();
		dm.inicializarDiccionario();
		
		for (int clave = 0; clave < n; clave++) {
			for(int c=0; c < n;c++) {
				int valor = rnd.nextInt(n);
				dm.agregar(clave, valor);
			}
		}
	}
	
	public static void llenar(DiccionarioSimpleTDA d, int n) {
		Random rnd = new Random();
		d.inicializarDiccionario();
		
		for (int clave = 0; clave < n; clave++) {
			int valor = rnd.nextInt(n);
			d.agregar(clave, valor);
		}
	}
	
	
	public static void llenar(ConjuntoTDA conjunto, int n) {
		Random rnd = new Random();		
		for (int i = 0; i < n; i++) {
			int x = rnd.nextInt(n);
			conjunto.agregar(x);
		}
	}
	
	public static void mostrar(ColaPrioridadTDA cola) {
		if (cola.colaVacia()) {
			System.out.println("La cola se encuentra vacia, imposible mostrarla.");
			return;
		}
		
		ColaPrioridadTDA aux = new ColaPrioridadDA();
		aux.inicializarCola();		
		copiar(cola, aux);
		System.out.print("Cola:");
		while (!aux.colaVacia()) {
			System.out.print(" Valor: " + aux.primero() + " Prioridad: " + aux.prioridad());
			aux.desacolar();
		}
		System.out.println();
	}
	
	public static void mostrar(ColaTDA cola) {
		if (cola.colaVacia()) {
			System.out.println("La cola se encuentra vacia, imposible mostrarla.");
			return;
		}
		System.out.print("Cola:");
		ColaTDA aux = new ColaPU();
		aux.inicializarCola();		
		copiar(cola, aux);
		
		while (!aux.colaVacia()) {
			System.out.print(" " + aux.primero());
			aux.desacolar();
		}
		System.out.println();
	}
	
	public static void mostrar(PilaTDA pila) {
		if (pila.pilaVacia()) {
			System.out.println("La pila se encuentra vacia, imposible mostrarla.");
			return;
		}
		System.out.print("Pila:");
		PilaTDA aux = new PilaTI();
		aux.inicializarPila();		
		copiar(pila, aux);
		
		while (!aux.pilaVacia()) {
			System.out.print(" " + aux.tope());
			aux.desapilar();
		}
		System.out.println();
	}
	
	public static void mostrar(PilaTDA pila, String leyenda) {
		if (pila.pilaVacia()) {
			System.out.println("La pila se encuentra vacia, imposible mostrarla.");
			return;
		}
		System.out.print(leyenda +":");
		PilaTDA aux = new PilaTI();
		aux.inicializarPila();		
		copiar(pila, aux);
		
		while (!aux.pilaVacia()) {
			System.out.print(" " + aux.tope());
			aux.desapilar();
		}
		System.out.println();
	}
	public static void mostrar(ConjuntoTDA a) {
		ConjuntoTA aux1= new ConjuntoTA();
		aux1.inicializarConjunto();
		copiar(a,aux1);
		System.out.print("Conjunto :");
		while (!aux1.conjuntoVacio()) {
			int e=aux1.elegir();
			System.out.print(e+" ");
			aux1.sacar(e);
		}
		System.out.println();
	}
	
	public static void mostrar(DiccionarioMultipleTDA dict, String leyenda) {
		System.out.println("Diccionario:" +leyenda );
		/* En los diccionarios, la llave de acceso son las claves
		 * por eso, lo primero que hacemos es leer las claves
		 * y a trav�s de las claves accedemos a los valores
		 */
		
		ConjuntoTDA claves= dict.claves();
		while(!claves.conjuntoVacio()){
			System.out.print("Clave: ");
			int clave=claves.elegir();
			System.out.print(clave);
			System.out.print("; Valores: ");			
			ConjuntoTDA valores = dict.recuperar(clave);
			// Por cada clave, recupero su conjunto de valores
			while(!valores.conjuntoVacio()) {
				int elegido=valores.elegir();
				System.out.print(elegido + ",");
				valores.sacar(elegido);
			}
			System.out.println();
			claves.sacar(clave);
		}		
	}
	public static void mostrar(DiccionarioSimpleTDA d, String leyenda) {
		System.out.println("Diccionario:" +leyenda );
		/* En los diccionarios, la llave de acceso son las claves
		 * por eso, lo primero que hacemos es leer las claves
		 * y a trav�s de las claves accedemos a los valores
		 */
		ConjuntoTDA claves= d.claves();
		while(!claves.conjuntoVacio()){
			System.out.print("Clave: ");
			int clave=claves.elegir();
			System.out.print(clave);
			System.out.println("; Valor: "+d.recuperar(clave));			
			claves.sacar(clave);
		}		
	}
	
	
	
	
}
