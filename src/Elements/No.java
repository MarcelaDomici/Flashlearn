package Elements;


public class No<tipo> {
       private tipo valor;
       private No<tipo> prox;
       public No(tipo newValues){this.valor=newValues;this.prox=null;}
       public tipo getValor(){return this.valor;}
       public void setValor(tipo newValues){this.valor=newValues;}
       public No<tipo> getProx(){return this.prox;}
       public void setProx(No<tipo> newProx){this.prox=newProx;}
}
