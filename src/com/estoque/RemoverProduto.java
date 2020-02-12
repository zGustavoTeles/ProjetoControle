package com.estoque;

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
			lblProduto.setRect(LEFT + 150, CENTER - 150, PREFERRED, PREFERRED);
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
				if (evt.target == btnRemover) {

					if (editQuantidade.getText().equals("")) {
						MessageBox msg = new MessageBox("CONTROLE", "Por favor digite\n uma quantidade");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();

						return;

					} else if (Convert.toInt(editQuantidade.getText()) == 0) {
						MessageBox msg = new MessageBox("CONTROLE", "Quantidade inválida");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						editQuantidade.setText("");
						
						return;

					} 
					else if (Convert.toInt(editQuantidade.getText()) > Convert.toInt(Estoque.quantidade)) {
						MessageBox msg = new MessageBox("CONTROLE", "Quantidade inserida maior\n que a quantidade no estoque");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						editQuantidade.setText("");
						
						return;

					} else {
						removeProdutoEstoque();
						
						if (Convert.toInt(editEstoque.getText()) == 0 
								|| Convert.toInt(editEstoque.getText()) < 0) {

							deletaProdutoEstoque();
						}
						
						MessageBox msg = new MessageBox("CONTROLE", "Produto removido\n do estoque");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();

						unpop();
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
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
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
			MessageBox msg = new MessageBox("CONTROLE", "Erro " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
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
			MessageBox msg = new MessageBox("CONTROLE", "Erro " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void calculaQuantidade() {

		try {

			int total = 0;
			total = Convert.toInt(editEstoque.getText()) - Convert.toInt(editQuantidade.getText());
			editEstoque.setText(Convert.toString(total));

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no calculo\n do produto" + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}

}
