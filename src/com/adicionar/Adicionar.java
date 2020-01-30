package com.adicionar;


import java.util.Random;

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
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class Adicionar extends totalcross.ui.Window{
	
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
	private ArtButton						btnAdicionar;
	private ArtButton 						btnVoltar;
	private ImageControl					imgAdicionar;

	public Adicionar(){
		 setBackColor(0x003366);
		 initUI();
		 carregaCmbCategoria();
		 carregaCmbDescricao();
		 carregaCmbMarca();
		 carregaCmbProduto();
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

			btnAdicionar = new ArtButton("ADICIONAR");
	        add(btnAdicionar);
	        btnAdicionar.setRect(LEFT, BOTTOM, width - 400, PREFERRED);
	        btnAdicionar.setBackColor(0x009933);
	        btnAdicionar.setForeColor(Color.WHITE);
					    
			btnVoltar = new ArtButton("VOLTAR");
	        add(btnVoltar);
	        btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
	        btnVoltar.setBackColor(0x003366);
	        btnVoltar.setForeColor(Color.WHITE);

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE","Erro ao carregar a Tela");
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

				} else if (evt.target == btnAdicionar) {

					if (!editQuantidade.getText().equals("") && cmbCategoria.getSelectedItem() != null
							&& cmbMarca.getSelectedItem() != null && cmbProduto.getSelectedItem() != null) {

						adicionaProdutoEstoque();

						MessageBox msg = new MessageBox("CONTROLE", "Produto adicionado ao estoque");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();

					} else {
						MessageBox msg = new MessageBox("CONTROLE", "Preencha todos os campos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
					}
				
				}
			}
			
		}catch (Exception e) {
				MessageBox msg = new MessageBox("CONTROLE","Erro no evento");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();
			}
			
			
		}

	public void adicionaProdutoEstoque() {
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
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao inserir\n produto ao estoque");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
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
					sql = " SELECT PRODUTO FROM PRODUTO";

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
				MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();

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
				MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();

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
					sql = " SELECT DESCRICAO FROM MARCA";

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
				MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();

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
					sql = " SELECT DESCRICAO FROM DESCRICAO";

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
				MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();

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
