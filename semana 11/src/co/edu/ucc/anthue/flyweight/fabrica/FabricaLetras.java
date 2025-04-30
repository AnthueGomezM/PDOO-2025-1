package co.edu.ucc.anthue.flyweight.fabrica;

import co.edu.ucc.anthue.flyweight.implementacion.LetraConcreta;
import co.edu.ucc.anthue.flyweight.interfaces.ILetra;

import java.util.HashMap;

public class FabricaLetras {
    private static final HashMap<Character, ILetra> pool = new HashMap<>();

    public static ILetra obtenerLetra(char simbolo) {
        if (!pool.containsKey(simbolo)) {
            pool.put(simbolo, new LetraConcreta(simbolo));
        }
        return pool.get(simbolo);
    }
}
