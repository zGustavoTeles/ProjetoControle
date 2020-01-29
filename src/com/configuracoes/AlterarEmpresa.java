package com.configuracoes;

import nx.componentes.ArtButton;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class AlterarEmpresa extends totalcross.ui.Window {

	public Label                lblInformacao;
	public Label 				lblEmpresa;
	public Label 				lblCnpj;
	public Label				lblUsuario;
	public Edit					editUsuario;
	public Edit 				editEmpresa;
	public Edit 				editCnpj;
	public ArtButton		    btnSalvar;
	public ArtButton		    btnCadastrar;
	public ArtButton 			btnVoltar;

	public AlterarEmpresa() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblInformacao = new Label("ATUALMENTE A EMPRESA CADASTRADA É: ");
			add(lblInformacao);
			lblInformacao.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblInformacao.setBackColor(0x003366);
			lblInformacao.setForeColor(Color.WHITE);
			
			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, lblInformacao);

			add(editEmpresa = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED, lblEmpresa);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);
			editEmpresa.setText("Umbrella");

			lblCnpj = new Label("CNPJ: ");
			add(lblCnpj);
			lblCnpj.setBackColor(0x003366);
			lblCnpj.setForeColor(Color.WHITE);
			lblCnpj.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, editEmpresa);

			add(editCnpj = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED, lblCnpj);
			editCnpj.setBackColor(Color.WHITE);
			editCnpj.setForeColor(0x003366);
			editCnpj.setText("59.291.534/0001-67");
			
			lblUsuario = new Label("USUÁRIO: ");
			add(lblUsuario);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);
			lblUsuario.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
			
			add(editUsuario = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);
			editUsuario.setText("admin");
			
			btnSalvar = new ArtButton("SALVAR");
			add(btnSalvar);
			btnSalvar.setRect(CENTER - 30, AFTER + 50, width - 400, PREFERRED, editUsuario);
			btnSalvar.setBackColor(0x009933);
			btnSalvar.setForeColor(Color.WHITE);
			
			btnCadastrar = new ArtButton("CADASTRAR");
			add(btnCadastrar);
			btnCadastrar.setRect(AFTER + 40, SAME, width - 400, PREFERRED, btnSalvar);
			btnCadastrar.setBackColor(0xd12115);
			btnCadastrar.setForeColor(Color.WHITE);

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
