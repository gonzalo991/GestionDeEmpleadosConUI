package entidades;

public class Contrato {
    private String tipo;
    private String obraSocial;
    private String beneficioExtra;

    public Contrato(String tipo, String obraSocial, String beneficioExtra){
        this.tipo = tipo;
        this.obraSocial = obraSocial;
        this.beneficioExtra = beneficioExtra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getBeneficioExtra() {
        return beneficioExtra;
    }

    public void setBeneficioExtra(String beneficioExtra) {
        this.beneficioExtra = beneficioExtra;
    }
}