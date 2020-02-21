package com.informacao;

import nx.componentes.ArtButton;
import totalcross.ui.Label;
import totalcross.ui.MultiEdit;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Informacao extends totalcross.ui.Window{
	
    private Label 							lblInformacao;
    private Label							lblVersao;
    private Label							lblSobre;
    private Label							lblCopyright;
    private MultiEdit						editInformacao;
	private ArtButton 						btnVoltar;
	private int 							linha = 6;
	private int							    dist = 1;
	
	public Informacao(){
		 setBackColor(0x003366);
		 initUI();
	}
	
	public void initUI() {
		
		try {

			lblInformacao = new Label("INFORMACÕES: ");
			add(lblInformacao);
			lblInformacao.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblInformacao.setBackColor(0x003366);
	        lblInformacao.setForeColor(Color.WHITE);
	        
	        editInformacao = (new MultiEdit("", linha, dist));
			add(editInformacao);			
			editInformacao.setMaxLength(500);
			editInformacao.setRect(LEFT, AFTER + 30,FILL + 5, height - 200, lblInformacao);
			editInformacao.setBackColor(Color.WHITE);
			editInformacao.setForeColor(0x003366);
			editInformacao.setText("Um controle de estoque efetivo é hoje um fator determinante para o sucesso de uma empresa. "
					+ " Por representar uma parte importante dos ativos é necessário que se tenha um sistema que supra as "
					+ " necessidades de controle de estoque da empresa. A distribuidora Umbrella do ramo de bebidaspossui "
					+ " uma variedade de mais de 50 tipos de produtos em seu estoque, sem nenhum controle rígido. O objetivo "
					+ " deste trabalho é identificar os diferentes fatores que influenciam o estoque, desenvolvendo um sistema "
					+ " de controle para a distribuidora. .As teorias de base fundamentadas de citações de diversos autores ajudou "
					+ " abranger uma área mais ampla de teóricos e também compondo os três pilares que será nossa base de sustentação "
					+ " do projeto. O controle e gestão de estoque, que terá uma grande importância para nosso cliente e também na construção "
					+ " do sistema, o estoque de segurança, que prevenirá nosso cliente de futuros problemas de corte no fornecimento. "
					+ " Por fim o gerenciamento de estoque, que ajudará o mesmo a organizar melhor o seu empreendimento.O resultado da "
					+ " análise mostrou uma utilização incorreta dos recursos da distribuidora, tanto de espaço físico, quanto de datas de "
					+ " compras e tipos de produtos a serem comprados em cada momento. Baseados na análise dos dados e da situação são esboçados "
					+ " algumas recomendações. ");
			editInformacao.setEditable(false);
			
			
			lblCopyright = new Label("Copyright©2020-Todos os direitos reservados");
			add(lblCopyright);
			lblCopyright.setRect(LEFT, AFTER + 10, PREFERRED, PREFERRED, editInformacao);
			lblCopyright.setBackColor(0x003366);
			lblCopyright.setForeColor(Color.WHITE);  
			
			lblSobre = new Label("CONTROLE-PC");
			add(lblSobre);
			lblSobre.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, lblCopyright);
			lblSobre.setBackColor(0x003366);
			lblSobre.setForeColor(Color.WHITE);
			
			lblVersao = new Label("VERSÃO: 1.0");
			add(lblVersao);
			lblVersao.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, lblSobre);
			lblVersao.setBackColor(0x003366);
			lblVersao.setForeColor(Color.WHITE);  

			btnVoltar = new ArtButton("VOLTAR");
	        add(btnVoltar);
	        btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
	        btnVoltar.setBackColor(0x003366);
	        btnVoltar.setForeColor(Color.WHITE);
	        
	        reposition();
	        
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE","Erro ao carregar a Tela");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();

		}
		
	}
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();
				}
			}
		}catch (Exception e) {
				MessageBox msg = new MessageBox("CONTROLE","Erro no evento");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();
			}
			
			
		}
	
	
}
