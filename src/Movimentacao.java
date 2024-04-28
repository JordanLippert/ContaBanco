import java.time.LocalDateTime;

public class Movimentacao {

    private String descricao;
    private char tipo;
    private double valor;
    private LocalDateTime dataHora;

    public Movimentacao(String descricao, char tipo, double valor){
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }
    public String getMovimentacao(){
        return "Descrição: " + descricao + ", Tipo: " + tipo + ", Valor: " + valor + ", Data/Hora: " + dataHora;
    }
}
