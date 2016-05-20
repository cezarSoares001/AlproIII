/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Lucas
 * @param 
 */
public class ArvoreBinariaDePesquisa {

    private Nodo raiz;
    
    public List<Integer> filhosPares (){
        List<Integer> lista = new ArrayList<>();
        return filhosPares0(raiz,lista);
    }
    
    private List<Integer> filhosPares0(Nodo nodo, List<Integer> lista){
        if(nodo == null){
            return lista;
        }
        if(nodo.direito != null && nodo.esquerdo != null){
            if((nodo.esquerdo.chave % 2 == 0) && (nodo.direito.chave % 2 == 0)){
                lista.add(nodo.chave);
            }
        }
        filhosPares0(nodo.direito, lista);       
        filhosPares0(nodo.esquerdo,lista);        
        return lista;
    }
    
    public Nodo retornaNodo(int valor) {
        return retornaNodo0(raiz, valor);
    }
    
    private Nodo retornaNodo0(Nodo nodo, int valor) {
        if(nodo == null){
            return null;
        }        
        if(nodo.chave < valor) {
            retornaNodo0(nodo.direito, valor);              
        } else if(nodo.chave == valor){
            return nodo;
        }
        return retornaNodo0(nodo.esquerdo, valor);
    }
    
    public int descendentes(int valor) {        
        Nodo node = retornaNodo(valor);
        System.out.println(""+ node);
        List<Integer> list = new ArrayList<>();
        return descendentes0(node, list);
    }
    
    private int descendentes0(Nodo nodo, List<Integer> list){                
        if(nodo == null) {            
            return list.size()-1;            
        }             
        
        descendentes0(nodo.esquerdo, list);                
        descendentes0(nodo.direito, list);                       
        list.add(nodo.chave);
        return list.size()-1;
    }

    public void inserirAvl(int chave) {
        raiz = inserirAvl(raiz, chave);
    }

    private Nodo inserirAvl(Nodo nodo, int chave) {
        if (nodo == null) {
            return new Nodo<>(chave);
        }

        if (chave < nodo.chave) {
            nodo.esquerdo = inserirAvl(nodo.esquerdo, chave);
            if (h(nodo.esquerdo) - h(nodo.direito) == 2) {

                if (chave < nodo.esquerdo.chave) {
                    nodo = rotacionarComFilhoEsquerdo(nodo);
                } else {
                    nodo = duplaComFilhoEsquerdo(nodo);
                }
            }

        } else if (chave > nodo.chave) {
            nodo.direito = inserirAvl(nodo.direito, chave);
            if (h(nodo.esquerdo) - h(nodo.direito) == -2) {

                if (chave > nodo.direito.chave) {
                    nodo = rotacionarComFilhoDireito(nodo);
                } else {
                    nodo = duplaComFilhoDireito(nodo);
                }
            }
        }
//        } else {
//            throw new IllegalArgumentException("Chave duplicada");
//        }

        nodo.altura = Math.max(h(nodo.esquerdo), h(nodo.direito)) + 1;

        return nodo;
    }

    public void inserirNaoAvl(int chave) {
        raiz = inserirNaoAvl(raiz, chave);
    }

    private Nodo inserirNaoAvl(Nodo nodo, int chave) {
        if (nodo == null) {
            return new Nodo<>(chave);
        }
        if (chave < nodo.chave) {
            nodo.esquerdo = inserirNaoAvl(nodo.esquerdo, chave);
        } else if (chave > nodo.chave) {
            nodo.direito = inserirNaoAvl(nodo.direito, chave);
        }
//        } else {
//            throw new IllegalArgumentException("Chave duplicada");
//        }
        nodo.altura = Math.max(h(nodo.esquerdo), h(nodo.direito)) + 1;

        return nodo;
    }

    private Nodo duplaComFilhoDireito(Nodo k1) {
        k1.direito = rotacionarComFilhoEsquerdo(k1.direito);
        return rotacionarComFilhoDireito(k1);
    }

    private Nodo duplaComFilhoEsquerdo(Nodo k3) {
        k3.esquerdo = rotacionarComFilhoDireito(k3.esquerdo);
        return rotacionarComFilhoEsquerdo(k3);
    }

    private Nodo rotacionarComFilhoDireito(Nodo k1) {
        Nodo k2 = k1.direito;
        k1.direito = k2.esquerdo;
        k2.esquerdo = k1;

        k1.altura = Math.max(h(k1.esquerdo), h(k1.direito)) + 1;
        k2.altura = Math.max(k1.altura, h(k2.direito)) + 1;

        return k2;
    }

    private Nodo rotacionarComFilhoEsquerdo(Nodo k2) {
        Nodo k1 = k2.esquerdo;
        k2.esquerdo = k1.direito;
        k1.direito = k2;

        k2.altura = Math.max(h(k2.esquerdo), h(k2.direito)) + 1;
        k1.altura = Math.max(h(k1.esquerdo), k2.altura) + 1;

        return k1;
    }

    private int h(Nodo nodo) {

        return nodo == null ? -1 : nodo.altura;
    }

    public void preOrdem() {
        System.out.println("PRE=");
        preOrdem0(raiz);
        System.out.println();
    }

    private void preOrdem0(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        System.out.print(" " + nodo.chave);

        preOrdem0(nodo.esquerdo);
        preOrdem0(nodo.direito);

    }

    public void central() {
        System.out.println("CENTRAL=");
        central0(raiz);
        System.out.println();
    }

    private void central0(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        central0(nodo.esquerdo);

        System.out.print(" " + nodo.chave);

        central0(nodo.direito);
    }

    public void posOrdem() {
        System.out.println("POS=");
        posOrdem0(raiz);
        System.out.println();
    }

    private void posOrdem0(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        posOrdem0(nodo.esquerdo);
        posOrdem0(nodo.direito);

        System.out.print(" " + nodo.chave);
    }

    @Override
    public String toString() {
        return String.format("ArvoreBinariaDePesquisa [raiz=%s]",
                toString0(raiz));
    }

    /**
     * Pré-ordem
     *
     * @param nodo
     * @return
     */
    private String toString0(Nodo nodo) {
        if (nodo == null) {
            return " # ";
        }

        int delta = getAltura0(nodo.esquerdo) - getAltura0(nodo.direito);
        String msg = String
                .format("%s  nível= ? altura= %d delta= %d grau= %d pai= ? tio = ? %n[%s]%n[%s]",
                        nodo.chave, getAltura0(nodo), delta, grau(nodo),
                        toString0(nodo.esquerdo), toString0(nodo.direito));

        return msg;
    }

    private int grau(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }

        int g = 0;
        if (nodo.esquerdo != null) {
            g++;
        }
        if (nodo.direito != null) {
            g++;
        }

        return g++;
    }

    public Nodo consultar(int chave) {
        return consultar0(raiz, chave);
    }

    private Nodo consultar0(Nodo nodo, int chave) {
        if (nodo == null) {
            return null;
        }

        // if (chave < nodo.chave)
        if (chave < nodo.chave) {
            return consultar0(nodo.esquerdo, chave);
        } else if (chave > nodo.chave) {
            return consultar0(nodo.direito, chave);
        } else {
            return nodo;
        }
    }

    public int getAltura() {
        return getAltura0(raiz);
    }

    /**
     * Pós-ordem
     *
     * @param nodo
     * @return
     */
    private int getAltura0(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }

        int ae = getAltura0(nodo.esquerdo);
        int ad = getAltura0(nodo.direito);

        return 1 + Math.max(ae, ad);
    }

    public boolean isEquilibrada() {
        return isEquilibrada0(raiz);
    }

    private boolean isEquilibrada0(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        int delta = getAltura0(nodo.esquerdo) - getAltura0(nodo.direito);

        if (delta == 2 || delta == -2) {
            return false;
        }

        return isEquilibrada0(nodo.esquerdo) && isEquilibrada0(nodo.direito);
    }

    public List<Integer> getCaminho(int chave) {
        List<Integer> r = new ArrayList<>();
        return getCaminho0(raiz, chave, r);
    }

    private List<Integer> getCaminho0(Nodo<Integer> nodo, int chave, List<Integer> r) {
        if (nodo == null) {
            throw new IllegalArgumentException("Chave não encontrada: " + chave);
        }

        r.add(nodo.chave);

        if (chave < nodo.chave) {
            return getCaminho0(nodo.esquerdo, chave, r);
        } else if (chave > nodo.chave) {
            return getCaminho0(nodo.direito, chave, r);
        } else {
            return r;
        }

    }

    public int getPathSizeTo(int element) {
        return getPathSizeTo(raiz, element, 0);
    }

    private int getPathSizeTo(Nodo nodo, int element, int cont) {
        if (nodo == null) {
            throw new IllegalArgumentException("Arvore vazia");
        }
        if (element < nodo.chave) {
            return getPathSizeTo(nodo.esquerdo, element, cont++);
        } else if (element > nodo.chave) {
            return getPathSizeTo(nodo.direito, element, cont++);
        } else {
            return cont;
        }
    }

    public void printSequenciasDePares() {
        printSequenciasDePares0(raiz);
    }

    private void printSequenciasDePares0(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        printSequenciasDePares0(nodo.esquerdo);
        // System.out.println(nodo.chave);
        List<Integer> caminho = getCaminho(nodo.chave);
        boolean temImpar = false;
        for (Integer t : caminho) {
            Integer v =  t;
            if (v % 2 != 0) {
                temImpar = true;
                break;
            }
        }
        if (!temImpar) {
            System.out.println(caminho);
        }
        printSequenciasDePares0(nodo.direito);
    }      

    public ArrayList<Integer> getNivel(int n) {
        ArrayList<Integer> r = new ArrayList<>();
        getNivel(raiz, n, r, 0);
        return r;
    }

    private void getNivel(Nodo nodo, int n, List<Integer> r, int atual) {
        if (nodo == null) {
            throw new IllegalArgumentException("Nível não existe: " + n);
        }
        if (n == atual) {
            r.add(nodo.chave);
        } else if (atual < n) {
            if(nodo.esquerdo != null)
            getNivel(nodo.esquerdo, n, r, atual + 1);
            if(nodo.direito != null)
            getNivel(nodo.direito, n, r, atual + 1);
            
        }
    }
    
    public int contador;
  
    
    public String printTree() {
        return printTree(raiz);
    }   
    
    private String printTree(Nodo nodo) {        
        int pos;
        int contCaracter;
        Stack<Nodo> filaAtual = new Stack<>();
        Stack<Nodo> proximaFila = new Stack<>();
        StringBuilder textTemp = new StringBuilder();
        StringBuilder textFinal = new StringBuilder();
        Nodo node;
        HashMap<Integer, Integer> hashPosition = posicaoNaString();        
        contador += 13; 
        if(nodo != null){
            filaAtual.push(nodo);
            contador += 2;
        }
        do{
            contador += 2;
            while (!filaAtual.empty()){           
                node = filaAtual.pop();
                pos = hashPosition.get(node.chave);
                contador += 8;
                if(node.esquerdo !=     null) {           
                    contCaracter = hashPosition.get(node.esquerdo.chave);
                    textTemp.append(stringBuilder(" ", contCaracter - textTemp.length()));
                    textTemp.append("|");
                    textTemp.append(stringBuilder("-", pos - contCaracter - 1));
                    proximaFila.push(node.esquerdo);
                    contador += 14;
                } else {           
                    textTemp.append(stringBuilder(" ", pos - textTemp.length()));
                    contador +=14;
                }
                textTemp.append(node.chave);
                contador += 4;
                if(node.direito != null) {                    
                    contCaracter = hashPosition.get(node.direito.chave);
                    textTemp.append(stringBuilder("-", contCaracter - pos - 1));
                    textTemp.append("|");
                    proximaFila.push(node.direito);
                    contador += 10;
                }
            }    
            textFinal.append(textTemp);
            textTemp = new StringBuilder();
            textFinal.append("\n");
            contador += 6;
            while (proximaFila.size() > 0){                
                filaAtual.push(proximaFila.pop());
                contador += 4;
            }
        } while (filaAtual.size() > 0);
        
        return textFinal.toString();
        
    }

    
    public String stringBuilder(String letter, int n){
        StringBuilder texto = new StringBuilder();
        for(int i=0; i < n; i++){
            texto.append(letter);
        }
        return texto.toString();
    }
    
    public HashMap<Integer,Integer> posicaoNaString(){
        HashMap<Integer,Integer> stringPos = new HashMap<>();
        posicaoNaString(raiz, stringPos, 1);
        return stringPos;
    }
    
    private int posicaoNaString(Nodo nodo, HashMap<Integer, Integer> stringPos, int cont){
        if(nodo != null){
            cont = posicaoNaString(nodo.esquerdo, stringPos, cont);
            //verificar pode dar erro
            String key = Integer.toString(nodo.chave);
            cont = cont + key.length();
            stringPos.put(nodo.chave, cont);
            cont = posicaoNaString(nodo.direito, stringPos, cont);
        }
        return cont;
    }
    
    public String printTreeE2(){        
        String str = "";                
        for(int i = 0; i < getAltura()+1; i++){                        
            ArrayList<Integer> lista = getNivel(i);                    
            for(int j = 0; j < lista.size(); j++){                       
                str += lista.get(j) + " ";                
            }
            str += "\n";        
        }                
        return str;             
    } 

    
}
