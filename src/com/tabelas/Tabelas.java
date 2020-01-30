package com.tabelas;

import com.litebase.LitebasePack;

import litebase.ResultSet;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;

public class Tabelas {
	
	public Tabelas() {
		criaTabelas();
	}
	
	public void criaTabelas() {
		ResultSet rs = null;
		LitebasePack lb = null;
		String sql = "";
		
		try {

			try {
				lb = new LitebasePack();
//----------------------------------------------------------------------------------------------------------------------					
					if (!lb.exists("MARCA")) {

						sql = " create table marca ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index marca01 ON marca(codigo,descricao)");
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('01', 'DEVASSA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('02', 'ANTARTICA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('03', 'COCA-COLA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('04', 'JOHNNIE WALKER')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('05', 'MINEIRO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('06', 'STELLA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('07', 'CANTINA DA TERRA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('08', 'REDBULL')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('09', 'SMIENOFF')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('10', 'VULKANO')";
					
					lb.executeUpdate(sql);
				
				
					}
//-----------------------------------------------------------------------------------------------------------------------						
					if (!lb.exists("CATEGORIA")) {

						sql = " create table categoria ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index categoria01 ON categoria(codigo,descricao)");
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('01', 'VODKAS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('02', 'CERVEJAS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('03', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('04', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('05', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('06', 'CONHAQUES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('06', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					}

//--------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("DESCRICAO")) {

					sql = " create table descricao ( " + "codigo int," + " descricao char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index descricao01 ON descricao(codigo,descricao)");

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('01', '200-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('02', '300-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('03', '400-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('04', '500-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('05', '600-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('06', '700-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('07', '1-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('08', '1,5-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('09', '2-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('10', '2,5-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('11', '3-LT')";

					lb.executeUpdate(sql);

				}

//-------------------------------------------------------------------------------------------------------------------------	
				if (!lb.exists("PRODUTO")) {

					sql = " create table produto ( " + "codigo int," + " produto char(40), " + " valor double, "
							+ "quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40)" + ")";

					lb.execute(sql);
					lb.execute("create index produto01 ON produto(codigo,produto)");

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('01', 'REFRIGERANTE', '7','50', 'REFRIGERANTE', 'COCA-COLA', '2LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('02', 'CERVEJA', '6', '50', 'CERVEJA', 'ARTARTICA', '1LT' )"; 

					lb.executeUpdate(sql);

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('03', 'VODKA', '5', '100', 'VODKA', 'KISLLA', '1LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('04', 'ENERGETICO', '4', '350', 'ENERGETICO', 'REDBULL', '300ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('05', 'VINHO', '5', '350', 'VINHO', 'CANTINA DA CERRA', '1,5LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('06', 'CONHAQUE', '149', '50', 'CONHAQUE', 'CHÂTEAU', '1LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO produto (codigo, produto, valor, quantidade, categoria, marca, descricao)" + " VALUES "
							+ " ('07', 'WHISKY', '359', '50', 'WHISKY', 'JOHNNIE WALKER', '1LT')";

					lb.executeUpdate(sql);

				}
//----------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("ESTOQUE")) {

					sql = " create table estoque ( " + "codigo int," + " produto char(40), " + " valor char(10), "
							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
							+ "dataentrada date"
							+ ")";

					lb.execute(sql);
					lb.execute("create index estoque01 ON estoque(codigo,produto)");
				}
//-----------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("VENDAPRODUTO")) {

					sql = " create table vendaproduto ( " + "codigo int," + " produto char(40), " + " marca char(20), " 
					    + " valor char(10), "
						+ " quantidade int, " + "datavenda date" + ")";

					lb.execute(sql);
					lb.execute("create index vendaproduto01 ON vendaproduto(codigo,produto)");
				}
//------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("EMPRESA")) {

					sql = " create table empresa ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
						+ " usuario char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index empresa01 ON empresa(codigo,nome)");
				}
//--------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("EMPRESAESCOLHIDA")) {

					sql = " create table empresaescolhida ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
						+ " usuario char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index empresaescolhida01 ON empresaescolhida(codigo,nome)");
				}
				
			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
				MessageBox msg = new MessageBox("CONTROLE","Erro " + e);
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x424242);
				msg.popup();
			}
			
		}

}

