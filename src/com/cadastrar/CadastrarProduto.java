package com.cadastrar;


import java.util.Random;

import com.auxiliares.Auxiliares;
import com.litebase.LitebasePack;

import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.ui.ComboBox;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class CadastrarProduto extends totalcross.ui.Window{
	
	private Label 							lblCategoria;
	private Label							lblProduto;
	private Label							lblMarca;
	private Label							lblDescricao;
	private Label							lblQuantidade;
	private Label							lblValor;
	private ComboBox						cmbCategoria;
	private ComboBox						cmbProduto;
	private ComboBox						cmbMarca;
	private ComboBox						cmbDescricao;
	private Edit                            editQuantidade;
	private Edit 							editValor;
	private ArtButton						btnCadastrar;
	private ArtButton 						btnVoltar;
	private ImageControl					imgAdicionar;

	public CadastrarProduto() {
		setBackColor(0x003366);
		initUI();
		carregaCmbCategoria();
		carregaCmbDescricao();
	}
	
	public void initUI() {
		
		try {
			
			imgAdicionar = new ImageControl(new Image("img/adicionar.png"));
			imgAdicionar.scaleToFit = true;
			imgAdicionar.centerImage = true;
			add(imgAdicionar, CENTER, TOP + 5, PREFERRED, PREFERRED);
			
			lblCategoria = new Label("CATEGORIA:");
			add(lblCategoria);
			lblCategoria.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, imgAdicionar);
			lblCategoria.setBackColor(0x003366);
			lblCategoria.setForeColor(Color.WHITE);
			
			cmbCategoria = new ComboBox();
			add(cmbCategoria);
			cmbCategoria.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblCategoria);
			
			lblProduto = new Label("PRODUTO:");
			add(lblProduto);
			lblProduto.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, cmbCategoria);
			lblProduto.setBackColor(0x003366);
			lblProduto.setForeColor(Color.WHITE);
			
			cmbProduto = new ComboBox();
			add(cmbProduto);
			cmbProduto.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblProduto);
			
			lblMarca = new Label("MARCA:");
			add(lblMarca);
			lblMarca.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, cmbProduto);
			lblMarca.setBackColor(0x003366);
			lblMarca.setForeColor(Color.WHITE);
						
			cmbMarca = new ComboBox();			
			add(cmbMarca);
			cmbMarca.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblMarca);	
			
			lblDescricao = new Label("DESCRIÇÃO: ");
			add(lblDescricao);
			lblDescricao.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, cmbMarca);
			lblDescricao.setForeColor(Color.WHITE);
			lblDescricao.setBackColor(0x003366);
			
			cmbDescricao = new ComboBox();			
			add(cmbDescricao);
			cmbDescricao.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblDescricao);
			
			lblQuantidade = new Label("QUANTIDADE: ");
			add(lblQuantidade);
			lblQuantidade.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, cmbDescricao);
			lblQuantidade.setForeColor(Color.WHITE);
			lblQuantidade.setBackColor(0x003366);
			
			editQuantidade = new Edit();			
			add(editQuantidade);
			editQuantidade.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblQuantidade);
			editQuantidade.setBackColor(Color.WHITE);
			editQuantidade.setForeColor(0x003366);
			editQuantidade.setValidChars("0 1 2 3 4 5 6 7 8 9");
			
			lblValor = new Label("VALOR: ");
			add(lblValor);
			lblValor.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, editQuantidade);
			lblValor.setForeColor(Color.WHITE);
			lblValor.setBackColor(0x003366);
			
			editValor = new Edit();			
			add(editValor);
			editValor.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblValor);
			editValor.setBackColor(Color.WHITE);
			editValor.setForeColor(0x003366);
			editValor.setValidChars("0 1 2 3 4 5 6 7 8 9 .");

			btnCadastrar = new ArtButton("CADASTRAR");
	        add(btnCadastrar);
	        btnCadastrar.setRect(LEFT - 2, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
	        btnCadastrar.setBackColor(0x009933);
	        btnCadastrar.setForeColor(Color.WHITE);
					    
			btnVoltar = new ArtButton("VOLTAR");
	        add(btnVoltar);
	        btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
	        btnVoltar.setBackColor(0x003366);
	        btnVoltar.setForeColor(Color.WHITE);
	        
	        reposition();
	        
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao construir a tela cadastrarProduto\n" + e);

		}
		
	}
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnCadastrar) {

					if (!editQuantidade.getText().equals("") && cmbCategoria.getSelectedItem() != null
							&& cmbMarca.getSelectedItem() != null && cmbProduto.getSelectedItem() != null) {

						if (editValor.getText().equals(".0") || editValor.getText().equals(".1")
								|| editValor.getText().equals(".2") || editValor.getText().equals(".3")
								|| editValor.getText().equals(".4") || editValor.getText().equals(".5")
								|| editValor.getText().equals(".6") || editValor.getText().equals(".7")
								|| editValor.getText().equals(".8") || editValor.getText().equals(".9")) {

							Auxiliares.artMsgbox("CONTROLE",
									"Valor inserido incorreto!\n tente '2.23', por exemplo... ");
							return;
						}

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.artMsgbox("CONTROLE", "Deseja cadastrar o produto no estoque?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							cadastrarProdutoNoEstoque();

							Auxiliares.artMsgbox("CONTROLE", "Produto cadastrado no estoque!");
						}

					} else {
						Auxiliares.artMsgbox("CONTROLE", "Preencha todos os campos!");
					}

				} else if (evt.target == cmbCategoria) {
					cmbMarca.removeAll();
					cmbProduto.removeAll();
					carregaCmbMarca();
					carregaCmbProduto();

				}

			}
			
		}catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela cadastrarProduto\n" + e);
			}
			
			
		}

	public void cadastrarProdutoNoEstoque() {
		String sql = "";
		LitebasePack lb = null;

		try {
			Random random = new Random();
			int codigo = random.nextInt(900);
			String dataEntrada;
			Date year = new Date();
			Date month = new Date();
			Date day = new Date();

			dataEntrada = Date.formatDate(year.getYear(), month.getMonth(), day.getDay());

			lb = new LitebasePack();

			sql = "INSERT INTO ESTOQUE " + "(" + " CODIGO, PRODUTO, VALOR, QUANTIDADE, CATEGORIA, MARCA, DESCRICAO,"
					+ " DATAENTRADA " + ")" + " VALUES " + "( '" + codigo + "' , '" + cmbProduto.getSelectedItem()
					+ "', '" + editValor.getText() + "', '" + editQuantidade.getText() + "', '"
					+ cmbCategoria.getSelectedItem() + "', '" + cmbMarca.getSelectedItem() + "', '"
					+ cmbDescricao.getSelectedItem() + "', '" + dataEntrada + "'" + ")";

			lb.executeUpdate(sql);

			cmbProduto.removeAll();
			cmbMarca.removeAll();
			cmbCategoria.removeAll();
			cmbDescricao.removeAll();
			editQuantidade.clear();
			editValor.clear();

			carregaCmbCategoria();
			carregaCmbDescricao();
			carregaCmbMarca();
			carregaCmbProduto();

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao cadastrarProdutoNoEstoque\n" + e);
			return;
		}

	}
	
	public void carregaCmbProduto() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT PRODUTO, CATEGORIA FROM PRODUTO "
						+ " WHERE CATEGORIA = " + "'" + cmbCategoria.getSelectedItem() + "'";;

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("PRODUTO");
						cmbProduto.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.artMsgbox("ERRO", "Erro ao carregaCmbProduto\n" + e);

			}

		}
	}
	
	public void carregaCmbCategoria() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					cmbCategoria.removeAll();
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM CATEGORIA";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbCategoria.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.artMsgbox("ERRO", "Erro ao carregaCmbCategoria\n" + e);

			}

		}
	}
	
	public void carregaCmbMarca() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO, CATEGORIA FROM MARCA "
						+ " WHERE CATEGORIA = " + "'" + cmbCategoria.getSelectedItem() + "'";;

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbMarca.add(b);
						rs.next();
					} 
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.artMsgbox("ERRO", "Erro ao carregaCmbMarca\n" + e);

			}

		}
	}
	
	public void carregaCmbDescricao() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM DESCRICAO ";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbDescricao.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.artMsgbox("ERRO", "Erro ao carregaCmbDescricao\n" + e);

			}

		}
	}
	
	public static String completNumber(int arg, int len) throws Exception {
		return completNumber(Convert.toString(arg), len);
	}

	public static String completNumber(String arg, int len) throws Exception {
		String result = "";
		if (arg == null)
			arg = "";

		if (arg.length() > len)
			arg = arg.substring(0, len);

		for (int x = 0; x < len - arg.length(); x++)
			result += "0";

		result = result + arg;
		return result;
	}

	public static int getDataInt(String formato) throws Exception {
		Date data = new Date();
		String dataFormatada = "";

		if (formato.equalsIgnoreCase("ddmmyyyy"))
			dataFormatada = completNumber(data.getDay(), 2) + completNumber(data.getMonth(), 2)
					+ Convert.toString(data.getYear());
		
		else if (formato.equalsIgnoreCase("yyyymmdd"))
			dataFormatada = Convert.toString(data.getYear()) +completNumber(data.getMonth(), 2)
					+ completNumber(data.getDay(), 2);

		return Convert.toInt(dataFormatada);
	}
	
}
