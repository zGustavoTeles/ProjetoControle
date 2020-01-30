package com.adm;


import nx.componentes.ArtButton;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Administrador extends totalcross.ui.Window {

	private ArtButton		    btnCadastrarEmpresa;
	private ArtButton 			btnApagarEmpresa;
	private ArtButton			btnEscolherEmpresa;
	private ArtButton 			btnVoltar;

	public Administrador() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {

			btnCadastrarEmpresa = new ArtButton("CADASTRAR EMPRESA");
			add(btnCadastrarEmpresa);
			btnCadastrarEmpresa.setRect(CENTER, TOP + 150, width - 200, PREFERRED + 80);
			btnCadastrarEmpresa.setBackColor(0x003366);
			btnCadastrarEmpresa.setForeColor(Color.WHITE);
			
			btnEscolherEmpresa = new ArtButton("ESCOLHER EMPRESA");
			add(btnEscolherEmpresa);
			btnEscolherEmpresa.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnEscolherEmpresa.setBackColor(0x003366);
			btnEscolherEmpresa.setForeColor(Color.WHITE);

			btnApagarEmpresa = new ArtButton("APAGAR EMPRESA");
			add(btnApagarEmpresa);
			btnApagarEmpresa.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnApagarEmpresa.setBackColor(0x003366);
			btnApagarEmpresa.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!", "Erro ao carregar a Tela");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x363636);
			msg.popup();

		}

	}

	public void onEvent(Event evt) {

		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				}else if (evt.target == btnCadastrarEmpresa) {
					CadastrarEmpresa cadastrarEmpresa = new CadastrarEmpresa();
					cadastrarEmpresa.popup();
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
