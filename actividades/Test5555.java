import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test5555 
{
    Correos correos;

    public Test5555() {
    }

    @Before
    public void setUp() {
        correos = new Correos();
    }

    @Test
    public void testEstaVaciaCola() {
        assertEquals(true, correos.estaLaColaVacia());
    }

    @Test
    public void testNoEstaVaciaColaConUnUnElemento() {
        correos.llegaPersona("Juan");
        assertEquals(false, correos.estaLaColaVacia());
    }

    @Test
    public void testInsertarYBorrarDejaLaColaVacia() {
        correos.llegaPersona("Juan");
        correos.ultimaPersonaSeVa();
        assertEquals(true, correos.estaLaColaVacia());
    }
    
    @Test
    public void testGetPrimeroDeUnaColaVacia() {
        assertEquals(null, correos.getPrimeraPersonaDeLaCola());
    }    

    @Test
    public void testGetPrimeroDeUnaColaConUnElemento() {
        correos.llegaPersona("Juan");
        assertEquals(true, correos.getPrimeraPersonaDeLaCola().equals("Juan"));
    }

    @Test
    public void testGetPrimeroDeUnaColaConDosElementos() {
        correos.llegaPersona("Juan");
        correos.llegaPersona("Miguel");
        assertEquals(true, correos.getPrimeraPersonaDeLaCola().equals("Juan"));
    }

    @Test
    public void testGetPrimeroDeUnaColaDespuesDeAnadir2ElementoYBorrarUno() {
        correos.llegaPersona("Juan");
        correos.llegaPersona("Miguel");
        correos.despacharALaPrimeraPersona();
        assertEquals(true, correos.getPrimeraPersonaDeLaCola().equals("Miguel"));
    }  

    @Test
    public void testTamanoColaVacia() {
        assertEquals(0, correos.getNumeroPersonasEnLaCola());
    }

    @Test
    public void testTamanoColaUnElemento() {
        correos.llegaPersona("Juan");
        assertEquals(1, correos.getNumeroPersonasEnLaCola());
    }

    @Test
    public void testColaGrande() {
        for (int i = 1; i <= 20 + 4; i++) {
            correos.llegaPersona(String.valueOf(i));
        }
        assertEquals("1", correos.getPrimeraPersonaDeLaCola());

    }

    @Test
    public void testBorradosColaGrande() {
        for (int i = 1; i <= 30 + 4; i++) {
            correos.llegaPersona(String.valueOf(i));
        }
        for (int i = 1; i <= 10; i++) {
            correos.despacharALaPrimeraPersona();
        }
        assertEquals("11", correos.getPrimeraPersonaDeLaCola());
    }

    
    @Test
    public void testListadoPersonasEnColaVacia() {
        assertEquals("Cola vacia", correos.getListadoPersonasEnCola());
    }    
    
    @Test
    public void testListadoPersonasEnCola() {
        for (int i = 1; i <= 10; i++) {
            correos.llegaPersona(String.valueOf(i));
        }
        assertEquals("1-2-3-4-5-6-7-8-9-10", correos.getListadoPersonasEnCola());
    }
    
    @Test
    public void testGetListadoPersonasDespuesDeQueUnaSeVaya() {
        correos.llegaPersona("Juan");
        correos.llegaPersona("Miguel");
        correos.llegaPersona("Lorena");        
        correos.ultimaPersonaSeVa();
        assertEquals("Juan-Miguel", correos.getListadoPersonasEnCola());
    }      
    
    @Test
    public void testGetListadoPersonasDespuesDeQueDosSeVayan() {
        correos.llegaPersona("Juan");
        correos.llegaPersona("Miguel");
        correos.llegaPersona("Lorena");        
        correos.ultimaPersonaSeVa();
        correos.ultimaPersonaSeVa();        
        assertEquals("Juan", correos.getListadoPersonasEnCola());
    }     

}
