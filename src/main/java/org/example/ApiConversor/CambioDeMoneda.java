package org.example.ApiConversor;

import java.util.HashMap;
import java.util.Map;

public class CambioDeMoneda {

    private  String result;
    private final Map<String , Double> conversion_rates = new HashMap<>();

    public String getResult(){return  result;}

    public  double realizarCambio(double monto, String monedaLocal, String monedaDeCambio ){
        if (!conversion_rates.containsKey(monedaLocal)){
            throw new RuntimeException("La moneda que ingreso: " + monedaLocal + ", no es válido");
        }
        if (!conversion_rates.containsKey(monedaDeCambio)){
            throw  new RuntimeException("El tipo de cambio: "+ monedaDeCambio + ", no es válido");
        }
        return monto * conversion_rates.get(monedaDeCambio) / conversion_rates.get(monedaLocal);
    }
}
