import apis.*;
import impl.*;

import static metodos.Ejercicios.*;

public class Main {
    public static void main(String[] args) {
        //ejerciciosPilas();
        //ejerciciosColas();
        //ejerciciosColaPrioridad();
        //practicaParcial2();
        //practicaParcial3();
        practicaParcial4();
    }

    public static void pasar(PilaTDA p1, PilaTDA p2) {
        while(!p1.pilaVacia()) {
            int tope = p1.tope();
            p2.apilar(tope);
            p1.desapilar();
        }
    }

    public static void copiar(PilaTDA p1, PilaTDA p2) {
        PilaTDA aux = new PilaLD();
        aux.inicializarPila();
        pasar(p1, aux);
        pasar(aux,p2);
    }

    public static int contarElementosPila(PilaTDA p1){
        PilaTDA aux = new PilaLD();
        aux.inicializarPila();
        int elementos = 0;

        while(!p1.pilaVacia()) {
            int tope = p1.tope();
            aux.apilar(tope);
            p1.desapilar();
            elementos++;
        }
        pasar(aux,p1);
        return elementos;
    }

    public static int sumarElementosPila(PilaTDA p1){
        PilaTDA aux = new PilaLD();
        aux.inicializarPila();
        int suma = 0;
        while(!p1.pilaVacia()) {
            int tope = p1.tope();
            aux.apilar(tope);
            p1.desapilar();
            suma += tope;
        }
        pasar(aux,p1);
        return suma;
    }

    public static int calcularPromedio(PilaTDA p1){
        return sumarElementosPila(p1)/contarElementosPila(p1);
    }

    public static void ejerciciosPilas(){
        PilaTDA p1 = new PilaLD();
        PilaTDA p2 = new PilaLD();

        p1.inicializarPila();
        p2.inicializarPila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);

        System.out.println("Inicio Ejercicio a");
        //pasar(p1, p2);
        System.out.println("Fin Ejercicio a");
        System.out.println("Inicio Ejercicio b");
        //copiar(p1,p2);
        System.out.println("Fin Ejercicio b");
        System.out.println("Inicio Ejercicio c");
        //copiar(p1,p2);
        //pasar(p2,p1);
        System.out.println("Fin Ejercicio c");
        System.out.println("Inicio Ejercicio d");
        System.out.println(contarElementosPila(p1));
        System.out.println("Fin Ejercicio d");
        System.out.println("Inicio Ejercicio e");
        System.out.println(sumarElementosPila(p1));
        System.out.println("Fin Ejercicio e");
        System.out.println("Inicio Ejercicio f");
        System.out.println(calcularPromedio(p1));
        System.out.println("Fin Ejercicio f");
    }


    public static void pasar(ColaTDA c1, ColaTDA c2) {
        while(!c1.colaVacia()) {
            int primero = c1.primero();
            c2.acolar(primero);
            c1.desacolar();
        }
    }

    public static void invertirColaPilaAuxiliar(ColaTDA c1){
        PilaTDA aux = new PilaLD();
        aux.inicializarPila();
        while(!c1.colaVacia()) {
            int primero = c1.primero();
            aux.apilar(primero);
            c1.desacolar();
        }

        while(!aux.pilaVacia()) {
            int tope = aux.tope();
            c1.acolar(tope);
            aux.desapilar();
        }
    }

    public static void invertirCola(ColaTDA c1){
        if(!c1.colaVacia()) {
            int primero = c1.primero();
            c1.desacolar();
            invertirColaPilaAuxiliar(c1);
            c1.acolar(primero);

        }
    }

    public static int obtenerUltimoElemento(ColaTDA c){
        int ultimo = 0;
        while(!c.colaVacia()) {
            ultimo = c.primero();
            c.desacolar();
        }
        return ultimo;
    }

    public static boolean coincidenFinales(ColaTDA c1, ColaTDA c2){
        return obtenerUltimoElemento(c1) == obtenerUltimoElemento(c2);
    }


    public static void ejerciciosColas(){
        ColaTDA c1 = new ColaLD();
        ColaTDA c2 = new ColaLD();

        c1.inicializarCola();
        c2.inicializarCola();

        c1.acolar(1);
        c1.acolar(2);
        c1.acolar(3);

        c2.acolar(4);
        c2.acolar(5);
        c2.acolar(6);

        System.out.println("Inicio Ejercicio a");
        //pasar(c1,c2);
        System.out.println("Fin Ejercicio a");
        System.out.println("Inicio Ejercicio b");
        //invertirColaPilaAuxiliar(c1);
        System.out.println("Fin Ejercicio b");
        System.out.println("Inicio Ejercicio c");
        //invertirCola(c1);
        System.out.println("Fin Ejercicio c");
        System.out.println("Inicio Ejercicio d");
        System.out.println(coincidenFinales(c1,c2));
        System.out.println("Fin Ejercicio d");
        System.out.println("Inicio Ejercicio e");
        System.out.println("Fin Ejercicio e");
        System.out.println("Inicio Ejercicio f");
        System.out.println("Fin Ejercicio f");
    }


    public static void pasar(ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        while (!c1.colaVacia() && !c2.colaVacia()){
            int prioridad = c1.prioridad();
            int primero = c1.primero();
            c1.desacolar();
            c2.acolarPrioridad(primero,prioridad);
        }

    }

    public static void unirColasPrioridad(ColaPrioridadTDA c1, ColaPrioridadTDA c2, ColaPrioridadTDA union){
        pasar(c1,union);
        pasar(c2,union);
    }

    public static void ejerciciosColaPrioridad(){
        ColaPrioridadTDA c1 = new ColaPrioridadDA();
        ColaPrioridadTDA c2 = new ColaPrioridadDA();

        c1.inicializarCola();
        c2.inicializarCola();

        c1.acolarPrioridad(1,5);
        c1.acolarPrioridad(2,4);
        c1.acolarPrioridad(3,1);

        c2.acolarPrioridad(4,3);
        c2.acolarPrioridad(5,2);
        c2.acolarPrioridad(6,1);

        System.out.println("Inicio Ejercicio a");

        ColaPrioridadTDA union = new ColaPrioridadDA();
        union.inicializarCola();
        unirColasPrioridad(c1,c2,union);

        System.out.println("Fin Ejercicio a");


    }



    public static DiccionarioMultipleTDA DiferenciasEntreDiccionarios(DiccionarioMultipleTDA d1, DiccionarioMultipleTDA d2){
        DiccionarioMultipleTDA retorno = new DicMultipleL();
        retorno.inicializarDiccionario();

        ConjuntoTDA unionDeClaves = union(d1.claves(),d2.claves());

        while(!unionDeClaves.conjuntoVacio()) {
            int clave = unionDeClaves.elegir();
            ConjuntoTDA diferenciaSimetrica = diferenciaSimetricaSinOperaciones(d1.recuperar(clave),d2.recuperar(clave));
            while(!diferenciaSimetrica.conjuntoVacio()) {
                int valor = diferenciaSimetrica.elegir();
                retorno.agregar(clave,valor);
                diferenciaSimetrica.sacar(valor);
            }
            unionDeClaves.sacar(clave);
        }
        return retorno;

    }



    public static void ejercicioParcial(){
        //1.Una empresa desea identificar las diferencias de registros de operaciones de sus clientes en sus dos bases
        // de datos. Para ello dispone de información de registros de operaciones en dos bases de datos que contienen
        // la siguiente información: NroCliente, y registros de operaciones bancarias realizadas, las mismas no pueden
        // repetirse en un mismo cliente, pero si en clientes distintos.

        DiccionarioMultipleTDA d1 = new DicMultipleL();
        DiccionarioMultipleTDA d2 = new DicMultipleL();

        d1.inicializarDiccionario();
        d2.inicializarDiccionario();

        d1.agregar(1,10);
        d1.agregar(1,11);
        d1.agregar(1,24);
        d1.agregar(1,25);
        d1.agregar(1,26);
        d1.agregar(2,7);
        d1.agregar(2,10);
        d1.agregar(2,1);
        d1.agregar(3,10);
        d1.agregar(3,20);
        d1.agregar(3,30);


        d2.agregar(1,10);
        d2.agregar(1,11);
        d2.agregar(1,24);
        d2.agregar(2,7);
        d2.agregar(2,10);
        d2.agregar(3,10);
        d2.agregar(3,20);
        d2.agregar(3,30);

        mostrar(DiferenciasEntreDiccionarios(d1,d2),"dif");

        }

        public static DiccionarioMultipleTDA invertirClaves(DiccionarioMultipleTDA d1){
            DiccionarioMultipleTDA retorno = new DicMultipleL();
            retorno.inicializarDiccionario();

            ConjuntoTDA claves = d1.claves();
            while(!claves.conjuntoVacio()) {
                int clave = claves.elegir();
                ConjuntoTDA valores = d1.recuperar(clave);
                while(!valores.conjuntoVacio()) {
                    int valor = valores.elegir();
                    retorno.agregar(valor,clave);
                    valores.sacar(valor);
                }
                claves.sacar(clave);
            }
            return retorno;
        }


        public static void practicaParcial2(){
            //Se guarda una lista de curso con la cantidad de estudiantes inscriptos (el curso no
            //se repite)

            // Pasar la información a otro TDA capaz de almacenar inscriptos, y cursos que
            //tengan dicha cantidad de inscriptos

            DiccionarioMultipleTDA d1 = new DicMultipleL();

            d1.inicializarDiccionario();
            d1.agregar(1,10);
            d1.agregar(2,7);
            d1.agregar(3,10);

            mostrar(invertirClaves(d1),"dif");

    }


    public static DiccionarioMultipleTDA ordenarDiccionarioDecreciente(DiccionarioMultipleTDA d1){
        DiccionarioMultipleTDA retorno = new DicMultipleL();
        retorno.inicializarDiccionario();
        ColaPrioridadTDA cola = new ColaPrioridadLD();
        DiccionarioMultipleTDA aux  = invertirClaves(d1);
        mostrar(aux,"invertido");
        ConjuntoTDA notas = aux.claves();
        while(!notas.conjuntoVacio()) {
            int clave = notas.elegir();
            ConjuntoTDA alumno = aux.recuperar(clave);
            while(!alumno.conjuntoVacio()) {
                int valor = alumno.elegir();
                cola.acolarPrioridad(valor,clave);
                alumno.sacar(valor);
            }
            notas.sacar(clave);
        }

        while(!cola.colaVacia()){
            int primero = cola.primero();
            int prioridad = cola.prioridad();
            retorno.agregar(prioridad,primero);
            cola.desacolar();
        }


        return retorno;
    }

    public static void practicaParcial3(){

        // en un diccionario multiple se guardan los legajos de los alumnos , se necesita copiar esa informacion a un
        // tda adecuado que permita almacenar la informacion pero ordenada por nota en forma decreciente

        DiccionarioMultipleTDA d1 = new DicMultipleL();
        d1.inicializarDiccionario();
        d1.agregar(1,10);
        d1.agregar(2,7);
        d1.agregar(1,5);
        d1.agregar(2,8);
        mostrar(d1,"notas");
        mostrar(ordenarDiccionarioDecreciente(d1),"ordenado");
    }


    public static DiccionarioMultipleTDA ordenarValoresClave(DiccionarioMultipleTDA d1){
        DiccionarioMultipleTDA retorno = new DicMultipleL();
        retorno.inicializarDiccionario();
        ColaPrioridadTDA cola = new ColaPrioridadLD();

        ConjuntoTDA claves = d1.claves();

        while(!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            ConjuntoTDA valores = d1.recuperar(clave);
            while(!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                cola.acolarPrioridad(valor,valor);
                valores.sacar(valor);
            }

            while(!cola.colaVacia()){
                int primero = cola.primero();

                retorno.agregar(clave,primero);
                cola.desacolar();
            }

            claves.sacar(clave);
        }

        return retorno;

    }


    public static void practicaParcial4(){
        DiccionarioMultipleTDA d1 = new DicMultipleL();
        d1.inicializarDiccionario();
        d1.agregar(1,100);
        d1.agregar(1,105);
        d1.agregar(1,250);
        d1.agregar(1,90);

        mostrar(d1,"precios");
        mostrar(ordenarValoresClave(d1),"ordenado");

    }



    }


