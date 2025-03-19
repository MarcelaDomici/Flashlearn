
package Elements;

import Body.Estudo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class List<tipo> {
    private No<tipo> primeiro;
    private No<tipo> ultimo;
    
    public void Add(tipo values){
        Estudo teste = (Estudo) values;
        if(teste.getPergunta()==null||teste.getResposta()==null)return;
        if(this.primeiro==null){
            this.primeiro = new No<>(values);
            this.ultimo=primeiro;
        }else{
            No<tipo> element = new No<>(values);
            this.ultimo.setProx(element);
            this.ultimo = element;
        }
    }
    public void flush()throws SQLException{
        No<tipo> aux = this.primeiro;
        ArrayList<Estudo> aux1 = new ArrayList<>();
        if(aux!=null){
            while(aux!=null){
                aux1.add((Estudo)aux.getValor());
                aux=aux.getProx();
            }
            for(int i=0;i<aux1.size();i++){
                Estudo teste = (Estudo)aux1.get(i);
                if(teste.getPergunta()==null||teste.getResposta()==null||teste.getPergunta().equals("null")||teste.getResposta().equals("null"))continue;
                new ConnectSQL.ConnectDAO().getEstudoToUpdate(aux1.get(i));
            }
            //JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso!","Aviso!",1);
        }
    }
}
