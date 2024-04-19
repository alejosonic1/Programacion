import java.util.Scanner;

public class Dalton {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Dime el numero de Daltons");
        int tamaño = sc.nextInt();
        int[] tamañosDaltons = new int[tamaño];
        int cont = 0;

        for (int i = 0; i < tamaño; i++) {
            System.out.println("Dime el tamaño del Dalton " + (i + 1));
            tamañosDaltons[i] = sc.nextInt(); 
        }
        
        //Ascendente
        if(tamañosDaltons[0] < tamañosDaltons[1]) {
 
        for(int i = 1; i < tamaño; i++) {
        	
        	if(tamañosDaltons[i] <= tamañosDaltons[i-1]) {
        		cont++;
        	}
        	
        }
        }else {
        	for(int i = 1; i < tamaño; i++) {
            	
            	if(tamañosDaltons[i] >= tamañosDaltons[i-1]) {
            		cont++;
            	}
            	
            }
        }
        
      
        if(cont!=0 || tamaño!=4) {
        	System.out.println("DESCONOCIDOS");
        }else {
        	System.out.println("DALTONS");
        }
        
        
    }
    
}
