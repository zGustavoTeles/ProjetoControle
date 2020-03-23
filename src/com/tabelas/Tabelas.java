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
//---------------------------------------------------------------------------------------------------------------------------------------					
					if (!lb.exists("MARCA")) {

						sql = " create table marca ( " + "codigo int," + " descricao char(40), " + "categoria char(30)," 
						    + "codigoprod int" + ")";

					lb.execute(sql);
					lb.execute("create index marca01 ON marca(codigo,descricao, categoria, codigoprod)");
					
//------------------REFRIGERANTES---------------------------------------------------------------------------------------------------------	
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('01', 'COCA-COLA', 'REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('02', 'FANTA', 'REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('03', 'JAÓ', 'REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('04', 'GUARANA KUAT', 'REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('05', 'SUKITA', 'REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('06', 'DOLLY', 'REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('07', 'GUARANA ANTÁRCTICA','REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('08', 'MINEIRO','REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('09', 'SODA','REFRIGERANTE', '01')";

					lb.executeUpdate(sql);
					
//------------------AGUA-----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('10', 'AGUA-MINERAL','AGUA', '28')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('11', 'AGUA-TONICA','AGUA', '28')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('12', 'AGUA-COM-GAS','AGUA', '28')";

					lb.executeUpdate(sql);

//------------------SUCOS-----------------------------------------------------------------------------------------------------------					
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('13', 'SUVALAN', 'SUCO', '02')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('14', 'MAGUARY LIFE','SUCO', '02')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('15', 'DO BEM INTEGRAL', 'SUCO', '02')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('16', 'DEL VALLE 100% SUCO', 'SUCO', '02')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('17', 'SUFRESH 100% SUCO', 'SUCO', '02')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('18', 'TIAL 100% SUCO', 'SUCO', '02')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('19', 'NOVA ALIANÇA 100% SUCO', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('20', 'CERES 100% JUICE BLEND', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('21', 'LINHA 100% JANDAIA', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('22', 'CAMPO LARGO LARANJA INTEGRAL', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('23', 'LA FRUIT', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('24', 'TAMPICO', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('25', 'SULPER', 'SUCO', '02')";
					
					lb.executeUpdate(sql);
					
//------------------VODKA-----------------------------------------------------------------------------------------------------------					
						
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('26', 'RUSTOFF', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('27', 'KISLLA', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('28', 'SMIENOFF', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('29', 'ABSOLUT', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('30', 'GREY GOOSE', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('31', 'STOLI CHNAYA', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('32', 'SVEDKA','BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('33', 'SKYY', 'BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('34', 'CÎROC','BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('35', 'FINLANDIA','BEBIDA-ALCOOLICA', '03')";
					
					lb.executeUpdate(sql);
					
//------------------CERVEJA---------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('36', 'ITAIPAVA', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('37', 'EISENBAHAN', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('38', 'IMPERIO', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('39', 'PETRA', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('40', 'SCHIN', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('41', 'SOL', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('42', 'CARACU', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('43', 'STELLA', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('44', 'ANTARTICA', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('45', 'KAISER', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('46', 'BAVARIA', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('47', 'SOL', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('48', 'BRAHMA','BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('49', 'COORS LIGHT', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('50', 'HEINEKEN', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('51', 'SKOL','BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('52', 'CORONA', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('53', 'BUD LIGHT', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('54', 'YANJING','BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('55', 'BUDWEISER', 'BEBIDA-ALCOOLICA', '04')";
					
					lb.executeUpdate(sql);
//------------------VINHO------------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('56', 'CATUABA', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('57', 'CATUABA SELVAGEM PINA COLADA', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('58', 'QUINTA DO MORGADO BORDO SUAVE', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('59', 'MIORANZA', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('60', 'CONCHA Y TORO', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('61', 'BAREFOOT', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('62', 'E&J GALLO WINERY', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('63', 'ROBERT MONDAVI', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('64', 'CANTINA DA SERRA', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('65', 'PERGOLA', 'BEBIDA-ALCOOLICA', '05')";
					
					lb.executeUpdate(sql);
//------------------PINGAS-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('66', 'CACHACA 29', 'BEBIDA-ALCOOLICA', '29')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('67', 'CACHACA 51', 'BEBIDA-ALCOOLICA', '29')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('68', 'CACHACA DA ROÇA', 'BEBIDA-ALCOOLICA', '29')";
			
					lb.executeUpdate(sql);
					
//------------------WHISKY-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('69', 'JOHNNIE WALKER', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('70', 'JACK DANIELS', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('71', 'CHIVAS REGAL', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('72', 'BALLANTINES', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('73', 'JIM BEAM', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('74', 'JAMESON', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('75', 'SUNTORY WHISKY', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('76', 'CROWN ROYAL', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('77', 'DEWARS', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('78', 'GRANTS', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('79', 'J&B', 'BEBIDA-ALCOOLICA', '06')";
					
					lb.executeUpdate(sql);
//------------------CONHAQUES----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('80', 'HENNESSY', 'BEBIDA-ALCOOLICA', '07')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('81', 'MARTELL', 'BEBIDA-ALCOOLICA', '07')";
					
					lb.executeUpdate(sql);
//------------------COQUITEIS-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('82', 'OLD FASHIONED', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('83', 'NEGRONI', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('84', 'MANHATTAN', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('85', 'DAIQUIRI', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('86', 'DRY MARTINI', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('87', 'WHISKEY SOUR', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('88', 'MARGARITA', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('89', 'SAZERAC', 'BEBIDA-ALCOOLICA', '08')";
					
					lb.executeUpdate(sql);
//------------------CHAMPANHES-----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('90', 'MOET & CHANDON', 'BEBIDA-ALCOOLICA', '09')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('91', 'VEUVE CLICQUOT', 'BEBIDA-ALCOOLICA', '09')";
					
					lb.executeUpdate(sql);
//------------------TEQUILAS--------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('92', 'PATRÓN', 'BEBIDA-ALCOOLICA', '10')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('93', 'JOSÉ CUERVO', 'BEBIDA-ALCOOLICA', '10')";
					
					lb.executeUpdate(sql);
//------------------GIMS------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('94', 'TANQUERAY', 'BEBIDA-ALCOOLICA', '11')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('95', 'GORDONS', 'BEBIDA-ALCOOLICA', '11')";
					
					lb.executeUpdate(sql);
//------------------RUM-------------------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('96', 'BACARDI','BEBIDA-ALCOOLICA', '12')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('97', 'CAPTAIN MORGAN', 'BEBIDA-ALCOOLICA', '12')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('98', 'MALIBU', 'BEBIDA-ALCOOLICA', '12')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('99', 'HAVANA CLUB', 'BEBIDA-ALCOOLICA', '12')";
					
					lb.executeUpdate(sql);
//------------------LICOR------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('100', 'BAILEYS', 'BEBIDA-ALCOOLICA', '13')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('101', 'RICARD', 'BEBIDA-ALCOOLICA', '13')";
					
					lb.executeUpdate(sql);

//------------------VERMOUTH------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('102', 'MARTINI', 'BEBIDA-ALCOOLICA', '14')";
					
					lb.executeUpdate(sql);
					
					
//-----------------DIVERSOS-------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('103', 'CRONY CHURRASCO DIVERSOS', 'ALIMENTACAO', '15')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('104', 'CRONY CEBOLA E SALSA DIVERSOS', 'ALIMENTACAO', '15')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('105', 'CRONY ORIGINAL DIVERSOS', 'ALIMENTACAO', '15')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('106', 'REFINATA FRANGO DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('107', 'REFINATA COSTELINHA DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('108', 'PETICITOS CALABRESA DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('109', 'PETICITOS BARBECUE DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('110', 'PETICITOS CARNE DE SOL DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('111', 'PETICITOS CHURRASCO DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('112', 'PETICITOS QUEIJO DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('113', 'PETICITOS PIMENTA DIVERSOS', 'ALIMENTACAO', '16')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('114', 'SARDINHA TOMATE DIVERSOS', 'ALIMENTACAO', '17')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('115', 'SARDINHA OLEO DIVERSOS', 'ALIMENTACAO', '17')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('116', 'SALSINHA DIVERSOS', 'ALIMENTACAO', '18')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('117', 'SALSINHA AO MOLHO DIVERSOS', 'ALIMENTACAO', '18')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('118', 'MILHO PIPOCA VELLY', 'ALIMENTACAO', '19')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('119', 'SALGADINHO BACON KRIK', 'ALIMENTACAO', '20')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('120', 'WAFER MORANGO DIVERSOS', 'ALIMENTACAO', '21')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('121', 'WAFER CHOCOLATE DIVERSOS', 'ALIMENTACAO', '21')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('122', 'CARVAO DE COCO P/NARGUILE DIVERSOS', 'DIVERSOS', '22')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('123', 'CARVAO P/CHURRASCO DIVERSOS', 'DIVERSOS', '23')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('124', 'GELO DIVERSOS', 'DIVERSOS', '24')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('125', 'PIRA KIDS DIVERSOS', 'ALIMENTACAO', '25')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('126', 'MILHOPA CEBOLA', 'ALIMENTACAO', '26')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('127', 'MILHOPA CHURRASCO', 'ALIMENTACAO', '26')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('128', 'MILHOPA QUEIJO', 'ALIMENTACAO', '26')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('134', 'MILHOPA GALINHA', 'ALIMENTACAO', '26')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('129', 'MILHOPA PIZZA', 'ALIMENTACAO', '26')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('130', 'MILHOPA PRESUNTO', 'ALIMENTACAO', '26')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('131', 'MOLHO DE PIMENTA GOTA', 'ALIMENTACAO', '27')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria, codigoProd)" + " VALUES "
							+ " ('132', 'MOLHO DE PIMENTA DIVERSOS', 'ALIMENTACAO', '27')";
					
					lb.executeUpdate(sql);
					
					}
//--------------------------------------------------------------------------------------------------------------------------------------------						
				if (!lb.exists("CATEGORIA")) {

					sql = " create table categoria ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index categoria01 ON categoria(codigo,descricao)");

					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES " + " ('01', 'REFRIGERANTE')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES " + " ('02', 'SUCO')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES " + " ('03', 'BEBIDA-ALCOOLICA')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES " + " ('04', 'AGUA')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES " + " ('05', 'ALIMENTACAO')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES " + " ('06', 'DIVERSOS')";

					lb.executeUpdate(sql);

				}

//--------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("DESCRICAO")) {

					sql = " create table descricao ( " + "codigo int," + " descricao char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index descricao01 ON descricao(codigo,descricao)");
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('01', '100-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('02', '150-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('03', '200-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('04', '220-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('05', '250-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('06', '269-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('07', '270-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('08', '275-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('09', '300-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('10', '330-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('11', '350-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('12', '355-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('13', '400-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('14', '450-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('15', '500-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('16', '600-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('17', '700-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('18', '750-ML')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('19', '880-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('20', '1-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('21', '1,5-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('22', '2-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('23', '2,5-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('24', '3-LT')";
					
					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('25', '20-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('26', '21-LT')";
					
					lb.executeUpdate(sql);
					
				}
//-------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("DESCRICAOPESO")) {

					sql = " create table descricaopeso ( " + "codigo int," + " descricao char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index descricaopeso01 ON descricaopeso(codigo,descricao)");

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('01', '10-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('02', '15-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('03', '20-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('04', '30-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('05', '40-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('06', '50-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('07', '60-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('08', '70-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('09', '78-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('10', '80-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('11', '90-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('12', '100-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('13', '120-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('14', '125-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('15', '200-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('16', '300-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('17', '400-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('18', '500-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('19', '600-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('20', '700-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('21', '800-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('22', '900-G')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('23', '1-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('24', '2-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('25', '3-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('26', '4-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('27', '5-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('28', '6-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('29', '7-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('30', '8-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('31', '9-KL')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricaopeso (codigo, descricao)" + " VALUES " + " ('32', '10-KL')";

					lb.executeUpdate(sql);

				}

//--------------------------------------------------------------------------------------------------------------------------------------	
				if (!lb.exists("PRODUTO")) {

					sql = " create table produto ( " + "codigo int," + " produto char(40), " +  " categoria char(30) " + ")";

					lb.execute(sql);
					lb.execute("create index produto01 ON produto(codigo,produto,categoria)");

					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('01', 'REFRIGERANTE', 'REFRIGERANTE')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('02', 'SUCO', 'SUCO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('03', 'VODKA', 'BEBIDA-ALCOOLICA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('04', 'CERVEJA', 'BEBIDA-ALCOOLICA')";

					lb.executeUpdate(sql);
										
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('05', 'VINHO', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('06', 'WHISKY', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('07', 'CONHAQUE', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('08', 'COQUITEI', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('09', 'CHAMPANHE', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('10', 'TEQUILA', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
								
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('11', 'GIM', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('12', 'RUM', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
										
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('13', 'LICOR','BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('14', 'VERMOUTH', 'BEBIDA-ALCOOLICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('15', 'BATATA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('16', 'PETICITOS', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('17', 'SARDINHA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('18', 'SALSINHA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('19', 'MILHO PIPOCA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('20', 'SALGADINHO', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('21', 'WAFER', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('22', 'CARVAO-NARGUILE', 'DIVERSOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('23', 'CARVAO-CHURRASCO', 'DIVERSOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('24', 'GELO', 'DIVERSOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('25', 'PIRA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('26', 'MILHOPA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('27', 'MOLHO DE PIMENTA', 'ALIMENTACAO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('28', 'AGUA', 'AGUA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('29', 'PINGA', 'BEBIDA-ALCOOLICA')";
					
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

					sql = " create table vendaproduto ( " + "codigo int," +  "codigoProd int," + " produto char(40), " + " valor char(10), "
							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
							+ "tipopagamento char(20)," + "datasaida date"
							+ ")";

					lb.execute(sql);
					lb.execute("create index vendaproduto01 ON vendaproduto(codigo,produto)");
				}
//------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("VENDAPRODUTOTEMP")) {

					sql = " create table vendaprodutoTemp ( " + "codigo int," +  "codigoProd int," + " produto char(40), " + " valor char(10), "
							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
							+ "tipopagamento char(20)," + "datasaida date"
							+ ")";

					lb.execute(sql);
					lb.execute("create index vendaprodutoTemp01 ON vendaprodutoTemp(codigo,produto)");
				}
//------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("EMPRESA")) {

					sql = " create table empresa ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
						+ " usuario char(40), " + " datacadastro date " + ")";

					lb.execute(sql);
					lb.execute("create index empresa01 ON empresa(codigo,nome)");
				}
//-------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("ADMINISTRADOR")) {

					sql = " create table administrador ( " + "codigo int," + " senha char(40) "+")";

					lb.execute(sql);
					lb.execute("create index administrador01 ON administrador(codigo,senha)");
				}
//--------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("TIPOPAGAMENTO")) {

					sql = " create table tipopagamento ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index tipopagamento01 ON tipopagamento(codigo,descricao)");

					sql = " INSERT INTO tipopagamento (codigo, descricao)" 
					    + " VALUES " + " ('01', 'DINHEIRO')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO tipopagamento (codigo, descricao)" 
					    + " VALUES " + " ('02', 'CARTAO')";

					lb.executeUpdate(sql);

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

