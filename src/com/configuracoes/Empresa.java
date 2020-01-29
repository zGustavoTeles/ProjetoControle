package com.configuracoes;

import nx.componentes.ArtButton;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Empresa extends totalcross.ui.Window {

	public Label                lblAviso;
	public Label 				lblUsuario;
	public Label 				lblSenha;
	public Edit 				editUsuario;
	public Edit 				editSenha;
	public ArtButton		    btnAlterarSenha;
	public ArtButton		    btnAlterarEmpresa;
	public ArtButton 			btnVoltar;

	public Empresa() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("BEM VINDO A CONFIGURAÇÃO DA EMPRESA\n SELECIONE A OPÇÃO DESEJADA: ");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			btnAlterarEmpresa = new ArtButton("ALTERAR EMPRESA");
			add(btnAlterarEmpresa);
			btnAlterarEmpresa.setRect(CENTER, TOP + 150, width - 200, PREFERRED + 80);
			btnAlterarEmpresa.setBackColor(0x003366);
			btnAlterarEmpresa.setForeColor(Color.WHITE);
			
			btnAlterarSenha = new ArtButton("ALTERAR SENHA");
			add(btnAlterarSenha);
			btnAlterarSenha.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnAlterarSenha.setBackColor(0x003366);
			btnAlterarSenha.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!", "Erro ao carregar a Tela");
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

				} else if(evt.target == btnAlterarEmpresa) {
					AlterarEmpresa alterarEmpresa = new AlterarEmpresa();
					alterarEmpresa.popup();
				}


			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}

}
