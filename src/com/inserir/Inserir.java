package com.inserir;

import java.util.Random;

import com.litebase.LitebasePack;
import com.sun.glass.events.KeyEvent;
import com.teclado.Teclado;
import com.venda.Venda;

import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.util.Date;

public class Inserir extends totalcross.ui.Window {

	private Label				 lblProduto;
	private Label 				 lblEstoque;
	private Label 			     lblValor;
	private Label 				 lblQuantidade;
	private Label				 lblTotal;
	private Label   			 lblCodigo;
	private Label				 lblCategoria;
	private Label 				 lblMarca;
	private Label 				 lblDescricao;
	private Edit				 editCategoria;
	private Edit				 editMarca;
	private Edit				 editDescricao;
	private Edit 				 editCodigo;
	private Edit 				 editProduto;
	private Edit 				 editEstoque;
	private Edit 				 editValor;
	private Edit				 editQuantidade;
	private Edit 				 editTotal;
	private ArtButton 			 btnVender;
	private ArtButton 			 btnVoltar;

	public double 				 valorProduto = 0.0;
	public double				 total = 0.0;
	public int 				     quantidade = 0;
	public int 					 quantidadeEstoque = 0;
	public int 					 qntEstoqueCalculo = 0;
	public String 				 quantidadeVendida = "";
	public String 				 dataEntrada = "";
	public String				 estoque = "";
	public String 				 quantidadeInserida = "";

	public Teclado teclado;

	public Inserir() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblCategoria = new Label("CATEGORIA:   ");
			add(lblCategoria);
			lblCategoria.setRect(LEFT + 150, CENTER - 250, PREFERRED, PREFERRED);
			lblCategoria.setBackColor(0x003366);
			lblCategoria.setForeColor(Color.WHITE);

			editCategoria = new Edit();
			add(editCategoria);
			editCategoria.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblCategoria);
			editCategoria.setBackColor(0x003366);
			editCategoria.setForeColor(Color.WHITE);
			editCategoria.setText(Venda.categoria);
			editCategoria.setEnabled(false);
			
			lblMarca = new Label("MARCA:           ");
			add(lblMarca);
			lblMarca.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editCategoria);
			lblMarca.setBackColor(0x003366);
			lblMarca.setForeColor(Color.WHITE);

			editMarca = new Edit();
			add(editMarca);
			editMarca.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblMarca);
			editMarca.setBackColor(0x003366);
			editMarca.setForeColor(Color.WHITE);
			editMarca.setText(Venda.marca);
			editMarca.setEnabled(false);
			
			lblDescricao = new Label("DESCRICAO:   ");
			add(lblDescricao);
			lblDescricao.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editMarca);
			lblDescricao.setBackColor(0x003366);
			lblDescricao.setForeColor(Color.WHITE);

			editDescricao = new Edit();
			add(editDescricao);
			editDescricao.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblDescricao);
			editDescricao.setBackColor(0x003366);
			editDescricao.setForeColor(Color.WHITE);
			editDescricao.setText(Venda.descricao);
			editDescricao.setEnabled(false);		

			lblProduto = new Label("PRODUTO:      ");
			add(lblProduto);
			lblProduto.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editDescricao);
			lblProduto.setBackColor(0x003366);
			lblProduto.setForeColor(Color.WHITE);

			editProduto = new Edit();
			add(editProduto);
			editProduto.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblProduto);
			editProduto.setBackColor(0x003366);
			editProduto.setForeColor(Color.WHITE);
			editProduto.setText(Venda.produto);
			editProduto.setEnabled(false);

			lblCodigo = new Label("CÓDIGO:          ");
			add(lblCodigo);
			lblCodigo.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editProduto);
			lblCodigo.setBackColor(0x003366);
			lblCodigo.setForeColor(Color.WHITE);

			editCodigo = new Edit();
			add(editCodigo);
			editCodigo.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblCodigo);
			editCodigo.setBackColor(0x003366);
			editCodigo.setForeColor(Color.WHITE);
			editCodigo.setText(Venda.codigo);
			editCodigo.setEnabled(false);

			lblEstoque = new Label("ESTOQUE:       ");
			add(lblEstoque);
			lblEstoque.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editCodigo);
			lblEstoque.setBackColor(0x003366);
			lblEstoque.setForeColor(Color.WHITE);

			editEstoque = new Edit();
			add(editEstoque);
			editEstoque.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblEstoque);
			editEstoque.setBackColor(0x003366);
			editEstoque.setForeColor(Color.WHITE);
			editEstoque.setText(Venda.quantidade);
			editEstoque.setEnabled(false);

			lblQuantidade = new Label("QUANTIDADE: ");
			add(lblQuantidade);
			lblQuantidade.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, lblEstoque);
			lblQuantidade.setBackColor(0x003366);
			lblQuantidade.setForeColor(Color.WHITE);

			editQuantidade = new Edit();
			editQuantidade.setMode(BORDER_LOWERED);
			add(editQuantidade);
			editQuantidade.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblQuantidade);
			editQuantidade.setBackColor(Color.WHITE);
			editQuantidade.setForeColor(0x003366);
			editQuantidade.setText("1");

			lblValor = new Label("VALOR:            ");
			add(lblValor);
			lblValor.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, lblQuantidade);
			lblValor.setBackColor(0x003366);
			lblValor.setForeColor(Color.WHITE);

			editValor = new Edit();
			add(editValor);
			editValor.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblValor);
			editValor.setBackColor(0x003366);
			editValor.setForeColor(Color.WHITE);
			editValor.setText(Venda.valor);
			editValor.setEnabled(false);

			lblTotal = new Label("TOTAL:            ");
			add(lblTotal);
			lblTotal.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editValor);
			lblTotal.setBackColor(0x003366);
			lblTotal.setForeColor(Color.WHITE);

			editTotal = new Edit();
			add(editTotal);
			editTotal.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblTotal);
			editTotal.setBackColor(0x003366);
			editTotal.setForeColor(Color.WHITE);
			editTotal.setText(Venda.valor + "$");
			editTotal.setEnabled(false);

			btnVender = new ArtButton("VENDER");
			add(btnVender);
			btnVender.setRect(CENTER, AFTER + 50, width - 300, PREFERRED, editTotal);
			btnVender.setBackColor(0x009933);
			btnVender.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
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
				if (evt.target == btnVender) {

					if (editQuantidade.getText().length() == 0) {
						MessageBox msg = new MessageBox("CONTROLE", "Por favor insira\n uma quantidade");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						return;
					}

					if (editQuantidade.getText().length() > 0) {

						estoque = editEstoque.getText();
						quantidadeInserida = editQuantidade.getText();

						if (Convert.toInt(quantidadeInserida) > Convert.toInt(estoque)) {
							MessageBox msg = new MessageBox("CONTROLE",
									"Quantidade inserida\n maior que o limite\n do estoque ");
							msg.setBackColor(Color.WHITE);
							msg.setForeColor(0x003366);
							msg.popup();
							return;

						}

						efetuaVenda();
						baixaEstoque();

						MessageBox msg = new MessageBox("CONTROLE!", "Venda efetuada com sucesso ");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();

						unpop();
					}

				}
				if (editQuantidade.getText().length() > 0) {
					calculaTotalProduto();

				}
			}
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}

	public void calculaTotalProduto() {

		try {

			String quantidadeString = "";
			quantidadeString = editQuantidade.getText();
			valorProduto = Convert.toDouble(Venda.valor.replace(",", "."));
			quantidade = Convert.toInt(quantidadeString);

			total = valorProduto * quantidade;
			editTotal.setText( Convert.toCurrencyString(total, 2) + " $$");

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no calculo\n do produto" + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void efetuaVenda() {

		String sql = "";
		LitebasePack lb = null;

		try {
			try {
				Random random = new Random();
				int codigo = random.nextInt(900);
				String dataVenda;
				Date year = new Date();
				Date month = new Date();
				Date day = new Date();

				dataVenda = Date.formatDate(year.getYear(), month.getMonth(), day.getDay());

				lb = new LitebasePack();

				sql = "INSERT INTO VENDAPRODUTO " + "(" + " CODIGO, PRODUTO, MARCA, VALOR, QUANTIDADE, " + " DATAVENDA "
						+ ")" + " VALUES " + "( '" + codigo + "' , '" + editProduto.getText() + "', '"
						+ editMarca.getText() + "', '" + editTotal.getText() + "', '" + editQuantidade.getText()
						+ "', '" + dataVenda + "'" + ")";

				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao inserir\n produto ao estoque");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void baixaEstoque() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();

				sql = "SELECT QUANTIDADE, CODIGO, DATAENTRADA FROM ESTOQUE " + " WHERE CODIGO = "
						+ editCodigo.getText();
				rs = lb.executeQuery(sql);

				qntEstoqueCalculo = rs.getInt("QUANTIDADE");
				dataEntrada = rs.getString("DATAENTRADA");
				quantidadeVendida = editQuantidade.getText();

				quantidadeEstoque = qntEstoqueCalculo - Convert.toInt(quantidadeVendida);

				Date year = new Date();
				Date month = new Date();
				Date day = new Date();
				dataEntrada = Date.formatDate(year.getYear(), month.getMonth(), day.getDay());

				sql = "DELETE FROM ESTOQUE WHERE CODIGO = " + editCodigo.getText();

				lb.executeUpdate(sql);

				sql = "INSERT INTO ESTOQUE " + "(" + " CODIGO, PRODUTO, VALOR, QUANTIDADE, CATEGORIA, MARCA, DESCRICAO,"
						+ " DATAENTRADA " + ")" + " VALUES " + "( '" + editCodigo.getText() + "' , '"
						+ editProduto.getText() + "', '" + editValor.getText() + "', '" + quantidadeEstoque + "', '"
						+ editCategoria.getText() + "', '" + editMarca.getText() + "', '" + editDescricao.getText()
						+ "', '" + dataEntrada + "'" + ")";

				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao dar\n baixa no estoque");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}
	}

}
