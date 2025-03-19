
package Body;


public class Estudo {

    private String pergunta, resposta;
    private int id;
    
    public int getId(){
        return this.id;
    }
    public void setId(int newId){
        this.id=newId;
    }
    
    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
    
}
