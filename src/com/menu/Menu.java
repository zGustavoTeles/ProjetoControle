package com.menu;

import com.adicionar.Adicionar;
import com.configuracoes.Configuracoes;
import com.estoque.Estoque;
import com.relatorio.Relatorio;
import com.venda.Venda;
import nx.componentes.ArtButton;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Menu extends totalcross.ui.Window {
	
	private ArtButton			 btnVenda;
	private ArtButton 		     btnAdicionar;
	private ArtButton		     btnEstoque;
	private ArtButton    		 btnRelatorio;
	private ArtButton 			 btnConfiguracao;
	private ArtButton			 btnVoltar;

	public Menu() {
		setBackColor(0x003366);
		initUI();

	}

	public void initUI() {

		try {

			btnVenda = new ArtButton("VENDA");
			add(btnVenda);
			btnVenda.setRect(CENTER, TOP + 20, width - 200, PREFERRED + 80);
			btnVenda.setBackColor(0x003366);
			btnVenda.setForeColor(Color.WHITE);

			btnAdicionar = new ArtButton("ADICIONAR");
			add(btnAdicionar);
			btnAdicionar.setBackColor(0x003366);
			btnAdicionar.setForeColor(Color.WHITE);
			btnAdicionar.setRect(CENTER, AFTER + 10, width - 200, PREFERRED + 80, btnVenda);

			btnEstoque = new ArtButton("ESTOQUE");
			add(btnEstoque);
			btnEstoque.setBackColor(0x003366);
			btnEstoque.setForeColor(Color.WHITE);
			btnEstoque.setRect(CENTER, AFTER + 10, width - 200, PREFERRED + 80, btnAdicionar);

			btnRelatorio = new ArtButton("RELATÓRIO");
			add(btnRelatorio);
			btnRelatorio.setBackColor(0x003366);
			btnRelatorio.setForeColor(Color.WHITE);
			btnRelatorio.setRect(CENTER, AFTER + 10, width - 200, PREFERRED + 80, btnEstoque);

			btnConfiguracao = new ArtButton("CONFIGURAÇÃO");
			add(btnConfiguracao);
			btnConfiguracao.setBackColor(0x003366);
			btnConfiguracao.setForeColor(Color.WHITE);
			btnConfiguracao.setRect(CENTER, AFTER + 10, width - 200, PREFERRED + 80, btnRelatorio);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			btnVoltar.setRect(CENTER, AFTER + 10, width - 200, PREFERRED + 80, btnConfiguracao);

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

				if (evt.target == btnVenda) {
					Venda personagens = new Venda();
					personagens.popup();

				} else if (evt.target == btnAdicionar) {
					Adicionar cartas = new Adicionar();
					cartas.popup();

				} else if (evt.target == btnEstoque) {
					Estoque estoque = new Estoque();
					estoque.popup();

				} else if (evt.target == btnRelatorio) {
					Relatorio relatorio = new Relatorio();
					relatorio.popup();

				} else if (evt.target == btnConfiguracao) {
					Configuracoes configuracoes = new Configuracoes();
					configuracoes.popup();

				} else if (evt.target == btnVoltar) {
					unpop();
				}

			}
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
}
