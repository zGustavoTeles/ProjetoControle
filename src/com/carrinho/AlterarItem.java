package com.carrinho;

import java.util.Random;

import com.auxiliares.Auxiliares;
import com.litebase.LitebasePack;
import com.teclado.Teclado;
import com.venda.Venda;
import totalcross.ui.ComboBox;
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

public class AlterarItem extends totalcross.ui.Window {

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
	private ArtButton 			 btnAlterar;
	private ArtButton 			 btnVoltar;
	private ComboBox			 cmbTipoPagamento;
	
	public double 				 valorProduto = 0.0;
	public double				 total = 0.0;
	public int				     qntEstoqueFinal = 0;
	public int 				     quantidade = 0;
	public int 					 quantidadeEstoque = 0;
	public int 					 qntEstoqueCalculo = 0;
	public String 				 quantidadeVendida = "";
	public String 				 dataEntrada = "";
	public String				 estoque = "";
	public String 				 quantidadeInserida = "";
	
	public String				valorTemp = "";
	public int					quantidadeTemp = 0;

	public Teclado teclado;

	public AlterarItem() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblCategoria = new Label("CATEGORIA:   ");
			add(lblCategoria);
			lblCategoria.setRect(LEFT + 150, CENTER - 280, PREFERRED, PREFERRED);
			lblCategoria.setBackColor(0x003366);
			lblCategoria.setForeColor(Color.WHITE);

			editCategoria = new Edit();
			add(editCategoria);
			editCategoria.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblCategoria);
			editCategoria.setBackColor(0x003366);
			editCategoria.setForeColor(Color.WHITE);
			editCategoria.setEnabled(false);
			
			lblMarca = new Label("MARCA:          ");
			add(lblMarca);
			lblMarca.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editCategoria);
			lblMarca.setBackColor(0x003366);
			lblMarca.setForeColor(Color.WHITE);

			editMarca = new Edit();
			add(editMarca);
			editMarca.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblMarca);
			editMarca.setBackColor(0x003366);
			editMarca.setForeColor(Color.WHITE);
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
			editQuantidade.setValidChars("0 1 2 3 4 5 6 7 8 9");
			editQuantidade.setText(Carrinho.quantidadeProduto);

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
			editTotal.setText(Carrinho.totalProduto);
			editTotal.setEnabled(false);
			
			cmbTipoPagamento = new ComboBox();
			add(cmbTipoPagamento);
			cmbTipoPagamento.setRect(LEFT + 150, AFTER + 15, FILL - 140, PREFERRED, editTotal);

			btnAlterar = new ArtButton("ALTERAR");
			add(btnAlterar);
			btnAlterar.setRect(CENTER, AFTER + 50, SCREENSIZE - 5, PREFERRED + 13, cmbTipoPagamento);
			btnAlterar.setBackColor(0x009933);
			btnAlterar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
			carregaCmbTipoPagamento();
			
			if (Carrinho.tipoPagamentoProduto.equals("DINHEIRO")) {
				cmbTipoPagamento.setSelectedIndex(0);
			} else {
				cmbTipoPagamento.setSelectedIndex(1);
			}
			
			carregaInfoItem();
			
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO","Erro ao construir a tela alterarItem\n" + e);

		}

	}

	public void onEvent(Event evt) {

		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				}
				
				if (evt.target == btnAlterar) {

					if (editQuantidade.getText().length() == 0) {
						Auxiliares.artMsgbox("CONTROLE", "Por favor insira uma quantidade!");
						return;
					}

					if (editQuantidade.getText().length() > 0) {

						estoque = editEstoque.getText();
						quantidadeInserida = editQuantidade.getText();

						if (Convert.toInt(quantidadeInserida) > quantidadeTemp) {
							Auxiliares.artMsgbox("CONTROLE",
									"Quantidade inserida maior que a quantidade\n em estoque!");
							return;

						}

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.artMsgbox("CONTROLE", "Deseja alterar o item?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							insereProdutoNoCarrinho();

							Auxiliares.artMsgbox("CONTROLE", "Produto inserido no carrinho!");

							unpop();
							unpop();
						}
					}

				}
				if (editQuantidade.getText().length() > 0) {
					calculaTotalProduto();

				} else if (editQuantidade.getText().length() == 0) {
					editEstoque.setText(Convert.toString(quantidadeTemp));
					editTotal.setText("");
				}
			}
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela alterarItem\n" + e);
		}

	}

	public void calculaTotalProduto() {

		try {

			estoque = Convert.toString(quantidadeTemp);
			quantidadeInserida = editQuantidade.getText();
			qntEstoqueFinal = Convert.toInt(estoque) - Convert.toInt(quantidadeInserida);

			String quantidadeString = "";
			quantidadeString = editQuantidade.getText();
			valorProduto = Convert.toDouble(valorTemp.replace(".", "."));
			quantidade = Convert.toInt(quantidadeString);

			total = valorProduto * quantidade;
			editTotal.setText(Convert.toString(total, 2));
			editEstoque.setText(Convert.toString(qntEstoqueFinal));

		} catch (Exception e) {
			Auxiliares.artMsgbox("CONTROLE", "Erro no calculo do produto" + e);
		}

	}
	
	public void insereProdutoNoCarrinho() {

		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				
				lb = new LitebasePack();
				
				sql = "SELECT CODIGO, CODIGOPROD FROM VENDAPRODUTOTEMP";
				rs = lb.executeQuery(sql);
				rs.first();
									
					int codigo = rs.getInt("CODIGO");
					int codigoProduto = rs.getInt("CODIGOPROD");
					
					sql = "DELETE VENDAPRODUTOTEMP "
						+ " WHERE CODIGOPROD = " + codigoProduto;
					
					lb.executeUpdate(sql);

					String dataVenda;
					Date year = new Date();
					Date month = new Date();
					Date day = new Date();

					dataVenda = Date.formatDate(year.getYear(), month.getMonth(), day.getDay());

					sql = "INSERT INTO VENDAPRODUTOTEMP " + "(" + " CODIGO, PRODUTO, VALOR, QUANTIDADE, CODIGOPROD, "
							+ " CATEGORIA, MARCA, DESCRICAO, TIPOPAGAMENTO, DATASAIDA " + ")" + " VALUES " 
							+ "( '" + codigo + "' , '" + editProduto.getText()
	                        + "', '" + editTotal.getText() + "', '"
							+ editQuantidade.getText() + "', '" + editCodigo.getText() + "','" + editCategoria.getText() + "','" 
							+ editMarca.getText() + "', '"+ editDescricao.getText() 
							+ "', '" + cmbTipoPagamento.getSelectedItem() + "', '" + dataVenda + "'" + ")";

					lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro insereProdutoNoCarrinho\n" + e);
		}

	}
	
	public void carregaCmbTipoPagamento() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM TIPOPAGAMENTO";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbTipoPagamento.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.artMsgbox("ERRO", "Erro carregaCmbTipoPagamento\n" + e);

			}

		}
	}
	
	public void carregaInfoItem() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				lb = new LitebasePack();
				sql = " SELECT * FROM ESTOQUE " 
				    + " WHERE CODIGO = " + Carrinho.codigoProduto;

				rs = lb.executeQuery(sql);
				rs.first();

				editCategoria.setText(rs.getString("CATEGORIA"));
				editCodigo.setText(Convert.toString(rs.getInt("CODIGO")));
				editDescricao.setText(rs.getString("DESCRICAO"));
				editEstoque.setText(Convert.toString(rs.getInt("QUANTIDADE")));
				editMarca.setText(rs.getString("MARCA"));
				editProduto.setText(rs.getString("PRODUTO"));
				editValor.setText(rs.getString("VALOR"));

				valorTemp = rs.getString("VALOR");
				quantidadeTemp = rs.getInt("QUANTIDADE");

			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro carregaInfoItem\n" + e);

		}

	}

}
