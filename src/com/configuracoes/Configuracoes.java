package com.configuracoes;

import com.adm.Administrador;
import com.auxiliares.Auxiliares;
import com.email.Email;
import com.informacao.Informacao;

import nx.componentes.ArtButton;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Configuracoes extends totalcross.ui.Window {

	private ArtButton		    btnInformacoes;
	private ArtButton 			btnApagarDados;
	private ArtButton			btnConfigEmpresa;
	private ArtButton			btnSuporte;
	private ArtButton			btnAdministrador;
	private ArtButton 			btnVoltar;

	public Configuracoes() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {

			btnInformacoes = new ArtButton("INFORMAÇÕES");
			add(btnInformacoes);
			btnInformacoes.setRect(CENTER, TOP + 60, width - 200, PREFERRED + 80);
			btnInformacoes.setBackColor(0x003366);
			btnInformacoes.setForeColor(Color.WHITE);
			
			btnConfigEmpresa = new ArtButton("EMPRESA");
			add(btnConfigEmpresa);
			btnConfigEmpresa.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnConfigEmpresa.setBackColor(0x003366);
			btnConfigEmpresa.setForeColor(Color.WHITE);

			btnApagarDados = new ArtButton("APAGAR DADOS");
			add(btnApagarDados);
			btnApagarDados.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnApagarDados.setBackColor(0x003366);
			btnApagarDados.setForeColor(Color.WHITE);
			
			btnSuporte = new ArtButton("SUPORTE");
			add(btnSuporte);
			btnSuporte.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnSuporte.setBackColor(0x003366);
			btnSuporte.setForeColor(Color.WHITE);
			
			btnAdministrador = new ArtButton("ADMINISTRADOR");
			add(btnAdministrador);
			btnAdministrador.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnAdministrador.setBackColor(0x003366);
			btnAdministrador.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO","Erro ao construir a tela configuracoes\n" + e);

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
					ApagarDados apagarDados = new ApagarDados();
					apagarDados.popup();
					
				} else if (evt.target == btnConfigEmpresa) {
					InfoEmpresa alterarEmpresa = new InfoEmpresa();
					alterarEmpresa.popup();
					
				}else if (evt.target == btnSuporte) {
					Email email = new Email();
					email.popup();
					
				}else if (evt.target == btnAdministrador) {
					Administrador administrador = new Administrador();
					administrador.popup();
				}

			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela configuracoes\n" + e);
		}

	}

}
