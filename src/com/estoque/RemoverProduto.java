package com.estoque;

import com.auxiliares.Auxiliares;
import com.litebase.LitebasePack;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class RemoverProduto extends totalcross.ui.Window {

	public Label                lblAviso;
	public Label 				lblProduto;
	public Label 				lblEstoque;
	public Label				lblQuantidade;
	public Label				lblCodigo;
	public Edit					editCodigo;
	public Edit					editQuantidade;
	public Edit					editEstoque;
	public Edit 				editProduto;
	public ArtButton		    btnRemover;
	public ArtButton 			btnVoltar;

	public RemoverProduto() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label(" INSIRA A QUANTIDADE DO PRODUTO\n QUE DESEJA REMOVER DO ESTOQUE:");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			lblProduto = new Label("PRODUTO:      ");
			add(lblProduto);
			lblProduto.setRect(LEFT + 150, AFTER + 70, PREFERRED, PREFERRED, lblAviso);
			lblProduto.setBackColor(0x003366);
			lblProduto.setForeColor(Color.WHITE);

			editProduto = new Edit();
			add(editProduto);
			editProduto.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblProduto);
			editProduto.setBackColor(Color.WHITE);
			editProduto.setForeColor(0x003366);
			editProduto.setEditable(false);
			editProduto.setText(Estoque.produto);
			
			lblCodigo = new Label("CÓDIGO:          ");
			add(lblCodigo);
			lblCodigo.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editProduto);
			lblCodigo.setBackColor(0x003366);
			lblCodigo.setForeColor(Color.WHITE);

			editCodigo = new Edit();
			add(editCodigo);
			editCodigo.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblCodigo);
			editCodigo.setBackColor(Color.WHITE);
			editCodigo.setForeColor(0x003366);
			editCodigo.setEditable(false);
			editCodigo.setText(Estoque.codigo);
			
			lblEstoque = new Label("ESTOQUE:       ");
			add(lblEstoque);
			lblEstoque.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editCodigo);
			lblEstoque.setBackColor(0x003366);
			lblEstoque.setForeColor(Color.WHITE);
			
			editEstoque = new Edit();
			add(editEstoque);
			editEstoque.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblEstoque);
			editEstoque.setBackColor(Color.WHITE);
			editEstoque.setForeColor(0x003366);
			editEstoque.setEditable(false);
			editEstoque.setText(Estoque.quantidade);
			
			lblQuantidade = new Label("QUANTIDADE: ");
			add(lblQuantidade);
			lblQuantidade.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editEstoque);
			lblQuantidade.setBackColor(0x003366);
			lblQuantidade.setForeColor(Color.WHITE);
			
			editQuantidade = new Edit();
			add(editQuantidade);
			editQuantidade.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblQuantidade);
			editQuantidade.setBackColor(Color.WHITE);
			editQuantidade.setForeColor(0x003366);
			
			btnRemover = new ArtButton("REMOVER");
			add(btnRemover);
			btnRemover.setRect(CENTER, AFTER + 50, SCREENSIZE - 4, PREFERRED, editQuantidade);
			btnRemover.setBackColor(0xDF0101);
			btnRemover.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
			editQuantidade.requestFocus();
			
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO","Erro ao construir a tela removerProduto\n" + e);

		}

	}

	public void onEvent(Event evt) {

		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				}
				if (evt.target == btnRemover) {

					if (editQuantidade.getText().equals("")) {
						Auxiliares.artMsgbox("CONTROLE", "Por favor digite uma quantidade!");

						return;

					} else if (Convert.toInt(editQuantidade.getText()) == 0) {
						Auxiliares.artMsgbox("CONTROLE", "Quantidade inválida!");
						editQuantidade.setText("");
						
						return;

					} 
					else if (Convert.toInt(editQuantidade.getText()) > Convert.toInt(Estoque.quantidade)) {
						Auxiliares.artMsgbox("CONTROLE", "Quantidade inserida maior que a quantidade\n em estoque!");
						editQuantidade.setText("");
						
						return;

					} else {

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.artMsgbox("CONTROLE",
								"Deseja remover " + editQuantidade.getText() + " unidade(s) deste produto do estoque?",
								ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							removeProdutoEstoque();

							if (Convert.toInt(editEstoque.getText()) == 0 || Convert.toInt(editEstoque.getText()) < 0) {

								deletaProdutoEstoque();
							}

							Auxiliares.artMsgbox("CONTROLE", "Produto removido do estoque!");

							unpop();
						}
					}
				}
				
				if (editQuantidade.getText().length() == 0) {
					editEstoque.setText(Estoque.quantidade);
				}

				if (editQuantidade.getText().length() > 0) {
					editEstoque.setText("");
					editEstoque.setText(Estoque.quantidade);
					calculaQuantidade();

				}

			}			

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela removerProduto\n" + e);
		}

	}

	public void deletaProdutoEstoque() {
		LitebasePack lb = null;
		String sql = "";

		try {

			try {
				
				lb = new LitebasePack();
				sql = " DELETE FROM ESTOQUE " 
					+ " WHERE CODIGO = " + editCodigo.getText();
					
					lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro deletaProdutoEstoque\n" + e);
		}

	}
	
	public void removeProdutoEstoque() {

		LitebasePack lb = null;
		String sql = "";

		try {

			try {

				lb = new LitebasePack();
				sql = " UPDATE ESTOQUE " 
				    + " SET QUANTIDADE = " + editEstoque.getText() 
				    + " WHERE CODIGO = " + editCodigo.getText();

				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro removeProdutoEstoque\n" + e);
		}

	}
	
	public void calculaQuantidade() {

		try {

			int total = 0;
			total = Convert.toInt(editEstoque.getText()) - Convert.toInt(editQuantidade.getText());
			editEstoque.setText(Convert.toString(total));

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao calcularQuantidade\n" + e);
		}

	}

}
