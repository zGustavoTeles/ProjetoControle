package com.adm;

import nx.componentes.ArtButton;
import principal.Home;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class ValidaAdm extends totalcross.ui.Window {

	public Label                lblAviso;
	public Label 				lblAdm;
	public Label 				lblSenha;
	public Edit 				editAdm;
	public Edit 				editSenha;
	public ArtButton		    btnEntrar;
	public ArtButton 			btnVoltar;

	public ValidaAdm() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("POR FAVOR INSIRA O ADMINISTRADOR\n E A SENHA PARA ENTRAR NO SISTEMA\n COMO ADM");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			lblAdm = new Label("USUÁRIO:   ");
			add(lblAdm);
			lblAdm.setRect(LEFT + 150, CENTER - 100, PREFERRED, PREFERRED);
			lblAdm.setBackColor(0x003366);
			lblAdm.setForeColor(Color.WHITE);

			editAdm = new Edit();
			add(editAdm);
			editAdm.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblAdm);
			editAdm.setBackColor(Color.WHITE);
			editAdm.setForeColor(0x003366);

			lblSenha = new Label("SENHA:       ");
			add(lblSenha);
			lblSenha.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editAdm);
			lblSenha.setBackColor(0x003366);
			lblSenha.setForeColor(Color.WHITE);
			
			editSenha = new Edit();
			editSenha.setMode(TAB_ONLY_BORDER);
			add(editSenha);
			editSenha.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblSenha);
			editSenha.setBackColor(Color.WHITE);
			editSenha.setForeColor(0x003366);

			btnEntrar = new ArtButton("ENTRAR");
			add(btnEntrar);
			btnEntrar.setRect(CENTER, AFTER + 50, SCREENSIZE - 5, PREFERRED, editSenha);
			btnEntrar.setBackColor(0x009933);
			btnEntrar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao carregar a Tela");
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
				if (evt.target == btnEntrar) {
					if (editAdm.getText().equals("admin") && editSenha.getText().equals("admin")) {
						Administrador adm = new Administrador();
						adm.popup();
						
					} else if (editAdm.getText().equals("") || editSenha.getText().equals(" ")) {
						MessageBox msg = new MessageBox("CONTROLE", "Todos os campos devem\n ser preenchidos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						editSenha.setText("");
						editAdm.setText("");

					} else {
						MessageBox msg = new MessageBox("CONTROLE", "Administrador ou senha incorretos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						editSenha.setText("");
						editAdm.setText("");
					}
				}

			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}

}
