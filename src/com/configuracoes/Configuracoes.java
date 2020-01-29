package com.configuracoes;

import com.informacao.Informacao;

import nx.componentes.ArtButton;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Configuracoes extends totalcross.ui.Window {

	private ArtButton		    btnInformacoes;
	private ArtButton 			btnApagarDados;
	private ArtButton			btnConfiguracaoUsuario;
	private ArtButton 			btnVoltar;

	public Configuracoes() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {

			btnInformacoes = new ArtButton("INFORMA��ES");
			add(btnInformacoes);
			btnInformacoes.setRect(CENTER, TOP + 150, width - 200, PREFERRED + 80);
			btnInformacoes.setBackColor(0x003366);
			btnInformacoes.setForeColor(Color.WHITE);
			
			btnConfiguracaoUsuario = new ArtButton("CONFIG. USU�RIO");
			add(btnConfiguracaoUsuario);
			btnConfiguracaoUsuario.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnConfiguracaoUsuario.setBackColor(0x003366);
			btnConfiguracaoUsuario.setForeColor(Color.WHITE);

			btnApagarDados = new ArtButton("APAGAR DADOS");
			add(btnApagarDados);
			btnApagarDados.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnApagarDados.setBackColor(0x003366);
			btnApagarDados.setForeColor(Color.WHITE);

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

				} else if (evt.target == btnInformacoes) {
					Informacao informacao = new Informacao();
					informacao.popup();

				} else if (evt.target == btnApagarDados) {
					VerificaDados verificaDados = new VerificaDados();
					verificaDados.popup();
					
				} else if (evt.target == btnConfiguracaoUsuario) {
					ConfigUsuario configUsuario = new ConfigUsuario();
					configUsuario.popup();
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
