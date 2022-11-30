public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Billetes Vendidos
    private int billetesVendidos;
    // Tipo de maquina (true == maquina normal y false == maquina con premio)
    private boolean tipoMaquina;
    // Maximo de billetes
    private int maximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaNormal, int maximoDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        tipoMaquina = maquinaNormal;
        maximoBilletes = maximoDeBilletes;
    }
    
    /**
     * Nuevo constructor.
     */
    public MaquinaExpendedoraMejorada(boolean maquinaNormal, int maximoDeBilletes) {
        precioBillete = 8;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "León";
        estacionDestino = "Guardo";
        billetesVendidos = 0;
        tipoMaquina = maquinaNormal;
        maximoBilletes = maximoDeBilletes;
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(billetesVendidos < maximoBilletes){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else{
            System.out.println("Error: Maximo de billetes vendidos");
        }
    }
    
    /**
     * Imprime un billete para el cliente actual
     */
     public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
         if (cantidadDeDineroQueFalta <= 0) {  
            if(billetesVendidos >= maximoBilletes){
                System.out.println("Error: Maximo de billetes vendidos");
            }
            else{
                if (tipoMaquina == true){
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();
            
                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    // Billetes vendidos 
                    billetesVendidos = billetesVendidos + 1;
                }
                else {
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();
                    System.out.println("Tienes un descuento de " + ((precioBillete*25)/100) + " euros para el Zara.");
            
                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    // Billetes vendidos 
                    billetesVendidos = billetesVendidos + 1;
                }
            }
        }
        else {
            System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                    
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
     /**
     * Vacioado total de la maquina expendedora 
     */
    public int vaciarDineroDeLaMaquina() {
        int vaciarDineroDeLaMaquina;
        if (balanceClienteActual == 0) {
            vaciarDineroDeLaMaquina = totalDineroAcumulado - balanceClienteActual;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            vaciarDineroDeLaMaquina = -1;
            System.out.println("Error: Operacion en curso, cancele y recoja el dinero");
        }
        return vaciarDineroDeLaMaquina;
    }
    
    /**
     * Devuelve los billetes vendidos
     */
    public int getNumeroBilletesVendidos(){
        int getNumeroBilletesVendidos = billetesVendidos;
        return getNumeroBilletesVendidos;
    }
    
    /**
     * Imprime los billetes vendidos
     */
    public void imprimirNumeroBilletesVendidos(){
        System.out.println((billetesVendidos) + " Billetes vendidos");
    }
}