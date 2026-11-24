package com.example.projetopdmii;

public class Pergunta {
    private String pergunta, opcaoA, opcaoB, opcaoC, opcaoD, gabarito;
    public Pergunta(String pergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String gabarito){
        this.pergunta = pergunta;
        this.opcaoA = opcaoA;
        this.opcaoB = opcaoB;
        this.opcaoC = opcaoC;
        this.opcaoD = opcaoD;
        this.gabarito = gabarito;
    }

    public String getPergunta() {return pergunta;}
    public void setPergunta(String pergunta) {this.pergunta = pergunta;}

    public String getOpcaoA() {return opcaoA;}
    public void setOpcaoA(String opcaoA) {this.opcaoA = opcaoA;}

    public String getOpcaoB() {return opcaoB;}
    public void setOpcaoB(String opcaoB) {this.opcaoB = opcaoB;}

    public String getOpcaoC() {return opcaoC;}
    public void setOpcaoC(String opcaoC) {this.opcaoC = opcaoC;}

    public String getOpcaoD() {return opcaoD;}
    public void setOpcaoD(String opcaoD) {this.opcaoD = opcaoD;}

    public String getGabarito() {return gabarito;}
    public void setGabarito(String gabarito) {this.gabarito = gabarito;}
}
