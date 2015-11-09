
package factories;

import adapters.perfil.PerfilAdapter;
import adapters.perfil.PerfilClienteAdapter;
import adapters.perfil.PerfilFoodtruckAdapter;


public class PerfilFactory {

    private static PerfilFactory singleton = null;

    public static PerfilFactory getInstance() {
        
        if (singleton == null) {
            singleton = new PerfilFactory();        
        }
        
        return singleton;

    }
   
    private PerfilFactory(){}
    
    
    public PerfilAdapter obtenerPerfil(int tipo){
    
    if(tipo==1){        
     
     return  new PerfilClienteAdapter();     
     
    }else if(tipo==2){        
   
     return  new PerfilFoodtruckAdapter();    
     
    }else{        
        
     return  null;    
     
    }
        
    
    
    }

    
    
    
    
    
    
}
