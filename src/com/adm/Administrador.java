package com.adm;

import com.auxiliares.Auxiliares;
import com.email.Email;
import com.informacao.Informacao;

import nx.componentes.ArtButton;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Administrador extends totalcross.ui.Window {

	private ArtButton		    btnCadastrarProduto;
	private ArtButton 			btnCadastrarDescricao;
	private ArtButton			btnCadastrarMarca;
	private ArtButton			btnCadastrarCategoria;
	private ArtButton 			btnVoltar;

	public Administrador() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {

			btnCadastrarProduto = new ArtButton("CADASTRAR PRODUTO");
			add(btnCadastrarProduto);
			btnCadastrarProduto.setRect(CENTER, TOP + 120, width - 200, PREFERRED + 80);
			btnCadastrarProduto.setBackColor(0x003366);
			btnCadastrarProduto.setForeColor(Color.WHITE);
			
			btnCadastrarMarca = new ArtButton("CADASTRAR MARCA");
			add(btnCadastrarMarca);
			btnCadastrarMarca.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnCadastrarMarca.setBackColor(0x003366);
			btnCadastrarMarca.setForeColor(Color.WHITE);

			btnCadastrarDescricao = new ArtButton("CADASTRAR DESCRIÇÃO");
			add(btnCadastrarDescricao);
			btnCadastrarDescricao.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnCadastrarDescricao.setBackColor(0x003366);
			btnCadastrarDescricao.setForeColor(Color.WHITE);
			
			btnCadastrarCategoria = new ArtButton("CADASTRAR CATEGORIA");
			add(btnCadastrarCategoria);
			btnCadastrarCategoria.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnCadastrarCategoria.setBackColor(0x003366);
			btnCadastrarCategoria.setForeColor(Color.WHITE);

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

				} else if (evt.target == btnCadastrarProduto) {
					CadastrarProdutoSistema cadastrarProdutoSistema = new CadastrarProdutoSistema();
					cadastrarProdutoSistema.popup();
					
				}else if (evt.target == btnCadastrarMarca) {
					CadastrarMarcaSistema cadastrarMarcaSistema = new CadastrarMarcaSistema();
					cadastrarMarcaSistema.popup();
					
				}else if (evt.target == btnCadastrarDescricao) {
					CadastrarDescricaoSistema cadastrarDescricaoSistema = new CadastrarDescricaoSistema();
					cadastrarDescricaoSistema.popup();
					
				}else if (evt.target == btnCadastrarCategoria) {
					CadastrarCategoriaSistema cadastrarCategoriaSistema = new CadastrarCategoriaSistema();
					cadastrarCategoriaSistema.popup();
				}

			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela configuracoes\n" + e);
		}

	}

}
