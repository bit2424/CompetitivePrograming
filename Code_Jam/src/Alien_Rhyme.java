import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;



public class Alien_Rhyme {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cases = Integer.parseInt(br.readLine());
		for(int I = 0; I<cases ; I++) {
			wr.write("Case #" + (I+1)+": " +Solve() + "\n");
		}
		wr.flush();
	}
	
	private static String Solve() throws IOException {
		int n_words = Integer.parseInt(br.readLine());
		nodo lol = new nodo(true,new HashMap<Character, nodo>(),' ',0,1); 
        Trie prueba = new Trie(lol);
		
		for (int I = 0; I < n_words; I++) {
			String entry = br.readLine();
			StringBuilder ar = new StringBuilder(entry);
			
//				System.out.println(entry.substring(K, entry.length()) + "       LOL");
				prueba.insertarP(ar.reverse().toString(), null, 0,I+2);
//				System.out.println(" ");
			
		}
		int sol = n_words - prueba.buscarMax(null, 0);
		return String.valueOf(sol);
		
	}
	
	
}

class Trie{
    nodo root;
    
    public Trie(nodo root){
        this.root = root;
    }
    
    public void insertarP(String palabra, nodo lugar,int i, int ident){
        
        if(i==0){
            lugar = root;
        }
        
       //System.out.println("i "+i+" "+palabra.length());
        
        if(i<palabra.length()){
//                System.out.println("Parce estoy bajando y voy en "+i+" En la letra "+ palabra.charAt(i));
//                System.out.println(lugar.darHijos().isEmpty());
//                System.out.println(ident + " Mi idetificador");
                if(!(lugar.darHijos().isEmpty()) && lugar.darHijos().containsKey(palabra.charAt(i)) ){
                	if(ident != lugar.darHijos().get(palabra.charAt(i)).getIdentifier()  ) {
	                        if(i<palabra.length()-1){
//	                            System.out.println("Identificador  "+ lugar.getIdentifier() +"  Estoy en "+palabra.charAt(i)+" y hay un man igualito a mi y voy a ver que dice la banda en el nivel "+ i);
	                            lugar.darHijos().get(palabra.charAt(i)).setRepetitions(lugar.darHijos().get(palabra.charAt(i)).getRepetitions()+1);
	                            insertarP(palabra,lugar.darHijos().get(palabra.charAt(i)),1+i , ident);
	                        }else{
//	                            System.out.println("Estoy en "+palabra.charAt(i)+" y  pues esta vaina se acabo con alguien igualito a mi");
	                            lugar.darHijos().get(palabra.charAt(i)).setRepetitions(lugar.darHijos().get(palabra.charAt(i)).getRepetitions()+1);
	                            lugar.darHijos().get(palabra.charAt(i)).cSigue(false);
	                        }
                	}else {
                		if(i<palabra.length()-1){
//                            System.out.println("No repetidos  "+ lugar.getIdentifier() +"  Estoy en "+palabra.charAt(i)+" y hay un man igualito a mi y voy a ver que dice la banda en el nivel "+ i);
                            insertarP(palabra,lugar.darHijos().get(palabra.charAt(i)),1+i , ident);
                        }else{
//                            System.out.println("No repetidos "+palabra.charAt(i)+" y  pues esta vaina se acabo con alguien igualito a mi");
                            lugar.darHijos().get(palabra.charAt(i)).cSigue(false);
                        }
                	}
                	
                }else{
                    if(i<palabra.length()-1){
//                     System.out.println("Parce no hay nadie igualito a en este nivel y me voy a agregar");
                        nodo hijo = new nodo(true,new HashMap(),palabra.charAt(i),1, ident);
                        lugar.darHijos().put(palabra.charAt(i),hijo);
                        insertarP(palabra,hijo,1+i , ident);
                    }else{
//                        System.out.println("Parce estoy en el final de la palabra no hay nadie");
                        nodo hijo = new nodo(false,new HashMap(),palabra.charAt(i),1, ident);
                        lugar.darHijos().put(palabra.charAt(i),hijo);
                    }
                }
            
        }
//        System.out.println("Recursando Acabe " + palabra.charAt(i));
    }   
    
    
    public int buscarMax(nodo lugar,int i){
    	
        if(i==0){
            lugar = root;
        }
        String info = lugar.darValor()+"";
        int max = 0;
        
        for (Entry<Character, nodo> entry : lugar.darHijos().entrySet()) {
           max += buscarMax(entry.getValue(), 1);
        }
        
        if(!lugar.darSigue()) {
        	max+=1;
        }
        
        if(max >= 2 && i != 0) {
        	max -= 2;
        	return max;
        }else {
        	return max;
        }

    } 
}

class nodo{
    public boolean sigue;
    //public ArrayList<nodo> hijos = new ArrayList<nodo>(); 
    HashMap<Character, nodo> hijos = new HashMap();
    public char valor;
    public int repetitions;
    public int identifier;
    
    public nodo(boolean s,HashMap<Character, nodo> h, char v,int repetitions, int identifier){
        sigue = s;
        hijos = h;
        valor = v;
        this.repetitions  = repetitions;
        this.identifier = identifier;
    }
    
    public boolean darSigue(){
        return sigue;
    }
    
    public char darValor(){
        return valor;
    }
    
    public HashMap<Character, nodo> darHijos(){
        return hijos;
    }
    
    public void cSigue(boolean cambio){
        sigue = cambio;
    }

	public int getRepetitions() {
		return repetitions;
	}


	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
    
	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
}
